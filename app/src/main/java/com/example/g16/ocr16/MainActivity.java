package com.example.g16.ocr16;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.googlecode.tesseract.android.TessBaseAPI;

import java.io.File;


public class MainActivity extends ActionBarActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recognize();
        }

    public String recognize(){

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 4;

        Bitmap bitmap = BitmapFactory.decodeFile("res/drawable/apple1.bmp", options);

        String DATA_PATH = "";

        TessBaseAPI baseApi = new TessBaseAPI();
        baseApi.init(DATA_PATH + "eng.traineddata" ,"eng");
        baseApi.setImage(bitmap);
        String ret=baseApi.getUTF8Text();
        baseApi.end();

        Toast.makeText(getApplicationContext(), ret,
                Toast.LENGTH_LONG).show();

        /*File myDir = getExternalFilesDir(Environment.MEDIA_MOUNTED);


        Toast.makeText(getApplicationContext(), myDir.toString(),
                Toast.LENGTH_LONG).show();*/

    return null;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
