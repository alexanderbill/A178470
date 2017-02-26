package com.mobcent.discuz.fragments;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.appbyme.dev.R;
import com.bumptech.glide.Glide;
import com.mobcent.common.JsonConverter;
import com.mobcent.discuz.api.LqForumApi;
import com.mobcent.discuz.base.UIJumper;
import com.mobcent.discuz.base.constant.DiscuzRequest;
import com.mobcent.discuz.bean.Component;
import com.mobcent.discuz.bean.MoreNewResult;
import com.mobcent.discuz.widget.LoadMoreViewManager;

import org.json.JSONArray;
import org.json.JSONObject;

import static com.mobcent.discuz.widget.LoadMoreViewManager.TYPE_ERROR;

/**
 * Created by ubuntu on 16-6-21.
 */
public class Discovery2Fragment extends DiscoveryBaseFragment {

    private DiscuzRequest request;
    private ListView mListView;
    private LoadMoreViewManager mMoreViewManager;
    private MyAdapter myAdapter = new MyAdapter();
    private int page = 1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected View onCreateContentLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mListView = (ListView) inflater.inflate(R.layout.listview_base, container, false);
        mListView.setAdapter(myAdapter);
        mMoreViewManager = new LoadMoreViewManager(mListView);
        mMoreViewManager.setNoMoreDateHintRes(R.string.mc_forum_detail_load_finish);
        return mListView;
    }

    @Override
    public void onRefreshing() {
    }
    @Override
    public void onLoadMore() {
        LqForumApi.newsList(++page, getNewsListId(), new HttpResponseHandler() {
            @Override
            public void onSuccess(String result) {
                updateList(result);
            }

            @Override
            public void onFail(String result) {
                mMoreViewManager.setFooterType(TYPE_ERROR);
            }
        });
    }

    class MyAdapter extends BaseAdapter {
        public JSONArray array = new JSONArray();
        @Override
        public int getCount() {
            return array.length();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.discovery2_item, parent, false);
            }
            try {
                final JSONObject object = array.getJSONObject(position);
                ImageView imageView = (ImageView) convertView.findViewById(R.id.image);
                TextView title = (TextView) convertView.findViewById(R.id.title);
                TextView detail = (TextView) convertView.findViewById(R.id.detail);
                TextView time = (TextView) convertView.findViewById(R.id.time);
                TextView vote = (TextView) convertView.findViewById(R.id.vote);
                TextView reply = (TextView) convertView.findViewById(R.id.reply);
                final LinearLayout gridView = (LinearLayout) convertView.findViewById(R.id.imagegride);
                int rows = (int) Math.ceil(object.getJSONArray("imageList").length() / 3.0);
                gridView.findViewById(R.id.secondrow).setVisibility(View.GONE);
                gridView.findViewById(R.id.thirdrow).setVisibility(View.GONE);
                gridView.findViewById(R.id.firstrow).setVisibility(View.GONE);
                gridView.setVisibility(View.GONE);
                switch (rows) {
                    case 3:
                        gridView.findViewById(R.id.thirdrow).setVisibility(View.VISIBLE);
                        try {
                            Glide.with(getContext()).load(object.getJSONArray("imageList").getString(6)).into((ImageView) gridView.findViewById(R.id.im6));
                            Glide.with(getContext()).load(object.getJSONArray("imageList").getString(7)).into((ImageView) gridView.findViewById(R.id.im7));
                            Glide.with(getContext()).load(object.getJSONArray("imageList").getString(8)).into((ImageView) gridView.findViewById(R.id.im8));
                        } catch (Exception e) {

                        }
                    case 2:
                        gridView.findViewById(R.id.secondrow).setVisibility(View.VISIBLE);
                        try {
                            Glide.with(getContext()).load(object.getJSONArray("imageList").getString(3)).into((ImageView) gridView.findViewById(R.id.im3));
                            Glide.with(getContext()).load(object.getJSONArray("imageList").getString(4)).into((ImageView) gridView.findViewById(R.id.im4));
                            Glide.with(getContext()).load(object.getJSONArray("imageList").getString(5)).into((ImageView) gridView.findViewById(R.id.im5));
                        } catch (Exception e) {

                        }
                    case 1:
                        gridView.findViewById(R.id.firstrow).setVisibility(View.VISIBLE);
                        try {
                            Glide.with(getContext()).load(object.getJSONArray("imageList").getString(0)).into((ImageView) gridView.findViewById(R.id.im0));
                            Glide.with(getContext()).load(object.getJSONArray("imageList").getString(1)).into((ImageView) gridView.findViewById(R.id.im1));
                            Glide.with(getContext()).load(object.getJSONArray("imageList").getString(2)).into((ImageView) gridView.findViewById(R.id.im2));
                        } catch (Exception e) {

                        }
                    case 0:
                        gridView.setVisibility(View.VISIBLE);
                }

                Glide.with(getContext()).load(object.getString("userAvatar")).into(imageView);
                title.setText(object.getString("user_nick_name"));
                detail.setText(object.getString("title"));
                String timeText = TimeUtils.getTimeText(object.getString("last_reply_date"));
                time.setText(timeText);
                vote.setText(object.getString("hits"));
                reply.setText(object.getString("replies"));
                ViewTreeObserver vto = gridView.getViewTreeObserver();
                vto.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                    boolean hasMeasured;

                    @Override
                    public boolean onPreDraw() {
                        if (!hasMeasured) {
                            // 获得初始宽高
                            try {
                                int width = gridView.getMeasuredWidth();
                                int height = (int) (width / 3 * Math.ceil(object.getJSONArray("imageList").length() / 3.0));
                                gridView.setLayoutParams(new LinearLayout.LayoutParams(width, height));
                                hasMeasured = true;
                            } catch (Exception e) {

                            }
                        }
                        return true;
                    }
                });
                convertView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            UIJumper.jumpTopic(getContext(), (object.optInt("source_id", 0) != 0) ? object.getInt("source_id") : object.getInt("topic_id"));
                        } catch (Exception e) {

                        }
                    }
                });
            } catch (Exception e) {

            }
            return convertView;
        }
    }

    @Override
    protected void onExecuteRequest(HttpResponseHandler handler) {
        page = 1;
        request = LqForumApi.newsList(page, getNewsListId(), this);
    }

    @Override
    protected void showContent(String result) {
        myAdapter.array = new JSONArray();
        updateList(result);
    }

    private void updateList(String result) {
        try {
            JSONObject object = new JSONObject(result);
            if (object.getInt("rs") == 1) {
                JSONArray array = object.getJSONArray("list");
                for (int i = 0; i < array.length(); i++) {
                    myAdapter.array.put(array.getJSONObject(i));
                }
                mRefreshLayout.setCanLoadMore();
                mRefreshLayout.onLoadComplete();
                myAdapter.notifyDataSetChanged();
            }
        } catch (Exception e) {

        }
    }

    @Override
    public void onDestroy() {
        if (request != null) {
            request.cancel(true);
        }
        super.onDestroy();
    }
}
