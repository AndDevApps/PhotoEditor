//
// Created by Viktor on 20.03.2018.
//

#ifndef IMAGEEDITOR_GAUSSIANBLURFILTER_H
#define IMAGEEDITOR_GAUSSIANBLURFILTER_H

#include "ImageFilter.h"
#include "Util.h"

typedef struct _gaussianBlurOptions {
    _gaussianBlurOptions(double s) {
        this->sigma = s;
    }
    double sigma;
} GaussianBlurOptions;

class GaussianBlurFilter : public ImageFilter {
public:
    GaussianBlurFilter(int *_pixels, int _width, int _height, GaussianBlurOptions opions);
    ~GaussianBlurFilter() {
        this->sigma = 0;
        delete [] kernel;
        kernel = NULL;
    }
    int* procImage();
private:
    double sigma;
    double *kernel;
    int kernelSum;
    int maskSize;
};


#endif //IMAGEEDITOR_GAUSSIANBLURFILTER_H
