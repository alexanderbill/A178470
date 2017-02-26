package com.mobcent.discuz.module.user.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.appbyme.dev.R;

import discuz.com.bean.me.Profile;

/**
 * Created by pangxiaomin on 16/12/18.
 */
public class ProfileTextView extends RelativeLayout {

    private TextView mTitle;
    private TextView mContent;

    public ProfileTextView(Context context) {
        super(context);
        init();
    }

    public ProfileTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ProfileTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        LayoutInflater.from(getContext()).inflate(R.layout.layout_profile_text_view,this,true);
        mTitle = (TextView)findViewById(R.id.profile_title);
        mContent = (TextView)findViewById(R.id.profile_content);
    }

    public void bindData(Profile profile){
        mTitle.setText(profile.getTitle());
        mContent.setText(profile.getData());
    }
}
