//
// Created by Viktor on 20.03.2018.
//

#ifndef IMAGEEDITOR_NEONFILTER_H
#define IMAGEEDITOR_NEONFILTER_H


#include <math.h>
#include <stdlib.h>
#include <time.h>

#include "Util.h"
#include "ColorGetter.h"
#include "ImageFilter.h"

typedef struct _neonFilterOptions {
    _neonFilterOptions(int r, int g, int b) {
        this->r = r;
        this->g = g;
        this->b = b;
    }
    int r;
    int g;
    int b;
} NeonFilterOptions;

class NeonFilter : public ImageFilter {
public:
    NeonFilter(int *_pixels, int _width, int _height, NeonFilterOptions options);
    int* procImage();
private:
    int neonR;
    int neonG;
    int neonB;
};

#endif //IMAGEEDITOR_NEONFILTER_H
