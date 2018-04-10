package com.ex.droidlist

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_recyclerview_list_adapter.*

class RecyclerVIewListAdapterFragment : Fragment() {

    lateinit var adapter: TaskListAdapter
    var arrayList: MutableList<Task> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_recyclerview_list_adapter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = TaskListAdapter { }

        arrayList.add(Task(0, "1", false))
        arrayList.add(Task(1, "2", false))
        arrayList.add(Task(2, "3", false))

        rv_list.layoutManager = LinearLayoutManager(activity)
        rv_list.adapter = adapter

        adapter.submitList(arrayList)
    }
}