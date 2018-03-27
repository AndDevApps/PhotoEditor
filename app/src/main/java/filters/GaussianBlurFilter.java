package filters;

import android.graphics.Bitmap;

/**
 * Created by Viktor on 20.03.2018.
 */

public class GaussianBlurFilter {
    static {
        System.loadLibrary("native-lib");
    }

    public static Bitmap changeToGaussianBlur(Bitmap bitmap, double sigma) {
        int ksize = (int) (sigma * 3 + 1);
        if (ksize == 1) {
            throw new IllegalArgumentException(String.format("sigma %f is too small", sigma));
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();

        int[] pixels = new int[width * height];
        bitmap.getPixels(pixels, 0, width, 0, 0, width, height);

        int[] returnPixels = NativeFunction.discreteGaussianBlur(pixels, width, height, sigma);
        Bitmap returnBitmap = Bitmap.createBitmap(returnPixels, width, height, Bitmap.Config.ARGB_8888);

        return returnBitmap;
    }
}