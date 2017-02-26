package com.mobcent.discuz.base;

import com.mobcent.common.AppHashUtil;
import com.mobcent.discuz.activity.LoginUtils;

import java.util.HashMap;

import discuz.com.net.service.config.WebParamsKey;
import discuz.com.net.service.config.WebParamsValue;

/**
 * Created by pangxiaomin on 16/11/27.
 */
public class WebParamsMap {

    public static HashMap<String,String> map(){
        HashMap<String,String> map = new HashMap<>();
        map.put(WebParamsKey.egnVersion, WebParamsValue.egnVersion);
        map.put(WebParamsKey.appName, WebParamsValue.appName);
        map.put(WebParamsKey.sdkType, WebParamsValue.sdkType);
        map.put(WebParamsKey.packageName, WebParamsValue.packageName);

        map.put(WebParamsKey.forumKey, WebParamsValue.forumKey);
        map.put(WebParamsKey.accessSecret,  LoginUtils.getInstance().getAccessSecret());
        map.put(WebParamsKey.accessToken, LoginUtils.getInstance().getAccessToken());
        return map;
    }
}
