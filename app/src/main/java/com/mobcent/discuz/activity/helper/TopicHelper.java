package com.mobcent.discuz.activity.helper;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.appbyme.dev.R;
import com.mobcent.common.ImageLoader;
import com.mobcent.common.ScreenUtil;
import com.mobcent.discuz.base.EmoticonHelper;
import com.mobcent.discuz.base.UIJumper;
import com.mobcent.discuz.bean.TopicContent;
import com.mobcent.discuz.widget.ViewHolder;

import java.util.List;

import static com.mobcent.discuz.bean.TopicContent.TYPE_ATTACHMENT;
import static com.mobcent.discuz.bean.TopicContent.TYPE_AUDIO;
import static com.mobcent.discuz.bean.TopicContent.TYPE_IMAGE;
import static com.mobcent.discuz.bean.TopicContent.TYPE_LINK;
import static com.mobcent.discuz.bean.TopicContent.TYPE_TEXT;
import static com.mobcent.discuz.bean.TopicContent.TYPE_VIDEO;

/**
 * Created by sun on 2016/8/30.
 */

public class TopicHelper {

    /**
     * 设置内容
     *
     * @param context
     * @param viewGroup
     * @param topicContents
     */
    public static void updateContent(final Context context, LinearLayout viewGroup, List<TopicContent> topicContents) {
        viewGroup.removeAllViews();

        for (final TopicContent item : topicContents) {
            View itemView = LayoutInflater.from(context).inflate(R.layout.topic_detail1_middle_item, viewGroup, false);
            ViewHolder holder = new ViewHolder(itemView);

            setVisible(holder, item);

            int type = item.getType();
            final String content = item.getInfor();

            if (type == TYPE_LINK || type == TYPE_ATTACHMENT) {
                // 链接
                TextView tv = holder.getView(R.id.text_view);
                tv.setMovementMethod(LinkMovementMethod.getInstance());
                SpannableStringBuilder span = new SpannableStringBuilder(content);
                span.setSpan(new ClickableSpan() {
                    @Override
                    public void onClick(View widget) {
                        UIJumper.to(context, item.getUrl());

                    }
                }, 0, content.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                // 补充文字
                if (!TextUtils.isEmpty(item.getDesc())) {
                    span.append(item.getDesc());
                }

                tv.setText(span);
            } else if (type == TYPE_TEXT) {
                //普通文本，表情
                final TextView tv = holder.getView(R.id.text_view);
                tv.setTextIsSelectable(true);
                final int height = (int) tv.getTextSize();
                EmoticonHelper.addEmoticonSpans(context, content, height, new EmoticonHelper.EmoticonCallback() {
                    @Override
                    public void onEmoticonReady(SpannableStringBuilder builder) {
                        tv.setText(builder);
                    }
                });

            } else if (type == TYPE_VIDEO) {
                if (item.isVideoUnkown()) {
                    // 显示占位图片
                    holder.getView(R.id.video_view).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
//                            UIJumper.to(context, item.getInfor());
                            UIJumper.openVideo(context, item.getInfor());
                        }
                    });

                } else {
                    // 视频web
                    WebView webView = holder.getView(R.id.video_web);
                    webView.getLayoutParams().height = (int) (ScreenUtil.getScreenWidth() * 0.6);
                    webView.loadUrl(item.getInfor());
                }
            } else if (type == TYPE_AUDIO) {
                //音频
                holder.getView(R.id.audio_layout).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        UIJumper.openAudio(context, item.getInfor());
                    }
                });

            }else if (type == TYPE_IMAGE) {
                //图片
                final String url = item.getInfor().endsWith(".gif") ? item.getOriginalInfo() : item.getInfor();
                final ImageView imageView = holder.getView(R.id.img_view);
                holder.getConvertView().post(new Runnable() {
                    @Override
                    public void run() {
                        ImageLoader.load(url, imageView);
                    }
                });

                // TODO 点击图片进入ViewPager 查看原图（originalUrl)
            }

            viewGroup.addView(itemView);

        }

    }

    /**
     * 设置回帖内容
     *
     * @param context
     * @param viewGroup
     * @param topicContents
     */
    public static void updateReplyContent(final Context context, LinearLayout viewGroup, List<TopicContent> topicContents) {
        viewGroup.removeAllViews();

        for (final TopicContent item : topicContents) {
            View itemView = LayoutInflater.from(context).inflate(R.layout.topic_reply_middle_item, viewGroup, false);
            ViewHolder holder = new ViewHolder(itemView);

            int type = item.getType();
            holder.getView(R.id.text_view).setVisibility(
                    type == TYPE_LINK || type == TYPE_TEXT || type == TYPE_ATTACHMENT ? View.VISIBLE : View.GONE);
            holder.getView(R.id.img_view).setVisibility(
                    type == TYPE_IMAGE ? View.VISIBLE : View.GONE);

            final String content = item.getInfor();

            if (type == TYPE_LINK || type == TYPE_ATTACHMENT) {
                // 链接
                TextView tv = holder.getView(R.id.text_view);
                tv.setMovementMethod(LinkMovementMethod.getInstance());
                SpannableStringBuilder span = new SpannableStringBuilder(content);
                span.setSpan(new ClickableSpan() {
                    @Override
                    public void onClick(View widget) {
                        UIJumper.to(context, item.getUrl());

                    }
                }, 0, content.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                // 补充文字
                if (!TextUtils.isEmpty(item.getDesc())) {
                    span.append(item.getDesc());
                }

                tv.setText(span);
            } else if (type == TYPE_TEXT) {
                //普通文本，表情
                final TextView tv = holder.getView(R.id.text_view);
                tv.setTextIsSelectable(true);
                final int height = (int) tv.getTextSize();
                EmoticonHelper.addEmoticonSpans(context, content, height, new EmoticonHelper.EmoticonCallback() {
                    @Override
                    public void onEmoticonReady(SpannableStringBuilder builder) {
                        tv.setText(builder);
                    }
                });

            } else if (type == TYPE_IMAGE) {
                //图片
                final String url = item.getOriginalInfo();
//                final String url = item.getInfor().endsWith(".gif") ? item.getOriginalInfo() : item.getInfor();
                final ImageView imageView = holder.getView(R.id.img_view);
                holder.getConvertView().post(new Runnable() {
                    @Override
                    public void run() {
                        ImageLoader.load(url, imageView);
                    }
                });
                // TODO 点击图片进入ViewPager 查看原图（originalUrl)
            }

            viewGroup.addView(itemView);

        }

    }


    private static void setVisible(ViewHolder holder, TopicContent item) {
        int type = item.getType();
        holder.getView(R.id.text_view).setVisibility(
                type == TYPE_LINK || type == TYPE_TEXT || type == TYPE_ATTACHMENT ? View.VISIBLE : View.GONE);
        holder.getView(R.id.img_view).setVisibility(
                type == TYPE_IMAGE ? View.VISIBLE : View.GONE);
        holder.getView(R.id.video_view).setVisibility(type == TYPE_VIDEO && item.isVideoUnkown() ? View.VISIBLE : View.GONE);
        holder.getView(R.id.video_web).setVisibility(type == TYPE_VIDEO && !item.isVideoUnkown() ? View.VISIBLE : View.GONE);
        holder.getView(R.id.audio_layout).setVisibility(type == TYPE_AUDIO ? View.VISIBLE : View.GONE);
    }
}
