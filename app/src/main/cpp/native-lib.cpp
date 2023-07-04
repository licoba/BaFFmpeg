#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_licoba_baffmpeg_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C" {
#include "include/libavutil/avutil.h"
}
extern "C" JNIEXPORT jstring JNICALL
Java_com_licoba_baffmpeg_MainActivity_ffmpegInfo(JNIEnv *env, jobject thiz) {
// 返回 ffmpeg 配置信息
    return env->NewStringUTF(avutil_configuration());
}