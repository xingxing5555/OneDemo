package com.example.admin.basic.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by admin on 2017/10/31.
 */

public abstract class BaseActivity  extends AppCompatActivity{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = LayoutInflater.from(this).inflate(getLayoutId(), null);
        setContentView(view);
        initView(view);
        init();
    }


    public abstract int getLayoutId();

    public abstract void initView(View view);

    public abstract void init();
}
