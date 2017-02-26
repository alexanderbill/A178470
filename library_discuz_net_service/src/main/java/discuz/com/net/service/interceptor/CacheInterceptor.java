package discuz.com.net.service.interceptor;

import java.io.IOException;

import discuz.com.net.service.DiscuzRetrofitCallback;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by pangxiaomin on 16/11/27.
 */
public class CacheInterceptor implements Interceptor{

    DiscuzRetrofitCallback mCallback;

    public CacheInterceptor(DiscuzRetrofitCallback callback){
        mCallback = callback;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (null != mCallback ) {
            if(!mCallback.isOnline()){
                if(!request.cacheControl().noCache()){
                    request = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .build();
                }
            }else{
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_NETWORK)
                        .build();
            }
        }

        Response response = chain.proceed(request);
        return response;
    }


}
