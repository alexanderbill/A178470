package com.mobcent.discuz.ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.appbyme.dev.R;
import com.mobcent.common.JsonConverter;
import com.mobcent.discuz.api.LqForumApi;
import com.mobcent.discuz.bean.Base;
import com.mobcent.discuz.bean.Topic;
import com.mobcent.discuz.fragments.HttpResponseHandler;

/**
 * Created by sun on 2016/9/9.
 * 帖子操作（右上角触发）
 */

public class TopicOptPopup extends BasePopup implements View.OnClickListener{
    private final Topic mTopic;
    private final String mUrl;
    private ViewModeCallback onlyPosterCallback;
    private boolean mOnlyPoster = false;

    public TopicOptPopup(Context context, Topic topic, String url) {
        super(context);
        setWindowLayoutMode(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        mTopic = topic;
        mUrl = url;
        getContentView().findViewById(R.id.post_collect).setSelected(mTopic.getIs_favor() > 0);
        getContentView().findViewById(R.id.post_collect).setOnClickListener(this);
        getContentView().findViewById(R.id.post_browser_open).setOnClickListener(this);
        getContentView().findViewById(R.id.post_link_copy).setOnClickListener(this);
        getContentView().findViewById(R.id.post_only_poster_visible).setOnClickListener(this);
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
            case R.id.post_only_poster_visible:
                // 只看楼主
                if (onlyPosterCallback != null) {
                    mOnlyPoster = !mOnlyPoster;
                    onlyPosterCallback.onlyPoster(mOnlyPoster);
                }
               TextView tv = (TextView) getContentView().findViewById(R.id.post_only_poster_visible_txt);
                tv.setText(mOnlyPoster ? mContext.getString(R.string.mc_forum_posts_by_all)
                        : mContext.getString(R.string.mc_forum_posts_by_author));
                break;
            case R.id.post_collect:
//                final WeakReference<Context> reference = new WeakReference<Context>(mContext);
                final boolean nowIsFavor = mTopic.getIs_favor() > 0;
                LqForumApi.topicFavor(mTopic.getTopic_id(), !nowIsFavor, new HttpResponseHandler() {
                    @Override
                    public void onSuccess(String result) {
                        Base result1 = JsonConverter.format(result, Base.class);
                        if (result1.isSuccess()) {
                            mTopic.setIs_favor(!nowIsFavor ? 1 : 0);
                        }
                        result1.checkAlert(mContext);
                    }

                    @Override
                    public void onFail(String result) {
                        Toast.makeText(mContext, result, Toast.LENGTH_SHORT).show();

                    }
                });
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

    public void setOnlyPosterCallback(ViewModeCallback onlyPosterCallback) {
        this.onlyPosterCallback = onlyPosterCallback;
    }

    public interface ViewModeCallback{
        void onlyPoster(boolean onlyPoster);
    }
}
