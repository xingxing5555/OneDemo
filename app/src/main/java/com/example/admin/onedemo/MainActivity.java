package com.example.admin.onedemo;

import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.FrameLayout;

import com.example.admin.basic.base.BaseActivity;
import com.example.admin.basic.view.BottomNavigationView;
import com.example.admin.one_all.AllPager;
import com.example.admin.one_first.OnePager;
import com.example.admin.one_me.MePager;

public class MainActivity extends BaseActivity {
    private BottomNavigationView bnv_show;
    private FrameLayout fl_container;
    private FragmentManager fragmentManager;

    private OnePager onePager;
    private AllPager allPager;
    private MePager mePager;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    public void initView(View view) {
        bnv_show = (BottomNavigationView) findViewById(R.id.bnv_show);
        fl_container = (FrameLayout) findViewById(R.id.fl_container);

    }

    @Override
    public void init() {
        onePager = new OnePager();
        mePager = new MePager();
        allPager = new AllPager();

        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.fl_container, onePager).add(R.id.fl_container, allPager).add(R.id.fl_container, mePager).show(onePager).hide(allPager).hide(mePager).commit();

        bnv_show.setOnBottonNavigationClickListener(new BottomNavigationView.OnBottonNavigationClickListener() {
            @Override
            public void onClick(int position) {
                switch (position) {
                    case 0:
                        fragmentManager.beginTransaction().show(onePager).hide(mePager).hide(allPager).commit();
                        break;
                    case 1:
                        fragmentManager.beginTransaction().hide(onePager).hide(mePager).show(allPager).commit();
                        break;
                    case 2:
                        fragmentManager.beginTransaction().hide(onePager).show(mePager).hide(allPager).commit();
                        break;
                }
            }
        });
    }


}
