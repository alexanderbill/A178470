package com.mobcent.discuz.config;

import com.mobcent.common.JsonConverter;
import com.mobcent.discuz.api.LqForumApi;
import com.mobcent.discuz.bean.InitUIResult;
import com.mobcent.discuz.bean.SettingResult;
import com.mobcent.discuz.fragments.HttpResponseHandler;

/**
 * Created by sun on 2016/9/14.
 */

/**
 * created by sun 2016.10
 * 论坛设置
 */
public class ForumSettings {
    public static final String LIST_TYPE_TIE_BA = "tieba";
    public static final String LIST_TYPE_NINE = "imageSudoku";
    public static final String LIST_TYPE_IMAGE = "image";

    private InitUIResult mUISetting;

    public InitUIResult getmUISetting() {
        return mUISetting;
    }

    public boolean isLoading() {
        return mState == State.LOADING;
    }

    enum State{
         LOADING, FIAL, OK
    }
    private ForumSettings(){
    }
    private static class Holder {
        public static final ForumSettings INSTANCE = new ForumSettings();
    }
    public static ForumSettings getInstance() {
        return Holder.INSTANCE;
    }

    private State mState;

    public  void loadSetting() {
        if (mState == State.LOADING || mState == State.OK) return;

        mState = State.LOADING;
        LqForumApi.initUI(new HttpResponseHandler() {
            @Override
            public void onSuccess(String result) {
//                SettingResult settingResult = JsonConverter.format(result, SettingResult.class);
                InitUIResult settingResult = JsonConverter.format(result, InitUIResult.class);
                if (settingResult.isSuccess()) {
                    mState = State.OK;
                    mUISetting = settingResult;
                } else {
                    mState = State.FIAL;
                }
            }

            @Override
            public void onFail(String result) {
                mState = State.FIAL;
            }
        });
    }
}
