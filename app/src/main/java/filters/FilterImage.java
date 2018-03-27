package filters;

import android.graphics.Bitmap;

/**
 * Created by Viktor on 20.03.2018.
 */

public class FilterImage {
    ///////////////////////FILTER ID//////////////////////////////


    public static final int AVERAGE_SMOOTH_STYLE = 1; // gray scale
    public static final int BLOCK_STYLE = 2; // relief
    public static final int GAUSSIAN_BLUR_STYLE = 3; // average blur
    public static final int GOTHAM_STYLE = 4; // oil painting
    public static final int HDR_STYLE = 5; // neon
    public static final int LIGHT_STYLE = 6; // pixelate
    public static final int LOMO_STYLE = 7; // Old TV
    public static final int MOTION_BLUR_STYLE = 8; // invert the colors
    public static final int NEON_STYLE = 9; // engraving
    public static final int OIL_STYLE = 10; // old photo
    public static final int PIXELATE_STYLE = 11; // lomo
    public static final int RELIEF_STYLE = 12; // HDR
    public static final int SHARPEN_STYLE = 13; // gaussian blur
    public static final int SKETCH_STYLE = 14; // soft glow
    public static final int SOFT_GLOW_STYLE = 15; // sketch style
    public static final int TV_STYLE = 16; // motion blur

    public static final int TOTAL_FILTER_NUM = TV_STYLE;
    /////////////////////////////////////////////////////////////////



    ////////////////////////CHANGE IMAGE ///////////////////////////////
    public static Bitmap changeFilter(Bitmap bitmap, int styleNo, Object... options) {
        if (styleNo == AVERAGE_SMOOTH_STYLE) {
            if (options.length < 1) {
                return AverageSmoothFilter.changeToAverageBlur(bitmap, 5);
            }
            return AverageSmoothFilter.changeToAverageBlur(bitmap, (Integer)options[0]); // maskSize
        }
        else if (styleNo == BLOCK_STYLE) {
            return BlockFilter.changeToBrick(bitmap);
        }
        else if (styleNo == GAUSSIAN_BLUR_STYLE) {
            if (options.length < 1) {
                return GaussianBlurFilter.changeToGaussianBlur(bitmap, 1.2);
            }
            return GaussianBlurFilter.changeToGaussianBlur(bitmap, (Double)options[0]); // sigma
        }
        else if (styleNo == GOTHAM_STYLE) {
            return GothamFilter.changeToGotham(bitmap);
        }
        else if (styleNo == HDR_STYLE) {
            return HDRFilter.changeToHDR(bitmap);
        }
        else if (styleNo == LIGHT_STYLE) {
            if (options.length < 3) {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                return LightFilter.changeToLight(bitmap, width / 2, height / 2, Math.min(width / 2, height / 2));
            }
            return LightFilter.changeToLight(bitmap, (Integer)options[0],
                    (Integer)options[1], (Integer)options[2]); // centerX, centerY, radius
        }
        else if (styleNo == LOMO_STYLE) {
            if (options.length < 1) {
                double radius = (bitmap.getWidth() / 2) * 95 / 100;
                return LomoAddBlackRound.changeToLomo(bitmap, radius);
            }
            return LomoAddBlackRound.changeToLomo(bitmap, (Double)options[0]);
        }
        else if (styleNo == MOTION_BLUR_STYLE) {
            if (options.length < 2) {
                return MotionBlurFilter.changeToMotionBlur(bitmap, 5, 1);
            }
            return MotionBlurFilter.changeToMotionBlur(bitmap, (Integer)options[0], (Integer)options[1]);
        }
        else if (styleNo == NEON_STYLE) {
            if (options.length < 3) {
                return NeonFilter.changeToNeon(bitmap, 200, 50, 100);
            }
            return NeonFilter.changeToNeon(bitmap, (Integer)options[0], (Integer)options[1], (Integer)options[2]);
        }
        else if (styleNo == OIL_STYLE) {
            if (options.length < 1) {
                return OilFilter.changeToOil(bitmap, 5);
            }
            return OilFilter.changeToOil(bitmap, (Integer)options[0]);
        }
        else if (styleNo == PIXELATE_STYLE) {
            if (options.length < 1) {
                return PixelateFilter.changeToPixelate(bitmap, 10);
            }
            return PixelateFilter.changeToPixelate(bitmap, (Integer)options[0]);
        }
        else if (styleNo == RELIEF_STYLE) {
            return ReliefFilter.changeToRelief(bitmap);
        }
        else if (styleNo == SHARPEN_STYLE) {
            return SharpenFilter.changeToSharpen(bitmap);
        }
        else if (styleNo == SKETCH_STYLE) {
            return SketchFilter.changeToSketch(bitmap);
        }
        else if (styleNo == SOFT_GLOW_STYLE) {
            if (options.length < 1) {
                return SoftGlowFilter.softGlowFilter(bitmap, 0.6);
            }
            return SoftGlowFilter.softGlowFilter(bitmap, (Double)options[0]);
        }
        else if (styleNo == SOFT_GLOW_STYLE) {
            if (options.length < 1) {
                return SoftGlowFilter.softGlowFilter(bitmap, 0.6);
            }
            return SoftGlowFilter.softGlowFilter(bitmap, (Double)options[0]);
        }
        else if (styleNo == TV_STYLE) {
            return TvFilter.changeToTV(bitmap);
        }
        return bitmap;
    }
    /////////////////////////////////////////////////////////////////////////////



}
