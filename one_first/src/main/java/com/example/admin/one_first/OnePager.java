package com.example.admin.one_first;


import android.support.v4.app.Fragment;
import android.view.View;

import com.example.admin.basic.base.BaseFragment;
import com.example.admin.basic.bean.IndexList;
import com.example.admin.basic.bean.OneList;
import com.example.admin.basic.impl.IndexListImpl;
import com.example.admin.basic.inter.IndexListListener;
import com.example.admin.basic.utils.LogUtils;


/**
 * A simple {@link Fragment} subclass.
 */
public class OnePager extends BaseFragment implements IndexListListener {
    private IndexListImpl impl;
    @Override
    public int getLayoutId() {
        return R.layout.fragment_one_pager;
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void init() {
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
