package com.mobcent.discuz.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.appbyme.dev.R;
import com.mobcent.common.ErrReport;
import com.mobcent.discuz.base.Tasker;
import com.mobcent.discuz.fragments.HttpResponseHandler;
import com.mobcent.discuz.ui.EmptyLayout;
import com.mobcent.discuz.widget.SuperRefreshLayout;
import com.mobcent.discuz.widget.SuperRefreshLayoutListener;

/**
 * Created by sun on 2016/8/29.
 */

public abstract class BaseRefreshActivity extends BaseActivity implements SuperRefreshLayoutListener,
        HttpResponseHandler {
    protected SuperRefreshLayout mRefreshLayout;
    /**
     *  空白 错误 占位布局
     */
    protected EmptyLayout mErrorLayout;

    @Override
    public int bindLayout() {
        return R.layout.activity_pull_refresh;
    }

    @Override
    public void initView(ViewGroup root, Bundle savedInstanceState) {
        mRefreshLayout = (SuperRefreshLayout) root.findViewById(R.id.swiperefreshlayout);
        mErrorLayout = (EmptyLayout) root.findViewById(R.id.error_layout);
        mErrorLayout.setOnLayoutClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mState = STATE_REFRESH;
                mErrorLayout.setErrorType(EmptyLayout.NETWORK_LOADING);
                onRefresh();
            }
        });
        mRefreshLayout.addView(onCreateContentLayout(mRefreshLayout, savedInstanceState));
        mRefreshLayout.setSuperRefreshLayoutListener(this);
        mRefreshLayout.setRefreshing(true);
        findViewById(R.id.nav_btn_back).setVisibility(View.VISIBLE);

    }


    @Override
    public void initData(Context mContext) {
        onRefresh();
    }


    /**
     *  super
     */
    @Override
    public void onRefreshing() {
        onRefresh();
    }

    @Override
    public void onLoadMore() {

    }

    public void onRefresh() {
        add(onExecuteRequest(this));
    }

    public void showRereshingAnim() {
        mRefreshLayout.setRefreshing(true);
    }

    @Override
    public void onSuccess(String result) {
        try {
            mRefreshLayout.setRefreshing(false);
            mErrorLayout.setErrorType(EmptyLayout.HIDE_LAYOUT);
            showContent(result);
        } catch (Exception e) {
            ErrReport.jsonErr();
        }
    }

    @Override
    public void onFail(String result) {
        mRefreshLayout.setRefreshing(false);
        mErrorLayout.setErrorType(EmptyLayout.NETWORK_ERROR);
    }


    /**
     * 设置Navi Bar 标题
     * @param title
     */
    public void setHeaderTitle(String title) {
        TextView textView = (TextView) findViewById(R.id.nav_title);
        textView.setText(title);
    }



    /**
     * 刷新内容布局
     * @return
     * @param container
     * @param savedInstanceState
     */
    protected abstract View onCreateContentLayout( ViewGroup container, Bundle savedInstanceState);

    /**
     * 请求接口
     * @param handler
     */
    protected abstract Tasker onExecuteRequest(HttpResponseHandler handler);

    /**
     * 显示结果
     * @param result
     */
    protected abstract void showContent(String result) ;


}
