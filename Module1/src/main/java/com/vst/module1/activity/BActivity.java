package com.vst.module1.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.vst.commonlib.bean.User;
import com.vst.module1.R;

/**
 * Created by zwy on 2017/11/30.
 * email:16681805@qq.com
 */
@Route(path = "/test/bactivity")
public class BActivity extends Activity {
    @Autowired
    String vkey;
    @Autowired
    User user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m1_activity_b);
        ARouter.getInstance().inject(this);
//        String value = getIntent().getStringExtra("vkey");
        if (!TextUtils.isEmpty(vkey))
            Toast.makeText(this, ">>>>" + vkey+" "+user.getName(), Toast.LENGTH_SHORT).show();
        setResult(999);
    }
}
