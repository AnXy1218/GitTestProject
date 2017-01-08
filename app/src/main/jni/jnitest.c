//
// Created by Leovo on 2016/12/3.
//
#include <com_example_utils_JNIUtils.h>
#include <string.h>
#include <android/log.h>
// 宏定义类似java 层的定义,不同级别的Log LOGI, LOGD, LOGW, LOGE, LOGF。 对就Java中的 Log.i log.d
#define LOG_TAG    "JNI_TAG" // 这个是自定义的LOG的标识
#undef LOG // 取消默认的LOG
#define LOGI(...)  __android_log_print(ANDROID_LOG_INFO,LOG_TAG, __VA_ARGS__)
#define LOGD(...)  __android_log_print(ANDROID_LOG_DEBUG,LOG_TAG, __VA_ARGS__)
#define LOGW(...)  __android_log_print(ANDROID_LOG_WARN,LOG_TAG, __VA_ARGS__)
#define LOGE(...)  __android_log_print(ANDROID_LOG_ERROR,LOG_TAG, __VA_ARGS__)
#define LOGF(...)  __android_log_print(ANDROID_LOG_FATAL,LOG_TAG, __VA_ARGS__)
/*
 * Class:     com_example_utils_JNIUtils
 * Method:    helloJni
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_example_utils_JNIUtils_helloJni
  (JNIEnv *env, jclass jobj){
    return (*env)->NewStringUTF(env,"Hello JNI!");
}

/*
 * Class:     com_example_utils_JNIUtils
 * Method:    addCal
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_com_example_utils_JNIUtils_addCal
  (JNIEnv *env, jclass jobj, jint ja, jint jb){
    return ja+jb;
 }

/*
 * Class:     com_example_utils_JNIUtils
 * Method:    callJNI
 * Signature: (Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_com_example_utils_JNIUtils_callJNI
(JNIEnv *env, jclass jobj, jstring jStr){

    //在C代码中调用java的方法
    //java反射
    //1、找到java代码的.class文件
    //   jclass      (*FindClass)(JNIEnv*, const char*);
    jclass dpjclazz = (*env)->FindClass(env,"com/example/utils/PrintToastUtils");
    //获取dpjclazz的构造函数并生成一个对象
    jmethodID ctor = (*env)->GetMethodID(env,dpjclazz, "<init>", "()V");
    jobject obj = (*env)->NewObject(env,dpjclazz, ctor);

    if(dpjclazz == 0){
        LOGI("find class error!");
        return;
    }

    LOGI("find class!");

    //2、寻找class里面的方法
    //  jmethodID   (*GetMethodID)(JNIEnv*, jclass, const char*, const char*);第四个参数是返回值类型
    jmethodID methodID = (*env)->GetMethodID(env,dpjclazz,"printToastFromJNI","(Ljava/lang/String;)V");

    LOGI("find method!");

    //3、调用方法
    ////    void        (*CallVoidMethod)(JNIEnv*, jobject, jmethodID, ...);
//    (*env)->CallVoidMethod(env,jobj,methodID,"我是jni，我调用java的方法，我要发送的是："+jStr);
    (*env)->CallVoidMethod(env,obj,methodID,jStr);
    LOGI("final");
}
