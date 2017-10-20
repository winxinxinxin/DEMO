package app;

import android.content.Context;
import android.support.v7.app.AppCompatCallback;
import android.support.v7.app.AppCompatDelegateImplV14;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;

import com.hisunflytone.cmdm.module.staticstics.traceless.baseview.TraceButton;
import com.hisunflytone.cmdm.module.staticstics.traceless.baseview.TraceImageButton;
import com.hisunflytone.cmdm.module.staticstics.traceless.baseview.TraceImageView;
import com.hisunflytone.cmdm.module.staticstics.traceless.baseview.TraceTextView;

/**
 * <p>Title:
 * <p>Description:
 * <p>@author:      jiangwx
 * <p>Copyright:  Copyright (c) 2016
 * <p>Company:      @咪咕动漫
 * <p>Create Time:  2017/5/19
 * <p>@author:
 * <p>Update Time:
 * <p>Updater:
 * <p>Update Comments:
 */

public class TraceAppCompatDelegate extends AppCompatDelegateImplV14{
    public TraceAppCompatDelegate(Context context, Window window, AppCompatCallback callback) {
        super(context, window, callback);
    }

    @Override
    View callActivityOnCreateView(View parent, String name, Context context, AttributeSet attrs) {
        switch (name){
            case "Button":
                return new TraceButton(context, attrs);
            case "ImageView":
                return new TraceImageView(context, attrs);
            case "TextView":
                return new TraceTextView(context,attrs);
            case "ImageButton":
                return new TraceImageButton(context, attrs);
            //注意：暂时不建议替换layout
        }

        return super.callActivityOnCreateView(parent, name, context, attrs);
    }
}
