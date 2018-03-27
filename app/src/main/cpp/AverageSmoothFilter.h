//
// Created by Viktor on 20.03.2018.
//

#ifndef IMAGEEDITOR_AVERAGESMOOTHFILTER_H
#define IMAGEEDITOR_AVERAGESMOOTHFILTER_H

#include "ImageFilter.h"
#include "Util.h"

typedef struct _averageSmoothOptions {
    _averageSmoothOptions(int maskSize) {
        this->maskSize = maskSize;
    }
    int maskSize;
} AverageSmoothOptions;

class AverageSmoothFilter : public ImageFilter {
public:
    AverageSmoothFilter(int *pixels, int width, int height);
    AverageSmoothFilter(int *_pixels, int _width, int _height, AverageSmoothOptions options);
    virtual ~AverageSmoothFilter() {};
    int* procImage();
private:
    int maskSize;
};



#endif //IMAGEEDITOR_AVERAGESMOOTHFILTER_H