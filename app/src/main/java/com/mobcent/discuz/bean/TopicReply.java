package com.mobcent.discuz.bean;

import java.util.List;

/**
 * Created by sun on 2016/8/29.
 * 帖子回复
 */

public class TopicReply {

    /**
     * reply_id : 214362
     * reply_content : [{"infor":"[嘻嘻][嘻嘻][送花][送花]感恩","type":0}]
     * reply_type : normal
     * reply_name : sundxing
     * reply_posts_id : 332703
     * position : 2
     * posts_date : 1472372901000
     * icon : http://forum.longquanzs.org/uc_server/avatar.php?uid=214362&size=middle
     * level : 1
     * userTitle : 新手上路
     * location :
     * mobileSign : 来自龙泉论坛手机客户端
     * reply_status : 1
     * status : 1
     * role_num : 1
     * title :
     * is_quote : 1
     * quote_pid : 0
     * quote_content : lqsapptest 发表于 2016-8-28 14:33
     @sundxing
     @sundxing @stest1 @stest2
     #文本
      * quote_user_name :
      * delThread : true
      * managePanel : [{"action":"http://forum.longquanzs.org/forum.php?mod=post&action=edit&fid=525&tid=64551&pid=332703","title":"编辑"},{"type":"delthread","action":"http://forum.longquanzs.org/mobcent/app/web/index.php?r=forum/topicadminex&sdkVersion=2.5.0.0&accessToken=274d079f604beba7d6edaa76be052&accessSecret=db799660500f1cafae3d030c09caa&apphash=276399a6&topicId=64551&postId=332703","title":"删帖"}]
      * extraPanel : [{"action":"http://forum.longquanzs.org/mobcent/app/web/index.php?r=forum/support&sdkVersion=2.5.0.0&accessToken=274d079f604beba7d6edaa76be052&accessSecret=db799660500f1cafae3d030c09caa&apphash=276399a6&tid=64551&pid=332703&type=post","title":"支持","recommendAdd":"","extParams":{"beforeAction":"","recommendAdd":0,"isHasRecommendAdd":0},"type":"support"}]
     */

    private int reply_id;
    private String reply_type;
    private String reply_name;
    private int reply_posts_id;
    private int position;
    private String posts_date;
    private String icon;
    private int level;
    private String userTitle;
    private String location;
    private String mobileSign;
    private int reply_status;
    private int status;
    private int role_num;
    private String title;
    private int is_quote;
    private int quote_pid;
    private String quote_content;
    private String quote_user_name;
    private boolean delThread;
    /**
     * infor : [嘻嘻][嘻嘻][送花][送花]感恩
     * type : 0
     */

    private List<TopicContent> reply_content;
    /**
     * action : http://forum.longquanzs.org/forum.php?mod=post&action=edit&fid=525&tid=64551&pid=332703
     * title : 编辑
     */

    private List<ManagePanelBean> managePanel;
    private int topicId;

    public int getReply_id() {
        return reply_id;
    }

    public void setReply_id(int reply_id) {
        this.reply_id = reply_id;
    }

    public String getReply_type() {
        return reply_type;
    }

    public void setReply_type(String reply_type) {
        this.reply_type = reply_type;
    }

    public String getReply_name() {
        return reply_name;
    }

    public void setReply_name(String reply_name) {
        this.reply_name = reply_name;
    }

    public int getReply_posts_id() {
        return reply_posts_id;
    }

    public void setReply_posts_id(int reply_posts_id) {
        this.reply_posts_id = reply_posts_id;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getPosts_date() {
        return posts_date;
    }

    public void setPosts_date(String posts_date) {
        this.posts_date = posts_date;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getUserTitle() {
        return userTitle;
    }

    public void setUserTitle(String userTitle) {
        this.userTitle = userTitle;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMobileSign() {
        return mobileSign;
    }

    public void setMobileSign(String mobileSign) {
        this.mobileSign = mobileSign;
    }

    public int getReply_status() {
        return reply_status;
    }

    public void setReply_status(int reply_status) {
        this.reply_status = reply_status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getRole_num() {
        return role_num;
    }

    public void setRole_num(int role_num) {
        this.role_num = role_num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIs_quote() {
        return is_quote;
    }

    public void setIs_quote(int is_quote) {
        this.is_quote = is_quote;
    }

    public int getQuote_pid() {
        return quote_pid;
    }

    public void setQuote_pid(int quote_pid) {
        this.quote_pid = quote_pid;
    }

    public String getQuote_content() {
        return quote_content;
    }

    public void setQuote_content(String quote_content) {
        this.quote_content = quote_content;
    }

    public String getQuote_user_name() {
        return quote_user_name;
    }

    public void setQuote_user_name(String quote_user_name) {
        this.quote_user_name = quote_user_name;
    }

    public boolean isDelThread() {
        return delThread;
    }

    public void setDelThread(boolean delThread) {
        this.delThread = delThread;
    }

    public List<TopicContent> getReply_content() {
        return reply_content;
    }

    public void setReply_content(List<TopicContent> reply_content) {
        this.reply_content = reply_content;
    }

    public List<ManagePanelBean> getManagePanel() {
        return managePanel;
    }

    public void setManagePanel(List<ManagePanelBean> managePanel) {
        this.managePanel = managePanel;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

}
