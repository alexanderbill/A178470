package com.mobcent.discuz.module.user.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.appbyme.dev.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.mobcent.common.GlideCircleTransform;
import com.phone.niuche.views.widget.stackblur.NativeBlurProcess;

import discuz.com.net.service.model.me.UserResult;

/**
 * Created by pangxiaomin on 16/11/20.
 */
public class UserHomeCenterHeader extends RelativeLayout {

    private ImageView mAvatar;
    private ImageView mBackground;
    private TextView mName;
    private TextView mUserTitle;
    private TextView mEssenceNum;
    private TextView mFriendNum;
    private TextView mFollowNum;
    private TextView mSign;

    public UserHomeCenterHeader(Context context) {
        super(context);
        initView();
    }

    public UserHomeCenterHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public UserHomeCenterHeader(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView(){
        LayoutInflater.from(getContext()).inflate(R.layout.user_home_center_fragment_header,this,true);
        mAvatar = $(R.id.user_center_avatar);
        mBackground = $(R.id.user_center_background);
        mName = $(R.id.user_center_name);
        mUserTitle = $(R.id.user_center_user_title);
        mEssenceNum = $(R.id.user_center_essence_num);
        mFriendNum = $(R.id.user_center_friend_num);
        mFollowNum = $(R.id.user_center_follow_num);
        mSign = $(R.id.user_center_sign);
    }

    public void setContent(UserResult userInfo){
        if(userInfo == null) return;
        Glide.with(getContext()).load(userInfo.getIcon()).transform(new GlideCircleTransform(getContext())).into(mAvatar);
        Glide.with(getContext()).load(userInfo.getIcon()).asBitmap().into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                try{
                    NativeBlurProcess blur = new NativeBlurProcess();
                    final Bitmap blurImg = blur.blur(resource, 20);
                    ((Activity)getContext()).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mBackground.setImageBitmap(blurImg);
                            mBackground.invalidate();
                        }
                    });

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        mName.setText(userInfo.getName());
        mUserTitle.setText(userInfo.getUserTitle());
        mUserTitle.setSelected(userInfo.getGender() == 0);
        mUserTitle.setVisibility(VISIBLE);
        mEssenceNum.setText(getResources().getString(R.string.mc_forum_my_partin)+userInfo.getEssence_num());
        mFriendNum.setText(getResources().getString(R.string.mc_forum_user_follow)+userInfo.getFriend_num());
        mFollowNum.setText(getResources().getString(R.string.mc_forum_user_fan)+userInfo.getFollow_num());
        mSign.setText(userInfo.getSign());
    }

    protected <T> T $( int id) {
        return (T) findViewById(id);
    }
}
