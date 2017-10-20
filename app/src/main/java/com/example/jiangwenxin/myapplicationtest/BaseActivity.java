package com.example.jiangwenxin.myapplicationtest;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;

import com.winxinxinxin.traceless.staticstics.traceless.util.TraceAppCompatUtil;

/**
 * <p>Title:
 * <p>Description:
 * <p>@author:      jiangwx
 * <p>Create Time:  2017/9/3
 * <p>@author:
 * <p>Update Time:
 * <p>Updater:
 * <p>Update Comments:
 */

public abstract class BaseActivity extends AppCompatActivity {

    //设置控件代理开始
    private AppCompatDelegate mAppCompatDelegate;
    @NonNull
    @Override
    public AppCompatDelegate getDelegate() {
        if(mAppCompatDelegate==null){
            mAppCompatDelegate = TraceAppCompatUtil.create(this, this);
        }
        return mAppCompatDelegate;
    }
}
