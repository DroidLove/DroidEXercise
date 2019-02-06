package com.ex.droidlist;


import android.graphics.drawable.Animatable;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AnimatedVectorDrawableFragment extends Fragment {

    ImageView mImgCheck;

    public AnimatedVectorDrawableFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_animated_vector_drawable, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mImgCheck = (ImageView) view.findViewById(R.id.imageView);

        mImgCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ((Animatable) mImgCheck.getDrawable()).start();
                }else{
                    ((AnimatedVectorDrawableCompat) mImgCheck.getDrawable()).start();
                }
            }
        });

    }
}
