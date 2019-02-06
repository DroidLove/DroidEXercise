package com.ex.droidlist

import android.content.ContentValues
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_content_provider.*


/**
 * Created by Jitesh on 01/02/18.
 */
class ContentProviderDemoFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_content_provider, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button2.setOnClickListener {
            onClickAddName(it)
        }
    }

    fun onClickAddName(view: View) {
        // Add a new student record
        val values = ContentValues()
        values.put(StudentProvider.NAME,
                editText2.getText().toString())

        values.put(StudentProvider.GRADE,
                editText3.getText().toString())

        val uri = activity?.getContentResolver()?.insert(
                StudentProvider.CONTENT_URI, values)

        Toast.makeText(activity?.getBaseContext(),
                uri.toString(), Toast.LENGTH_LONG).show()
    }

    fun onClickRetrieveStudents(view: View) {
        // Retrieve student records
        val URL = "content://com.ex.droidlist.StudentProvider"

        val students = Uri.parse(URL)
//        val c = managedQuery(students, null, null, null, "name")
//
//        if (c.moveToFirst()) {
//            do {
//                Toast.makeText(activity,
//                        c.getString(c.getColumnIndex(StudentProvider._ID)) +
//                                ", " + c.getString(c.getColumnIndex(StudentProvider.NAME)) +
//                                ", " + c.getString(c.getColumnIndex(StudentProvider.GRADE)),
//                        Toast.LENGTH_SHORT).show()
//            } while (c.moveToNext())
//        }
    }
}