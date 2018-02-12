package com.hardtopcrm.metaldud.daggertest;

import android.app.Application;
import com.hardtopcrm.metaldud.daggertest.di.component.AppComponent;

import com.hardtopcrm.metaldud.daggertest.di.component.DaggerAppComponent;
import com.hardtopcrm.metaldud.daggertest.di.module.AppModule;
import com.hardtopcrm.metaldud.daggertest.di.module.DataModule;
import com.hardtopcrm.metaldud.daggertest.di.module.NetModule;
import com.hardtopcrm.metaldud.daggertest.utils.Constants;

public class App extends Application {

    private static AppComponent appComponent;


    public static AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
            .appModule(new AppModule(getApplicationContext()))
            .dataModule(new DataModule())
            .netModule(new NetModule(false, Constants.BASE_URL))
            .build();
    }
}
