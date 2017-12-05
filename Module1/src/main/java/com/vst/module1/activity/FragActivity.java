package com.vst.module1.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.launcher.ARouter;
import com.vst.module1.R;

/**
 * Created by zwy on 2017/11/30.
 * email:16681805@qq.com
 */

public class FragActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m1_activity_fra);
        Fragment fragment = (Fragment) ARouter.getInstance().build("/test/myfra").navigation();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.rlyt_fra, fragment).commit();

    }
}
