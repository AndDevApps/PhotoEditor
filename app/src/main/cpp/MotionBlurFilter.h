//
// Created by Viktor on 20.03.2018.
//

#ifndef IMAGEEDITOR_MOTIONBLURFILTER_H
#define IMAGEEDITOR_MOTIONBLURFILTER_H


#include "ImageFilter.h"
#include "Util.h"

#define DELAY 2

typedef struct _motionBlurFilterOptions {
    _motionBlurFilterOptions(int x, int y) {
        xSpeed = x;
        ySpeed = y;
    }
    int xSpeed;
    int ySpeed;
} MotionBlurFilterOpitons;

class MotionBlurFilter : public ImageFilter {
public:
    MotionBlurFilter(int *pixels, int width, int height);
    MotionBlurFilter(int *pixels, int width, int height, int x, int y);
    MotionBlurFilter(int *pixels, int width, int height, MotionBlurFilterOpitons options);
    int* procImage();
private:
    int xSpeed;
    int ySpeed;
    void procSpeed();
};


#endif //IMAGEEDITOR_MOTIONBLURFILTER_H
