package com.example.mike.beasttutorial.infrastructure;

import android.app.Application;

import com.example.mike.beasttutorial.inmemory.Module;
import com.squareup.otto.Bus;
/**
 * Created by Mike on 12/19/2016.
 */

public class BeastApplication extends Application {

    private Bus bus;

    public Bus getBus() {
        return bus;
    }

    public static final String YOUTUBE_KEY = "AIzaSyDYrwbdJ0hdedfQ0Gf6wj-d3XlMHOA-rQ0";

    @Override
    public void onCreate() {
        super.onCreate();
        Module.Register(this);
    }

    public BeastApplication() {
        this.bus = new Bus();
    }
}
