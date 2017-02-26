package discuz.com.retrofit.library;

import android.webkit.CookieManager;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/**
 * Created by pangxiaomin on 16/11/27.
 */
public class WebkitCookieJar implements CookieJar {

    private CookieManager mWebkitCookieManager = CookieManager.getInstance();

    @Override
    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
        for(Cookie cookie:cookies){
            mWebkitCookieManager.setCookie(url.toString(),cookie.toString());
        }
    }

    @Override
    public List<Cookie> loadForRequest(HttpUrl url) {
        List<Cookie> result = new ArrayList<>();
        String cookieStr = mWebkitCookieManager.getCookie(url.toString());
        if(null != cookieStr){
            Cookie cookie = Cookie.parse(url,cookieStr);
            if(null != cookie){
                result.add(cookie);
            }
        }

        return result;
    }
}
