package com.mobcent.discuz.module.user.adapter;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mobcent.discuz.module.user.fragment.BaseUserInnerScrollFragment;
import com.mobcent.discuz.module.user.fragment.UserHomeInformationFragment;
import com.mobcent.discuz.module.user.fragment.UserHomePublishFragment;

import java.util.ArrayList;

/**
 * Created by pangxiaomin on 16/11/20.
 */
public class UserHomeAdapter extends FragmentPagerAdapter {

    private static final String PAGE_TITLES[] = {"发表","资料"};

    private ArrayList<BaseUserInnerScrollFragment> mFragments;

    public UserHomeAdapter(FragmentManager fm) {
        super(fm);
        mFragments =  new ArrayList<>();
        UserHomePublishFragment userHomePostFragment = UserHomePublishFragment.newInstance();
        UserHomeInformationFragment userHomeInformationFragment = new UserHomeInformationFragment();
        mFragments.add(userHomePostFragment);
        mFragments.add(userHomeInformationFragment);
    }


    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public BaseUserInnerScrollFragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return  PAGE_TITLES[position];
    }

    public boolean canScrollVertically(int position, int direction) {
        return getItem(position).canScrollVertically(direction);
    }
}
