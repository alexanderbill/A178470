package com.mobcent.discuz.bean;

import java.util.List;

/**
 * Created by sun on 2016/8/21.
 *  帖子
 */

public class Topic {


    /**
     * topic_id : 64551
     * title : 内容AT
     * type : normal_complex
     * sortId : 0
     * user_id : 216891
     * user_nick_name : lqsapptest
     * replies : 2
     * hits : 27
     * essence : 0
     * vote : 0
     * hot : 0
     * top : 0
     * is_favor : 0
     * create_date : 1472366007000
     * icon : http://forum.longquanzs.org/uc_server/avatar.php?uid=216891&size=middle
     * level : 1
     * userTitle : 新手上路
     * isFollow : 0
     * zanList : []
     * content : [{"infor":"http://forum.longquanzs.org/data/attachment/forum/201608/28/143728t5oqd5qwd3m3uvkh.png.thumb.jpg","type":1,"url":"http://forum.longquanzs.org/forum.php?mod=attachment&aid=MTM5MTYwfGI5ZmM4NWIwfDE0NzI0Mzk2NDh8MjE0MzYyfDY0NTUx&nothumb=yes","originalInfo":"http://forum.longquanzs.org/data/attachment/forum/201608/28/143728t5oqd5qwd3m3uvkh.png","aid":139160,"extParams":{"videoType":"youku","videoId":""},"desc":"(9.66 KB, 下载次数: 7)"}]
     * extraPanel : [{"action":"http://forum.longquanzs.org/mobcent/app/web/index.php?r=forum/topicrate&sdkVersion=2.5.0.0&accessToken=274d079f604beba7d6edaa76be052&accessSecret=db799660500f1cafae3d030c09caa&apphash=276399a6&tid=64551&pid=332663&type=view","title":"评分","extParams":{"beforeAction":"http://forum.longquanzs.org/mobcent/app/web/index.php?r=forum/topicrate&sdkVersion=2.5.0.0&accessToken=274d079f604beba7d6edaa76be052&accessSecret=db799660500f1cafae3d030c09caa&apphash=276399a6&tid=64551&pid=332663&type=check"},"type":"rate"}]
     * status : 1
     * reply_status : 1
     * flag : 0
     * gender : 1
     * reply_posts_id : 332663
     * reward : {"score":[{"infor":"微笑","value":1}],"userList":[{"uid":214362,"userName":"sundxing","userIcon":"http://forum.longquanzs.org/uc_server/avatar.php?uid=214362&size=middle"}],"userNumber":1,"showAllUrl":"http://forum.longquanzs.org/mobcent/app/web/index.php?r=forum/ratelistview&sdkVersion=2.5.0.0&accessToken=274d079f604beba7d6edaa76be052&accessSecret=db799660500f1cafae3d030c09caa&apphash=276399a6&tid=&pid=332663"}
     */

    private int topic_id;
    private String title;  // 标题
    private int hits; //查看次数
    private int essence; // 精华
    private String type;
    private int replies;
    private int vote;
    private int hot;
    private int top; //置顶
    private int sortId;
    private int is_favor; // 帖子被收藏
    // 用户
    private int user_id;
    private String icon; //头像
    private String user_nick_name; //用户名
    private String userTitle; //头衔
    private String create_date; // 发帖时间

    private int isFollow; //是否关注
    private int level;
    private int status;
    private int reply_status; // 是否可以回复
    private int flag;
    private int gender;
    private int reply_posts_id;
    /**
     * 赞赏
     *
     * score : [{"infor":"微笑","value":1}]
     * userList : [{"uid":214362,"userName":"sundxing","userIcon":"http://forum.longquanzs.org/uc_server/avatar.php?uid=214362&size=middle"}]
     * userNumber : 1
     * showAllUrl : http://forum.longquanzs.org/mobcent/app/web/index.php?r=forum/ratelistview&sdkVersion=2.5.0.0&accessToken=274d079f604beba7d6edaa76be052&accessSecret=db799660500f1cafae3d030c09caa&apphash=276399a6&tid=&pid=332663
     */

    private RewardBean reward;
    /**
     * 帖子内容
     *
     * infor : http://forum.longquanzs.org/data/attachment/forum/201608/28/143728t5oqd5qwd3m3uvkh.png.thumb.jpg
     * type : 1
     * url : http://forum.longquanzs.org/forum.php?mod=attachment&aid=MTM5MTYwfGI5ZmM4NWIwfDE0NzI0Mzk2NDh8MjE0MzYyfDY0NTUx&nothumb=yes
     * originalInfo : http://forum.longquanzs.org/data/attachment/forum/201608/28/143728t5oqd5qwd3m3uvkh.png
     * aid : 139160
     * extParams : {"videoType":"youku","videoId":""}
     * desc : (9.66 KB, 下载次数: 7)
     */

