package com.gc.buaa.baidumap.utils;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;


/**
 * Created by Administrator on 2016/5/8.
 */
public class Utils {
    private static Toast toast;

    /**
     * 在屏幕中央显示一个Toast
     *
     * @param text
     */
    public static void showToast(Context context, CharSequence text) {
        if (toast == null) {
            toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        }
        toast.setText(text);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

    }
}
