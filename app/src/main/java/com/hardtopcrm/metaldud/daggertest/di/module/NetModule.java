package com.hardtopcrm.metaldud.daggertest.di.module;

import android.content.Context;
import android.support.annotation.NonNull;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import com.hardtopcrm.metaldud.daggertest.utils.NetworkUtil;

/**
 * Created by user on 12.02.18.
 */

@Module
@Singleton
public class NetModule {

    @NonNull
    private String BASE_URL;
    private boolean useCache;

    public NetModule(boolean userCache, @NonNull String BASE_URL) {
        this.useCache = userCache;
        this.BASE_URL = BASE_URL;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().create();
    }

    @Provides
    @Singleton
    Cache provideCache(Context context) {
        int cacheSize = 10 * 1024 * 1024;
        return new Cache(context.getCacheDir(), cacheSize);
    }


    @Provides
    @Singleton
    OkHttpClient provideOkhttpClient(Cache cache, Context context) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder client = new OkHttpClient.Builder();

        client.interceptors().add(interceptor);

        if (useCache) {
            client.cache(cache);
            client.addNetworkInterceptor(chain -> {
                Response originalResponse = chain.proceed(chain.request());
                String cacheControl = originalResponse.header("Cache-Control");

                if (cacheControl == null || cacheControl.contains("no-store") || cacheControl
                    .contains("no-cache") ||
                    cacheControl.contains("must-revalidate") || cacheControl
                    .contains("max-age=0")) {
                    return originalResponse.newBuilder()
                        .header("Cache-Control", "public, max-age=" + 5000)
                        .build();
                } else {
                    return originalResponse;
                }
            });
            client.addInterceptor(chain -> {
                Request request = chain.request();

                if (!NetworkUtil.isNetworkConnected(context)) {

                    //int maxStale = 60 * 60 * 24 * 28; // tolerate 4-weeks stale
                    request = request.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public, only-if-cached")
                        .build();
                }

                return chain.proceed(request);
            });
        }
        client.addInterceptor(interceptor);
        return client.build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();

    }


}
