package com.hardtopcrm.metaldud.daggertest.di.module;

import android.content.Context;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Picasso.Builder;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by user on 12.02.18.
 */

public class PicassoModule {


    @Provides
    public Picasso picasso(OkHttp3Downloader downloader, Context context) {
        return new Builder(context)
            .downloader(downloader)
            .build();
    }

    @Provides
    public OkHttp3Downloader okHttp3Downloader(OkHttpClient httpClient) {
        return new OkHttp3Downloader(httpClient);

    }


}
