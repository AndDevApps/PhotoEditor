//
// Created by Viktor on 20.03.2018.
//

#ifndef IMAGEEDITOR_HDRFILTER_H
#define IMAGEEDITOR_HDRFILTER_H

#include "Util.h"
#include "ImageFilter.h"
#include "GaussianBlurFilter.h"

class HDRFilter : public ImageFilter {
public:
    HDRFilter(int *_pixels, int _width, int _height): ImageFilter(_pixels, _width, _height) {};
    int* procImage();
};


#endif //IMAGEEDITOR_HDRFILTER_H
