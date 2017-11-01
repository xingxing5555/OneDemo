package com.example.admin.basic.utils;

import android.text.TextUtils;

/**
 * noted:
 * 1、文字工具类
 * 2、数字工具类
 */

public class BaseUtils {


    /**
     * 判断字符串是否为空
     */
    public static boolean isEmpty(String text){
        if(text!=null&& !TextUtils.isEmpty(text)){
            return false;
        }
        return true;
    }

    /**
     * 若double中的小数都为0，则仅显示整数，否则，不发生变化
     */
    public static String doubleTrans(double num){
        if(num % 1.0 == 0){
            return String.valueOf((long)num);
        }
        return String.valueOf(num);
    }
}
