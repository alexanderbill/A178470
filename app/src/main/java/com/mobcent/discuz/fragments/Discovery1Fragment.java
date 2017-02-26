package com.mobcent.discuz.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.appbyme.dev.R;
import com.bumptech.glide.Glide;
import com.mobcent.discuz.api.LqForumApi;
import com.mobcent.discuz.base.UIJumper;
import com.mobcent.discuz.base.constant.DiscuzRequest;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by ubuntu on 16-6-21.
 */
public class Discovery1Fragment extends DiscoveryBaseFragment {

    private DiscuzRequest request;
    private ViewGroup viewGroup;
    private int page = 1;
    private double left;
    private double right;
    private LinearLayout leftView;
    private LinearLayout rightView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected View onCreateContentLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.listview_base, container, false);
        ListView listView = (ListView)viewGroup.findViewById(R.id.topic_reply_list);
        listView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return 1;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = LayoutInflater.from(getContext()).inflate(R.layout.two_list_middle, parent, false);
                leftView = (LinearLayout)view.findViewById(R.id.left_list);
                rightView = (LinearLayout)view.findViewById(R.id.right_list);
                return view;
            }
        });

        return viewGroup;
    }

    @Override
    public void onRefreshing() {

    }

    @Override
    public void onLoadMore() {
        page++;
        LqForumApi.newsList(page, getNewsListId(), new HttpResponseHandler() {
            @Override
            public void onSuccess(String result) {
                addView(result);
            }

            @Override
            public void onFail(String result) {

            }
        });
    }

    @Override
    protected void onExecuteRequest(HttpResponseHandler handler) {
        page = 1;
        request = LqForumApi.newsList(page, getNewsListId(), this);
    }

    public View getView(final JSONObject object, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.portal_list_photo1_item, parent, false);
        }
        try {
            ImageView imageView = (ImageView) convertView.findViewById(R.id.mc_forum_photo_shader);
            ImageUtils.getImageViewSizeInit(imageView, Double.parseDouble(object.getString("ratio")));
            Glide.with(getContext()).load(object.getString("pic_path")).into(imageView);
            TextView comment = (TextView) convertView.findViewById(R.id.mc_forum_comment_text);
            comment.setText(object.getString("hits"));
            TextView title = (TextView) convertView.findViewById(R.id.mc_forum_title);
            title.setText(object.getString("title"));
            TextView auth = (TextView) convertView.findViewById(R.id.mc_forum_username);
            auth.setText(object.getString("user_nick_name"));
            TextView time = (TextView) convertView.findViewById(R.id.mc_forum_time_text);
            String timeText = TimeUtils.getTimeText(object.getString("last_reply_date"));
            time.setText(timeText);
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

    @Override
    protected void showContent(String result) {
        leftView.removeAllViews();
        rightView.removeAllViews();
        left = 0;
        right = 0;
        addView(result);
    }

    private void addView(String result) {
        try {
            JSONObject object = new JSONObject(result);
            if (object.getInt("rs") == 1) {
                JSONArray array = object.getJSONArray("list");
                for (int i = 0; i < array.length(); i++) {
                    JSONObject item = array.getJSONObject(i);
                    double ratio = Double.parseDouble(item.getString("ratio"));
                    if (left < right) {
                        left += ratio;
                        View view = getView(item, null, leftView);
                        leftView.addView(view);
                    } else {
                        right += ratio;
                        View view = getView(item, null, rightView);
                        rightView.addView(view);
                    }
                }
                mRefreshLayout.onLoadComplete();
                mRefreshLayout.setCanLoadMore();
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
