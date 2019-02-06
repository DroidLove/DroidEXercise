package com.ex.droidlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myArray = ArrayList()

        fillData()

        val layout = androidx.recyclerview.widget.LinearLayoutManager(activity)
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

    class SampleAdapter(internal var myArray: ArrayList<String>) : androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder>() {

        override fun getItemCount(): Int {
            return myArray.size
        }

        override fun onBindViewHolder(holder: androidx.recyclerview.widget.RecyclerView.ViewHolder, position: Int) {
            (holder as VHItem).tv_item!!.text = myArray[position]
        }

        override fun onCreateViewHolder(parent: ViewGroup, arg1: Int): androidx.recyclerview.widget.RecyclerView.ViewHolder {

            val convertView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.row_item, parent, false)

            val holder = VHItem(convertView)
            holder.tv_item = convertView.findViewById(R.id.tv_text) as TextView
            return holder
        }

        internal inner class VHItem(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
            var tv_item: TextView? = null
        }
    }
}