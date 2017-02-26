package discuz.com.net.service.api.me;

import java.util.Map;

import discuz.com.net.service.model.me.UserResult;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by pangxiaomin on 16/11/27.
 */
public interface UserInfoService {

    /**获取用户资料*/
    @FormUrlEncoded
    @POST("index.php?r=user/userinfo")
    Observable<UserResult> requestUserInfo(@Field("userId")String userId, @FieldMap Map<String,String> params);

    /**获取用户发表*/
    @FormUrlEncoded
    @POST("user/topiclist")
    Observable<UserResult> requestUserPublish(@FieldMap Map<String,String> params);




}
