package com.mobcent.discuz.fragments;

import android.content.Intent;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.appbyme.dev.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.ImageVideoWrapperEncoder;
import com.litesuits.android.log.Log;
import com.mobcent.common.JsonConverter;
import com.mobcent.discuz.activity.BoardListDetailActivity;
import com.mobcent.discuz.activity.LoginActivity;
import com.mobcent.discuz.activity.LoginUtils;
import com.mobcent.discuz.api.LqForumApi;
import com.mobcent.discuz.base.constant.DiscuzRequest;
import com.mobcent.discuz.bean.Component;
import com.mobcent.discuz.bean.HomeResult;
import com.mobcent.discuz.ui.ComponentBuilder;
import com.zejian.emotionkeyboard.utils.EmotionUtils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * Created by ubuntu on 16-6-21.
 */
public class Discuz1Fragment extends BaseRefreshFragment {

    public static final String TAG = Discuz1Fragment.class.getSimpleName();
    private DiscuzRequest request;
    private RecAdapter mRecAdapter = new RecAdapter();
    private OtherAdapter mOtherAdapter = new OtherAdapter();
    public Vector<JSONArray> values = new Vector<>();
    private int selected = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected View onCreateContentLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.two_list, container, false);

        ListView first = (ListView) viewGroup.findViewById(R.id.left_list);
        first.setVerticalScrollBarEnabled(false);
        first.setAdapter(mRecAdapter);
        ListView second = (ListView)viewGroup.findViewById(R.id.right_list);
        second.setVerticalScrollBarEnabled(false);
        second.setAdapter(mOtherAdapter);
        return viewGroup;
    }

    class OtherAdapter extends  BaseAdapter {
        public JSONArray values = new JSONArray();
        @Override
        public int getCount() {
            return values.length();
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
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.board_list_fragment3_child_follow_item, parent, false);
            }
            try {
                final JSONObject object = values.getJSONObject(position);
                TextView board_name_text = (TextView) convertView.findViewById(R.id.board_name_text);
                board_name_text.setText(object.getString("board_name"));
                TextView board_favorite_text = (TextView) convertView.findViewById(R.id.board_favorite_text);
                board_favorite_text.setText(object.getString("favNum"));
                TextView board_nearest_reply_text = (TextView) convertView.findViewById(R.id.board_nearest_reply_text);
                board_nearest_reply_text.setText(object.getString("td_posts_num"));
                ImageView board_icon_img = (ImageView)convertView.findViewById(R.id.board_icon_img);
                String url = object.getString("board_img");
                Glide.with(getContext()).load(url).into(board_icon_img);

                View follow = convertView.findViewById(R.id.follow_btn_bg);
                View unfollow = convertView.findViewById(R.id.cancel_follow_btn_bg);
                Button button = (Button)convertView.findViewById(R.id.board_follow_btn);
                if (object.getInt("is_focus") == 1) {
                    unfollow.setVisibility(View.GONE);
                    follow.setVisibility(View.VISIBLE);
                    button.setText("取消");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            try {
                                LqForumApi.userFavor(object.getInt("board_id"), false, new FollowResponseHandler());
                            } catch (Exception e) {

                            }
                        }
                    });
                } else {
                    unfollow.setVisibility(View.VISIBLE);
                    follow.setVisibility(View.GONE);
                    button.setText("关注");

                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (!LoginUtils.getInstance().isLogin()) {
                                Intent it = new Intent(getContext(), LoginActivity.class);
                                startActivity(it);
                                return;
                            }
                            try {
                                LqForumApi.userFavor(object.getInt("board_id"), true, new FollowResponseHandler());
                            } catch (Exception e) {

                            }
                        }
                    });
                }
                convertView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            BoardListDetailActivity.start(getContext(), object.getLong("board_id"));
                        } catch (Exception e) {

                        }
                    }
                });
            } catch (Exception e) {

            }
            return convertView;
        }
    }

    class RecAdapter extends BaseAdapter {
        public List<String> keys = new ArrayList<>();

        @Override
        public int getCount() {
            return keys.size();
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
                convertView = new TextView(getContext());
            }
            convertView.setPadding(0, 20, 0, 20);
            ((TextView)convertView).setGravity(Gravity.CENTER);
            ((TextView)convertView).setText(keys.get(position));
            ((TextView)convertView).setTextSize(20);
            ((TextView)convertView).setTextColor(getResources().getColor(R.color.mc_forum_board_title_normal_color));
            if (position != selected) {
                convertView.setBackgroundResource(R.drawable.dz_icon_line);
            } else {
                convertView.setBackgroundResource(R.drawable.dz_bg_white);
            }
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showRightList(position);
                    selected = position;
                    RecAdapter.this.notifyDataSetChanged();
                }
            });
            return convertView;
        }
    }

    @Override
    public void onRefreshing() {
    }
    @Override
    public void onLoadMore() {
    }

    @Override
    protected void onExecuteRequest(HttpResponseHandler handler) {
        LqForumApi.forumList(new RecResponseHandler(), "rec");
    }

    @Override
    protected void showContent(String result) {
        try {
            JSONObject object = new JSONObject(result);
            JSONArray list = object.getJSONArray("list");
            for (int i = 0; i < list.length(); i++) {
                JSONObject names = list.getJSONObject(i);
                mRecAdapter.keys.add(names.getString("board_category_name"));
                JSONArray board_list = names.getJSONArray("board_list");
                values.add(board_list);
            }
            mRecAdapter.notifyDataSetChanged();
            showRightList(selected);
        } catch (Exception e) {

        }
    }

    private void showRightList(int position) {
        mOtherAdapter.values = values.elementAt(position);
        mOtherAdapter.notifyDataSetChanged();
    }

    class RecResponseHandler implements HttpResponseHandler {
        @Override
        public void onSuccess(String result) {
            try {
                JSONObject object = new JSONObject(result);
                if (object.getInt("rs") == 1) {
                    mRecAdapter.keys.clear();
                    values.clear();

                    try {
                        JSONArray fav = new JSONArray();
                        JSONArray list = object.getJSONArray("focusBoard");
                        for (int i = 0; i < list.length(); i++) {
                            fav.put(list.getJSONObject(i));
                        }

                        list = object.getJSONArray("recommendedBoard");
                        for (int i = 0; i < list.length(); i++) {
                            fav.put(list.getJSONObject(i));
                        }
                        mRecAdapter.keys.add(0, "我的关注");
                        values.add(0, fav);
                    } catch (Exception e) {

                    }
                    request = LqForumApi.forumList(Discuz1Fragment.this);
                }
            } catch (Exception e) {

            }

        }

        @Override
        public void onFail(String result) {
            Toast.makeText(getContext(), "获取板块失败，请刷新页面", Toast.LENGTH_SHORT).show();
        }
    }

    class FollowResponseHandler implements HttpResponseHandler {
        @Override
        public void onSuccess(String result) {
            try {
                JSONObject object = new JSONObject(result);
                if (object.getInt("rs") == 1) {
                    Toast.makeText(getContext(), object.getString("errcode"), Toast.LENGTH_SHORT).show();
                    onExecuteRequest(null);
                }
            } catch (Exception e) {

            }

        }

        @Override
        public void onFail(String result) {
            Toast.makeText(getContext(), "关注失败，请刷新页面", Toast.LENGTH_SHORT).show();
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
