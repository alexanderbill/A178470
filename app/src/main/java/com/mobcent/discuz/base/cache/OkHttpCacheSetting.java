package com.mobcent.discuz.base.cache;

import android.os.Environment;

import com.litesuits.common.assist.Network;
import com.mobcent.discuz.api.RequestParams;
import com.mobcent.discuz.application.DiscuzApplication;
import com.mobcent.discuz.base.constant.DiscuzRequest;
import com.mobcent.discuz.base.constant.LoggingInterceptor;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by sun on 2016/9/14.
 * OkHttp 缓存设置
 */

public class OkHttpCacheSetting {
    private static String cachedirectory = DiscuzApplication._instance.getCacheDir() + "/lqForum/caches";
    private static long cacheSize = 1024 * 1024 * 20;
    private static Cache cache = new Cache(new File(cachedirectory), cacheSize);
    private static final Interceptor REWRITE_CACHE_CONTROL_INTERCEPTOR = new Interceptor() {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Response originalResponse = chain.proceed(request);

            boolean netWorkOk = Network.isConnected(DiscuzApplication._instance);

            if (netWorkOk) {
                int maxAge = 60  * 60 * 24; // read from cache
                return originalResponse.newBuilder()
                        .header("Cache-Control", "public, max-age=" + maxAge)
                        .build();
            } else {
                int maxStale = 60 * 60 * 24 * 28; // tolerate 4-weeks stale
                return originalResponse.newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        .build();
            }
//            return originalResponse.newBuilder()
//                    .removeHeader("Pragma")
//                    .removeHeader("Cache-Control")
//                    .header("Cache-Control", String.format("max-age=%d", CACHE_TIME))
//                    .build();//设置了缓存时间为10秒
        }
    };

    public static OkHttpClient getNewOKHttp() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.cookieJar(DiscuzRequest.COOKIE_JAR);
        builder.cache(cache);
        builder.networkInterceptors().add(REWRITE_CACHE_CONTROL_INTERCEPTOR);

        builder.addInterceptor(new LoggingInterceptor());
        return builder.build();
    }
}
