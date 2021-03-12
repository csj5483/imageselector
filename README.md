# Imagepicker

## An android project to help the user in selecting the image from gallery or capturing the image from camera.

### It will show a dialog to choose the option.

## Setup

### Add the Jitpack to your build file

```gradle
allprojects {
    repositories {
	...
	maven { url "https://jitpack.io" }
    }
}
```

### Add the dependency

```gradle
dependencies {
    implementation 'com.github.csj5483:imagepicker:+'
}
```

## Implementation

### To select image from camera or gallery

```Java
  ImagePicker imagePicker = new ImagePicker();
  imagePicker.fromCameraOrGallery(activity);

```

![Image1](https://github.com/csj5483/imagepicker/blob/master/screenshots/output-1.png)

### To select image from camera only

```Java
  ImagePicker imagePicker = new ImagePicker();
  imagePicker.fromCamera(activity);
```

### To select image from gallery only

```Java
  ImagePicker imagePicker = new ImagePicker();
  imagePicker.fromGallery(activity);
```

## The dialog is fully customizable.

### Can change the title text

```Java
  ImagePicker imagePicker = new ImagePicker();
  imagePicker.setTitle("Replace with our title").fromCameraOrGallery(activity);
```

### Can change the title color, title font size, title background and title padding

```Java
  ImagePicker imagePicker = new ImagePicker();
  imagePicker.setTitleColor(Color.RED).setTitleTextSize(24f).setTitle("Replace with our title").fromCameraOrGallery(activity);
```

![Image1](https://github.com/csj5483/imagepicker/blob/master/screenshots/output-3.png)

### Can change the camera option text and gallery option text

```Java
  ImagePicker imagePicker = new ImagePicker();
  imagePicker.setTitle("Title Text").setCameraText("Replace With Your Text").setGalleryText("Replace With Your Text").fromCameraOrGallery(activity);
```

![Image1](https://github.com/csj5483/imagepicker/blob/master/screenshots/output-2.png)

## User can show a dialog with Icons

```Java
  ImagePicker imagePicker = new ImagePicker();
  imagePicker.imagePickerWithIcons(activity);
```

![Image1](https://github.com/csj5483/imagepicker/blob/master/screenshots/output-4.png)

### Can change the orientation of icons

```Java
  ImagePicker imagePicker = new ImagePicker();
  imagePicker.setOrientation(LinearLayout.VERTICAL).imagePickerWithIcons(activity);
```

![Image1](https://github.com/csj5483/imagepicker/blob/master/screenshots/output-5.png)

### Can change the icons of camera and gallery

```Java
  ImagePicker imagePicker = new ImagePicker();
  imagePicker.setGalleryIcon(R.drawable.ic_image).imagePickerWithIcons(activity);
```

![Image1](https://github.com/csj5483/imagepicker/blob/master/screenshots/output-6.png)

## All available functions for dialog without icons

```Java
  ImagePicker imagePicker = new ImagePicker();
  imagePicker.setTitle("Title")
             .setTitleTextSize(30f)
             .setTitleColor(Color.RED)
             .setTitleBackground(Color.GREEN)
             .setTitlePadding(20, 10, 10, 20)
             .setCameraText("choose from camera")
             .setGalleryText("choose from gallery")
             .fromCameraOrGallery(activity);

```

## All available functions for dialog with icons

```Java
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
```

## To use the camera or gallery result

```java
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

```

#### Here CAMERA_REQUEST=100 and GALLERY_REQUEST=200

## To use in Android 11

### Add this in your manifest

```xml
<manifest>
  <application
   android:requestLegacyExternalStorage="true">

  </application>
  <queries>
        <intent>
            <action android:name="android.media.action.IMAGE_CAPTURE" />
        </intent>
        <intent>
            <action android:name="android.intent.action.PICK" />
        </intent>
   </queries>
</manifest>
```

### Created By [Chetan](https://github.com/csj5483)

[Contact me](mailto:csj5483@gmail.com)
