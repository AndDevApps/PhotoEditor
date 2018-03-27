package filters;

import android.graphics.Bitmap;

/**
 * Created by Viktor on 20.03.2018.
 */

public class AverageSmoothFilter {
    static {
        System.loadLibrary("native-lib");
    }

    /**
     * average blur filter, the maskSize must odd
     * @param // bitmap
     * @param //maskSize
     * @return
     */
    public static Bitmap changeToAverageBlur(Bitmap bitmap, int maskSize) {
        if (maskSize % 2 == 0) {
            throw new IllegalArgumentException(String.format("the maskSize must odd, but %d is an even", maskSize));
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();

        int[] pixels = new int[width * height];
        bitmap.getPixels(pixels, 0, width, 0, 0, width, height);

        int[] returnPixels = NativeFunction.averageSmooth(pixels, width, height, maskSize);
        Bitmap returnBitmap = Bitmap.createBitmap(returnPixels, width, height, Bitmap.Config.ARGB_8888);

        return returnBitmap;
    }
}
