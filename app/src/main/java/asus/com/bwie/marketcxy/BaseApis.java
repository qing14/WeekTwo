package asus.com.bwie.marketcxy;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

public interface BaseApis<T> {

    @GET
    Observable<ResponseBody> get(@Url String url);
    @GET
    Observable<ResponseBody> getcircle(@Url String url, @Query("page")int page, @Query("count") int count);
    @POST
    Observable<ResponseBody> post(@Url String url, @QueryMap Map<String,String> map);
    @PUT
    Observable<ResponseBody> put(@Url String url,@QueryMap Map<String,String> map);
    @DELETE
    Observable<ResponseBody> delete(@Url String url,@QueryMap Map<String,String> map);


}
