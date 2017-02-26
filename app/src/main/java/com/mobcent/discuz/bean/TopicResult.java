package com.mobcent.discuz.bean;

import java.util.List;

/**
 * Created by sun on 2016/8/21.
 *  帖子
 */

public class TopicResult extends BaseResult{


    /**
     * forumName : 测试版块
     * boardId : 525
     * forumTopicUrl : http://forum.longquanzs.org/forum.php?mod=viewthread&tid=64551
     */

    private String forumName;
    private int boardId;
    /**
     * 引用原地址
     */
    private String forumTopicUrl;

    private Topic topic;
    private int topicId;

    private int total_num;
    /**
     * 回帖列表
     */
    private List<TopicReply> list;
    /**
     * 回帖页码
     */
    private int page;

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public List<TopicReply> getList() {
        for (TopicReply reply : list) {
            reply.setTopicId(topicId);
        }
        return list;
    }

    public void setList(List<TopicReply> list) {
        this.list = list;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getForumName() {
        return forumName;
    }

    public void setForumName(String forumName) {
        this.forumName = forumName;
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public String getForumTopicUrl() {
        return forumTopicUrl;
    }

    public void setForumTopicUrl(String forumTopicUrl) {
        this.forumTopicUrl = forumTopicUrl;
    }

    public int getTotalNum() {
        return total_num;
    }

    public void setTotalNum(int total_num) {
        this.total_num = total_num;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }
}
