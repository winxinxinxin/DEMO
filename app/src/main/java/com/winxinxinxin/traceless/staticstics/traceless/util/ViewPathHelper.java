package com.winxinxinxin.traceless.staticstics.traceless.util;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;

import java.util.List;

/**
 * <p>Title:资源位点击事件 无埋点方式 控件匹配工具
 * <p>Description:
 * <p>@author:      jiangwx
 * <p>Create Time:  2017/5/19
 * <p>@author:
 * <p>Update Time:
 * <p>Updater:
 * <p>Update Comments:
 */

public class ViewPathHelper {
    private static ViewPathHelper mViewPathManager = new ViewPathHelper();
    private final String PATHSPIT = ":";

    private ViewPathHelper() {
    }

    public static ViewPathHelper getInstance() {
        return mViewPathManager;
    }


    /**
     * 生成控件的标识  便于匹配
     * 需要取数的控件，注意id命名不要重复
     *
     * @param mActivity
     * @param view
     * @return
     */
    public String getViewPath(Activity mActivity, View view) {
        String result = "";

        try {
            if (mActivity != null) {
                String activityName = mActivity.getClass().getSimpleName();
                result = activityName;

                if(mActivity instanceof FragmentActivity){
                    String fragment = getFragmentByView((FragmentActivity)mActivity, view);
                    if (!TextUtils.isEmpty(fragment)) {
                        result += PATHSPIT + fragment;
                    }
                }


                String viewClassName = view.getClass().getSimpleName();
                result += PATHSPIT + viewClassName;

                int viewId = view.getId();
                String entryName = mActivity.getResources().getResourceEntryName(viewId);
                result += PATHSPIT + entryName;
            }

        } catch (Exception e) {
        }
        return result;
    }

    /**
     * 获取view所在的fragment.目前仅查到activity层面往下两级fragment。
     * 例如view在activity里的fragment1内，获取结果为fragment1
     * 例如view在activity里的fragment1内的fragment11内的fragment111里面，获取结果为fragment11
     *
     * @param mActivity view 所在activity
     * @param view
     * @return 所在fragment的simpleClassName
     */
    @SuppressWarnings("RestrictedApi")
    private String getFragmentByView(FragmentActivity mActivity, View view) {
        try {
            int viewId = view.getId();
            mActivity.getSupportFragmentManager().getFragments();
            List<Fragment> fragments = mActivity.getSupportFragmentManager().getFragments();
            if (fragments == null) {
                return null;
            }
            for (Fragment f : fragments) {
                if (f!=null && f.getChildFragmentManager().getFragments() != null && f.getChildFragmentManager().getFragments().size() > 0) {
                    for (Fragment ff : f.getChildFragmentManager().getFragments()) {
                        View ffchild = ff.getView().findViewById(viewId);
                        if (ffchild != null && ffchild == view) {
                            return ff.getClass().getSimpleName();
                        }
                    }
                }
                if (f.getView() != null) {
                    View fchild = f.getView().findViewById(viewId);
                    if (fchild != null && fchild == view) {
                        return f.getClass().getSimpleName();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
