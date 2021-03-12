package com.csj.camerapicker;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.provider.MediaStore;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;


public class ImagePicker {

    String[] options = {"Camera", "Gallery"};
    String title = "Select Image From";
    float titleFontSize = 20f;
    int titleTextColor = Color.BLACK;
    int titleBackgroundColor = Color.TRANSPARENT;
    int titleLeftPadding = 45;
    int titleRightPadding = 45;
    int titleTopPadding = 5;
    int titleBottomPadding = 5;
    int camera = R.drawable.ic_camera_color;
    int gallery = R.drawable.ic_gallery_color;
    int orientation = LinearLayout.HORIZONTAL;


    final static int CAMERA_REQUEST = 100;
    final static int GALLERY_REQUEST = 200;

    public ImagePicker setTitle(String title) {
        this.title = title;

        return this;
    }

    public ImagePicker setGalleryText(String galleryText) {

        this.options[1] = galleryText;
        return this;
    }

    public ImagePicker setCameraText(String cameraText) {

        this.options[0] = cameraText;
        return this;
    }

    public ImagePicker setTitleColor(int color) {
        this.titleTextColor = color;
        return this;
    }

    public ImagePicker setTitleTextSize(float size) {
        this.titleFontSize = size;
        return this;
    }

    public ImagePicker setTitlePadding(int leftPadding, int rightPadding, int topPadding, int bottomPadding) {
        this.titleLeftPadding = leftPadding;
        this.titleRightPadding = rightPadding;
        this.titleTopPadding = topPadding;
        this.titleBottomPadding = bottomPadding;
        return this;
    }

    public ImagePicker setTitleBackground(int color) {
        this.titleBackgroundColor = color;
        return this;
    }

    public void fromCameraOrGallery(Activity activity) {
        TextView titleTextView = new TextView(activity);
        titleTextView.setText(title);
        titleTextView.setTextColor(titleTextColor);
        titleTextView.setBackgroundColor(titleBackgroundColor);
        titleTextView.setTextSize(titleFontSize);
        titleTextView.setPadding(titleLeftPadding, titleTopPadding, titleRightPadding, titleBottomPadding);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setCustomTitle(titleTextView);
        builder.setItems(options, (dialog, which) -> {
            switch (which) {
                case 0:
                    Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    activity.startActivityForResult(takePictureIntent, CAMERA_REQUEST);
                    break;
                case 1:
                    Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    activity.startActivityForResult(galleryIntent, GALLERY_REQUEST);
                    break;

                default:
                    Toast.makeText(activity, "Default", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public ImagePicker fromCamera(Activity activity) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        activity.startActivityForResult(takePictureIntent, CAMERA_REQUEST);
        return this;
    }

    public ImagePicker fromGallery(Activity activity) {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        activity.startActivityForResult(galleryIntent, GALLERY_REQUEST);
        return this;

    }

    public ImagePicker setCameraIcon(int camera) {
        this.camera = camera;
        return this;
    }

    public ImagePicker setGalleryIcon(int gallery) {
        this.gallery = gallery;
        return this;
    }
    public ImagePicker setOrientation(int orientation){
        this.orientation=orientation;
        return this;
    }

    public void imagePickerWithIcons(Activity activity) {
        LinearLayout linearLayout = (LinearLayout) LinearLayout.inflate(activity, R.layout.icon_layout, null);
        LinearLayout cameraLayout = linearLayout.findViewById(R.id.cameraLayout);
        LinearLayout galleryLayout = linearLayout.findViewById(R.id.galleryLayout);

        ImageView galleryIcon = linearLayout.findViewById(R.id.galleryIcon);
        ImageView cameraIcon = linearLayout.findViewById(R.id.cameraIcon);
        cameraIcon.setImageResource(camera);
        galleryIcon.setImageResource(gallery);
        TextView cameraText = linearLayout.findViewById(R.id.cameraText);
        TextView galleryText = linearLayout.findViewById(R.id.galleryText);
        cameraText.setText(options[0]);
        galleryText.setText(options[1]);

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(title);
        linearLayout.setOrientation(orientation);

        builder.setView(linearLayout);
        AlertDialog dialog = builder.create();


        cameraLayout.setOnClickListener(v -> {
            dialog.dismiss();
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            activity.startActivityForResult(takePictureIntent, CAMERA_REQUEST);
        });
        galleryLayout.setOnClickListener(v -> {
            dialog.dismiss();
            Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            activity.startActivityForResult(galleryIntent, GALLERY_REQUEST);
        });

        dialog.show();

    }


}
