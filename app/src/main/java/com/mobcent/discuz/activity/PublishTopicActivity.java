package com.mobcent.discuz.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.appbyme.dev.R;
import com.foamtrace.photopicker.PhotoPickerActivity;
import com.foamtrace.photopicker.PhotoPreviewActivity;
import com.foamtrace.photopicker.SelectModel;
import com.foamtrace.photopicker.intent.PhotoPickerIntent;
import com.mobcent.discuz.api.LqForumApi;
import com.mobcent.discuz.base.constant.DiscuzRequest;
import com.mobcent.discuz.base.constant.LocationProvider;
import com.mobcent.discuz.bean.Reply;
import com.mobcent.discuz.fragments.HttpResponseHandler;
import com.mobcent.discuz.uitls.PermissionUtils;
import com.zejian.emotionkeyboard.fragment.EmotionMainFragment;
import com.zejian.emotionkeyboard.utils.ScreenUtils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Vector;


/**
 * Created by ubuntu on 16-8-18.
 */
public class PublishTopicActivity extends FragmentActivity {

    private GridView mGridView;
    private ImageAdapter mImageAdapter;
    private ImageView mLocation;
    private TextView mLocationText;
    private LocationClickListener mLocationClickListener;
    private boolean isFirst = true;
    private int mCate;
    private int width;

    private String mLongitude;
    private String mLatitude;
    private String mCameraStore;
    private UploadFileHandler mUploadFileHandler = new UploadFileHandler();
    private LocationHandler mLocationHandler = new LocationHandler();
    private LocationCheckHandler mLocationCheckHandler = new LocationCheckHandler();

    private Reply reply;

    /**
     * 回复回帖
     * @param context
     * @param reply
     */
    public static void start(Context context, Reply reply) {
        Intent starter = new Intent(context, PublishTopicActivity.class);
        starter.putExtra("Type","0");
        starter.putExtra("catId", 1);
        starter.putExtra("ser_reply", reply);
        context.startActivity(starter);
    }

    public static void start(Context context, int catId) {
        Intent starter = new Intent(context, PublishTopicActivity.class);
        starter.putExtra("Type","0");
        starter.putExtra("catId", catId);
        context.startActivity(starter);
    }
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.publish_topic_activity);
        reply = (Reply) getIntent().getSerializableExtra("ser_reply");
        mCate = getIntent().getIntExtra("catId", 0);
        if (mCate > 0 || reply != null) {
            findViewById(R.id.title_layout).setVisibility(View.GONE);
        }

        mGridView = (GridView) findViewById(R.id.imagegride);
        mImageAdapter = new ImageAdapter(this);
        mImageAdapter.addItem(new Item("", BitmapFactory.decodeResource(getResources(), R.drawable.dz_publish_add_picture_h)));
        mGridView.setAdapter(mImageAdapter);

        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                if (position == mImageAdapter.getCount() - 1) {
                    final Dialog dialog = new Dialog(PublishTopicActivity.this, R.style.mc_forum_home_publish_dialog);
                    final LayoutInflater in = LayoutInflater.from(PublishTopicActivity.this);
                    View view = in.inflate(R.layout.publish_pic_select, null);
                    view.findViewById(R.id.mc_forun_publish_from_pictures).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                            startSelectPicture();
                        }
                    });
                    view.findViewById(R.id.mc_forun_publish_from_camera).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                            startCamera();
                        }
                    });

                    dialog.setContentView(view);
                    dialog.show();
                } else {

                }
            }
        });

        mLocation = (ImageView) findViewById(R.id.mc_forum_location_img);
        mLocationClickListener = new LocationClickListener();
        mLocationText = (TextView) findViewById(R.id.mc_forum_loction_text);
        mLocationText.setOnClickListener(mLocationClickListener);
        mLocation.setOnClickListener(mLocationClickListener);

        findViewById(R.id.mc_forum_back_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        findViewById(R.id.mc_forum_public_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCate == 0) {
                    Toast.makeText(PublishTopicActivity.this, "请先选择板块", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (mImageAdapter.getCount() > 1) {
                    String url = DiscuzRequest.baseUrl + "forum/sendattachmentex&mType=image&forumKey=BW0L5ISVRsOTVLCTJx&accessSecret=" + LoginUtils.getInstance().getAccessSecret() + "&accessToken=" + LoginUtils.getInstance().getAccessToken() +
                            "&module=forum&egnVersion=v2035.2&sdkVersion=2.4.3.0&fid=" + mCate + "&apphash=4c37ae6f";
                    Vector<String> files = new Vector<String>();
                    for (int i = 1; i < mImageAdapter.getCount(); i++) {
                        files.add(((Item) mImageAdapter.getItem(i)).mPath);
                    }
                    new DiscuzRequest(url, files, mUploadFileHandler).execute();
                } else {
                    doPublish(new Vector<String>());
                }
            }
        });

        findViewById(R.id.mc_forum_public_label_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PublishTopicActivity.this, BoardListActivity.class);
                startActivityForResult(intent, 3);
            }
        });

        final EditText content = (EditText)findViewById(R.id.mc_forum_content_edit);
        content.setFocusable(true);
        content.setFocusableInTouchMode(true);
        content.requestFocus();
        InputMethodManager im = ((InputMethodManager) getSystemService(INPUT_METHOD_SERVICE));
        im.showSoftInput(content, 0);

        //构建传递参数
        Bundle fragmentBundle = new Bundle();
        //隐藏控件
        fragmentBundle.putBoolean(EmotionMainFragment.HIDE_BAR_EDITTEXT_AND_BTN,true);
        //替换fragment
        //创建修改实例
        final EmotionMainFragment emotionMainFragment = EmotionMainFragment.newInstance(EmotionMainFragment.class, fragmentBundle);
        emotionMainFragment.bindCustomEditText(content);
        emotionMainFragment.bindToContentView(findViewById(R.id.mc_forum_scrollview));
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // Replace whatever is in thefragment_container view with this fragment,
        // and add the transaction to the backstack
        transaction.replace(R.id.fl_emotionview_main, emotionMainFragment);
