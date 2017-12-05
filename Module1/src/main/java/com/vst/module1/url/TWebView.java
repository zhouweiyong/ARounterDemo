package com.vst.module1.url;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.vst.module1.R;

/**
 * Created by zwy on 2017/12/1.
 * email:16681805@qq.com
 */
@Route(path = "/url/webview")
public class TWebView extends Activity {
    WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m1_webview_t);
        webView = findViewById(R.id.wv);
        webView.loadUrl(getIntent().getStringExtra("url"));
    }
}
