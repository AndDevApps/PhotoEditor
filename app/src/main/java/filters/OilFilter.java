package filters;

import android.graphics.Bitmap;

/**
 * Created by Viktor on 20.03.2018.
 */

public class OilFilter {
    static {
        System.loadLibrary("native-lib");
    }

    public static Bitmap changeToOil(Bitmap bitmap, int oilRange) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();

        int[] pixels = new int[width * height];
        bitmap.getPixels(pixels, 0, width, 0, 0, width, height);

        int[] returnPixels = NativeFunction.oilFilter(pixels, width, height, oilRange);
        Bitmap returnBitmap = Bitmap.createBitmap(returnPixels, width, height, Bitmap.Config.ARGB_8888);
        return returnBitmap;
    }
}
