package com.mobcent.discuz.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.appbyme.dev.R;
import com.mobcent.discuz.application.DiscuzApplication;
import com.mobcent.discuz.base.constant.DiscuzRequest;
import com.mobcent.discuz.config.PasswordHelp;
import com.mobcent.discuz.fragments.HttpResponseHandler;

import org.json.JSONObject;

/**
 * Created by ubuntu on 16-6-29.
 */
public class LoginActivity extends Activity {

    private TextView mUsername;
    private TextView mPassword;
    public static int QQ_LOGIN = 1;

    public void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(R.layout.user_login_fragment);
        findViewById(R.id.find_password).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebActivity.start(LoginActivity.this, DiscuzRequest.baseUrl + "user/getpwd", "找回密码");
            }
        });
        mUsername = (TextView)findViewById(R.id.user_login_name_edit);
        mPassword = (TextView)findViewById(R.id.user_login_password_edit);

        Button button = (Button)findViewById(R.id.login_submit_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String u = mUsername.getText().toString().trim();
                String p = mPassword.getText().toString().trim();
                if (!TextUtils.isEmpty(u) && !TextUtils.isEmpty(p)) {
                    PasswordHelp.savePassword(DiscuzApplication._instance, u, p, true);
                    try {
                        JSONObject obj = new JSONObject();
                        obj.put("mType", "login");
                        obj.put("isValidation", "1");
                        obj.put("username", u);
                        obj.put("password", p);
                        new DiscuzRequest("user/login", obj.toString(), new Handler()).begin();
                    } catch (Exception e) {

                    }
                }
            }
        });
        findViewById(R.id.user_qq_login_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //GET //mobcent/app/web/index.php?r=user/qqlogin&mod=login&op=init&referer=forum.php&statfrom=login_simple&sdkVersion=2.4.3.0&apphash=afded4a4 HTTP/1.1
                WebActivity.startActivityForResult(LoginActivity.this, DiscuzRequest.baseUrl + "user/qqlogin&mod=login&op=init&referer=forum.php&statfrom=login_simple&sdkVersion=2.4.3.0&apphash=afded4a4", "同步设置");
            }
        });
    }

    private class Handler implements HttpResponseHandler {
        @Override
        public void onSuccess(String result) {
            try {
                JSONObject object = new JSONObject(result);
                if ("1".equals(object.getString("rs"))) {
                    LoginUtils.getInstance().setLogin(result);
                    finish();
                } else {
                    onFail(object.getString("errcode"));
                }
            } catch (Exception e) {
                onFail("登录接口有问题，请联系管理员");
            }
        }

        @Override
        public void onFail(String result) {
            Toast.makeText(LoginActivity.this, result, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (resultCode != RESULT_OK) {
            return;
        }
        if (requestCode == QQ_LOGIN) {
            String openid = intent.getExtras().getString("openid");
            String oauth_token = intent.getExtras().getString("oauth_token");
            try {
                JSONObject obj = new JSONObject();
                obj.put("mType", "login");
                obj.put("isValidation", "1");
                obj.put("oauthToken", oauth_token);
                obj.put("openId", openid);
                new DiscuzRequest("user/platforminfo", obj.toString(), new Handler()).begin();
            } catch (Exception e) {

            }
        }
    }
}
