//
// Created by Viktor on 20.03.2018.
//

#ifndef IMAGEEDITOR_IMAGEFILTER_H
#define IMAGEEDITOR_IMAGEFILTER_H

#include <string.h>

#include "Util.h"

/*
 * base Filter class
 */
class ImageFilter {
public:
    ImageFilter(int *_pixels = NULL, int _width = 0, int _height = 0): height(_height), width(_width) {
//		pixels = new int[width * height];
//		memcpy(pixels, _pixels, width * height * sizeof(int));
        this->pixels = _pixels; // avoid alloc redundant pixels buffer
    };
    virtual ~ImageFilter() {
//		if (pixels != NULL)
//			delete [] pixels;
        pixels = NULL;
    };
    void setPixels(int *_pixels, int width, int height) {
        if (pixels != NULL)
            delete [] pixels;
        this->width = width;
        this->height = height;
        this->pixels = _pixels; // avoid alloc redundant pixels buffer
        //this->pixels = new int[this->width * this->height];
        //memcpy(pixels, _pixels, this->width * this->height * sizeof(int));
    };
    /**
     * this method will change the inner pixels array,
     * and return the inner pixels
     */
    virtual int* procImage() = 0;
protected:
    int* pixels;
    int width;
    int height;
};



#endif //IMAGEEDITOR_IMAGEFILTER_H
