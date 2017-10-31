package com.example.admin.basic.inter;

/**
 * Created by admin on 2017/10/31.
 */

public interface IndexListListener<T> {
    void initData(T indexList);
    void error(String errorMsg);
}
