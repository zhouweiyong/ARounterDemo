package com.vst.arounterdemo;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;


/**
 * Created by zwy on 2017/11/28.
 * email:16681805@qq.com
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            ARouter.openLog();
            ARouter.openDebug();
        }

        ARouter.init(this);
    }
}
