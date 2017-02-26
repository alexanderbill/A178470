package com.mobcent.discuz.module.user.fragment;

import com.mobcent.discuz.fragments.BaseFragment;

import ru.noties.scrollable.CanScrollVerticallyDelegate;
import ru.noties.scrollable.OnFlingOverListener;

/**
 * Created by pangxiaomin on 16/11/20.
 */
public class BaseUserInnerScrollFragment extends BaseFragment implements CanScrollVerticallyDelegate,OnFlingOverListener {

    @Override
    public boolean canScrollVertically(int direction) {
        return false;
    }

    @Override
    public void onFlingOver(int y, long duration) {

    }
}