//        transaction.addToBackStack(null);
        //提交修改
        transaction.commit();

        // 失去焦点时隐藏表情(防止双键盘出现）
        content.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    emotionMainFragment.hidePanel();
                }
                findViewById(R.id.fl_emotionview_main).setVisibility(hasFocus ? View.VISIBLE : View.GONE);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        width = ScreenUtils.getScreenWidth(this) / 5 - 8;
        if (isFirst) {
            String type = getIntent().getExtras().getString("Type");
            if (type.equals("1")) {
                startSelectPicture();
            } else if (type.equals("2")) {
                startCamera();
            }
            isFirst = false;
        }
    }

    private void startSelectPicture() {
        PermissionUtils.verifyStoragePermissions(PublishTopicActivity.this);
        PhotoPickerIntent intent = new PhotoPickerIntent(this);
        intent.setSelectModel(SelectModel.MULTI);
        //intent.setShowCarema(true); // 是否显示拍照， 默认false
        intent.setMaxTotal(10); // 最多选择照片数量，默认为9
        // intent.setSelectedPaths(imagePaths); // 已选中的照片地址， 用于回显选中状态
        startActivityForResult(intent, 1);
    }

    private void startCamera() {
        PermissionUtils.verifyCameraPermissions(PublishTopicActivity.this);
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(getImagePath())));
        intent.putExtra("return-data", true);
        startActivityForResult(intent, 2);
    }

    private String getImagePath() {
        mCameraStore = android.os.Environment.getExternalStorageDirectory().toString() + "/DCIM/Bitmap[" +
                android.os.SystemClock.uptimeMillis() + "].jpg";
        return mCameraStore;
    }

    class UploadFileHandler implements HttpResponseHandler {
        private DiscuzRequest mLocationRequest;

        @Override
        public void onSuccess(String result) {
            try {
                JSONObject object = new JSONObject(result);
                if (!"1".equals(object.getString("rs"))) {
                    onFail(object.getString("errcode"));
                } else {
                    try {
                        JSONArray array = object.getJSONObject("body").getJSONArray("attachment");
                        Vector<String> v = new Vector<>();
                        for (int i = 0; i < array.length(); i++) {
                            v.add(array.getJSONObject(i).getString("urlName"));
                        }
                        doPublish(v);
                    } catch (Exception e) {

                    }

                }
            } catch (Exception e) {

            }
        }

        @Override
        public void onFail(String result) {
            Toast.makeText(PublishTopicActivity.this, result, Toast.LENGTH_SHORT).show();
        }
    }

    private void doPublish(Vector<String> urlNames) {
        EditText title = (EditText)findViewById(R.id.mc_forum_title_edit);
        String titleString = title.getText().toString().trim();
        EditText content = (EditText)findViewById(R.id.mc_forum_content_edit);
        String contentString = content.getText().toString().trim();
        if (reply != null) {
            reply.getBody().getJson().setContentStr(contentString);
            LqForumApi.reply(reply, new PublishHandler());
        } else {
            try {
                JSONObject contentJson = new JSONObject();
                contentJson.put("infor", contentString);
                contentJson.put("mType", "0");

                JSONArray contentArray = new JSONArray();
                contentArray.put(contentJson);

                for (int i = 0; i < urlNames.size(); i++) {
                    JSONObject urlName = new JSONObject();
                    urlName.put("infor", urlNames.get(i));
                    urlName.put("mType", "1");
                    contentArray.put(urlName);
                }

                String contentArrayString = URLEncoder.encode(contentArray.toString());
                JSONObject total = new JSONObject();
                JSONObject body = new JSONObject();
                JSONObject json = new JSONObject();
                json.put("typeId", "80");
                json.put("isShowPostion", "1");
                json.put("content", contentArrayString);
                json.put("aid", "");
                json.put("isQuote", "0");
                json.put("fid", mCate);
                json.put("longitude", mLongitude);
                json.put("latitude", mLatitude);
                json.put("title", URLEncoder.encode(titleString));
                total.put("body", body);
                body.put("json", json);
                JSONObject param = new JSONObject();
                param.put("platType", 5);
                param.put("act", "new");
                param.put("json", URLEncoder.encode(total.toString()));
                new DiscuzRequest("forum/topicadmin", param.toString(), new PublishHandler()).execute();
            } catch (Exception e) {

            }
        }

    }

    private class PublishHandler implements HttpResponseHandler {
        @Override
        public void onSuccess(String result) {
            try {
                JSONObject object = new JSONObject(result);
                if (!"1".equals(object.getString("rs"))) {
                    onFail(object.getString("errcode"));
                } else {
                    onFail(object.getString("errcode"));
                    finish();
                }
            } catch (Exception e) {

            }
        }
        @Override
        public void onFail(String result) {
            Toast.makeText(PublishTopicActivity.this, result, Toast.LENGTH_SHORT).show();
        }
    }

    class LocationClickListener implements View.OnClickListener {
        private DiscuzRequest mLocationRequest;

        private class MyLocationHandler implements LocationProvider.LocationHandler {
            @Override
            public void onLocationUpdate(Location location) {
                sendLocationRequest(location);
            }
        }

        @Override
        public void onClick(View view) {
            mLocation.setImageResource(R.drawable.dz_publish_location_selected);
            mLocationText.setText("定位中");
            Location location = LocationProvider.getInstance().provideLocation(new MyLocationHandler());
            if (location != null) {
                sendLocationRequest(location);
            }
        }

        private void sendLocationRequest(Location location) {
            if (mLocationRequest != null) {
                mLocationRequest.cancel(true);
            }
            mLocationHandler.setPosition(location.getLongitude(), location.getLatitude());
            mLocationRequest = new DiscuzRequest("http://api.map.baidu.com/geocoder/v2/?ak=GT5EmhOircF8diYLKDrIezIp&location=" + location.getLatitude() + "," + location.getLongitude() + "&output=json&pois=1", "", mLocationHandler, "get");
            mLocationRequest.execute();
        }
    }

    private class LocationHandler implements HttpResponseHandler {
        private DiscuzRequest mLocationCheckRequest;
        public LocationHandler() {

        }
        public void setPosition(double longitude, double latitude) {
            mLongitude = String.valueOf(longitude);
            mLatitude = String.valueOf(latitude);
        }
        @Override
        public void onSuccess(String result) {
            try {
                JSONObject object = new JSONObject(result);
                String location = object.getJSONObject("result").getString("formatted_address");
                JSONObject object1 = new JSONObject();
                object1.put("location", location);
                object1.put("longitude", mLongitude);
                object1.put("latitude", mLatitude);
                mLocationCheckHandler.setLocation(location);
                if (mLocationCheckRequest != null) {
                    mLocationCheckRequest.cancel(true);
                }
                mLocationCheckRequest = new DiscuzRequest("user/location", object1.toString(), mLocationCheckHandler);
                mLocationCheckRequest.execute();
            } catch (Exception e) {
                onFail("");
            }
        }

        @Override
        public void onFail(String result) {
            onLocationFail();
        }
    }

    private class LocationCheckHandler implements HttpResponseHandler {
        private String mLocationString;
        public LocationCheckHandler() {

        }
        public void setLocation(String location) {
            mLocationString = location;
        }
        @Override
        public void onSuccess(String result) {
            try {
                JSONObject object = new JSONObject(result);
                String rs = object.getString("rs");
                if ("1".equals(rs)) {
                    mLocation.setImageResource(R.drawable.dz_publish_location_unselected);
                    mLocationText.setText(mLocationString);
                }
            } catch (Exception e) {
                onFail("");
            }
        }

        @Override
        public void onFail(String result) {
            onLocationFail();
        }
    }

    private void onLocationFail() {
        mLocation.setImageResource(R.drawable.dz_publish_location_unselected);
        mLocationText.setText(R.string.mc_forum_rapid_publish_show_location);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==2)
        {
            if (resultCode==Activity.RESULT_OK) {
                Bitmap cameraBitmap = loadBitmap(mCameraStore, width, width);
                mImageAdapter.addItem(new Item(mCameraStore, cameraBitmap));
                mImageAdapter.notifyDataSetChanged();
            }
        } else if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK && data != null) {
                ArrayList<String > arrayList = data.getStringArrayListExtra(PhotoPickerActivity.EXTRA_RESULT);
                mImageAdapter.removeAll();
                for (int i = 0; i < arrayList.size(); i++) {
                    String pirPath = arrayList.get(i);
                    Bitmap bitmap = loadBitmap(pirPath, width, width);
                    mImageAdapter.addItem(new Item(pirPath, bitmap));
                }
                mImageAdapter.notifyDataSetChanged();
            }
        } else if (requestCode == 3) {
            if (resultCode == Activity.RESULT_OK && data != null) {
                int cate = data.getIntExtra("cate", 0);
                String cateName = data.getStringExtra("cateName");
                if (cate != 0) {
                    mCate = cate;
                    ((TextView)findViewById(R.id.mc_forum_public_label_text)).setText(cateName);
                }
            }
        }
    }

    class Item {
        public final String mPath;
        public final Bitmap mBitmap;

        public Item(String path, Bitmap bitmap) {
            mPath = path;
            mBitmap = bitmap;
        }
    }

    public class ImageAdapter extends BaseAdapter {
        private Context context = null;

        private Vector<Item> mThumbIds = new Vector<Item>();

        public ImageAdapter(Context context){
            this.context = context;
        }

        public int getCount() {
            return mThumbIds.size();
        }

        public void addItem(Item bitmap) {
            if (mThumbIds.size() == 10) {
                mThumbIds.remove(0);
            }
            mThumbIds.add(bitmap);
        }

        public void removeAll() {
            mThumbIds.removeAllElements();
            mThumbIds.add(new Item("", BitmapFactory.decodeResource(getResources(), R.drawable.dz_publish_add_picture_h)));
        }

        public Object getItem(int position) {
            return mThumbIds.get(position);
        }

        public long getItemId(int position) {
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = (ImageView)convertView;
            if(imageView == null){
                imageView = new ImageView(context);
            }
            LinearLayout.LayoutParams gridLayout = new LinearLayout.LayoutParams(width, width);
            imageView.setLayoutParams(gridLayout);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            if (position == getCount() - 1) {
                imageView.setImageBitmap(mThumbIds.get(0).mBitmap);
            } else {
                imageView.setImageBitmap(mThumbIds.get(position + 1).mBitmap);
            }
            return imageView;
        }

    }

    public Bitmap loadBitmap(String url, int width, int height)
    {
        Bitmap bitmap = null;
        if (url == null || !new File(url).exists()) return bitmap;
        try
        {
            BitmapFactory.Options opts = new BitmapFactory.Options();
            opts.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(url, opts);
            opts.inSampleSize = calculateSampleSize(opts, width, height);
            opts.inJustDecodeBounds = false;
            opts.inPreferredConfig = Bitmap.Config.RGB_565;
            opts.inPurgeable = true;
            opts.inInputShareable = true;
            PermissionUtils.verifyStoragePermissions(this);
            bitmap = BitmapFactory.decodeStream(new FileInputStream(url), null, opts);
            bitmap = ThumbnailUtils.extractThumbnail(bitmap, width, height);
            return bitmap;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return bitmap;
    }

    private static int calculateSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight)
    {
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;
        if (height > reqHeight || width > reqWidth)
        {
            final int halfHeight = height / 2;
            final int halfWidth = width / 2;
            while ((halfHeight / inSampleSize) > reqHeight && (halfWidth / inSampleSize) > reqWidth)
            {
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }

}
