package com.vst.module1.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.vst.module1.R;
import com.vst.module1.model.TUser;

/**
 * Created by zwy on 2017/12/1.
 * email:16681805@qq.com
 */
@Route(path = "/url/wactivity")
public class WActivity extends Activity {
    @Autowired
    String url;
    @Autowired
    String name;
    @Autowired
    int age;
    @Autowired
    TUser user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m1_activity_w);
        ARouter.getInstance().inject(this);
        if (!TextUtils.isEmpty(url))
            Log.i("zwy", url);
        if (!TextUtils.isEmpty(name))
            Log.i("zwy", name + ">>>" + age);
        if (user != null)
            Log.i("zwy", user.getName() + ">>>" + user.getAge());
    }
}
