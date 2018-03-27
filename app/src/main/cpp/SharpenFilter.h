//
// Created by Viktor on 20.03.2018.
//

#ifndef IMAGEEDITOR_SHARPENFILTER_H
#define IMAGEEDITOR_SHARPENFILTER_H



#include "ImageFilter.h"
#include "Util.h"
#include "ColorGetter.h"

class SharpenFilter : public ImageFilter {
public:
    SharpenFilter(int *pixels, int width, int height);
    ~SharpenFilter();
    int* procImage();
    int* highBoostSharpen();
};

#endif //IMAGEEDITOR_SHARPENFILTER_H
