package master.tattoo.slidingmenu.listview;

import info.androidhive.slidingmenu.R;

import java.util.ArrayList;
import java.util.List;

import master.tattoo.slidingmenu.ImageLoader;
import master.tattoo.slidingmenu.db.ProductDb;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ProductOfListViewAdapter extends BaseAdapter {

	// Declare Variables
	Context context;
	LayoutInflater inflater;
	ImageLoader imageLoader;
	private List<ProductDb> Master_Tattoo = null;
	private ArrayList<ProductDb> arraylist;

	public ProductOfListViewAdapter(Context context,
			List<ProductDb> Master_Tattoo) {
		this.context = context;
		this.Master_Tattoo = Master_Tattoo;
		inflater = LayoutInflater.from(context);
		this.arraylist = new ArrayList<ProductDb>();
		this.arraylist.addAll(Master_Tattoo);
		imageLoader = new ImageLoader(context);
	}

	public class ViewHolder {
		ImageView photo;
	}

	@Override
	public int getCount() {
		return Master_Tattoo.size();
	}

	@Override
	public Object getItem(int position) {
		return Master_Tattoo.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	public View getView(final int position, View view, ViewGroup parent) {
		final ViewHolder holder;
		if (view == null) {
			holder = new ViewHolder();
			view = inflater.inflate(R.layout.product_of_listview_item, null);
		
			// Locate the TextViews in listview_item.xml
			//holder.Master_id = (TextView) view.findViewById(R.id.Master_id);
			//holder.Name = (TextView) view.findViewById(R.id.Name);
			//holder.Gender = (TextView) view.findViewById(R.id.Gender);
			// Locate the ImageView in listview_item.xml
			holder.photo = (ImageView) view.findViewById(R.id.photo);
			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();
		}
		// Set the results into TextViews
		//holder.Master_id.setText(Master_Tattoo.get(position).getMaster_id());
		//holder.Name.setText(Master_Tattoo.get(position).getName());
		//holder.Gender.setText(Master_Tattoo.get(position)
			//	.getGender());
		// Set the results into ImageView
		//new add
		//imageLoader.DisplayImage(worldpopulationlist.get(position).getFlagFile(),
			//	holder.flag);
		imageLoader.DisplayImage(Master_Tattoo.get(position).getphoto(),
				holder.photo);
		// Listen for ListView Item Click
		//view.setOnClickListener(new OnClickListener() {

			/*@Override
			public void onClick(View arg0) {
				// Send single item click data to SingleItemView Class
				Intent intent = new Intent(context, SingleItemView.class);
				// Pass all data rank
				intent.putExtra("Master_id",
						(Master_Tattoo.get(position).getMaster_id()));
				// Pass all data country
				intent.putExtra("Name",
						(Master_Tattoo.get(position).getName()));
				// Pass all data population
				intent.putExtra("Gender",
						(Master_Tattoo.get(position).getGender()));
				// Pass all data flag
				//new add
				intent.putExtra("flag",
						(worldpopulationlist.get(position).getFlagFile()));
				intent.putExtra("image",
						(Master_Tattoo.get(position).getimage()));
				// Start SingleItemView Class
				context.startActivity(intent);
			}*/
		
		return view;
	}

}
