package asus.com.bwie.marketcxy.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class UserAgentIntercepter implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        SharedPreferences sharedPreferences = BaseApplication.getApplication().getSharedPreferences("spDemo", Context.MODE_PRIVATE);
        String userId = sharedPreferences.getString("userId", "");
        String sessionId = sharedPreferences.getString("sessionId", "");

        Request request= chain.request().newBuilder()
                .addHeader("userId",userId)
                .addHeader("sessionId",sessionId)
                .build();
        return chain.proceed(request);
    }
}
