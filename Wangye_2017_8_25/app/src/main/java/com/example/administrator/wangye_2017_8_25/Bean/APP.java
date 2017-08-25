package com.example.administrator.wangye_2017_8_25.Bean;

import android.app.Application;

import com.example.administrator.wangye_2017_8_25.BuildConfig;

import org.xutils.x;

/**
 * Created by Administrator on 2017/8/25.
 */

public class APP extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);
    }
}