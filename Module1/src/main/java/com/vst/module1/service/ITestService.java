package com.vst.module1.service;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * Created by zwy on 2017/12/5.
 * email:16681805@qq.com
 */

public interface ITestService extends IProvider {
    void sayHello(String content);
}
