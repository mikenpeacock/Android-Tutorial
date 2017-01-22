package com.example.mike.beasttutorial.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.mike.beasttutorial.infrastructure.BeastApplication;
import com.squareup.otto.Bus;

/**
 * Created by Mike on 1/1/2017.
 */

public class BaseActivity extends AppCompatActivity {
    protected BeastApplication application;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        application = (BeastApplication) getApplication();
        bus = application.getBus();
        bus.register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bus.unregister(this);
    }

    protected Bus bus;
}
