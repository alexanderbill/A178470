package discuz.com.retrofit.library;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * Created by pangxiaomin on 16/11/27.
 */
public class RxCallAdapterFactory extends CallAdapter.Factory {

    private static final RxJavaCallAdapterFactory rxJavaCallAdapterFactor = RxJavaCallAdapterFactory.create();

    public RxCallAdapterFactory() {
    }

    @Override
    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        return new RxCallAdapter(rxJavaCallAdapterFactor.get(returnType, annotations, retrofit));
    }
}
