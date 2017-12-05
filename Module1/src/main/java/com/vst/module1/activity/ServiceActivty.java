package com.vst.module1.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.launcher.ARouter;
import com.vst.module1.R;
import com.vst.module1.service.ITestService;
import com.vst.module1.service.SingleService;

/**
 * Created by zwy on 2017/12/5.
 * email:16681805@qq.com
 */

public class ServiceActivty extends Activity {
    // 1. (推荐)使用依赖注入的方式发现服务,通过注解标注字段,即可使用，无需主动获取
    // Autowired注解中标注name之后，将会使用byName的方式注入对应的字段，不设置name属性，会默认使用byType的方式发现服务(当同一接口有多个实现的时候，必须使用byName的方式发现服务)
    @Autowired
    ITestService testService;
    @Autowired(name = "/service/test")
    ITestService testService2;
    @Autowired
    SingleService singleService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m1_activity_service);
        ARouter.getInstance().inject(this);
        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testService.sayHello("hello TestService1....");
            }
        });
        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testService2.sayHello("hello TestService2....");
            }
        });
        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                singleService.say("hello SingleService...");
            }
        });
    }
}
