package com.mobcent.discuz.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.appbyme.dev.R;
import com.bumptech.glide.Glide;
import com.mobcent.discuz.activity.LoginActivity;
import com.mobcent.discuz.activity.LoginUtils;
import com.mobcent.discuz.api.UrlFactory;
import com.mobcent.discuz.base.constant.DiscuzRequest;
import com.mobcent.discuz.module.user.activity.UserHomeActivity;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by ubuntu on 16-6-21.
 */
public class MeFragment extends BaseFragment implements View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_self_header_item, container, false);
        view.findViewById(R.id.draft).setOnClickListener(this);
        view.findViewById(R.id.message).setOnClickListener(this);
        view.findViewById(R.id.manage).setOnClickListener(this);
        view.findViewById(R.id.settings).setOnClickListener(this);
        view.findViewById(R.id.mc_forum_user_publish).setOnClickListener(this);
        view.findViewById(R.id.mc_forum_user_friend).setOnClickListener(this);
        view.findViewById(R.id.mc_forum_user_collect).setOnClickListener(this);
        view.findViewById(R.id.mc_forum_user_info).setOnClickListener(this);

        String userinfo = LoginUtils.getInstance().getUserInfo();
        if (!TextUtils.isEmpty(userinfo)) {
            try {
                JSONObject object = new JSONObject(userinfo);
                Glide.with(getContext()).load(object.getString("avatar")).into((ImageView) view.findViewById(R.id.mc_forum_user_header_icon));
                ((TextView)view.findViewById(R.id.mc_forum_user_name)).setText(object.getString("userName"));
                ((TextView)view.findViewById(R.id.mc_forum_user_level)).setText(object.getString("userTitle"));
                JSONArray array = object.getJSONArray("creditShowList");
                String integral = "";
                for (int i = 0; i < array.length(); i++) {
                    JSONObject o = array.getJSONObject(i);
                    integral += o.getString("title") + ":" + o.getString("data");
                }
                ((TextView) view.findViewById(R.id.mc_forum_user_integral)).setText(integral);
            } catch (Exception e) {

            }
        }
        return view;
    }

    private void startLoginActivity() {
        Intent intent = new Intent(getContext(), LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        if (!LoginUtils.getInstance().isLogin()) {
            startLoginActivity();
            return;
        }
        int id = v.getId();
        switch (id) {
            case R.id.draft:
                break;
            case R.id.message:
                break;
            case R.id.manage:
                final Dialog dialog = new Dialog(getContext(), R.style.mc_forum_home_publish_dialog_nofullscreen);
                final LayoutInflater in = LayoutInflater.from(getContext());
                View view = in.inflate(R.layout.user_home_switch_user_dialog, null);
                view.findViewById(R.id.logout_layout).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                        builder.setTitle(getContext().getString(R.string.mc_forum_logout_dialog))
                                .setCancelable(true)
                                .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        JSONObject param = new JSONObject();
                                        try {
                                            param.put("type", "logout");
                                        } catch (Exception e) {

                                        }

                                        new DiscuzRequest(UrlFactory.LOGIN, param.toString(), new LogoutHandler()).execute();
                                        startLoginActivity();
                                    }
                                })
                                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                });
                        builder.create().show();
                    }
                });
                dialog.setContentView(view);
                dialog.show();
                break;
            case R.id.settings:
                break;
            case R.id.mc_forum_user_publish:
                break;
            case R.id.mc_forum_user_friend:
                break;
            case R.id.mc_forum_user_collect:
                break;
            case R.id.mc_forum_user_info:
                Intent intent = new Intent(getContext(), UserHomeActivity.class);
                startActivity(intent);
                break;
        }
    }

    class LogoutHandler implements HttpResponseHandler {
        @Override
        public void onSuccess(String result) {
            try {
                JSONObject object = new JSONObject(result);
                if ("1".equals(object.getString("rs"))) {
                    LoginUtils.getInstance().setLogout();
                }
                onFail(object.getString("errcode"));
            } catch (Exception e) {
                onFail("登出接口有问题，请联系管理员");
            }
        }

        @Override
        public void onFail(String result) {
            Toast.makeText(getContext(), result, Toast.LENGTH_SHORT).show();
        }
    }
}
