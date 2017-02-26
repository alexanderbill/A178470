package com.mobcent.discuz.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mobcent.common.ImageLoader;
import com.mobcent.common.ScreenUtil;

/**
 * Created by sun on 2016/8/26.
 * 宽度固定的情况下，高度适应图片
 */

public class FitHeightImageView extends ImageView {
    private String url;

    public FitHeightImageView(Context context) {
        super(context);
        init();
    }

    public FitHeightImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FitHeightImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        setLayoutParams(lp);
        setMaxHeight(ScreenUtil.getScreenHeight());
        setMaxWidth(ScreenUtil.getScreenWidth());
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (url != null)
            ImageLoader.load(url, this);
    }
}
