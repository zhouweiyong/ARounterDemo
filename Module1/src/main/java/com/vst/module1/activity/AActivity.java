package com.vst.module1.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.vst.module1.R;

/**
 * Created by zwy on 2017/11/29.
 * email:16681805@qq.com
 */
@Route(path = "/login/aa")
public class AActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m1_activity_a);

    }
}
