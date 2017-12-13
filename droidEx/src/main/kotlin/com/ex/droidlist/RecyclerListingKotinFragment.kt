package com.ex.droidlist

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_my_recyclerview.*
import java.util.*

/**
 * Created by itrs-676 on 28/08/17.
 */

class RecyclerListingKotinFragment : Fragment() {

    lateinit var myArray: ArrayList<String>
    lateinit var adapter: SampleAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.activity_my_recyclerview, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myArray = ArrayList()

        fillData()

        val layout = LinearLayoutManager(activity)
        rv_list.setLayoutManager(layout)

        adapter = SampleAdapter(myArray)
        rv_list.setAdapter(adapter)
    }

    private fun fillData() {

        val no_items = 1000
        for (i in 0 until no_items) {
            myArray.add("With RecyclerView Adapter Using Kotlin " + i)
        }
    }

    class SampleAdapter(internal var myArray: ArrayList<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        override fun getItemCount(): Int {
            return myArray.size
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            (holder as VHItem).tv_item!!.text = myArray[position]
        }

        override fun onCreateViewHolder(parent: ViewGroup, arg1: Int): RecyclerView.ViewHolder {

            val convertView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.row_item, parent, false)

            val holder = VHItem(convertView)
            holder.tv_item = convertView.findViewById(R.id.tv_text) as TextView
            return holder
        }

        internal inner class VHItem(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var tv_item: TextView? = null
        }
    }
}