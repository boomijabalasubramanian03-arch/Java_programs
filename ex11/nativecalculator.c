#include<jni.h>
#include"NativeCalculator.h"
#include<stdio.h>
JNIEXPORT jint JNICALL Java_NativeCalculator_add(JNIEnv *env,jobject obj,jint a,jint b)
{
   return a+b;
}
JNIEXPORT jint JNICALL Java_NativeCalculator_subtract(JNIEnv *env,jobject obj,jint a,jint b)
{
   return a-b;
}
JNIEXPORT jint JNICALL Java_NativeCalculator_multiple(JNIEnv *env,jobject obj,jint a,jint b)
{
   return a*b;
}
JNIEXPORT jint JNICALL Java_NativeCalculator_divide(JNIEnv *env,jobject obj,jint a,jint b)
{
   return a/b;
}
