package com.mobcent.discuz.uitls;

import android.content.Context;
import android.content.res.Resources;

/**
 * Created by Dimitry Ivanov on 23.05.2015.
 */
public class DipUtils {

    private DipUtils() {}

    public static int dipToPx(Context context, int dip) {
        final Resources r = context.getResources();
        final float scale = r.getDisplayMetrics().density;
        return (int) (dip * scale + .5F);
    }
}
