package com.example.admin.onedemo;

import android.view.View;
import android.widget.TextView;

import com.example.admin.basic.base.BaseActivity;
import com.example.admin.basic.bean.IndexList;
import com.example.admin.basic.bean.OneList;
import com.example.admin.basic.impl.IndexListImpl;
import com.example.admin.basic.inter.IndexListListener;
import com.example.admin.basic.utils.LogUtils;

public class MainActivity extends BaseActivity implements IndexListListener {
    private TextView tv_show;
    private IndexListImpl impl;


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    public void initView(View view) {
        tv_show = (TextView) findViewById(R.id.tv_show);
        impl = new IndexListImpl();
        impl.getIndexList(this);

    }


    @Override
    public void initData(Object indexList) {
        if (indexList instanceof IndexList) {
            LogUtils.e(indexList.toString());
            impl.getOneList(((IndexList) indexList).getData().get(0), this);
        } else if (indexList instanceof OneList) {
            LogUtils.e(indexList.toString());
        }
    }

    @Override
    public void error(String errorMsg) {
        LogUtils.e(errorMsg);
    }
}
