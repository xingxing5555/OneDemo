package com.example.admin.basic.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by admin on 2017/10/31.
 */

public class ToastUtils {
    public static Toast toast = null;

    public static void makeText(Context context, String text) {
        if (toast == null) {
            toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
            toast.show();
        } else {
            toast.setText(text);
            toast.show();
        }
    }
}
