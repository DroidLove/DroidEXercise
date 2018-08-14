package com.ex.droidlist

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_auto_ripple.*

class AutoRippleDemoFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_auto_ripple, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_auto_click.setOnClickListener { AppUtils.toastMe(context!!,"clicked") }
        btn_auto_click.callOnClick()
    }

    protected fun forceRippleAnimation( view:View)
{
//    var background: Drawable = view.

//    if(Build.VERSION.SDK_INT >= 21 && background instanceof RippleDrawable)
//    {
//        final RippleDrawable rippleDrawable = (RippleDrawable) background;
//
//        rippleDrawable.setState(new int[]{android.R.attr.state_pressed, android.R.attr.state_enabled});
//
//        Handler handler = new Handler();
//
//        handler.postDelayed(new Runnable()
//        {
//            @Override public void run()
//            {
//                rippleDrawable.setState(new int[]{});
//            }
//        }, 200);
//    }
}
}