    private List<TopicContent> content;
    /**
     * action : http://forum.longquanzs.org/mobcent/app/web/index.php?r=forum/topicrate&sdkVersion=2.5.0.0&accessToken=274d079f604beba7d6edaa76be052&accessSecret=db799660500f1cafae3d030c09caa&apphash=276399a6&tid=64551&pid=332663&type=view
     * title : 评分
     * extParams : {"beforeAction":"http://forum.longquanzs.org/mobcent/app/web/index.php?r=forum/topicrate&sdkVersion=2.5.0.0&accessToken=274d079f604beba7d6edaa76be052&accessSecret=db799660500f1cafae3d030c09caa&apphash=276399a6&tid=64551&pid=332663&type=check"}
     * type : rate
     */

    private List<ExtraPanelBean> extraPanel;

    private List<ManagePanelBean> managePanel;

    public int getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(int topic_id) {
        this.topic_id = topic_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSortId() {
        return sortId;
    }

    public void setSortId(int sortId) {
        this.sortId = sortId;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_nick_name() {
        return user_nick_name;
    }

    public void setUser_nick_name(String user_nick_name) {
        this.user_nick_name = user_nick_name;
    }

    public int getReplies() {
        return replies;
    }

    public void setReplies(int replies) {
        this.replies = replies;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public int getEssence() {
        return essence;
    }

    public void setEssence(int essence) {
        this.essence = essence;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getIs_favor() {
        return is_favor;
    }

    public void setIs_favor(int is_favor) {
        this.is_favor = is_favor;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
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

    public int getIsFollow() {
        return isFollow;
    }

    public void setIsFollow(int isFollow) {
        this.isFollow = isFollow;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getReply_status() {
        return reply_status;
    }

    public void setReply_status(int reply_status) {
        this.reply_status = reply_status;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getReply_posts_id() {
        return reply_posts_id;
    }

    public void setReply_posts_id(int reply_posts_id) {
        this.reply_posts_id = reply_posts_id;
    }

    public RewardBean getReward() {
        return reward;
    }

    public void setReward(RewardBean reward) {
        this.reward = reward;
    }

    public List<TopicContent> getContent() {
        return content;
    }

    public void setContent(List<TopicContent> content) {
        this.content = content;
    }

    public List<ExtraPanelBean> getExtraPanel() {
        return extraPanel;
    }

    public void setExtraPanel(List<ExtraPanelBean> extraPanel) {
        this.extraPanel = extraPanel;
    }

    public List<ManagePanelBean> getManagePanel() {
        return managePanel;
    }

    public void setManagePanel(List<ManagePanelBean> managePanel) {
        this.managePanel = managePanel;
    }

    /**
     * 赞赏列表
     */
    public static class RewardBean {
        private int userNumber;
        private String showAllUrl;
        /**
         * infor : 微笑
         * value : 1
         */

        private List<ScoreBean> score;
        /**
         * uid : 214362
         * userName : sundxing
         * userIcon : http://forum.longquanzs.org/uc_server/avatar.php?uid=214362&size=middle
         */

        private List<UserListBean> userList;

        public int getUserNumber() {
            return userNumber;
        }

        public void setUserNumber(int userNumber) {
            this.userNumber = userNumber;
        }

        public String getShowAllUrl() {
            return showAllUrl;
        }

        public void setShowAllUrl(String showAllUrl) {
            this.showAllUrl = showAllUrl;
        }

        public List<ScoreBean> getScore() {
            return score;
        }

        public void setScore(List<ScoreBean> score) {
            this.score = score;
        }

        public List<UserListBean> getUserList() {
            return userList;
        }

        public void setUserList(List<UserListBean> userList) {
            this.userList = userList;
        }

        public static class ScoreBean {
            private String info;
            private int value;

            public String getInfo() {
                return info;
            }

            public void setInfo(String info) {
                this.info = info;
            }

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }
        }

        public static class UserListBean {
            private int uid;
            private String userName;
            private String userIcon;

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public String getUserIcon() {
                return userIcon;
            }

            public void setUserIcon(String userIcon) {
                this.userIcon = userIcon;
            }
        }
    }

    public static class ExtraPanelBean {
        private String action;
        private String title;
        private String type;

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

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
