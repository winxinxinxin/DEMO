package com.winxinxinxin.traceless.staticstics.traceless.util;

import android.app.Activity;
import android.app.Dialog;
import android.support.v7.app.AppCompatCallback;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.app.TraceAppCompatDelegate;

/**
 * <p>Title:
 * <p>Description:
 * <p>@author:      jiangwx
 * <p>Create Time:  2017/5/19
 * <p>@author:
 * <p>Update Time:
 * <p>Updater:
 * <p>Update Comments:
 */

public class TraceAppCompatUtil {

    public static AppCompatDelegate create(Activity activity, AppCompatCallback callback){
        return new TraceAppCompatDelegate(activity, activity.getWindow(), callback);
    }

    public static AppCompatDelegate create(Dialog dialog, AppCompatCallback callback){
        return new TraceAppCompatDelegate(dialog.getContext(), dialog.getWindow(), callback);
    }
}
