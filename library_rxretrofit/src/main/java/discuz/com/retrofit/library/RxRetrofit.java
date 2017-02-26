package discuz.com.retrofit.library;

import okhttp3.CookieJar;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by pangxiaomin on 16/11/27.
 */
public class RxRetrofit {
    //采用webkit的cookieManager管理cookie 的 CookieJar
    protected static final CookieJar mWebkitCookieJar = new WebkitCookieJar();
    protected static final OkHttpClient mWebkitOkHttpClient;
    protected static final GsonConverterFactory mGsonConverterFactory;
    protected static final RxCallAdapterFactory mRxCallAdapterFactory;

    public RxRetrofit() {
    }

    protected static <T> T create(Retrofit retrofit, Class<T> service) {
        return retrofit.create(service);
    }

    public Retrofit.Builder builder() {
        return new Retrofit.Builder();
    }

    static {
        mWebkitOkHttpClient = (new okhttp3.OkHttpClient.Builder()).cookieJar(mWebkitCookieJar).build();
        mGsonConverterFactory = GsonConverterFactory.create();
        mRxCallAdapterFactory = new RxCallAdapterFactory();
    }
}
