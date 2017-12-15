package com.ex.droidlist

import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.support.transition.TransitionManager
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_constraint_animation.*

/**
 * A simple [Fragment] subclass.
 */
class ConstraintAnimationFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_constraint_animation, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val constraintSet1 = ConstraintSet()
        constraintSet1.clone(constraintlayout_main)
        val constraintSet2 = ConstraintSet()
        constraintSet2.clone(activity, R.layout.fragment_constraint_animation_alt)
//
        var changed = false

        button_animate_constraint.setOnClickListener {
            TransitionManager.beginDelayedTransition(constraintlayout_main)
            val constraint = if (changed) constraintSet1 else constraintSet2
            constraint.applyTo(constraintlayout_main)
            changed = !changed
        }
    }

}// Required empty public constructor