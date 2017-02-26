package com.mobcent.discuz.module.user.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appbyme.dev.R;
import com.mobcent.discuz.module.user.adapter.UserPublishAdapter;


/**
 * Created by pangxiaomin on 16/11/20.
 * 我-个人-发表
 */
public class UserHomePublishFragment extends BaseUserInnerScrollFragment  {


    private RecyclerView mPublishRecyclerView;

    public static UserHomePublishFragment newInstance() {
        return new UserHomePublishFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_home_publish, container, false);
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPublishRecyclerView = $(view,R.id.fragment_publish_recyclerview);
        mPublishRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        UserPublishAdapter adapter = new UserPublishAdapter(getActivity());
        mPublishRecyclerView.setAdapter(adapter);
    }

    @Override
    public boolean canScrollVertically(int direction) {
        return mPublishRecyclerView != null && mPublishRecyclerView.canScrollVertically(direction);
    }

    @Override
    public void onFlingOver(int y, long duration) {
        if (mPublishRecyclerView != null) {
            mPublishRecyclerView.smoothScrollBy(y, (int) duration);
        }
    }
}
