package discuz.com.retrofit.library;

import retrofit2.Response;
import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

/**
 * Created by pangxiaomin on 16/11/27.
 */
public abstract class HTTPSubscriber<T> extends Subscriber<T> {

    public static final int ERROR_CODE = -1001;
    public static final int ERROR_PROCESS_RESULT_CODE = -1002;

    public static final String ERROR_PROCESS          = "error process request or response:";
    public static final String ERROR_PROCESS_RESULT   = "error process result:";

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        if(e instanceof HttpException){
            HttpException httpException = (HttpException) e;
            retrofit2.Response response = httpException.response();
            onFail(response, ERROR_PROCESS_RESULT_CODE, ERROR_PROCESS_RESULT+e.getMessage());
        }else{
            onFail(400,ERROR_CODE,ERROR_PROCESS+e.getMessage());
        }
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    protected void onFail(Response<T> response,int errorUserCode, String message){
        onFail(response.code(), errorUserCode, message);
    }

    public abstract void onSuccess(T t);

    public abstract void onFail (int httpCode, int errorUserCode, String message);
}
