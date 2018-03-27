//
// Created by Viktor on 20.03.2018.
//

#ifndef IMAGEEDITOR_SKETCHFILTER_H
#define IMAGEEDITOR_SKETCHFILTER_H

#include <stdlib.h>

#include "ColorGetter.h"
#include "Util.h"
#include "ImageFilter.h"

class SketchFilter : public ImageFilter {
public:
    SketchFilter(int *_pixels, int _width, int _height);
    int* procImage();
private:
    int threshold;
};


#endif //IMAGEEDITOR_SKETCHFILTER_H
