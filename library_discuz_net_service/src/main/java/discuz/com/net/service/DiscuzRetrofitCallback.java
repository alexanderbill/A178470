package discuz.com.net.service;

import android.content.Context;

import java.io.File;

/**
 * Created by pangxiaomin on 16/11/27.
 */
public interface DiscuzRetrofitCallback {

    Context getApplicationContext();

    //获取默认的baseUrl
    String baseHttpUrl();

    //是否有网络
    boolean isOnline();

    //缓存
    File cacheDir();
    int cacheSize();

    //网络超时设置
    int timeoutConnect();
    int timeoutRead();
    int timeoutWrite();
}
