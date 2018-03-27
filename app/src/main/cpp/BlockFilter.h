//
// Created by Viktor on 20.03.2018.
//

#ifndef IMAGEEDITOR_BLOCKFILTER_H
#define IMAGEEDITOR_BLOCKFILTER_H

#include "Util.h"
#include "ImageFilter.h"

class BlockFilter : public ImageFilter {
public:
    BlockFilter(int* pixels, int width, int height);
    int* procImage();
private:
    int threshold;
};



#endif //IMAGEEDITOR_BLOCKFILTER_H
