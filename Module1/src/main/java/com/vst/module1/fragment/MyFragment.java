package com.vst.module1.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.vst.module1.R;

/**
 * Created by zwy on 2017/11/30.
 * email:16681805@qq.com
 */
@Route(path = "/test/myfra")
public class MyFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.m1_fragment_my, container, false);
    }
}
