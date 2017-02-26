package com.mobcent.discuz.base;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import com.mobcent.discuz.activity.BoardListDetailActivity;
import com.mobcent.discuz.activity.BoardTopMoreList;
import com.mobcent.discuz.activity.ModuleConfigActivity;
import com.mobcent.discuz.activity.MoreNewActivity;
import com.mobcent.discuz.activity.WebActivity;
import com.mobcent.discuz.activity.TopicDetailActivity;
import com.mobcent.discuz.api.UrlFactory;
import com.mobcent.discuz.bean.Component;

import java.net.URL;
import java.util.Set;

/**
 * Created by sun on 2016/8/23.
 * 页面跳转工具类
 */
public class UIJumper {
    private static final String TAG = UIJumper.class.getSimpleName();

    public static void jump(Context context, Component component) {
        final String type = component.getType();
        long id = component.getTargetId();
        Log.d(TAG, "jump:" + type + "-" + id);
        switch (type) {
            case Component.TYPE_POST_LIST:
                id = component.getTargetId();
                jumpTopic(context, id);
                break;
            case Component.TYPE_APP:
                jumpWebView(context, component.getExtParams1().getRedirect(), component.getContent());
                break;
            case Component.TYPE_TOPIC_LIST:
                jumpForumSection(context, id);
                break;
            case Component.TYPE_NEWS_LIST:
                jumpNewsList(context, id);
                break;
            case Component.TYPE_REF:
                id = component.getExtParams1().getModuleId();
                jumpModuleRef(context, id, component.getContent());
                break;
            default:
                break;
        }
    }

    private static void jumpModuleRef(Context context, long id, String title) {
        ModuleConfigActivity.start(context, id, title);
    }

    /**
     * @deprecated  @
     * @see UIJumper#jump(Context, Component)
     * @param context
     * @param type
     * @param id
     * @param urlRef
     */
    public static void jump(Context context, String type, long id, String urlRef) {
        Log.d(TAG, "jump:" + type + "-" + id);
        switch (type) {
            case Component.TYPE_POST_LIST:
                jumpTopic(context, id);
                break;
            case Component.TYPE_APP:
                jumpWebView(context, urlRef, "");
                break;
            case Component.TYPE_TOPIC_LIST:
                jumpForumSection(context, id);
                break;
            case Component.TYPE_NEWS_LIST:
                jumpNewsList(context, id);
                break;
            case Component.TYPE_REF:
                throw new IllegalStateException("type ref call jump()");
        }
    }

    /**
     *  帖子列表
     * @param context
     * @param id
     */
    private static void jumpNewsList(Context context, long id) {
        MoreNewActivity.start(context, id);
    }

    /**
     * 跳转论坛版块
     * @param context
     * @param id
     */
    public static void jumpForumSection(Context context, long id) {
        BoardListDetailActivity.start(context, id);
    }

    public static void jumpTopTopicList(Context context, long id) {
        BoardTopMoreList.start(context, id);
    }

    /**
     * 跳转H5页面
     *
     * @param context
     * @param url
     */
    public static void jumpWebView(Context context, String url, String title) {
        WebActivity.start(context, url, title);
    }

    /**
     * 跳转话题详情
     *
     * @param context
     * @param id
     */
    public static void jumpTopic(Context context, long id) {
        TopicDetailActivity.start(context, id);
    }

    /**
     * 内部跳转，需要根据url定义 是否打开本地界面，或者webview
     * 1 http://forum.longquanzs.org/home.php?mod=space&uid=214362  用户详情（外部/内部）
     * 2 http://forum.longquanzs.org/mailto:lqwsx2016@qq.com 邮箱调用
     * 3 http://forum.longquanzs.org/forum.php?mod=viewthread&tid=59858 帖子详情（内部）
     * 4 http://forum.longquanzs.org/forum.php?mod=attachment&aid=MTM5MTYwfGI5ZmM4NWIwfDE0NzI0Mzk2NDh8MjE0MzYyfDY0NTUx&nothumb=yes (附件）
     * 5 http://forum.longquanzs.org/forum.php?mod=post&action=edit&fid=525&tid=64551&pid=332705 编辑帖子
     * 6 http://forum.longquanzs.org/mobcent/app/web/index.php?r=forum/topicadminex&sdkVersion=2.5.0.0&accessToken=274d079f604beba7d6edaa76be052&accessSecret=db799660500f1cafae3d030c09caa&apphash=276399a6&topicId=64551&postId=332705
     * 删帖子
     * @param context
     * @param url
     */
    public static void to(Context context, String url) {
        if(url.contains("mailto:")) {
            String email = url.substring(url.lastIndexOf(":") + 1);
            Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
            String[] recipients = new String[]{email};
            emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, recipients);
            emailIntent.setType("text/plain");
            context.startActivity(Intent.createChooser(emailIntent, "发送邮件"));
            return;
        }
        Uri uri = Uri.parse(url);
        Set<String> parameterNames = uri.getQueryParameterNames();
        if (parameterNames.size() == 2) {
            // 其它定位或页码信息的 使用webView呈现
            if (parameterNames.contains("uid")) {
                // 用户
            } else if (parameterNames.contains("tid")) {
                jumpTopic(context, Long.decode(uri.getQueryParameter("tid")));
                return;
            }
        }
        Log.d("JUMP","to:" + url);

        jumpWebView(context, url, "");
    }

    public static void openAudio(Context context,  String url) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra ("oneshot",0);
        intent.putExtra ("configchange",0);
        intent.setDataAndType (Uri.parse(url), "audio/*");
        intent.setDataAndType (Uri.parse(url), "audio/*");
        context.startActivity(intent);
    }

    public static void openVideo(Context context, String url) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra ("oneshot",0);
        intent.putExtra ("configchange",0);
        intent.setDataAndType (Uri.parse(url), "video/*");
        context.startActivity(intent);
    }
    //{"body":{"json":{"fid":525,"tid":64551,"location":"","aid":"","content":"[{\"type\":0,\"infor\":\"刚刚\"}]","longitude":"116.27367401123047","latitude":"40.03788375854492","isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"isShowPostion":0,"replyId":332705,"isQuote":1}}}

    // "replyId":postId
    public static void reply(Context mContext, long topicId, long postId, boolean isQute) {
        //
    }
}
