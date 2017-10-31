package com.example.admin.basic.impl;

import com.example.admin.basic.bean.IndexList;
import com.example.admin.basic.bean.OneList;
import com.example.admin.basic.inter.IndexListListener;
import com.example.admin.basic.model.IndexListModel;
import com.example.admin.basic.model.OneListModel;
import com.example.admin.basic.net.RequestManager;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by admin on 2017/10/31.
 */

public class IndexListImpl implements IndexListModel,OneListModel {
    private CompositeDisposable disposable = new CompositeDisposable();
    private String channel = "wdj", version = "4.0.2", uuid = "ffffffff-a90e-706a-63f7-ccf973aae5ee", platform = "android";

    @Override
    public void getIndexList(final IndexListListener listListener) {
        Disposable subscribe = RequestManager.getNormalService().getIndexList(channel, version, uuid, platform)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<IndexList>() {
                    @Override
                    public void accept(IndexList indexList) throws Exception {
                        listListener.initData(indexList);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        listListener.error(throwable.getMessage());
                    }
                });
        disposable.add(subscribe);

    }

    @Override
    public void getOneList(String data, final IndexListListener listListener) {
        Disposable subscribe = RequestManager.getNormalService().getOneList(data,channel, uuid, platform)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<OneList>() {
                    @Override
                    public void accept(OneList indexList) throws Exception {
                        listListener.initData(indexList);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        listListener.error(throwable.getMessage());
                    }
                });
        disposable.add(subscribe);

    }
}
