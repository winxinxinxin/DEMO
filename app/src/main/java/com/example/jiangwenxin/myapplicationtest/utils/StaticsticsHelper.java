package com.example.jiangwenxin.myapplicationtest.utils;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.winxinxinxin.traceless.staticstics.traceless.util.TracePositionClickListener;
import com.winxinxinxin.traceless.staticstics.traceless.util.TraceStaticsticsHelper;
import com.winxinxinxin.traceless.staticstics.traceless.util.ViewPathHelper;

/**
 * <p>Title:
 * <p>Description:
 * <p>@author:      jiangwx
 * <p>Create Time:  2017/9/10
 * <p>@author:
 * <p>Update Time:
 * <p>Updater:
 * <p>Update Comments:
 */

public class StaticsticsHelper {
    private StaticsticsDataHelper mStaticsticsDataHelper = new StaticsticsDataHelper();

    public void init() {
        //设置assert目录下的配置文件名
        mStaticsticsDataHelper.init("statisticsPoint.json");

        TraceStaticsticsHelper mTraceStaticsticsHelper = TraceStaticsticsHelper.getInstance();
        mTraceStaticsticsHelper.init(new TracePositionClickListener() {
            @Override
            public void onViewClick(Activity activity, View view) {
                //取得控件路径viewpath
                String viewpath = ViewPathHelper.getInstance().getViewPath(activity, view);

                if (viewpath != null) {
                    Log.v("StaticsticsSDK", "viewpath=" + viewpath);
                    //匹配取数信息
                    StaticsticsDataBean bean = mStaticsticsDataHelper.getStaticsticsDataByViewPath(activity, viewpath);
                    if (bean != null) {
                        Toast.makeText(activity, "控件触发点击，对应埋点id:" + bean.columnid, Toast.LENGTH_LONG).show();
                        //todo 埋点取数
                    }
                }

            }
        });
    }
}
