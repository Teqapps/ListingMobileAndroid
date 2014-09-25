package master.tattoo.slidingmenu;

import java.util.ArrayList;
import java.util.List;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import info.androidhive.slidingmenu.R;
import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;

import android.widget.ListView;

public class PhotosFragment extends Fragment {
	ListView listview;
	List<ParseObject> ob;
	ProgressDialog mProgressDialog;
	ProductOfListViewAdapter adapter;
	private List<Product> Master_Tattoo = null;

	// new add

	public void onCreate() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Parse.initialize(getActivity(),
				"X5ipXQpsYBTBQEtozIli4dZQUsEy8aigsfy1Ynd3",
				"8AybZTMuyy9hmgnneN15udBK4x8nlTWS4fZCXiJ0");
		// send the data to Parse.com
		/*
		 * ParseObject testObject = new ParseObject("TestObject");
		 * testObject.put("foo", "bar"); testObject.saveInBackground();
		 */

		View rootView = inflater.inflate(R.layout.fragment_photos, container,
				false);
		listview = (ListView) rootView.findViewById(R.id.photolistview);
		new RemoteDataTask(getActivity(), listview).execute();

		Master_Tattoo = new ArrayList<Product>();
		try {
			// Locate the class table named "Country" in Parse.com
			ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Product");
			// Locate the column named "ranknum" in Parse.com and order list
			// by ascending
			// query.orderByAscending("ranknum");
			// query.orderByAscending("Master_id");
			ob = query.find();
			for (ParseObject Tattoo_Master : ob) {
				// Locate images in flag column
				ParseFile photo = (ParseFile) Tattoo_Master.get("photo");

				Product map = new Product();
				// map.setMaster_id((String) Tattoo_Master.get("Master_id"));
				// map.setName((String) Tattoo_Master.get("Name"));
				// map.setGender((String) Tattoo_Master.get("Gender"));
				map.setphoto(photo.getUrl());
				Master_Tattoo.add(map);
			}
		} catch (ParseException e) {
			Log.e("Error", e.getMessage());
			e.printStackTrace();
		}

		return rootView;

	}

	public class RemoteDataTask extends AsyncTask<Void, Void, Void> {
		ListView listview;
		Activity activity;

		public RemoteDataTask(Activity contex, ListView gview) {
			this.listview = gview;
			this.activity = contex;
		}

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			/*
			 * // Create a progressdialog mProgressDialog = new
			 * ProgressDialog(getActivity()); // Set// progressdialog// title
			 * mProgressDialog.setTitle("Parse.com Custom ListView Tutorial");
			 * // Set progressdialog message
			 * mProgressDialog.setMessage("Loading...");
			 * mProgressDialog.setIndeterminate(false); // Show progressdialog
			 * mProgressDialog.show();
			 */
		}

		@Override
		protected Void doInBackground(Void... params) {
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {

			// Locate the listview in listview_main.xml
			listview = (ListView) getView().findViewById(R.id.photolistview);
			// Pass the results into ListViewAdapter.java
			adapter = new ProductOfListViewAdapter(getActivity(), Master_Tattoo);
			// Binds the Adapter to the ListView
			listview.setAdapter(adapter);
			// Close the progressdialog
			// mProgressDialog.dismiss();

		}
	}
}
