package com.example.utils;

import android.util.Log;
import android.widget.Toast;

/**
 * Created by Leovo on 2016/12/3.
 */
public class JNIUtils {
    static{
        System.loadLibrary("helloJni");
    }
    public static native String helloJni();
    public static native int addCal(int a,int b);
    public static native void callJNI(String helloStr);
}
