package com.hardtopcrm.metaldud.daggertest.di.component;

import android.content.Context;
import com.hardtopcrm.metaldud.daggertest.di.module.AppModule;
import com.hardtopcrm.metaldud.daggertest.di.module.DataModule;
import com.hardtopcrm.metaldud.daggertest.di.module.NetModule;
import com.hardtopcrm.metaldud.daggertest.di.module.PicassoModule;
import com.hardtopcrm.metaldud.daggertest.model.repository.ILocalRepository;
import com.hardtopcrm.metaldud.daggertest.model.repository.IRemoteRepository;
import com.hardtopcrm.metaldud.daggertest.ui.activities.MainActivity;
import com.squareup.picasso.Picasso;
import dagger.Component;
import javax.inject.Singleton;
import retrofit2.Retrofit;

/**
 * Created by user on 12.02.18.
 */


@Component(modules = {AppModule.class, NetModule.class, DataModule.class, PicassoModule.class})
@Singleton
public interface AppComponent {

    IRemoteRepository remoteDataRepository();
    ILocalRepository localDataRepository();

    Context context();

    Retrofit retrofit();

    Picasso picasso();


    void inject(MainActivity mainActivity);
}
