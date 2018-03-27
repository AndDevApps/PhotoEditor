package filters;

import android.graphics.Bitmap;

/**
 * Created by Viktor on 20.03.2018.
 */

public class TvFilter {
    static {
        System.loadLibrary("native-lib");
    }

    public static final Bitmap changeToTV(Bitmap bitmap) {
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();

        int[] pixels = new int[width * height];
        bitmap.getPixels(pixels, 0, width, 0, 0, width, height);

        int[] resultPixels = NativeFunction.tvFilter(pixels, width, height);
        Bitmap returnBitmap = Bitmap.createBitmap(resultPixels, width, height, Bitmap.Config.ARGB_8888);

        return returnBitmap;
    }
}
