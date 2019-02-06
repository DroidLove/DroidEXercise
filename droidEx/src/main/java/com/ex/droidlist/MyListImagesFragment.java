package com.ex.droidlist;

import java.util.ArrayList;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class MyListImagesFragment extends Fragment {

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
		int imagesArray[] = { R.drawable.image1, R.drawable.image2,
				R.drawable.image3, R.drawable.image4, R.drawable.image5,
				R.drawable.image6, R.drawable.image7, R.drawable.image8,
				R.drawable.image9, R.drawable.image10 };

		public MyAdapter(ArrayList<String> myArray) {

			this.myArray = myArray;

		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return imagesArray.length;
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return imagesArray[arg0];
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
						R.layout.row_item_offers, parent, false);
				holder = new ViewHolder();

				holder.img_offers_listing = (ImageView) view
						.findViewById(R.id.img_offers_listing);

				Log.e("Listview2", "call " + arg0);

				view.setTag(holder);

			} else {
				holder = (ViewHolder) view.getTag();
			}

			holder.img_offers_listing.setImageResource(imagesArray[arg0]);

			return view;
		}

		class ViewHolder {
			ImageView img_offers_listing;
		}

	}

}
