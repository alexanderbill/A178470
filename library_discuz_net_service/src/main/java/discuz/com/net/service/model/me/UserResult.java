package discuz.com.net.service.model.me;


import discuz.com.bean.me.UserBodyList;
import discuz.com.net.service.model.BaseResult;

/**
 * Created by pangxiaomin on 16/11/21.
 */
public class UserResult extends BaseResult<UserBodyList> {

    private int flag;
    private int is_black;
    private int is_follow;
    private int is_friend;
    private String icon;
    private String level_url;
    private String email;
    private int status;
    private int gender;
    private int score;
    private int credits;
    private int topic_num;
    private int photo_num;
    private int reply_posts_num;
    private int essence_num;
    private int friend_num;
    private int follow_num;
    private int level;
    private String name;
    private String userTitle;
    private String sign;
    private String mobile;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getIs_black() {
        return is_black;
    }

    public void setIs_black(int is_black) {
        this.is_black = is_black;
    }

    public int getIs_follow() {
        return is_follow;
    }

    public void setIs_follow(int is_follow) {
        this.is_follow = is_follow;
    }

    public int getIs_friend() {
        return is_friend;
    }

    public void setIs_friend(int is_friend) {
        this.is_friend = is_friend;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getLevel_url() {
        return level_url;
    }

    public void setLevel_url(String level_url) {
        this.level_url = level_url;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getTopic_num() {
        return topic_num;
    }

    public void setTopic_num(int topic_num) {
        this.topic_num = topic_num;
    }

    public int getPhoto_num() {
        return photo_num;
    }

    public void setPhoto_num(int photo_num) {
        this.photo_num = photo_num;
    }

    public int getReply_posts_num() {
        return reply_posts_num;
    }

    public void setReply_posts_num(int reply_posts_num) {
        this.reply_posts_num = reply_posts_num;
    }

    public int getEssence_num() {
        return essence_num;
    }

    public void setEssence_num(int essence_num) {
        this.essence_num = essence_num;
    }

    public int getFollow_num() {
        return follow_num;
    }

    public void setFollow_num(int follow_num) {
        this.follow_num = follow_num;
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

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFriend_num() {
        return friend_num;
    }

    public void setFriend_num(int friend_num) {
        this.friend_num = friend_num;
    }
}
