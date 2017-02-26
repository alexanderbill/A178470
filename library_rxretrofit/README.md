####网络请求使用RxRetrofit + RxJava

如何使用:  
定义请求的interface,方法上使用注解区分get/post/put/delete等等请求  


@GET("index.php?r=logintest{param}")  
Observalbe<BaseResult<T>> requestLogin(@Path("param")String param, @QueryMap Map<String,String> params));

@UrlEncoded  
@POST("index.php?r=logintest")  
Observalbe<BaseResult<T>> requestLogin(@Field("param")String param, @FieldMap Map<String,String> params));

BaseResult,包含通用的code,errMsg等,T 为我们使用的封装成的对象,(例如对应body字段)  
另外,请求还需要一堆通用参数, (@FieldMap), params,和原来一样,  
直接使用WebParamsMap.map();即可。  


####PS:参照用户资料页请求。

