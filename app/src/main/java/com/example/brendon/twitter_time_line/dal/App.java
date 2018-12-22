package com.example.brendon.twitter_time_line.dal;

import android.app.Application;

import com.example.brendon.twitter_time_line.models.MyObjectBox;

import io.objectbox.BoxStore;

public class App extends Application {

    public static final String TAG = "ObjectBoxExample";
    public static final boolean EXTERNAL_DIR = false;

    private BoxStore boxStore;

    @Override
    public void onCreate() {
        super.onCreate();
        boxStore = MyObjectBox.builder().androidContext(App.this).build();

    }

    public BoxStore getBoxStore() {
        return boxStore;
    }
}