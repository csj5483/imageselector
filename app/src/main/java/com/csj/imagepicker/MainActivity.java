package com.csj.imagepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;


import com.csj.camerapicker.ImagePicker;

public class MainActivity extends AppCompatActivity {
    Activity activity = MainActivity.this;
    final static int CAMERA_REQUEST = 100;
    final static int GALLERY_REQUEST = 200;

    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);


        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePicker imagePicker = new ImagePicker();
                imagePicker.setTitle("Title")
                        .setTitleTextSize(30f)
                        .setTitleColor(Color.RED)
                        .setTitleBackground(Color.GREEN)
                        .setTitlePadding(20, 10, 10, 20)
                        .setCameraText("choose from camera")
                        .setGalleryText("choose from gallery")
                        .setCameraIcon(R.drawable.ic_camera)
                        .setGalleryIcon(R.drawable.ic_gallery_color)
                        .setOrientation(LinearLayout.VERTICAL)
                        .imagePickerWithIcons(activity);


            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);
        } else if (requestCode == GALLERY_REQUEST && resultCode == RESULT_OK) {
            Uri uri = data.getData();
            imageView.setImageURI(uri);
        }
    }

}





