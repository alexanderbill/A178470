package com.mobcent.discuz.api;

import android.util.Log;
import com.mobcent.common.JsonConverter;
import android.text.TextUtils;
import com.mobcent.discuz.base.constant.DiscuzRequest;
import com.mobcent.discuz.bean.Reply;
import com.mobcent.discuz.fragments.HttpResponseHandler;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import static android.R.attr.id;
import static com.appbyme.dev.R.id.page;
import static com.appbyme.dev.R.id.reply;
import static com.litesuits.android.async.AsyncExecutor.handler;

/**
 * 龙泉论坛Api
 * Created by sun on 2016/8/21.
 */

public class LqForumApi {

    public static final int PAGE_SIZE_TOPIC_REPLY = 10; // 帖子详情的回帖页
    /**
     * 首页
     * @param handler
     */
    public static DiscuzRequest home(HttpResponseHandler handler) {
        return moduleConfig(handler, 6);
    }

    public static DiscuzRequest moduleConfig(HttpResponseHandler handler , long id) {
        RequestParams params = new RequestParams();
        params.add("moduleId", id);
        params.setUseCache(true);
        DiscuzRequest request = new DiscuzRequest(UrlFactory.MODULE_CONFIG, params, handler);
        request.begin();
        return request;
    }

    /**
     * 首页 法语开示
     *
     */
    public static DiscuzRequest moreTopics(long newsModelId, int page,  HttpResponseHandler handler) {
        RequestParams params = new RequestParams();
        params.add("moduleId", newsModelId);
        params.add("page",page);
        params.setUseCache(true);
        DiscuzRequest request = new DiscuzRequest(UrlFactory.NEWS_LIST, params, handler);
        request.begin();
        return request;
    }

    /**
     * 帖子详情 & 帖子评论
     * page > 1 只有评论列表，不包含topic 内容
     */
    public static DiscuzRequest topicDetail( long topicId, int page, HttpResponseHandler handler) {
        RequestParams params = new RequestParams();
        params.add("topicId",topicId);
        params.add("page",page);
        params.add("pageSize", PAGE_SIZE_TOPIC_REPLY);
        params.setUseCache(true);
        DiscuzRequest request = new DiscuzRequest(UrlFactory.DETAIL_FORUM, params, handler);
        request.begin();
        return request;
    }

    /**
     * 关注TA
     * @param userId
     * @param handler
     */
    public static DiscuzRequest followUser(boolean follow, long userId, HttpResponseHandler handler) {
        RequestParams params = new RequestParams();
        params.add("uid",userId);
        params.add("type", follow ? "follow" : "unfollow");
        DiscuzRequest request = new DiscuzRequest(UrlFactory.USER_ADMIN, params.getJsonStr(), handler);
        request.begin();
        return request;
    }

