package com.mobcent.discuz.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.appbyme.dev.R;
import com.mobcent.common.FragmentBackHandler;
import com.mobcent.discuz.adapter.GalleryAdapter;
import com.zejian.emotionkeyboard.fragment.EmotionMainFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sun
 @see EmotionMainFragment
 */
public class EmotionExtraFragment extends com.zejian.emotionkeyboard.fragment.EmotionMainFragment implements FragmentBackHandler {

    private RecyclerView recyclerView;
    private final ArrayList<String> mPictures = new ArrayList<>();
    private FrameLayout mPreviewLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = super.onCreateView(inflater, container, savedInstanceState);
         mPreviewLayout = (FrameLayout) v.findViewById(R.id.content_preview_container);
        recyclerView = (RecyclerView) inflater.inflate(R.layout.ex_scroll_list, mPreviewLayout, false);
        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        return v;
    }

    @Override
    protected void addOtherPanelFragment(List<Fragment> fragments) {
        fragments.add(new FunctionFragment());
    }

    @Override
    protected boolean enableExtraPanel() {
        return true;
    }

    public void setConfirmClick(View.OnClickListener listener) {
        bar_btn_send.setOnClickListener(listener);
    }

    public void hideAllKeyBoard() {
        mEmotionKeyboard.hideAllPanel();
    }

    //处理返回的图片
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void showPicturePreview(ArrayList<String> arrayList) {
        mPictures.clear();
        mPictures.addAll(arrayList);
        mPreviewLayout.removeAllViews();
        mPreviewLayout.addView(recyclerView);
        GalleryAdapter adapter = new GalleryAdapter(getContext(), arrayList, mPreviewLayout);
        recyclerView.setAdapter(adapter);
    }

    public ArrayList<String> getPictures() {
        return mPictures;
    }

    public void clearPreviewList() {
        mPreviewLayout.removeAllViews();
        mPictures.clear();
    }
}


