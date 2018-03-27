//
// Created by Viktor on 20.03.2018.
//

#ifndef IMAGEEDITOR_RELIEFFILTER_H
#define IMAGEEDITOR_RELIEFFILTER_H

#include "Util.h"
#include "ImageFilter.h"

class ReliefFilter : public ImageFilter {
public:
    ReliefFilter(int *pixels, int width, int height);
    int* procImage();
private:
    int colorCompensation;
};

#endif //IMAGEEDITOR_RELIEFFILTER_H
