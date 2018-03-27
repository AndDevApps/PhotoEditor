//
// Created by Viktor on 20.03.2018.
//

#ifndef IMAGEEDITOR_BRIGHTCONTRASTFILTER_H
#define IMAGEEDITOR_BRIGHTCONTRASTFILTER_H

#include "ImageFilter.h"


class BrightContrastFilter : public ImageFilter {
public:
    BrightContrastFilter(int *pixels, int width, int height);
    int* procImage();
    int* setBrightness(double brightness);
    int* setContrast(double contrast);
};


#endif //IMAGEEDITOR_BRIGHTCONTRASTFILTER_H
