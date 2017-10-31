package com.example.admin.basic.bean;

import java.util.List;

/**
 * Created by admin on 2017/10/31.
 */

public class IndexList {

    /**
     * res : 0
     * data : ["4524","4516","4514","4539","4561","4538","4560","4537","4559","4547"]
     */

    private int res;
    private List<String> data;


    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "IndexList{" +
                "res=" + res +
                ", data=" + data +
                '}';
    }
}
