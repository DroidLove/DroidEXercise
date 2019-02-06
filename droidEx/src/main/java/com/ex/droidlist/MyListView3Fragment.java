package com.ex.droidlist;

import java.util.ArrayList;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MyListView3Fragment extends Fragment {

	ListView ls_main;
	ArrayList<String> myArray;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.listview1_frag, container, false);

		ls_main = (ListView) view.findViewById(R.id.ls_main);

		myArray = new ArrayList<String>();

		fillData();

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, myArray);
		ls_main.setAdapter(adapter);

		return view;
	}

	private void fillData() {

		int no_items = 1000;

		for (int i = 0; i < no_items; i++) {
			myArray.add("With ArrayAdapter " + i);
		}

	}

}
