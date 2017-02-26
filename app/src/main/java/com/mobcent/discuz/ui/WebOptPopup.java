package com.mobcent.discuz.ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.appbyme.dev.R;

/**
 * Created by sun on 2016/9/9.
 */

public class WebOptPopup extends BasePopup implements View.OnClickListener{
    private final String mUrl;

    public WebOptPopup(Context context, String url) {
        super(context);
        setWindowLayoutMode(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        mUrl = url;
        ViewGroup viewGroup = (ViewGroup) getContentView().findViewById(R.id.post_collect).getParent();
        viewGroup.setVisibility(View.GONE);

        getContentView().findViewById(R.id.post_browser_open).setOnClickListener(this);
        getContentView().findViewById(R.id.post_link_copy).setOnClickListener(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.topic_toolbar_panel;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.post_browser_open:
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(mUrl));
                mContext.startActivity(intent);
                break;

            case R.id.post_link_copy:
                ClipboardManager cm = (ClipboardManager) mContext.getSystemService(Context.CLIPBOARD_SERVICE);
                // 将文本内容放到系统剪贴板里。
                cm.setPrimaryClip(ClipData.newPlainText(null, mUrl));
                Toast.makeText(mContext, "已复制到剪贴板", Toast.LENGTH_LONG).show();
                //管理帖子
                break;

        }
        dismiss();
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }
}
