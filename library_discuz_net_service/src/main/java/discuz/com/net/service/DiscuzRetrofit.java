package discuz.com.net.service;

import android.content.Context;
import android.support.annotation.Nullable;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.concurrent.TimeUnit;

import discuz.com.net.service.api.me.UserInfoService;
import discuz.com.net.service.config.WebConfig;
import discuz.com.net.service.cookie.DiscuzCookiejar;
import discuz.com.net.service.cookie.PersistentCookieStore;
import discuz.com.net.service.interceptor.CacheInterceptor;
import discuz.com.retrofit.library.RxRetrofit;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;

/**
 * Created by pangxiaomin on 16/11/27.
 */
public class DiscuzRetrofit extends RxRetrofit {

    private static final String HTTP_BASE_URL  = WebConfig.HTTP_BASE_URL;
    private static final Annotation[] emptyAnnotation = new Annotation[0];


    private static Retrofit mHttpAPI;
    //配置回调
    private static DiscuzRetrofitCallback mCallback;

    //缓存处理
    private static CacheInterceptor mCacheInterceptor;

    private static OkHttpClient mHttpAPIClient;
    private static DiscuzCookiejar mCookiejar;
    private static Cache mCache;

    private DiscuzRetrofit() {}

    private static class Inner{
        private static final DiscuzRetrofit instance = new DiscuzRetrofit();
    }

    private static DiscuzRetrofit getInstance(){
        return Inner.instance;
    }

    public static void init(DiscuzRetrofitCallback callback){
        mCallback = callback;
        //初始化interceptor
        mCacheInterceptor = new CacheInterceptor(mCallback);
    }

    public static void initDefaultRetrofit(){

        OkHttpClient.Builder okHttpClientBuilder = RxRetrofit.mWebkitOkHttpClient.newBuilder();
        if(null != mCallback && null != mCallback.getApplicationContext()){
            PersistentCookieStore cookieStore = new PersistentCookieStore(mCallback.getApplicationContext());
            mCookiejar = new DiscuzCookiejar(cookieStore);
            okHttpClientBuilder.cookieJar(mCookiejar);
        }

        if(null != mCallback){
            //设置缓存
            try {
                File cacheDir = mCallback.cacheDir();
                if(null != cacheDir){
                    mCache = new Cache(cacheDir,mCallback.cacheSize());
                    okHttpClientBuilder.cache(mCache);
                }
            }catch (Exception ignored){ignored.printStackTrace();}

            //设置超时
            okHttpClientBuilder.connectTimeout(mCallback.timeoutConnect(), TimeUnit.MILLISECONDS)
                    .readTimeout(mCallback.timeoutRead(),TimeUnit.MILLISECONDS)
                    .writeTimeout(mCallback.timeoutWrite(),TimeUnit.MILLISECONDS);
        }

        mHttpAPIClient = okHttpClientBuilder.build();
        //初始化默认retrofit
        mHttpAPI = buildAPI(null != mCallback ? mCallback.baseHttpUrl() : HTTP_BASE_URL);
    }

    private static Retrofit buildAPI(String baseUrl){
        return buildAPI(baseUrl,true);
    }

    private static Retrofit buildAPI(String baseUrl, boolean withGsonConverter){
        Retrofit.Builder builder = new Retrofit.Builder()
                .addCallAdapterFactory(RxRetrofit.mRxCallAdapterFactory)
                .client(mHttpAPIClient)
                .baseUrl(baseUrl);
        if(withGsonConverter){
            builder.addConverterFactory(RxRetrofit.mGsonConverterFactory);
        }

        return builder.build();
    }

    //清除cookie
    public static void clearCookie(){
        if(null != mCookiejar){
            mCookiejar.clear();
        }
    }

    //清除缓存
    public static void clearCache(){
        if(null != mCache){
            try {
                mCache.delete();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static <T> T parseResponse(Class<T> type, ResponseBody body){
        try {
            return (T) mHttpAPI.responseBodyConverter(type,emptyAnnotation).convert(body);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    protected <T> T get(@Nullable Context context, Class<T> tClass){
        return get(mHttpAPI,context,tClass);
    }

    protected <T> T get(Retrofit retrofit, @Nullable Context context, Class<T> tClass){
        if(null == mHttpAPI){
            initDefaultRetrofit();
        }
        return RxRetrofit.create(mHttpAPI,tClass);
    }

    public static UserInfoService getUserInfoService(Context context){
        return getInstance().get(context,UserInfoService.class);
    }

}
