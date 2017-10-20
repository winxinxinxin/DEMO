package com.example.jiangwenxin.myapplicationtest.utils;

import android.content.Context;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

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

public class StaticsticsDataHelper {

    private Map<String, StaticsticsDataBean> mDatas = new HashMap<String, StaticsticsDataBean>();
    private boolean hasLoadMatchInfoData = false;
    private String mFileName = "statisticsPoint.json";


    public void init(String fileName){
        if(!TextUtils.isEmpty(fileName)){
            mFileName = fileName;
        }
    }

    /**
     * 查找该VIEW是否需要取数，需要取数返回columnid
     *
     * @param viewpath
     * @return 返回取数需要用到的columnid ， null- 不需要取数
     */
    public StaticsticsDataBean getStaticsticsDataByViewPath(Context context, String viewpath){
        if (!hasLoadMatchInfoData) {
            getAllStatisticsViewPathMatchInfo(context);
        }
        if (!TextUtils.isEmpty(viewpath)) {
            return mDatas.get(viewpath);
        }
        return null;
    }

    /**
     * 获取需要统计的 埋点 的viewpath信息和columnid信息
     */
    private void getAllStatisticsViewPathMatchInfo(Context context) {
        try {
            String s = new String(readAssets(context, mFileName));
            if (TextUtils.isEmpty(s)) return;

            JSONObject jsonObject = null;

            Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
            jsonObject = new JSONObject(s);
            JSONArray jsonArray = jsonObject.optJSONArray("data");
            for (int i = 0; i < jsonArray.length(); i++) {
                StaticsticsDataBean bean = gson.fromJson(jsonArray.optJSONObject(i).toString(), StaticsticsDataBean.class);
                mDatas.put(bean.viewPath, bean);
            }
            hasLoadMatchInfoData = true;
        } catch (Exception e) {
        }
    }

    /**
     * 读取Assets文件
     *
     * @param fileName
     * @return
     */
    private byte[] readAssets(Context context, String fileName) {
        if (fileName == null || fileName.length() <= 0) {
            return null;
        }
        byte[] buffer = null;
        try {
            InputStream fin = context.getAssets().open(fileName);
            int length = fin.available();
            buffer = new byte[length];
            fin.read(buffer);
            fin.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return buffer;
        }
    }

}
