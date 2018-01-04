package com.ex.droidlist

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_life_cycle_primary.*

class LifeCyclePrimaryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle_primary)

        AppUtils.toastMe(this, "onCreate")
        textview_lifecycle.setOnClickListener({
            val intent = Intent(this, LifeCycleSecondaryActivity::class.java)
            startActivity(intent)
        })
    }

    override fun onStart() {
        super.onStart()
        AppUtils.toastMe(this, "onStart")
    }

    override fun onResume() {
        super.onResume()
        AppUtils.toastMe(this, "onResume")
    }

    override fun onPause() {
        super.onPause()
        AppUtils.toastMe(this, "onPause")
    }

    override fun onRestart() {
        super.onRestart()
        AppUtils.toastMe(this, "onRestart")
    }

    override fun onStop() {
        super.onStop()
        AppUtils.toastMe(this, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        AppUtils.toastMe(this, "onDestroy")
    }
}
