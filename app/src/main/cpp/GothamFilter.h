//
// Created by Viktor on 20.03.2018.
//

#ifndef IMAGEEDITOR_GOTHAMFILTER_H
#define IMAGEEDITOR_GOTHAMFILTER_H


#include "ColorGetter.h"
#include "ImageFilter.h"

#define GOTHAM_R 34
#define GOTHAM_G 43
#define GOTHAM_B 109

class GothamFilter : public ImageFilter {
public:
    GothamFilter(int *pixels, int width, int height);
    int* procImage();

private:
    double gothamHue;
    double saturationFactor;
    double gammaValue;
    double contrastValue;
};


#endif //IMAGEEDITOR_GOTHAMFILTER_H
