package com.hardtopcrm.metaldud.daggertest.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import com.hardtopcrm.metaldud.daggertest.R;

/**
 * Created by user on 12.02.18.
 */

public class SplashScreen extends BaseActivity {

    Handler handler;

    private Runnable start = this::startNext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handler = new Handler();
        handler.postDelayed(start, 2000);

    }

    @Override
    public int getContentViewLayoutResource() {
        return R.layout.splash_screen;
    }


    void startNext() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(start);
    }
}
