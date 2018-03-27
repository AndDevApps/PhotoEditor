//
// Created by Viktor on 20.03.2018.
//

#ifndef IMAGEEDITOR_HUESATURATIONFILTER_H
#define IMAGEEDITOR_HUESATURATIONFILTER_H


#include "ImageFilter.h"
#include "ColorTranslator.h"

class HueSaturationFilter : public ImageFilter {
public:
    HueSaturationFilter(int *pixels, int width, int height);
    ~HueSaturationFilter();
    int* procImage();
    int* setHue(double hue);
    int* setSaturation(double saturation);
    int* setHueSaturation(double hue, double saturation);
    int* setHueSaturationIntesity(double hue, double saturation, double intesity);
private:
    HSI* pixelsHSI;
    void initPixelsHSI();
};



#endif //IMAGEEDITOR_HUESATURATIONFILTER_H
