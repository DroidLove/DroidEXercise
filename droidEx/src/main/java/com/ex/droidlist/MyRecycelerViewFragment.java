package com.ex.droidlist;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyRecycelerViewFragment extends Fragment {

	RecyclerView rv_list;
	StyleFeedAdapter adapter;
	ArrayList<String> myArray;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.activity_my_recyclerview,
				container, false);

		rv_list = (RecyclerView) view.findViewById(R.id.rv_list);

		myArray = new ArrayList<String>();

		fillData();

		LinearLayoutManager layout = new LinearLayoutManager(getActivity());

		rv_list.setLayoutManager(layout);

//		RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
//		recyclerView.setLayoutManager(mLayoutManager);
//		recyclerView.setItemAnimator(new DefaultItemAnimator());
//		recyclerView.setAdapter(mAdapter);

		adapter = new StyleFeedAdapter(myArray);

		rv_list.setAdapter(adapter);

		return view;
	}

	private void fillData() {

		int no_items = 1000;

		for (int i = 0; i < no_items; i++) {
			myArray.add("With RecyclerView Adapter " + i);
		}

	}

	public class StyleFeedAdapter extends
			RecyclerView.Adapter<RecyclerView.ViewHolder> {

		ArrayList<String> myArray;

		public StyleFeedAdapter(ArrayList<String> myArray) {

			this.myArray = myArray;

		}

		@Override
		public int getItemCount() {
			return myArray.size();
		}

		@Override
		public void onBindViewHolder(ViewHolder holder, int position) {

			((VHItem) holder).tv_item.setText(myArray.get(position));

		}

		@Override
		public ViewHolder onCreateViewHolder(ViewGroup parent, int arg1) {

			View convertView = LayoutInflater.from(parent.getContext())
					.inflate(R.layout.row_item, parent, false);

			VHItem holder = new VHItem(convertView);

			holder.tv_item = (TextView) convertView.findViewById(R.id.tv_text);

			return holder;
		}

		class VHItem extends RecyclerView.ViewHolder {

			TextView tv_item;

			public VHItem(View itemView) {
				super(itemView);
			}
		}

	}

}
