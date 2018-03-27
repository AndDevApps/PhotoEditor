#include <jni.h>
#include "Util.h"
#include "NeonFilter.h"
#include "OilFilter.h"
#include "TvFilter.h"
#include "LomoAddBlackRound.h"
#include "SoftGlowFilter.h"
#include "SketchFilter.h"
#include "AverageSmoothFilter.h"
#include "GaussianBlurFilter.h"
#include "HDRFilter.h"
#include "LightFilter.h"
#include "SharpenFilter.h"
#include "ReliefFilter.h"
#include "PixelateFilter.h"
#include "BlockFilter.h"
#include "MotionBlurFilter.h"
#include "GothamFilter.h"


extern "C"
JNIEXPORT jintArray JNICALL
Java_filters_NativeFunction_lightFilter(JNIEnv *env, jclass type, jintArray pixels_, jint width,
                                        jint height, jint centerX, jint centerY, jint radius) {
    LightFilterOptions options(centerX, centerY, radius);
    jintArray result = PROC_IMAGE_WITH_OPTIONS(env, pixels_, width, height, LightFilter, options);
    return result;
}

extern "C"
JNIEXPORT jintArray JNICALL
Java_filters_NativeFunction_lomoAddBlckRound(JNIEnv *env, jclass type, jintArray pixels_,
                                             jint width, jint height, jdouble roundRadius) {
    BlackRoundOptions options(roundRadius);
    jintArray result = PROC_IMAGE_WITH_OPTIONS(env, pixels_, width, height, LomoAddBlackRound, options);
    return result;
}

extern "C"
JNIEXPORT jintArray JNICALL
Java_filters_NativeFunction_neonFilter(JNIEnv *env, jclass type, jintArray pixels_, jint width,
                                       jint height, jint r, jint g, jint b) {
    NeonFilterOptions options(r, g, b);
    jintArray result = PROC_IMAGE_WITH_OPTIONS(env, pixels_, width, height, NeonFilter, options);
    return result;
}

extern "C"
JNIEXPORT jintArray JNICALL
Java_filters_NativeFunction_oilFilter(JNIEnv *env, jclass type, jintArray pixels_, jint width,
                                      jint height, jint oilRange) {
    OilFilterOptions options(oilRange);

    jintArray result = PROC_IMAGE_WITH_OPTIONS(env, pixels_, width, height, OilFilter, options);
    return result;
}

extern "C"
JNIEXPORT jintArray JNICALL
Java_filters_NativeFunction_tvFilter(JNIEnv *env, jclass type, jintArray pixels_, jint width,
                                     jint height) {
    jintArray result = PROC_IMAGE_WITHOUT_OPTIONS(env, pixels_, width, height, TvFilter);
    return result;
}

extern "C"
JNIEXPORT jintArray JNICALL
Java_filters_NativeFunction_averageSmooth(JNIEnv *env, jclass type, jintArray pixels_, jint width,
                                          jint height, jint maskSize) {
    AverageSmoothOptions options(maskSize);
    jintArray result = PROC_IMAGE_WITH_OPTIONS(env, pixels_, width, height, AverageSmoothFilter, options);
    return result;
}

extern "C"
JNIEXPORT jintArray JNICALL
Java_filters_NativeFunction_hdrFilter(JNIEnv *env, jclass type, jintArray pixels_, jint width,
                                      jint height) {
    jintArray result = PROC_IMAGE_WITHOUT_OPTIONS(env, pixels_, width, height, HDRFilter);
    return result;
}

extern "C"
JNIEXPORT jintArray JNICALL
Java_filters_NativeFunction_discreteGaussianBlur(JNIEnv *env, jclass type, jintArray pixels_,
                                                 jint width, jint height, jdouble sigma) {
    GaussianBlurOptions options(sigma);
    jintArray result = PROC_IMAGE_WITH_OPTIONS(env, pixels_, width, height, GaussianBlurFilter, options);
    return result;
}

extern "C"
JNIEXPORT jintArray JNICALL
Java_filters_NativeFunction_gothamFilter(JNIEnv *env, jclass type, jintArray pixels_, jint width,
                                         jint height) {
    jintArray result = PROC_IMAGE_WITHOUT_OPTIONS(env, pixels_, width, height, GothamFilter);
    return result;
}

extern "C"
JNIEXPORT jintArray JNICALL
Java_filters_NativeFunction_motionBlurFilter(JNIEnv *env, jclass type, jintArray pixels_,
                                             jint width, jint height, jint xSpeed, jint ySpeed) {
    MotionBlurFilterOpitons options(xSpeed, ySpeed);
    jintArray result = PROC_IMAGE_WITH_OPTIONS(env, pixels_, width, height, MotionBlurFilter, options);
    return result;
}


extern "C"
JNIEXPORT jintArray JNICALL
Java_filters_NativeFunction_blockFilter(JNIEnv *env, jclass type, jintArray pixels_, jint width,
                                        jint height) {
    jintArray result = PROC_IMAGE_WITHOUT_OPTIONS(env, pixels_, width, height, BlockFilter);
    return result;
}


extern "C"
JNIEXPORT jintArray JNICALL
Java_filters_NativeFunction_pxelateFilter(JNIEnv *env, jclass type, jintArray pixels_, jint width,
                                          jint height, jint pixelSize) {
    PixelateOptions options(pixelSize);
    jintArray result = PROC_IMAGE_WITH_OPTIONS(env, pixels_, width, height, PixelateFilter, options);
    return result;
}


extern "C"
JNIEXPORT jintArray JNICALL
Java_filters_NativeFunction_reliefFilter(JNIEnv *env, jclass type, jintArray pixels_, jint width,
                                         jint height) {
    jintArray result = PROC_IMAGE_WITHOUT_OPTIONS(env, pixels_, width, height, ReliefFilter);
    return result;
}


extern "C"
JNIEXPORT jintArray JNICALL
Java_filters_NativeFunction_sharpenFilter(JNIEnv *env, jclass type, jintArray pixels_, jint width,
                                          jint height) {
    jintArray result = PROC_IMAGE_WITHOUT_OPTIONS(env, pixels_, width, height, SharpenFilter);
    return result;
}


extern "C"
JNIEXPORT jintArray JNICALL
Java_filters_NativeFunction_sketchFilter(JNIEnv *env, jclass type, jintArray pixels_, jint width,
                                         jint height) {
    jintArray result = PROC_IMAGE_WITHOUT_OPTIONS(env, pixels_, width, height, SketchFilter);

    return result;
}


extern "C"
JNIEXPORT jintArray JNICALL
Java_filters_NativeFunction_softGlow(JNIEnv *env, jclass type, jintArray pixels_, jint width,
                                     jint height, jdouble blurSigma) {
    SoftGlowOptions options(blurSigma);
    jintArray result = PROC_IMAGE_WITH_OPTIONS(env, pixels_, width, height, SoftGlowFilter, options);

    return result;
}