package com.ex.droidlist

import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class LifeCycleSecondaryActivity : AppCompatActivity(), LifeCycleFragment.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle_secondar)

        AppUtils.toastMe(this, "onCreate FragmentActivity")
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_fragment,
                        LifeCycleFragment()).commit()
    }

    override fun onFragmentInteraction(uri: Uri) {
    }
}
