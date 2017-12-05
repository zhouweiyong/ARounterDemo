package com.vst.module1.service;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;

/**
 * Created by zwy on 2017/12/5.
 * email:16681805@qq.com
 */
@Route(path = "/service/test")
public class TestServiceImpl implements ITestService {
    Context context;

    @Override
    public void sayHello(String content) {
        Toast.makeText(context, ">>>" + content, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void init(Context context) {
        this.context = context;
        Log.i("zwy", "service init....");
    }

}
