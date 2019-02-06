package com.ex.droidlist;


import android.content.res.Resources;
import androidx.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ex.droidlist.databinding.FragmentCompressHighResImageBinding;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

import static android.graphics.BitmapFactory.decodeResource;


/**
 * A simple {@link Fragment} subclass.
 */
public class CompressHighResImageFragment extends Fragment {

    FragmentCompressHighResImageBinding binding;

    public CompressHighResImageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_compress_high_res_image, container, false);

        setImageHighRes();
        setImageCompressRes();
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    private void setImageHighRes() {

        // In Memory
        BitmapFactory.Options options = new BitmapFactory.Options();

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.high_res_experiment_image, options);

        // In Disk [inside the file]
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos);
        byte[] bitmapdata = bos.toByteArray();
        long lengthbmp = bitmapdata.length;

        binding.imageViewHighRes.setImageBitmap(bitmap);

        String messageToDisplay = (humanReadableByteCount(bitmap.getByteCount(), true) + " [In Memory]\n" +
                humanReadableByteCount(lengthbmp, true) + " [In Disk]\n" +
                String.valueOf(options.outHeight) + "x" + String.valueOf(options.outWidth));

        binding.textviewHighRes.setText(messageToDisplay);
    }

    private void setImageCompressRes() {

        // In Memory
        BitmapFactory.Options options = new BitmapFactory.Options();

        // First decode with inJustDecodeBounds=true to check dimensions
        options.inJustDecodeBounds = true;
        decodeResource(getResources(), R.drawable.high_res_experiment_image, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, 500, 500);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.high_res_experiment_image, options);

        // In Disk [inside the file]
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 50, bos);
        byte[] bitmapdata = bos.toByteArray();
        long lengthbmp = bitmapdata.length;

        binding.imageViewCompressRes.setImageBitmap(bitmap);

        String messageToDisplay = (humanReadableByteCount(bitmap.getByteCount(), true) + " [In Memory]\n" +
                humanReadableByteCount(lengthbmp, true) + " [In Disk]\n" +
                String.valueOf(options.outHeight) + "x" + String.valueOf(options.outWidth));

        binding.textviewCompressRes.setText(messageToDisplay);
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return decodeResource(res, resId, options);
    }

    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) >= reqHeight
                    && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

    public long bytesToLong(byte[] bytes) {
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        buffer.put(bytes);
        buffer.flip();//need flip
        return buffer.getLong();
    }

    public static String humanReadableByteCount(long bytes, boolean si) {
        int unit = si ? 1000 : 1024;
        if (bytes < unit) return bytes + " B";
        int exp = (int) (Math.log(bytes) / Math.log(unit));
        String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp - 1) + (si ? "" : "i");
        return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
    }

}
