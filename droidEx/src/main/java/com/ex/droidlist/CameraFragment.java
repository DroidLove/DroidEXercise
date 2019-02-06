package com.ex.droidlist;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.ex.droidlist.helper.ImageSurfaceView;
import com.ex.droidlist.helper.PermissionsDelegate;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class CameraFragment extends Fragment {

  private ImageSurfaceView mImageSurfaceView;
  private Camera camera;

  private FrameLayout cameraPreviewLayout;
  private ImageView capturedImageHolder;
  private PermissionsDelegate permissionsDelegate;
  private boolean hasCameraPermission;

  private int counter = 1;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_camera, container, false);

    permissionsDelegate = new PermissionsDelegate(getActivity());
    hasCameraPermission = permissionsDelegate.hasCameraPermission();
    cameraPreviewLayout = (FrameLayout) view.findViewById(R.id.camera_preview);
    capturedImageHolder = (ImageView) view.findViewById(R.id.captured_image);

    camera = checkDeviceCamera();
    if (hasCameraPermission) {
      mImageSurfaceView = new ImageSurfaceView(getActivity(), camera);
      cameraPreviewLayout.addView(mImageSurfaceView);
    } else {
      permissionsDelegate.requestCameraPermission();
    }

    Button captureButton = (Button) view.findViewById(R.id.button);
    captureButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        if (hasCameraPermission) {
          camera.takePicture(null, null, pictureCallback);
        } else {
          permissionsDelegate.requestCameraPermission();
        }
      }
    });

    return view;
  }

  private Camera checkDeviceCamera() {
    Camera mCamera = null;
    try {
      mCamera = Camera.open();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return mCamera;
  }

  PictureCallback pictureCallback = new PictureCallback() {
    @Override
    public void onPictureTaken(byte[] data, final Camera camera) {

      Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
      if (bitmap != null) {
//        Toast.makeText(getActivity(), "Captured image is empty", Toast.LENGTH_LONG).show();
        File file = new File(Environment.getExternalStorageDirectory() + "/dirr");
        if (!file.isDirectory()) {
          file.mkdir();
        }
        file = new File(Environment.getExternalStorageDirectory() + "/dirr",
            System.currentTimeMillis() + ".jpg");

        try {
          FileOutputStream fileOutputStream = new FileOutputStream(file);
          bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);

          fileOutputStream.flush();
          fileOutputStream.close();
        } catch (IOException e) {
          Log.e("File Exception", e.toString());
          e.printStackTrace();
        } catch (Exception exception) {
          Log.e("File Exception", exception.toString());
          exception.printStackTrace();
        }
      }

      capturedImageHolder.setImageBitmap(scaleDownBitmapImage(bitmap, 640, 480));

      final Handler handler = new Handler();
      handler.postDelayed(new Runnable() {
        @Override
        public void run() {
          //Do something after 100ms
          if (counter <= 4) {
            camera.takePicture(null, null, pictureCallback);
            counter++;
          }
        }
      }, 100);


    }
  };

  private Bitmap scaleDownBitmapImage(Bitmap bitmap, int newWidth, int newHeight) {
    Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, newWidth, newHeight, true);
    return resizedBitmap;
  }

  @Override
  public void onRequestPermissionsResult(int requestCode,
      @NonNull String[] permissions,
      @NonNull int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    if (permissionsDelegate.resultGranted(requestCode, permissions, grantResults)) {
      mImageSurfaceView = new ImageSurfaceView(getActivity(), camera);
      cameraPreviewLayout.addView(mImageSurfaceView);
    }
  }

}
