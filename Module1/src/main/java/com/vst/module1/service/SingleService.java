package com.vst.module1.service;

import android.content.Context;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * Created by zwy on 2017/12/5.
 * email:16681805@qq.com
 */
@Route(path = "/service/single")
public class SingleService implements IProvider {

    Context context;

    public void say(String content){
        Toast.makeText(context, ">>>" + content, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void init(Context context) {
        this.context = context;
    }
}
