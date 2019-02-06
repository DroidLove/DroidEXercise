package com.ex.droidlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_hello_kotlin.*

/**
 * A simple [Fragment] subclass.
 */
class HelloKotlinFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hello_kotlin, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Default way to initialize the views
        // var textView_kotlin = view?.findViewById(R.id.textView_kotlin) as TextView

        // initialize using Kotlin Android Extensions
        textView_kotlin.setOnClickListener {
            Toast.makeText(activity, "clicked", Toast.LENGTH_LONG).show()
        }

    }
}
