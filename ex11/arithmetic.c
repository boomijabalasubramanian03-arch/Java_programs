#include<jni.h>
#include"Arithmetic.h"
#include<stdio.h>
JNIEXPORT jint JNICALL Java_Arithmetic_add(JNIEnv *env,jobject obj,jint a,jint b)
{
   return a+b;
}
JNIEXPORT jint JNICALL Java_Arithmetic_sub(JNIEnv *env,jobject obj,jint a,jint b)
{
   return a-b;
}
JNIEXPORT jint JNICALL Java_Arithmetic_mul(JNIEnv *env,jobject obj,jint a,jint b)
{
   return a*b;
}
JNIEXPORT jint JNICALL Java_Arithmetic_div(JNIEnv *env,jobject obj,jint a,jint b)
{
   return a/b;
}
