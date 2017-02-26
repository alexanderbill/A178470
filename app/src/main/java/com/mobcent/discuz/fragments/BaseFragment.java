package com.mobcent.discuz.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

/**
 * Created by ubuntu on 16-8-18.
 */
public abstract  class BaseFragment extends Fragment implements HttpResponseHandler {
    public static final int STATE_NONE = 0;
    public static final int STATE_REFRESH = 1;
    public static final int STATE_LOADMORE = 2;
    public static final int STATE_NOMORE = 3;
    public static final int STATE_PRESSNONE = 4;// 正在下拉但还没有到刷新的状态
    private static final java.lang.String STATE_SAVE_IS_HIDDEN = "lq_state_is_hidden";
    public static int mState = STATE_NONE;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            boolean isSupportHidden = savedInstanceState.getBoolean(STATE_SAVE_IS_HIDDEN);

            FragmentTransaction ft = getFragmentManager().beginTransaction();
            if (isSupportHidden) {
                ft.hide(this);
            } else {
                ft.show(this);
            }
            ft.commit();
        }
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putBoolean(STATE_SAVE_IS_HIDDEN, isHidden());
    }

    @Override
    public void onSuccess(String result) {
        assert 1 == 0;
    }

    @Override
    public void onFail(String result) {
        assert 1 == 0;
    }

    protected <T> T $(View view, int id) {
        return (T) view.findViewById(id);
    }
}
