package com.mobcent.discuz.module.user.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.appbyme.dev.R;
import com.mobcent.discuz.activity.BasePopActivity;
import com.mobcent.discuz.activity.LoginUtils;
import com.mobcent.discuz.base.WebParamsMap;
import com.mobcent.discuz.module.user.adapter.UserHomeAdapter;
import com.mobcent.discuz.module.user.fragment.UserHomeInformationFragment;
import com.mobcent.discuz.module.user.fragment.UserHomePublishFragment;
import com.mobcent.discuz.module.user.view.UserHomeCenterHeader;

import discuz.com.net.service.DiscuzRetrofit;
import discuz.com.net.service.model.me.UserResult;
import discuz.com.retrofit.library.HTTPSubscriber;
import library.component.actionbar.sliding.SlidingTabLayout;
import ru.noties.scrollable.CanScrollVerticallyDelegate;
import ru.noties.scrollable.OnFlingOverListener;
import ru.noties.scrollable.OnScrollChangedListener;
import ru.noties.scrollable.ScrollableLayout;

/**
 * Created by pangxiaomin on 16/11/20
 * 用户资料页
 */
public class UserHomeActivity extends BasePopActivity implements View.OnClickListener{

    private ScrollableLayout mScrollableLayout;
    private UserHomeCenterHeader mUserCenterHeader;
    private SlidingTabLayout mSlideTabLayout;
    private ViewPager mUserViewPager;
    private UserHomeAdapter mUserHomeAdapter;
    private View tabView;

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        initView();
        initData();
        requestUserInfo();
    }

    @Override
    public int initLayout() {
        return R.layout.user_home_center_fragment;
    }

    @Override
    protected Fragment initContentFragment() {
        return null;
    }

    private void initView(){
        getAppActionBar().setTitle(R.string.user_center);
        getAppActionBar().setBackgroundAlpha(0);
        getAppActionBar().setRightTitle(R.string.mc_forum_userifo_update,this);
        mScrollableLayout = $(R.id.user_home_scrollable_layout);
        mUserCenterHeader = $(R.id.header_layout);
        mUserViewPager = $(R.id.fragment_user_viewpager);
        tabView = $(R.id.fragment_user_viewpager);

        mSlideTabLayout =  $(R.id.sliding_tab_layout);
        mSlideTabLayout.setCustomTabView(R.layout.view_sliding_tab_indicator, android.R.id.text1);
        mSlideTabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.dz_skin_custom_main_color));
        mSlideTabLayout.setDistributeEvenly(false);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.action_bar_right_title){
            //TODO edit user info
        }
    }

    private void initData(){
        mUserHomeAdapter = new UserHomeAdapter(getSupportFragmentManager());
        mUserViewPager.setAdapter(mUserHomeAdapter);
        mSlideTabLayout.setViewPager(mUserViewPager);
        mScrollableLayout.setDraggableView(mSlideTabLayout);

        mScrollableLayout.setCanScrollVerticallyDelegate(new CanScrollVerticallyDelegate() {
            @Override
            public boolean canScrollVertically(int direction) {
                return mUserHomeAdapter.canScrollVertically(mUserViewPager.getCurrentItem(), direction);
            }
        });

        mScrollableLayout.setOnFlingOverListener(new OnFlingOverListener() {
            @Override
            public void onFlingOver(int y, long duration) {
                mUserHomeAdapter.getItem(mUserViewPager.getCurrentItem()).onFlingOver(y, duration);
            }
        });

        mScrollableLayout.setOnScrollChangedListener(new OnScrollChangedListener() {
            @Override
            public void onScrollChanged(int y, int oldY, int maxY) {

                final float tabsTranslationY;
                if (y < maxY) {
                    tabsTranslationY = .0F;
                } else {
                    tabsTranslationY = y - maxY;
                }

                invalidateActionBarBackground(y,maxY);
                mSlideTabLayout.setTranslationY(tabsTranslationY);
                mUserCenterHeader.setTranslationY(y / 2);
            }
        });
    }

    //背景颜色渐变
    private void invalidateActionBarBackground(int transY,int maxY){
        //0-maxY 0-255
        getAppActionBar().setBackgroundAlpha(transY*255/maxY);
    }

    private void requestUserInfo(){
        DiscuzRetrofit.getUserInfoService(this).requestUserInfo(LoginUtils.getInstance().getUserId(),WebParamsMap.map()).subscribe(new HTTPSubscriber<UserResult>() {
            @Override
            public void onSuccess(UserResult userResult) {
                mUserCenterHeader.setContent(userResult);
                ((UserHomeInformationFragment)mUserHomeAdapter.getItem(1)).setContent(userResult.getBody().getProfileList(),
                        userResult.getBody().getCreditList());
            }

            @Override
            public void onFail(int httpCode, int errorUserCode, String message) {
                showToast(message);
            }
        });
    }


}
