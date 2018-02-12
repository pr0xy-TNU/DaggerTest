package com.hardtopcrm.metaldud.daggertest.di.module;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by user on 12.02.18.
 */
@Module
public class AppModule {

    private final Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    /**
     * Provide application context
     */
    @Provides
    @Singleton
    public Context provideApplicationContext() {
        return this.context;
    }

}
