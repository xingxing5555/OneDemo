package com.example.admin.basic.base;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by admin on 2017/11/3.
 */

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