    public static DiscuzRequest reply(Reply reply, HttpResponseHandler handler) {
        String json = JsonConverter.toString(reply);
        RequestParams params = new RequestParams();
        params.add("act",  "reply");
        try {
            String encode = URLEncoder.encode(json, "utf-8");
            params.add("json", URLEncoder.encode(encode,"utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Log.d("API", "reply json :" + json);
        DiscuzRequest request = new DiscuzRequest(UrlFactory.TOPIC_ADMIN, params.getJsonStr(), handler);
        request.begin();
        return request;
    }

    /**
     * 举报帖子
     * @param id
     * @param type
     * @param text
     * @param handler
     * @return
     */
    public static DiscuzRequest report(long id, String type, String text, HttpResponseHandler handler) {
        RequestParams params = new RequestParams();
        params.add("idType",  "post");
        params.add("id",id);
        try {
            String encode = URLEncoder.encode("["+type +"]", "utf-8");
            params.add("message", encode + text);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        DiscuzRequest request = new DiscuzRequest(UrlFactory.USER_REPORT, params.getJsonStr(), handler);
        request.begin();
        return request;
    }


    public static DiscuzRequest forumList(HttpResponseHandler handler) {
        RequestParams params = new RequestParams();
        params.setUseCache(true);
        DiscuzRequest request = new DiscuzRequest(UrlFactory.FORUM_LIST, params, handler);
        request.begin();
        return request;
    }

    public static DiscuzRequest forumList(HttpResponseHandler handler, String Type) {
        RequestParams params = new RequestParams();
        if (!TextUtils.isEmpty(Type)) {
            params.add("type", Type);
        }
        params.setUseCache(true);
        DiscuzRequest request = new DiscuzRequest(UrlFactory.FORUM_LIST, params, handler);
        request.begin();
        return request;
    }
    public static DiscuzRequest topicFavor(int id, boolean follow, HttpResponseHandler handler) {
        RequestParams params = new RequestParams();
        params.add("id", id);
        params.add("idType", "tid");
        params.add("action", follow ? "favorite" : "delfavorite");
        DiscuzRequest request = new DiscuzRequest(UrlFactory.USER_FAVOR, params.getJsonStr(), handler);
        request.begin();
        return request;
    }
    public static DiscuzRequest userFavor(int id, boolean follow, HttpResponseHandler handler) {
        RequestParams params = new RequestParams();
        params.add("id", id);
        params.add("idType", "fid");
        params.add("action", follow ? "favorite" : "delfavorite");
        DiscuzRequest request = new DiscuzRequest(UrlFactory.USER_FAVOR, params.getJsonStr(), handler);
        request.begin();
        return request;
    }

    public static DiscuzRequest topicList(int page, String sortby, String boardId, HttpResponseHandler handler) {
        return topicList(page, 0, sortby, boardId, handler);
    }

    public static DiscuzRequest topicList(int page, int filterId, String sortby, String boardId, HttpResponseHandler handler) {
        RequestParams params = new RequestParams();
        params.setUseCache(true);
        params.add("topOrder", "1");
        params.add("pageSize", "20");
        params.add("filterId", filterId);
        params.add("filterType", "typeid");
        params.add("sortby", sortby);
        params.add("page", String.valueOf(page));
        params.add("isRatio", "1");
        params.add("circle", "0");
        params.add("isImageList", "1");
        params.add("boardId", boardId);
        DiscuzRequest request = new DiscuzRequest(UrlFactory.TOPIC_LIST, params, handler);
        request.begin();
        return request;
    }

    public static DiscuzRequest newsList(int page, String moduleId, HttpResponseHandler handler) {
        RequestParams params = new RequestParams();
        params.setUseCache(true);
        params.add("pageSize", "20");
        params.add("moduleId", moduleId);
        params.add("page", String.valueOf(page));
        params.add("circle", "0");
        params.add("isImageList", "1");
        DiscuzRequest request = new DiscuzRequest(UrlFactory.NEWS_LIST, params, handler);
        request.begin();
        return request;
    }

    public static DiscuzRequest getSettings(HttpResponseHandler handler) {
        RequestParams params = new RequestParams();
        params.setUseCache(true);
        params.add("socket_timeout", 3000);
        params.add("connection_timeout",1000);
        params.add("getSetting","%7b%22body%22%3a%7b%22postInfo%22%3a%7b%22forumIds%22%3a%220%22%7d%7d%7d");
        DiscuzRequest request = new DiscuzRequest(UrlFactory.SETTING, params, handler);
        request.begin();
        return request;
    }

    /**
     * app界面显示结构配置
     * @param handler
     * @return
     */
    public static DiscuzRequest initUI(HttpResponseHandler handler) {
        RequestParams params = new RequestParams();
        params.setUseCache(true);
        params.add("connection_timeout",5000);
        params.add("forumType","7");
        DiscuzRequest request = new DiscuzRequest(UrlFactory.INIT_UI, params, handler);
        request.begin();
        return request;
    }

}
