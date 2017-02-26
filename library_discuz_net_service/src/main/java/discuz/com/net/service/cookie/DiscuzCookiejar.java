package discuz.com.net.service.cookie;

import android.os.Build;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;

import java.util.ArrayList;
import java.util.List;

import discuz.com.retrofit.library.WebkitCookieJar;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/**
 * Created by pangxiaomin on 16/11/27.
 */
public class DiscuzCookiejar implements CookieJar {

    private WebkitCookieJar webkitCookieJar = new WebkitCookieJar();
    private PersistentCookieStore cookieStore;


    public DiscuzCookiejar(PersistentCookieStore cookieStore){
        this.cookieStore = cookieStore;
    }

    @Override
    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
        try {
            if (cookies != null && cookies.size() > 0) {
                for (Cookie item : cookies) {
                    cookieStore.add(url, item);
                }

                //同时保存到CookieManager
                webkitCookieJar.saveFromResponse(url,cookies);
            }
        }catch (Exception ignored){ignored.printStackTrace();}
    }

    @Override
    public List<Cookie> loadForRequest(HttpUrl url) {
        List<Cookie> cookies = cookieStore.get(url);
        return cookies != null ? cookies : new ArrayList<Cookie>();
    }

    public void clear(){
        //1.持久化的cookie
        cookieStore.removeAll();

        //2.CookieManager的cookie
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                CookieManager.getInstance().removeAllCookies(null);
                CookieManager.getInstance().removeSessionCookies(null);
                CookieManager.getInstance().flush();
            }else{
                CookieManager.getInstance().removeAllCookie();
                CookieManager.getInstance().removeSessionCookie();
                CookieSyncManager.getInstance().sync();
            }
        }catch (Exception ignored){ignored.printStackTrace();}
    }
}
