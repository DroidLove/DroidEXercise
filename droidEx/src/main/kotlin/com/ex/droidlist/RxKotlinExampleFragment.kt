package com.ex.droidlist

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import io.reactivex.Flowable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toFlowable
import kotlinx.android.synthetic.main.fragment_hello_kotlin.*

/**
 * Created by Jitesh on 12/03/18.
 */
class RxKotlinExampleFragment : Fragment() {

    val list = listOf("Alpha", "Beta", "Gamma", "Delta", "Epsilon")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hello_kotlin, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Default way to initialize the views
        // var textView_kotlin = view?.findViewById(R.id.textView_kotlin) as TextView

//        var handler = Handler()
//        handler.postDelayed(delayInMillis = 1000L) {
//    }

        Flowable.just("item1")
                .map({ str ->
                    println("inside the map $str")
                    str
                })
                .subscribe({ result ->
                    System.out.println(result) })

        Flowable.just("item2")
                .flatMap({ str ->
                    println("inside the flatMap $str")
                    Flowable.just("$str+", "$str++", "$str+++")
                })
                .subscribe({ result ->
                    System.out.println(result) })

        textView_kotlin.setOnClickListener {
            Toast.makeText(activity, "clicked", Toast.LENGTH_LONG).show()
        }

        list.toFlowable() // extension function for Iterables
                .filter { it.length >= 5 }
                .subscribeBy(  // named arguments for lambda Subscribers
                        onNext = {
                            // some action
                            textView_kotlin.text = it
                        },
                        onError = { it.printStackTrace() },
                        onComplete = { println("Done!") }
                )
    }

}