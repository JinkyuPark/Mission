package com.example.parkjinkyu.mission;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.net.URL;

public class Mission01Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission01);


    }

    public void onButton2Clicked(View v) {
        ImageView imageView1 = (ImageView) findViewById(R.id.imageView1);
        ImageView imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView2.setImageDrawable(imageView1.getDrawable());
        imageView1.setImageDrawable(null);

        ImageButton imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        imageButton2.setEnabled(false);

        ImageButton imageButton1 = (ImageButton) findViewById(R.id.imageButton1);
        imageButton1.setEnabled(true);
    }

    public void onButton1Clicked(View v) {
        ImageView imageView1 = (ImageView) findViewById(R.id.imageView1);
        ImageView imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView1.setImageDrawable(imageView2.getDrawable());
        imageView2.setImageDrawable(null);

        ImageButton imageButton1 = (ImageButton) findViewById(R.id.imageButton1);
        imageButton1.setEnabled(false);

        ImageButton imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        imageButton2.setEnabled(true);
    }

    public void onButton3Clicked(View v) {
        ImageView imageView = (ImageView)findViewById(R.id.imageView1);
        try {
            URL url = new URL("https://www.android.com/static/2016/img/home/os-section/phone_1x.png");
            Bitmap bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            imageView.setImageBitmap(bitmap);
        } catch (Exception e) {
            Log.e("", "", e);
        }
    }
}
