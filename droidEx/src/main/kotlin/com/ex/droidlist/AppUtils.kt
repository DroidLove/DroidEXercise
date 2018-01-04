package com.ex.droidlist

import android.content.Context
import android.widget.Toast

/**
 * Created by Jitesh on 04/01/18.
 */
class AppUtils {

    companion object {
        public fun toastMe(context: Context, msg: String) {
            Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
        }
    }

}