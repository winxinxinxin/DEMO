package com.winxinxinxin.traceless.staticstics.traceless.util;

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

public class TraceStaticsticsHelper {

    private static TraceStaticsticsHelper mTraceStaticsticsHelper = new TraceStaticsticsHelper();

    private TracePositionClickListener mTracePositionClickListener;

    private TraceStaticsticsHelper() {
    }

    public static TraceStaticsticsHelper getInstance() {
        return mTraceStaticsticsHelper;
    }

    public void init(TracePositionClickListener listener){
        mTracePositionClickListener = listener;
    }

    public TracePositionClickListener getmTracePositionClickListener() {
        return mTracePositionClickListener;
    }
}
