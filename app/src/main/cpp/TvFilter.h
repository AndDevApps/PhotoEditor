//
// Created by Viktor on 20.03.2018.
//

#ifndef IMAGEEDITOR_TVFILTER_H
#define IMAGEEDITOR_TVFILTER_H


#include "Util.h"
#include "ColorGetter.h"
#include "ImageFilter.h"

class TvFilter : public ImageFilter {
public:
    TvFilter(int *pixels, int width, int height);
    int* procImage();
private:
    int gap;
};



#endif //IMAGEEDITOR_TVFILTER_H
