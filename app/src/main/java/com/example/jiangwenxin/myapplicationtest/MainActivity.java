package com.example.jiangwenxin.myapplicationtest;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jiangwenxin.myapplicationtest.utils.StaticsticsHelper;

public class MainActivity extends BaseActivity {
    private TextView textView;
    private ImageView imageView;
    private Button button;

    MainFragment mainFragment = new MainFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView = (TextView)findViewById(R.id.textView);
        textView.setOnClickListener(mOnClickListener);
        imageView = (ImageView)findViewById(R.id.imageView);
        imageView.setOnClickListener(mOnClickListener);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(mOnClickListener);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.relativeLayout, mainFragment);
        transaction.commit();

        //初始化无痕埋点
        StaticsticsHelper mStaticsticsHelper = new StaticsticsHelper();
        mStaticsticsHelper.init();
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {

        }
    };

}
