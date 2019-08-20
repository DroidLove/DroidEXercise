package com.ex.droidlist


import android.graphics.drawable.Animatable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.vectordrawable.graphics.drawable.Animatable2Compat
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import kotlinx.android.synthetic.main.fragment_animated_vector_drawable.*


/**
 * A simple [Fragment] subclass.
 */
class AnimatedVectorDrawableFragment : Fragment() {

    internal lateinit var mImgCheck: ImageView


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_animated_vector_drawable, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mImgCheck = view.findViewById<View>(R.id.imageView) as ImageView

        mImgCheck.setOnClickListener {
            (mImgCheck.drawable as Animatable).start()
            AnimatedVectorDrawableCompat.registerAnimationCallback(
                    mImgCheck.drawable,
                    object : Animatable2Compat.AnimationCallback() {
                        override fun onAnimationEnd(drawable: Drawable?) {
                            imageView.post {
                                (mImgCheck.drawable as Animatable).start()
                            }
                        }
                    })

            //            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {

//            (mImgCheck.drawable as AnimatedVectorDrawableCompat?)?.apply {
//                start()
////                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                registerAnimationCallback(
//                        object : Animatable2Compat.AnimationCallback() {
//                            override fun onAnimationEnd(drawable: Drawable?) {
//                                imageView.post { start() }
//                            }
//                        }
//                )
////                    }
//            }
//            }

//                            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
//                                ((Animatable) mImgCheck.getDrawable()).start().;
//                            }else{
//                                ((AnimatedVectorDrawableCompat) mImgCheck.getDrawable()).start();
//                            }
        }

    }
}// Required empty public constructor
