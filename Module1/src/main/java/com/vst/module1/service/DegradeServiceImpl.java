package com.vst.module1.service;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.DegradeService;

/**
 * Created by zwy on 2017/12/18.
 * email:16681805@qq.com'
 * 全局降级策略
 */
@Route(path = "/degrade/all")
public class DegradeServiceImpl implements DegradeService {
    private Context cxt;

    @Override
    public void onLost(Context context, Postcard postcard) {
        Toast.makeText(cxt, "跳转失败，采用全局降级策略", Toast.LENGTH_SHORT).show();
        Log.i("zwy", "跳转失败，采用全局降级策略");
        Log.i("zwy", context + "");
    }

    @Override
    public void init(Context context) {
        this.cxt = context;
    }
}
