//
// Created by Viktor on 20.03.2018.
//

#ifndef IMAGEEDITOR_SOFTGLOWFILTER_H
#define IMAGEEDITOR_SOFTGLOWFILTER_H

#include "Util.h"
#include "ColorGetter.h"
#include "ImageFilter.h"
#include "GaussianBlurFilter.h"

typedef struct _softGlowOptions {
    _softGlowOptions(double s) {
        this->blurSigma = s;
    }
    double blurSigma;
} SoftGlowOptions;

class SoftGlowFilter : public ImageFilter {
public:
    SoftGlowFilter(int *_pixels, int _width, int _height, SoftGlowOptions options);
    int* procImage();
private:
    double blurSigma;
};


#endif //IMAGEEDITOR_SOFTGLOWFILTER_H
