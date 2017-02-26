package com.mobcent.discuz.bean;

import java.util.List;

/**
 * Created by sun on 2016/9/10.
 * 版块详情列表
 */

public class BoardListResult extends MoreNewResult {

    /**
     * id : 502
     * title : 聚焦龙泉
     * description :
     * icon : http://forum.longquanzs.org/data/attachment/common/b5/common_502_icon.png
     * td_posts_num : 4
     * topic_total_num : 974
     * posts_total_num : 8076
     * is_focus : 1
     */

    private ForumInfoBean forumInfo;
    /**
     * type : normal
     * action :
     * title : 发表帖子
     */

    private List<NewTopicPanelBean> newTopicPanel;
    /**
     * id : 64544
     * title : 【视频：今天我在龙泉寺0822】特辑：讲经交流 龙泉风采
     */

    private List<TopTopicListBean> topTopicList;
    /**
     * classificationType_id : 34
     * classificationType_name : 文化部
     */
    private List<ClassificationTypeListBean> classificationType_list;

    public ForumInfoBean getForumInfo() {
        return forumInfo;
    }

    public void setForumInfo(ForumInfoBean forumInfo) {
        this.forumInfo = forumInfo;
    }

    public List<NewTopicPanelBean> getNewTopicPanel() {
        return newTopicPanel;
    }

    public void setNewTopicPanel(List<NewTopicPanelBean> newTopicPanel) {
        this.newTopicPanel = newTopicPanel;
    }

    public List<TopTopicListBean> getTopTopicList() {
        return topTopicList;
    }

    public void setTopTopicList(List<TopTopicListBean> topTopicList) {
        this.topTopicList = topTopicList;
    }

    public List<ClassificationTypeListBean> getClassificationType_list() {
        return classificationType_list;
    }

    public void setClassificationType_list(List<ClassificationTypeListBean> classificationType_list) {
        this.classificationType_list = classificationType_list;
    }

    public static class ForumInfoBean {
        private int id;
        private String title;
        private String description;
        private String icon;
        private String td_posts_num;
        private String topic_total_num;
        private String posts_total_num;
        private int is_focus;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getTd_posts_num() {
            return td_posts_num;
        }

        public void setTd_posts_num(String td_posts_num) {
            this.td_posts_num = td_posts_num;
        }

        public String getTopic_total_num() {
            return topic_total_num;
        }

        public void setTopic_total_num(String topic_total_num) {
            this.topic_total_num = topic_total_num;
        }

        public String getPosts_total_num() {
            return posts_total_num;
        }

        public void setPosts_total_num(String posts_total_num) {
            this.posts_total_num = posts_total_num;
        }

        public int getIs_focus() {
            return is_focus;
        }

        public void setIs_focus(int is_focus) {
            this.is_focus = is_focus;
        }
    }

    public static class NewTopicPanelBean {
        private String type;
        private String action;
        private String title;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    public static class TopTopicListBean {
        private int id;
        private String title;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

}
