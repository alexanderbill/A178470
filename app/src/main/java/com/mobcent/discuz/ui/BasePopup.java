package com.mobcent.discuz.ui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;

/**
 * Created by sun on 2016/9/2.
 */
public abstract class BasePopup extends PopupWindow{
    protected Context mContext;

    public BasePopup(Context context) {
        super(context);
        mContext = context;
        setBackgroundDrawable(
                new ColorDrawable(mContext.getResources().getColor(android.R.color.transparent)));
        setOutsideTouchable(true);
        setFocusable(true);
        LayoutInflater inflater =
                (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(getLayoutRes(), null);
        setContentView(view);
    }

    protected abstract int getLayoutRes();

}