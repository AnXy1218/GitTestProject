package com.example.utils;

import android.util.Log;

/**
 * Created by Leovo on 2017/1/4.
 */
public class PrintToastUtils {
    public void printToastFromJNI(String jniStr){
        Log.v("TAG","我是java的方法，我接收到了JNI给我传过来的信息：" + jniStr);
    }
}
