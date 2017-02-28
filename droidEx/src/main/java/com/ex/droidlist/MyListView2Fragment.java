package com.ex.droidlist;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MyListView2Fragment extends Fragment {

	ListView ls_main;
	ArrayList<String> myArray;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.listview1_frag, container, false);

		myArray = new ArrayList<String>();

		myArray.add("");
		myArray.add("");
		myArray.add("");
		myArray.add("");
		myArray.add("");

		fillData();

		ls_main = (ListView) view.findViewById(R.id.ls_main);

		MyAdapter adapter = new MyAdapter(myArray);
		ls_main.setAdapter(adapter);

		return view;
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
		public View getView(int arg0, View view, ViewGroup parent) {

			ViewHolder holder;

			if (view == null) {

				// inflate the layout

				// LayoutInflater inflater = ((Activity) mContext)
				// .getLayoutInflater();
				//
				// convertView = inflater.inflate(layoutResourceId, parent,
				// false);

				view = getActivity().getLayoutInflater().inflate(
						R.layout.row_item, parent, false);
				holder = new ViewHolder();

				holder.tv_text = (TextView) view.findViewById(R.id.tv_text);
				Log.e("Listview2", "call " + arg0);

				view.setTag(holder);

			} else {
				holder = (ViewHolder) view.getTag();
			}

			holder.tv_text.setText("With Holder " + arg0);

			return view;
		}

		class ViewHolder {
			TextView tv_text;
		}

	}

}
