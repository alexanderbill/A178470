package com.mobcent.discuz.bean;

import java.util.List;

/**
 * Created by sun on 2016/9/6.
 */

public class MoreNewResult extends BaseResult {
    /**
     * page : 1
     * has_next : 1
     * total_num : 4880
     * list : [{"special":0,"fid":394,"board_id":394,"board_name":"学佛问答","source_type":"topic","source_id":65321,"title":"师父新浪微博问答（2016.9.5）","user_id":140882,"last_reply_date":"1473036325000","user_nick_name":"qtrx","hits":436,"summary":"1.「网友问」：师父，我以前做过错事，但是我真心忏悔不做","replies":6,"pic_path":"http://forum.longquanzs.org/data/attachment/forum/201609/05/084521a7fhm2aua121ab1j.jpg.thumb.jpg","ratio":"0.716796875","redirectUrl":"","userAvatar":"http://forum.longquanzs.org/uc_server/avatar.php?uid=140882&size=middle","gender":0,"recommendAdd":0,"isHasRecommendAdd":0,"distance":"","location":"","imageList":[],"sourceWebUrl":"http://forum.longquanzs.org/forum.php?mod=viewthread&tid=65321","verify":[]}]
     */

    private int page;
    private int has_next;
    private int total_num;
    /**
     * special : 0
     * fid : 394
     * board_id : 394
     * board_name : 学佛问答
     * source_type : topic
     * source_id : 65321
     * title : 师父新浪微博问答（2016.9.5）
     * user_id : 140882
     * last_reply_date : 1473036325000
     * user_nick_name : qtrx
     * hits : 436
     * summary : 1.「网友问」：师父，我以前做过错事，但是我真心忏悔不做
     * replies : 6
     * pic_path : http://forum.longquanzs.org/data/attachment/forum/201609/05/084521a7fhm2aua121ab1j.jpg.thumb.jpg
     * ratio : 0.716796875
     * redirectUrl :
     * userAvatar : http://forum.longquanzs.org/uc_server/avatar.php?uid=140882&size=middle
     * gender : 0
     * recommendAdd : 0
     * isHasRecommendAdd : 0
     * distance :
     * location :
     * imageList : []
     * sourceWebUrl : http://forum.longquanzs.org/forum.php?mod=viewthread&tid=65321
     * verify : []
     */

    private List<ListBean> list;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getHas_next() {
        return has_next;
    }

    public void setHas_next(int has_next) {
        this.has_next = has_next;
    }

    public int getTotal_num() {
        return total_num;
    }

    public void setTotal_num(int total_num) {
        this.total_num = total_num;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        private int special;
        private int fid;
        private int board_id;
        private String board_name;
        private String source_type;
        private int source_id;
        private int topic_id;
        private String title;
        private int user_id;
        private String last_reply_date;
        private String user_nick_name;
        /**
         * hot : 0
         * essence : 0
         * top : 0
         */

        private int hot;
        private int essence;
        private int top;

        private int hits;
        private String summary;
        private int replies;
        private String pic_path;
        private String ratio;
        private String redirectUrl;
        private String userAvatar;
        private int gender;
        private int recommendAdd;
        private int isHasRecommendAdd;
        private String distance;
        private String location;
        private String sourceWebUrl;
        private List<String> imageList;
        private List<?> verify;

        public int getSpecial() {
            return special;
        }

        public void setSpecial(int special) {
            this.special = special;
        }

        public int getFid() {
            return fid;
        }

        public void setFid(int fid) {
            this.fid = fid;
        }

        public int getBoard_id() {
            return board_id;
        }

        public void setBoard_id(int board_id) {
            this.board_id = board_id;
        }

        public String getBoard_name() {
            return board_name;
        }

        public void setBoard_name(String board_name) {
            this.board_name = board_name;
        }

        public String getSource_type() {
            return source_type;
        }

        public void setSource_type(String source_type) {
            this.source_type = source_type;
        }

        public int getSource_id() {
            return source_id;
        }

        public void setSource_id(int source_id) {
            this.source_id = source_id;
        }

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

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getLast_reply_date() {
            return last_reply_date;
        }

        public void setLast_reply_date(String last_reply_date) {
            this.last_reply_date = last_reply_date;
        }

        public String getUser_nick_name() {
            return user_nick_name;
        }

        public void setUser_nick_name(String user_nick_name) {
            this.user_nick_name = user_nick_name;
        }

        public int getHits() {
            return hits;
        }

        public void setHits(int hits) {
            this.hits = hits;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public int getReplies() {
            return replies;
        }

        public void setReplies(int replies) {
            this.replies = replies;
        }

        public String getPic_path() {
            return pic_path;
        }

        public void setPic_path(String pic_path) {
            this.pic_path = pic_path;
        }

        public String getRatio() {
            return ratio;
        }

        public void setRatio(String ratio) {
            this.ratio = ratio;
        }

        public String getRedirectUrl() {
            return redirectUrl;
        }

        public void setRedirectUrl(String redirectUrl) {
            this.redirectUrl = redirectUrl;
        }

        public String getUserAvatar() {
            return userAvatar;
        }

        public void setUserAvatar(String userAvatar) {
            this.userAvatar = userAvatar;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public int getRecommendAdd() {
            return recommendAdd;
        }

        public void setRecommendAdd(int recommendAdd) {
            this.recommendAdd = recommendAdd;
        }

        public int getIsHasRecommendAdd() {
            return isHasRecommendAdd;
        }

        public void setIsHasRecommendAdd(int isHasRecommendAdd) {
            this.isHasRecommendAdd = isHasRecommendAdd;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getSourceWebUrl() {
            return sourceWebUrl;
        }

        public void setSourceWebUrl(String sourceWebUrl) {
            this.sourceWebUrl = sourceWebUrl;
        }

        public List<?> getImageList() {
            return imageList;
        }

        public void setImageList(List<String> imageList) {
            this.imageList = imageList;
        }

        public List<?> getVerify() {
            return verify;
        }

        public void setVerify(List<?> verify) {
            this.verify = verify;
        }

        public int getHot() {
            return hot;
        }

        public void setHot(int hot) {
            this.hot = hot;
        }

        public int getEssence() {
            return essence;
        }

        public void setEssence(int essence) {
            this.essence = essence;
        }

        public int getTop() {
            return top;
        }

        public void setTop(int top) {
            this.top = top;
        }
    }


}
