//
// Created by Viktor on 20.03.2018.
//

#ifndef IMAGEEDITOR_LOMOADDBLACKROUND_H
#define IMAGEEDITOR_LOMOADDBLACKROUND_H


#include "Util.h"
#include "ImageFilter.h"
#include "ColorGetter.h"

typedef struct _blackRoundOptions {
    _blackRoundOptions(double r) {
        roundRadius = r;
    }
    double roundRadius;
} BlackRoundOptions;

class LomoAddBlackRound : public ImageFilter {
public:
    LomoAddBlackRound(int *_pixels, int _width, int _height, BlackRoundOptions options);
    int* procImage();
private:
    double roundRadius;
    double pixelsFalloff;
    double scaleFunc(double distance);
};


#endif //IMAGEEDITOR_LOMOADDBLACKROUND_H
