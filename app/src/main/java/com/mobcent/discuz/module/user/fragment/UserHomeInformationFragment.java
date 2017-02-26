package com.mobcent.discuz.module.user.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.appbyme.dev.R;
import com.mobcent.discuz.fragments.BaseFragment;
import com.mobcent.discuz.module.user.view.ProfileTextView;
import com.mobcent.discuz.uitls.DipUtils;

import java.util.ArrayList;

import discuz.com.bean.me.Profile;

/**
 * Created by pangxiaomin on 16/11/20.
 * 我-个人页-个人资料
 */
public class UserHomeInformationFragment extends BaseUserInnerScrollFragment {

    private LinearLayout mContent;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_home_information, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);

    }

    private void initView(View view){
        mContent = $(view, R.id.content_container);
    }

    public void setContent(ArrayList<Profile> profiles, ArrayList<Profile> credits ){
        if(profiles == null) return;
        mContent.removeAllViews();
        for(int i=0; i<profiles.size(); i++){
            mContent.addView(createItemView(profiles.get(i)));
        }

        mContent.addView(createLine());

        for(int i=0; i<credits.size(); i++){
            mContent.addView(createItemView(credits.get(i)));
        }

    }

    private ProfileTextView createItemView(Profile profile){
        ProfileTextView textView = new ProfileTextView(getActivity());
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, DipUtils.dipToPx(getActivity(),50));
        textView.setLayoutParams(params);
        textView.bindData(profile);
        return textView;
    }

    private View createLine(){
        View line = new View(getActivity());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, DipUtils.dipToPx(getActivity(),10));
        line.setLayoutParams(params);
        line.setBackgroundColor(getResources().getColor(R.color.line_color));
        return line;
    }
}
