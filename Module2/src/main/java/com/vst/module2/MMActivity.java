package com.vst.module2;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.vst.commonlib.bean.User;

/**
 * Created by zwy on 2017/12/5.
 * email:16681805@qq.com
 */
@Route(path = "/module1/mmactivity")
public class MMActivity extends Activity {
    User user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m2_activity_main);
        Bundle bundle = getIntent().getBundleExtra("bundle");
        user = bundle.getParcelable("user");
        Log.i("zwy", user.getName() + ">>>" + user.getAge());
    }
}
