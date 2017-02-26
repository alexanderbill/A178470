package com.mobcent.discuz.bean;

import android.text.TextUtils;

import com.mobcent.common.JsonConverter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sun on 2016/9/4.
 */

public class Reply implements Serializable{

    /**
     * json : {"fid":525,"tid":64551,"location":"","aid":"","content":"[{\"type\":0,\"infor\":\"[心]赞一\"}]","longitude":"116.10552215576172","latitude":"40.11105728149414","isHidden":0,"isAnonymous":0,"isOnlyAuthor":0,"isShowPostion":0,"replyId":0,"isQuote":0}
     */


    private BodyBean body;

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

    public static Reply build(JsonBean json) {
        Reply reply = new Reply();
        BodyBean bodyBean = new BodyBean();
        bodyBean.setJson(json);
        reply.setBody(bodyBean);
        return reply;
    }

    public static Reply build(int fid, int topicId, String content) {
       return build(fid, topicId, content, 0);
    }

    public static Reply build(int fid, int topicId, String content, List<String> pics) {
        JsonBean json = new JsonBean();
        json.setFid(fid);
        json.setTid(topicId);
        json.setIsQuote(0);

        ArrayList<Content> cs = new ArrayList<>();
        Content c = new Content();
        c.setType(0);
        c.setInfo(content);
        cs.add(c);

        for (String imgUrl : pics) {
            Content c1 = new Content();
            c1.setType(1);
            c1.setInfo(imgUrl);
            cs.add(c1);
        }
        json.setContent(JsonConverter.toString(cs));

        return build(json);
    }

    private static Reply build(int fid, int topicId, String content, int isQuote) {
        JsonBean json = new JsonBean();
        json.setFid(fid);
        json.setTid(topicId);
        json.setIsQuote(isQuote);
        json.setContentStr(content);
        return build(json);
    }

    public static Reply buildQuote(int topicId,int replyId, String content, int isQuote) {
        JsonBean json = new JsonBean();
        json.setReplyId(replyId);
        json.setTid(topicId);
        json.setIsQuote(isQuote);
        json.setContentStr(content);
        return build(json);
    }

    public static class Content {
        int type;
        String infor;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getInfo() {
            return infor;
        }

        public void setInfo(String info) {
            this.infor = info;
        }
    }

    public static class BodyBean implements Serializable {
        /**
         * fid : 525
         * tid : 64551
         * location :
         * aid :
         * content : [{"type":0,"infor":"[心]赞一"}]
         * longitude : 116.10552215576172
         * latitude : 40.11105728149414
         * isHidden : 0
         * isAnonymous : 0
         * isOnlyAuthor : 0
         * isShowPostion : 0
         * replyI : 0
         * isQuote : 0
         */

        private JsonBean json;

        public JsonBean getJson() {
            return json;
        }

        public void setJson(JsonBean json) {
            this.json = json;
        }


    }

    public static class JsonBean implements Serializable{
        private int fid;
        private int tid;
        private String location;
        private String aid;
        private String content;
        private String longitude;
        private String latitude;
        private int isHidden;
        private int isAnonymous;
        private int isOnlyAuthor;
        private int isShowPostion;
        private int replyId;
        private int isQuote;

        public int getFid() {
            return fid;
        }

        public void setFid(int fid) {
            this.fid = fid;
        }

        public int getTid() {
            return tid;
        }

        public void setTid(int tid) {
            this.tid = tid;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getAid() {
            return aid;
        }

        public void setAid(String aid) {
            this.aid = aid;
        }

        public String  getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public int getIsHidden() {
            return isHidden;
        }

        public void setIsHidden(int isHidden) {
            this.isHidden = isHidden;
        }

        public int getIsAnonymous() {
            return isAnonymous;
        }

        public void setIsAnonymous(int isAnonymous) {
            this.isAnonymous = isAnonymous;
        }

        public int getIsOnlyAuthor() {
            return isOnlyAuthor;
        }

        public void setIsOnlyAuthor(int isOnlyAuthor) {
            this.isOnlyAuthor = isOnlyAuthor;
        }

        public int getIsShowPostion() {
            return isShowPostion;
        }

        public void setIsShowPostion(int isShowPostion) {
            this.isShowPostion = isShowPostion;
        }

        public int getReplyId() {
            return replyId;
        }

        public void setReplyId(int replyId) {
            this.replyId = replyId;
        }

        public int getIsQuote() {
            return isQuote;
        }

        public void setIsQuote(int isQuote) {
            this.isQuote = isQuote;
        }

        public void setContentStr(String content) {
            if (TextUtils.isEmpty(content))
                return;
            Content c = new Content();
            c.setType(0);
            c.setInfo(content);
            ArrayList<Content> cs = new ArrayList<>();
            cs.add(c);
            this.content = JsonConverter.toString(cs);
        }
    }
}
