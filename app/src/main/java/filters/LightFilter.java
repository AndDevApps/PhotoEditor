package filters;

import android.graphics.Bitmap;

/**
 * Created by Viktor on 20.03.2018.
 */

public class LightFilter {
    static {
        System.loadLibrary("native-lib");
    }

    public static Bitmap changeToLight(Bitmap bitmap, int centerX, int centerY, int radius) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();

        int[] pixels = new int[width * height];
        bitmap.getPixels(pixels, 0, width, 0, 0, width, height);

        int[] returnPixels = NativeFunction.lightFilter(pixels, width, height, centerX, centerY, radius);
        Bitmap returnBitmap = Bitmap.createBitmap(returnPixels, width, height, Bitmap.Config.ARGB_8888);

        return returnBitmap;
    }
}
