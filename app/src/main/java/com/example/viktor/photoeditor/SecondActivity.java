package com.example.viktor.photoeditor;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.github.chrisbanes.photoview.PhotoView;

import filters.FilterImage;

public class SecondActivity extends AppCompatActivity {

    private static final int MY_PERMISION_REQUEST = 1;
    private static final int RESULT_LOAD_IMAGE = 0;

    public Bitmap bitmap,newbitmap, lessbitmap;
    String picturePath;

    PhotoView photoView;
    FilterImage filterImage;

    ImageButton imageButtons,imageButtons1,imageButtons2,imageButtons3,imageButtons4,
            imageButtons5,imageButtons6,imageButtons7,imageButtons8,imageButtons9,
            imageButtons10,imageButtons11,imageButtons12,imageButtons13,imageButtons14,
            imageButtons15;

    static {
        System.loadLibrary("native-lib");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        photoView = (PhotoView) findViewById(R.id.photo_view);
        imageButtons = (ImageButton) findViewById(R.id.imageButton);
        imageButtons1 = (ImageButton) findViewById(R.id.imageButton1);
        imageButtons2 = (ImageButton) findViewById(R.id.imageButton2);
        imageButtons3 = (ImageButton) findViewById(R.id.imageButton3);
        imageButtons4 = (ImageButton) findViewById(R.id.imageButton4);
        imageButtons5 = (ImageButton) findViewById(R.id.imageButton5);
        imageButtons6 = (ImageButton) findViewById(R.id.imageButton6);
        imageButtons7 = (ImageButton) findViewById(R.id.imageButton7);
        imageButtons8 = (ImageButton) findViewById(R.id.imageButton8);
        imageButtons9 = (ImageButton) findViewById(R.id.imageButton9);
        imageButtons10 = (ImageButton) findViewById(R.id.imageButton10);
        imageButtons11 = (ImageButton) findViewById(R.id.imageButton11);
        imageButtons12 = (ImageButton) findViewById(R.id.imageButton12);
        imageButtons13 = (ImageButton) findViewById(R.id.imageButton13);
        imageButtons14 = (ImageButton) findViewById(R.id.imageButton14);
        imageButtons15 = (ImageButton) findViewById(R.id.imageButton15);

        if(ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)){
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},MY_PERMISION_REQUEST);
            }
            else{
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},MY_PERMISION_REQUEST);
            }

        }else{

        }

        Intent inten = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(inten,RESULT_LOAD_IMAGE);
    }


    private Bitmap applyStyle(int styleNo, Bitmap change) {
        Bitmap changeBitmap;
        switch (styleNo) {
            case FilterImage.AVERAGE_SMOOTH_STYLE:
                changeBitmap = FilterImage.changeFilter(change, FilterImage.AVERAGE_SMOOTH_STYLE, 5); // maskSize, must odd
                break;
            case FilterImage.BLOCK_STYLE:
                changeBitmap = FilterImage.changeFilter(change, FilterImage.BLOCK_STYLE); // sigma
                break;
            case FilterImage.GAUSSIAN_BLUR_STYLE:
                changeBitmap = FilterImage.changeFilter(change, FilterImage.GAUSSIAN_BLUR_STYLE,1.2); // sigma
                break;
            case FilterImage.GOTHAM_STYLE:
                changeBitmap = FilterImage.changeFilter(change, FilterImage.GOTHAM_STYLE); // sigma
                break;
            case FilterImage.HDR_STYLE:
                changeBitmap = FilterImage.changeFilter(change, FilterImage.HDR_STYLE); // sigma
                break;

            case FilterImage.LIGHT_STYLE:
                int width = change.getWidth();
                int height = change.getHeight();
                changeBitmap = FilterImage.changeFilter(change, FilterImage.LIGHT_STYLE, width / 3, height / 2, width / 2);
                break;
            case FilterImage.LOMO_STYLE:
                changeBitmap = FilterImage.changeFilter(change, FilterImage.LOMO_STYLE,
                        (change.getWidth() / 2.0) * 95 / 100.0);
                break;
            case FilterImage.MOTION_BLUR_STYLE:
                changeBitmap = FilterImage.changeFilter(change, FilterImage.MOTION_BLUR_STYLE,5,1); // sigma
                break;
            case FilterImage.NEON_STYLE:
                changeBitmap = FilterImage.changeFilter(change, FilterImage.NEON_STYLE,200, 100, 50); // sigma
                break;
            case FilterImage.OIL_STYLE:
                changeBitmap = FilterImage.changeFilter(change, FilterImage.OIL_STYLE,5); // sigma
                break;
            case FilterImage.PIXELATE_STYLE:
                changeBitmap = FilterImage.changeFilter(change, FilterImage.PIXELATE_STYLE,10); // sigma
                break;
            case FilterImage.RELIEF_STYLE:
                changeBitmap = FilterImage.changeFilter(change, FilterImage.RELIEF_STYLE); // sigma
                break;
            case FilterImage.SHARPEN_STYLE:
                changeBitmap = FilterImage.changeFilter(change, FilterImage.SHARPEN_STYLE); // sigma
                break;
            case FilterImage.SKETCH_STYLE:
                changeBitmap = FilterImage.changeFilter(change, FilterImage.SKETCH_STYLE); // sigma
                break;
            case FilterImage.SOFT_GLOW_STYLE:
                changeBitmap = FilterImage.changeFilter(change, FilterImage.SOFT_GLOW_STYLE,0.6); // sigma
                break;
            case FilterImage.TV_STYLE:
                changeBitmap = FilterImage.changeFilter(change, FilterImage.TV_STYLE); // sigma
                break;
            default:
                changeBitmap = FilterImage.changeFilter(change, styleNo);
                break;
        }
        return changeBitmap;
    }



    public void onClickListener(View view){
        switch (view.getId()){
            case R.id.imageButton:
                newbitmap = applyStyle(1,newbitmap);
                photoView.setImageBitmap(newbitmap);
                break;
            case R.id.imageButton1:
                newbitmap = applyStyle(2,newbitmap);
                photoView.setImageBitmap(newbitmap);
                break;
            case R.id.imageButton2:
                newbitmap = applyStyle(3,newbitmap);
                photoView.setImageBitmap(newbitmap);
                break;
            case R.id.imageButton3:
                newbitmap = applyStyle(4,newbitmap);
                photoView.setImageBitmap(newbitmap);
                break;
            case R.id.imageButton4:
                newbitmap = applyStyle(5,newbitmap);
                photoView.setImageBitmap(newbitmap);
                break;
            case R.id.imageButton5:
                newbitmap = applyStyle(6,newbitmap);
                photoView.setImageBitmap(newbitmap);
                break;
            case R.id.imageButton6:
                newbitmap = applyStyle(7,newbitmap);
                photoView.setImageBitmap(newbitmap);
                break;
            case R.id.imageButton7:
                newbitmap = applyStyle(8,newbitmap);
                photoView.setImageBitmap(newbitmap);
                break;
            case R.id.imageButton8:
                newbitmap = applyStyle(9,newbitmap);
                photoView.setImageBitmap(newbitmap);
                break;
            case R.id.imageButton9:
                newbitmap = applyStyle(10,newbitmap);
                photoView.setImageBitmap(newbitmap);
                break;
            case R.id.imageButton10:
                newbitmap = applyStyle(11,newbitmap);
                photoView.setImageBitmap(newbitmap);
                break;
            case R.id.imageButton11:
                newbitmap = applyStyle(12,newbitmap);
                photoView.setImageBitmap(newbitmap);
                break;
            case R.id.imageButton12:
                newbitmap = applyStyle(13,newbitmap);
                photoView.setImageBitmap(newbitmap);
                break;
            case R.id.imageButton13:
                newbitmap = applyStyle(14,newbitmap);
                photoView.setImageBitmap(newbitmap);
                break;
            case R.id.imageButton14:
                newbitmap = applyStyle(15,newbitmap);
                photoView.setImageBitmap(newbitmap);
                break;
            case R.id.imageButton15:
                newbitmap = applyStyle(16,newbitmap);
                photoView.setImageBitmap(newbitmap);
                break;
             default:
                 photoView.setImageBitmap(newbitmap);
                 break;
        }
    }


    public void backBitmap(View view){
        newbitmap=bitmap;
        photoView.setImageBitmap(newbitmap);
    }
    public void saveBitmap(View view){

    }

    public static Bitmap decodeSampledBitmapFromResource(String path,
                                                         int reqWidth, int reqHeight) {

        // Читаем с inJustDecodeBounds=true для определения размеров
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);

        // Вычисляем inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth,
                reqHeight);

        // Читаем с использованием inSampleSize коэффициента
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(path, options);
    }

    public static int calculateInSampleSize(BitmapFactory.Options options,
                                            int reqWidth, int reqHeight) {
        // Реальные размеры изображения
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Вычисляем наибольший inSampleSize, который будет кратным двум
            // и оставит полученные размеры больше, чем требуемые
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }




    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data){
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(selectedImage,filePathColumn,null,null,null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            picturePath = cursor.getString(columnIndex);
            cursor.close();
            lessbitmap = decodeSampledBitmapFromResource(picturePath,120,120);
            bitmap = (BitmapFactory.decodeFile(picturePath));

            newbitmap=bitmap;

            newbitmap=lessbitmap;
            imageButtons.setImageBitmap(applyStyle(1,newbitmap));
            imageButtons1.setImageBitmap(applyStyle(2,newbitmap));
            imageButtons2.setImageBitmap(applyStyle(3,newbitmap));
            imageButtons3.setImageBitmap(applyStyle(4,newbitmap));
            imageButtons4.setImageBitmap(applyStyle(5,newbitmap));
            imageButtons5.setImageBitmap(applyStyle(6,newbitmap));
            imageButtons6.setImageBitmap(applyStyle(7,newbitmap));
            imageButtons7.setImageBitmap(applyStyle(8,newbitmap));
            imageButtons8.setImageBitmap(applyStyle(9,newbitmap));
            imageButtons9.setImageBitmap(applyStyle(10,newbitmap));
            imageButtons10.setImageBitmap(applyStyle(11,newbitmap));
            imageButtons11.setImageBitmap(applyStyle(12,newbitmap));
            imageButtons12.setImageBitmap(applyStyle(13,newbitmap));
            imageButtons13.setImageBitmap(applyStyle(14,newbitmap));
            imageButtons14.setImageBitmap(applyStyle(15,newbitmap));
            imageButtons15.setImageBitmap(applyStyle(16,newbitmap));

            photoView.setImageBitmap(bitmap);

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case MY_PERMISION_REQUEST:{
                if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    if(ContextCompat.checkSelfPermission(this,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE)==PackageManager.PERMISSION_GRANTED){

                    }
                }else{
                    Toast.makeText(this,"No permission granted",Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        }
    }
}
