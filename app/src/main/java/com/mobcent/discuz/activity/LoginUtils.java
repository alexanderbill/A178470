package com.mobcent.discuz.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.mobcent.discuz.application.DiscuzApplication;
import com.mobcent.discuz.base.constant.DiscuzRequest;
import com.mobcent.discuz.config.PasswordHelp;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ubuntu on 16-6-29.
 */
public class LoginUtils {

    private static LoginUtils instance = new LoginUtils();
    private Context mContext;
    private SharedPreferences sp;
    private LoginUtils() {

    }

    public static LoginUtils getInstance() {
        return instance;
    }

    public void init(Context context) {
        mContext = context;
        sp = mContext.getSharedPreferences("login",Context.MODE_PRIVATE);
    }

    public boolean isLogin() {
        String name = sp.getString("secret", "");
        return !name.equals("");
    }

    public String getAccessSecret() {
        return sp.getString("secret", "");
    }

    public String getUserInfo() {
        return sp.getString("userinfo", "");
    }

    public String getAccessToken() {
        return sp.getString("token", "");
    }

    public  String getUserId(){
        return sp.getString("uid", "");
    }

    public void setLogin(String info) throws JSONException {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("userinfo", info);
        JSONObject obj = new JSONObject(info);
        try {
            editor.putString("uid", obj.getString("uid"));
            editor.putString("secret", obj.getString("secret"));
            editor.putString("token", obj.getString("token"));
        } catch (Exception e) {
            obj = obj.getJSONObject("body");
            editor.putString("secret", obj.getString("secret"));
            editor.putString("token", obj.getString("token"));
        }
        editor.commit();
    }

    public void setLogout() throws JSONException {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("userinfo", "");
        editor.putString("secret", "");
        editor.putString("token", "");
        editor.commit();
    }

    public static void autoLogin() {
        JSONObject obj = new JSONObject();
        String[] account = PasswordHelp.readPassword(DiscuzApplication._instance);
        try {
            obj.put("mType", "login");
            obj.put("isValidation", "1");
            obj.put("username", account[0]);
            obj.put("password", account[1]);
            new DiscuzRequest("user/login", obj.toString(), null).begin();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


}
