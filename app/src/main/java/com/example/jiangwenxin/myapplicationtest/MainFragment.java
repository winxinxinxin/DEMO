package com.example.jiangwenxin.myapplicationtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

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

public class MainFragment extends Fragment {
    private View rootView;

    private TextView textView;
    private ImageView imageView;
    private Button button;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main, container, false);

        textView = (TextView)rootView.findViewById(R.id.textView);
        textView.setOnClickListener(mOnClickListener);
        imageView = (ImageView)rootView.findViewById(R.id.imageView);
        imageView.setOnClickListener(mOnClickListener);
        button = (Button)rootView.findViewById(R.id.button);
        button.setOnClickListener(mOnClickListener);
        return rootView;
    }


    private View.OnClickListener mOnClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {

        }
    };
}
