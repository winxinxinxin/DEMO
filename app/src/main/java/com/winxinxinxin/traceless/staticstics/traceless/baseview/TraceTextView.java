package com.winxinxinxin.traceless.staticstics.traceless.baseview;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.View;

import com.winxinxinxin.traceless.staticstics.traceless.util.TraceStaticsticsHelper;


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

public class TraceTextView extends AppCompatTextView{
    private Context mContext;
    private OnClickListener mOnClickListener;
    private OnClickListener mProxyClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {

            Activity act = null;
            if(mContext instanceof Activity){
                act = (Activity)mContext;
            }
            if(TraceStaticsticsHelper.getInstance().getmTracePositionClickListener()!=null){
                TraceStaticsticsHelper.getInstance().getmTracePositionClickListener().onViewClick(act,v);
            }

            if(mOnClickListener!=null){
                mOnClickListener.onClick(v);
            }
        }
    };

    public TraceTextView(Context context) {
        super(context);
        mContext = context;
    }

    public TraceTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    public TraceTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
    }

    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        super.setOnClickListener(mProxyClickListener);
        mOnClickListener = l;
    }
}
