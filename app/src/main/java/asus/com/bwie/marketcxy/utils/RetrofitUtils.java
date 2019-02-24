package asus.com.bwie.marketcxy.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import asus.com.bwie.marketcxy.BaseApis;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static android.content.Context.MODE_PRIVATE;

public class RetrofitUtils {
    private final String BASE_URL = "http://172.17.8.100/small/";
    public static RetrofitUtils retrofitUtils;
    private final BaseApis baseApis;
    private final OkHttpClient mClient;

    public static RetrofitUtils getRetrofitUtils() {
        if (retrofitUtils == null) {
            synchronized (RetrofitUtils.class) {
                if (null == retrofitUtils) {
                    retrofitUtils = new RetrofitUtils();
                }
            }
        }
        return retrofitUtils;
    }

    public RetrofitUtils() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        mClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request original = chain.request();
                        SharedPreferences sharedPreferences= BaseApplication.getApplication().getSharedPreferences("spDemo",MODE_PRIVATE);
                        String userId = sharedPreferences.getString("userId", "");
                        String sessionId = sharedPreferences.getString("sessionId", "");

                        Request.Builder rerequestBuilder=original.newBuilder();

                        rerequestBuilder.method(original.method(),original.body());

                        if (!TextUtils.isEmpty(userId) && !TextUtils.isEmpty(sessionId)){
                            rerequestBuilder.addHeader("userId",userId);
                            rerequestBuilder.addHeader("sessionId",sessionId);
                            Log.d("user",userId);
                            Log.d("seeeionId",sessionId);

                        }
                        Request request = rerequestBuilder.build();



                        return chain.proceed(request);
                    }
                })
                .retryOnConnectionFailure(true)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .client(mClient)
                .build();

        baseApis = retrofit.create(BaseApis.class);

    }
    /**
     * get
     * @param urlData
     * @param listener
     * @return
     */
    public RetrofitUtils get(String urlData,HttpListener listener){
        baseApis.get(urlData)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getObserver(listener));
        return retrofitUtils;
    }
    /**
     * get请求
     * @param urlData
     *圈子列表
     * @return
     */
    public RetrofitUtils getCircle(String urlData,int page,int count,HttpListener listener){
        baseApis.getcircle(urlData,page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getObserver(listener));
        return retrofitUtils;
    }


    /**
     * 普通post请求
     */
    public RetrofitUtils post(String url,Map<String,String> map,HttpListener listener){
        if (map==null){
            map=new HashMap<>();
        }
        baseApis.post(url,map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(getObserver(listener));
        return retrofitUtils;
    }
    /**
     * put
     */
    public RetrofitUtils put(String url,Map<String,String> map,HttpListener listener){

        baseApis.put(url,map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(getObserver(listener));
        return retrofitUtils;
    }
    /**
     * del
     */
    public RetrofitUtils del(String url,Map<String,String> map,HttpListener listener){

        baseApis.delete(url,map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(getObserver(listener));
        return retrofitUtils;
    }





    /**
     * 观察者
     */
    private Observer getObserver(final HttpListener listener) {
        Observer observer = new Observer<ResponseBody>() {
            @Override
            public void onCompleted() {
                }
            @Override
            public void onError(Throwable e) {
                if (listener != null) {
                    listener.onFail(e.getMessage());
                }
            }
            @Override
            public void onNext(ResponseBody responseBody) {
                try {
                    String data = responseBody.string();
                    if (listener != null) {
                        listener.onSuccess(data);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    if (listener != null) {
                        listener.onFail(e.getMessage());
                    }
                }
            }
        };
        return observer;
    }

    public HttpListener listener;
    public void setListener(HttpListener httpListener) {
        this.listener = httpListener;
    }
    public interface HttpListener {
        void onSuccess(String data);
        void onFail(String error);
    }


}
