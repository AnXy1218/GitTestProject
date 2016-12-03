package com.example.utils;

/**
 * Created by Leovo on 2016/12/3.
 */
public class JNIUtils {
    static{
        System.loadLibrary("helloJni");
    }
    public static native String helloJni();
    public static native int addCal(int a,int b);
}
