package com.ex.droidlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.layout_beating_animation.*



class BeatingAlphaAnimationFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.layout_beating_animation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val myFadeInAnimation = AnimationUtils.loadAnimation(context, R.anim.tween)
        img_chat_anim.startAnimation(myFadeInAnimation)
    }

}