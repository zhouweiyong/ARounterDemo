package com.vst.module1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.vst.commonlib.bean.User;
import com.vst.module1.R;
import com.vst.module1.service.ITestService;
import com.vst.module1.service.SingleService;

/**
 * http://www.jianshu.com/p/7cb2cc9b726a
 * https://github.com/alibaba/ARouter
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m1_activity_main);
        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//简单跳转
                ARouter.getInstance().build("/login/aa")
                        .navigation();
            }
        });
        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//startForResult
                ARouter.getInstance().build("/test/bactivity")
                        .navigation(MainActivity.this, 22);
            }
        });
        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//跳转Fragment
                startActivity(new Intent(MainActivity.this, FragActivity.class));
            }
        });
        findViewById(R.id.btn4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//携带参数，参数需要实现Parcelable接口
                User user = new User("tom", 20);
                ARouter.getInstance().build("/test/bactivity")
                        .withString("vkey", "hello value")
                        .withParcelable("user", user)
                        .navigation();
            }
        });

        findViewById(R.id.btn5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//通过url跳转
                ARouter.getInstance()
                        .build("/url/webview")
                        .withString("url", "file:///android_asset/arounter.html")
                        .navigation();
            }
        });
        findViewById(R.id.btn6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//拦截跳转
                ARouter.getInstance()
                        .build("/login/aa")
                        .navigation(MainActivity.this, new NavigationCallback() {
                            @Override
                            public void onFound(Postcard postcard) {
                                Log.d("ARouter", "找到了");
                            }

                            @Override
                            public void onLost(Postcard postcard) {
                                Log.d("ARouter", "找不到了");
                            }

                            @Override
                            public void onArrival(Postcard postcard) {
                                Log.d("ARouter", "跳转完了");
                            }

                            @Override
                            public void onInterrupt(Postcard postcard) {
                                Log.d("ARouter", "被拦截了");
                            }

                        });
            }
        });

        findViewById(R.id.btn7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//通过name调用服务
                ((ITestService) ARouter.getInstance().build("/service/test").navigation()).sayHello("Hello Service...");
            }
        });
        findViewById(R.id.btn8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//通过type调用服务
                ARouter.getInstance().navigation(ITestService.class).sayHello("say hello to service...");
            }
        });
        findViewById(R.id.btn9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance()
                        .navigation(SingleService.class)
                        .say("Hello single Service...");
            }
        });
        findViewById(R.id.btn10).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//依赖注入调用服务service
                startActivity(new Intent(MainActivity.this, ServiceActivty.class));
            }
        });
        findViewById(R.id.btn12).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//跨Module跳转，使用Bundle携带参数
                Bundle bundle = new Bundle();
                bundle.putParcelable("user", new User("tomm", 36));
                ARouter.getInstance().build("/module1/mmactivity")
                        .withBundle("bundle", bundle)
                        .navigation();
            }
        });
        findViewById(R.id.btn13).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//跳转失败，采取单独降级策略
                ARouter.getInstance().build("/text/todo").navigation(MainActivity.this, new NavigationCallback() {
                    @Override
                    public void onFound(Postcard postcard) {

                    }

                    @Override
                    public void onLost(Postcard postcard) {
                        Log.i("zwy", "跳转失败");
                        Toast.makeText(MainActivity.this, "跳转失败了，降级策略", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onArrival(Postcard postcard) {

                    }

                    @Override
                    public void onInterrupt(Postcard postcard) {

                    }
                });
            }
        });
        findViewById(R.id.btn14).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//跳转失败，采取全局降级策略
                ARouter.getInstance().build("/test/todo").navigation();
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 22:
                Log.i("zwy", "onActivityResult111");
                break;
            default:
                break;
        }
    }
}
