package filters;

import android.graphics.Bitmap;

/**
 * Created by Viktor on 20.03.2018.
 */

public class GothamFilter {
    static {
        System.loadLibrary("native-lib");
    }

    public static Bitmap changeToGotham(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();

        int[] pixels = new int[width * height];
        bitmap.getPixels(pixels, 0, width, 0, 0, width, height);

        int[] returnPixles = NativeFunction.gothamFilter(pixels, width, height);
        Bitmap returnBitmap = Bitmap.createBitmap(returnPixles, width, height, Bitmap.Config.ARGB_8888);

        return returnBitmap;
    }
}
