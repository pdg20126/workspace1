package com.example.administrator.workspace.homework;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;

/**
 * Created by Administrator on 2016/6/16.
 */
public class myAPP extends Application {
    @Override
    public void onCreate() {
        SDKInitializer.initialize(getApplicationContext());
        super.onCreate();
    }
}
