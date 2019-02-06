package com.ex.droidlist

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [LifeCycleFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [LifeCycleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LifeCycleFragment : Fragment() {

    // TODO: Rename and change types of parameters
    private var mParam1: String? = null
    private var mParam2: String? = null

    private var mListener: OnFragmentInteractionListener? = null
    val context: Context
        @JvmName("getContext2")
        get() = activity!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppUtils.toastMe(activity!!, "onCreate Fragment")
        if (arguments != null) {
            mParam1 = arguments!!.getString(ARG_PARAM1)
            mParam2 = arguments!!.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        AppUtils.toastMe(context, "onCreateView Fragment")
        return inflater.inflate(R.layout.fragment_life_cycle, container, false)
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        if (mListener != null) {
            mListener!!.onFragmentInteraction(uri)
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     * See the Android Training lesson [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html) for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LifeCycleFragment.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(param1: String, param2: String): LifeCycleFragment {
            val fragment = LifeCycleFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnFragmentInteractionListener")
        }

        AppUtils.toastMe(context, "onAttach Fragment")
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null

        AppUtils.toastMe(context, "onDetach Fragment")
    }

    override fun onStart() {
        super.onStart()
        AppUtils.toastMe(context, "onStart Fragment")
    }

    override fun onResume() {
        super.onResume()
        AppUtils.toastMe(context, "onResume Fragment")
    }

    override fun onPause() {
        super.onPause()
        AppUtils.toastMe(context, "onPause Fragment")
    }

    override fun onStop() {
        super.onStop()
        AppUtils.toastMe(context, "onStop Fragment")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        AppUtils.toastMe(context, "onDestroyView Fragment")
    }

    override fun onDestroy() {
        super.onDestroy()
        AppUtils.toastMe(context, "onDestroy Fragment")
    }
}// Required empty public constructor
