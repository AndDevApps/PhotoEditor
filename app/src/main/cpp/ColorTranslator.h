//
// Created by Viktor on 20.03.2018.
//

#ifndef IMAGEEDITOR_COLORTRANSLATOR_H
#define IMAGEEDITOR_COLORTRANSLATOR_H


#include "ColorGetter.h"

typedef struct _rgb { // 0 ~ 225
    _rgb(int r = 0, int g = 0, int b = 0) {
        this->r = r;
        this->g = g;
        this->b = b;
    }
    int r;
    int g;
    int b;
} RGB;

typedef struct _hsi {
    _hsi(double h = 0, double s = 0, double i = 0) {
        this->h = h;
        this->s = s;
        this->i = i;
    }
    double h; // 0 ~ 360
    double s; // 0 ~ 1
    double i; // 0 ~ 1
} HSI;

class ColorTranslator {
public:
    static HSI RGB2HSI(double r, double g, double b);
    static RGB HSI2RGB(double h, double s, double i);
    static bool checkRGB(double r, double g, double b);
    static bool checkRGB(RGB rgb);

};

#endif //IMAGEEDITOR_COLORTRANSLATOR_H
