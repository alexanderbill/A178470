package discuz.com.net.service;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.support.annotation.Nullable;

import java.io.File;

import discuz.com.net.service.config.WebConfig;

/**
 * Created by pangxiaomin on 16/11/27.
 */
public class DiscuzRetrofitCallbackImpl implements DiscuzRetrofitCallback{

    //缓存目录大小,10M
    public static final int CACHE_SIZE = 20 * 1024 * 1024;
    //缓存目录名称
    private static final String CACHE_DIR = "/lqForum/caches";

    //连接超时
    public static final int TIMEOUT_CONNECT = 30_000;

    //读取超时
    public static final int TIMEOUT_READ = 30_000;

    //写入超时
    public static final int TIMEOUT_WRITE = 30_000;

    Context applicationContext;

    public DiscuzRetrofitCallbackImpl(Context context){
        if(null != context){
            applicationContext = context.getApplicationContext();
        }
    }

    @Override
    public Context getApplicationContext() {
        return applicationContext;
    }

    @Override
    public String baseHttpUrl() {
        return WebConfig.HTTP_BASE_URL;
    }

    @Override
    public boolean isOnline() {
        try {
            ConnectivityManager cm = (ConnectivityManager) applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo current = cm.getActiveNetworkInfo();
            if (current == null) {
                return false;
            }
            return (current.isAvailable());
        }catch (Exception ignored){
            ignored.printStackTrace();
            return false;
        }
    }

    @Nullable
    @Override
    public File cacheDir() {
        if(null != applicationContext){
            File cacheDir = null;
            if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
                    || !Environment.isExternalStorageRemovable()) {
                cacheDir = applicationContext.getExternalCacheDir();
            } else {
                cacheDir = applicationContext.getCacheDir();
            }
            if(null != cacheDir){
                return new File(cacheDir,CACHE_DIR);
            }
        }
        return null;
    }

    public int cacheSize(){
        return CACHE_SIZE;
    }

    @Override
    public int timeoutConnect() {
        return TIMEOUT_CONNECT;
    }

    @Override
    public int timeoutRead() {
        return TIMEOUT_READ;
    }

    @Override
    public int timeoutWrite() {
        return TIMEOUT_WRITE;
    }
}
