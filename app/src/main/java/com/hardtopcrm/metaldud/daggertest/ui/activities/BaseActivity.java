package com.hardtopcrm.metaldud.daggertest.ui.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    public abstract int getContentViewLayoutResource();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewLayoutResource());
    }

    public void showMassage(@NonNull String massage){
        Snackbar.make(findViewById(android.R.id.content), massage, Snackbar.LENGTH_SHORT).show();
    }
}
