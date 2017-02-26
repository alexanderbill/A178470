package com.mobcent.discuz.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.mobcent.discuz.config.ForumSettings;


/**
 * Created by sundxing
 * 适应动态配置页面
 */
public abstract class DiscoveryBaseFragment extends BaseRefreshFragment {

    private static  int DEFUALTID = 0;

    public static DiscoveryBaseFragment newInstance(int newsModuleId, String type, String style) {
        Bundle args = new Bundle();
        args.putString("id", String.valueOf(newsModuleId));
        args.putString("type", type);

        DiscoveryBaseFragment fragment;
        switch (style) {
            case ForumSettings.LIST_TYPE_IMAGE:
                fragment = new Discovery1Fragment();
                break;
            case ForumSettings.LIST_TYPE_NINE:
                fragment = new Discovery2Fragment();
                break;
            case ForumSettings.LIST_TYPE_TIE_BA:
                fragment = new Discovery3Fragment();
                break;
            default:
                fragment= new Discovery3Fragment();
        }
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        if (getArguments() == null ||
                TextUtils.isEmpty(getNewsListId())) {
            Bundle args = new Bundle();
            args.putString("id", String.valueOf(++DEFUALTID));
        }
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        DEFUALTID--;
        super.onDestroy();
    }

    public  String getNewsListId() {
       return getArguments().getString("id");
    }

}
