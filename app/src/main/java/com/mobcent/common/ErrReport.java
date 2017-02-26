package com.mobcent.common;

import android.widget.Toast;

import com.mobcent.discuz.application.DiscuzApplication;

/**
 * Created by sun on 2016/10/14.
 */

public class ErrReport {
    public static void jsonErr() {
        Toast.makeText(DiscuzApplication._instance, "Json解析错误", Toast.LENGTH_SHORT).show();
    }
}
