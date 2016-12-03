//
// Created by Leovo on 2016/12/3.
//
#include <com_example_utils_JNIUtils.h>
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
