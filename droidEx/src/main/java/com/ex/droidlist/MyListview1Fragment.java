package com.ex.droidlist;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.clans.fab.FloatingActionMenu;

public class MyListview1Fragment extends Fragment {

    ListView ls_main;
    ArrayList<String> myArray;
    FloatingActionMenu menu_labels_right;

    FragmentClickListener mCallback;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.listview1_frag, container, false);
        menu_labels_right = (FloatingActionMenu) view
                .findViewById(R.id.menu_labels_right);

        menu_labels_right.setVisibility(View.VISIBLE);

        menu_labels_right.setClosedOnTouchOutside(true);

        myArray = new ArrayList<String>();

        fillData();

        myArray.add("");
        myArray.add("");
        myArray.add("");
        myArray.add("");
        myArray.add("");

        ls_main = (ListView) view.findViewById(R.id.ls_main);

        MyAdapter adapter = new MyAdapter(myArray);
        ls_main.setAdapter(adapter);

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception.
        try {
            mCallback = (FragmentClickListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }

    private void fillData() {

        int no_items = 1000;

        for (int i = 0; i < no_items; i++) {
            myArray.add("");
        }

    }

    class MyAdapter extends BaseAdapter {

        ArrayList<String> myArray;

        public MyAdapter(ArrayList<String> myArray) {

            this.myArray = myArray;

        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return myArray.size();
        }

        @Override
        public Object getItem(int arg0) {
            // TODO Auto-generated method stub
            return myArray.get(arg0);
        }

        @Override
        public long getItemId(int arg0) {
            // TODO Auto-generated method stub
            return arg0;
        }

        @Override
        public View getView(final int arg0, View view, ViewGroup parent) {

            TextView tv_text;
            RelativeLayout rl_main;

            view = getActivity().getLayoutInflater().inflate(R.layout.row_item,
                    parent, false);

            tv_text = (TextView) view.findViewById(R.id.tv_text);
            rl_main = (RelativeLayout) view.findViewById(R.id.rl_main);
            Log.e("Listview1", "call " + arg0);

            tv_text.setText("Without holder " + arg0);

            rl_main.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub

                    mCallback.onFragmentSelected(arg0);

                }
            });

            return view;
        }
    }

}
