package com.ex.droidlist

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.google.gson.Gson
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_rxkotlin_api.*
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONArray
import org.json.JSONObject

/**
 * Created by Jitesh on 12/03/18.
 */
class RxKotlinAPICallFragment : Fragment() {

    lateinit var listEmployee: ArrayList<String>
    var url = "https://limitless-lake-93364.herokuapp.com/hello"
//    var url = "http://192.168.10.126:8080/listEmployees"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rxkotlin_api, container, false)
    }

    @SuppressLint("NewApi")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // initialize using Kotlin Android Extensions
//        textView_kotlin.setOnClickListener {
//            Toast.makeText(activity, "clicked", Toast.LENGTH_LONG).show()
//        }
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        var client = OkHttpClient.Builder()
                .addInterceptor(logging).build()

        listEmployee = ArrayList()

//        listEmployee.toFlowable()
//                .subscribeBy(  // named arguments for lambda Subscribers
//                onNext = {
//                    // some action
//                    textView_kotlin.text = it
//                },
//                onError = { it.printStackTrace() },
//                onComplete = { println("Done!") }
//        )

        Flowable.fromCallable<Any> {
            val request = Request.Builder()
                    .url(url)
                    .build()

            val response = client.newCall(request).execute()
            return@fromCallable response?.body()?.string()
        }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    Log.e("Response result", result.toString())
                    var jsonObj = JSONObject(result.toString())
                    var jsonArray = JSONArray(jsonObj.get("employee").toString())
                    Log.e("Response jsonObj", jsonObj.get("employee").toString())

                    for (i in 0 until jsonArray.length()) {
                        var gsonObj: EmplotyeeModel = Gson().fromJson<EmplotyeeModel>(jsonArray[i].toString(), EmplotyeeModel::class.java)
                        listEmployee.add(gsonObj.name)
                        Log.e("Response Gson", gsonObj.name)
                    }

                    val adapter = ArrayAdapter<String>(activity,
                            android.R.layout.simple_list_item_1, listEmployee)
                    listView_api.adapter = adapter
                }, { e ->
                    Log.e("Response error", e.toString())
                })
    }

}