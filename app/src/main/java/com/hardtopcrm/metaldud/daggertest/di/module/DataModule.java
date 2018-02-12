package com.hardtopcrm.metaldud.daggertest.di.module;

import android.content.Context;
import com.hardtopcrm.metaldud.daggertest.model.repository.ILocalRepository;
import com.hardtopcrm.metaldud.daggertest.model.repository.IRemoteRepository;
import com.hardtopcrm.metaldud.daggertest.model.repository.LocalDataRepository;
import com.hardtopcrm.metaldud.daggertest.model.repository.RemoteDataRepository;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import retrofit2.Retrofit;

/**
 * Created by user on 12.02.18.
 */
@Module
public class DataModule {

    @Provides
    @Singleton
    public IRemoteRepository provideRemoteRepository(Retrofit retrofit) {
        return new RemoteDataRepository(retrofit);
    }

    @Provides
    @Singleton
    public ILocalRepository provideLocalRepository(Context context) {
        return new LocalDataRepository(context);
    }

}
