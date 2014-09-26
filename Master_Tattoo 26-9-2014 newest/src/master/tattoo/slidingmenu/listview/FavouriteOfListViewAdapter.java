package master.tattoo.slidingmenu.listview;

import info.androidhive.slidingmenu.R;


import java.util.ArrayList;
import java.util.List;

import master.tattoo.slidingmenu.ImageLoader;
import master.tattoo.slidingmenu.SingleItemView;
import master.tattoo.slidingmenu.db.MasterDb;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FavouriteOfListViewAdapter extends BaseAdapter {

	// Declare Variables
	Context context;
	LayoutInflater inflater;
	ImageLoader imageLoader;
	private List<MasterDb> Master_Tattoo = null;
	private ArrayList<MasterDb> arraylist;



	public FavouriteOfListViewAdapter(Context context,
			List<MasterDb> Master_Tattoo) {
		this.context = context;
		this.Master_Tattoo = Master_Tattoo;
		inflater = LayoutInflater.from(context);
		this.arraylist = new ArrayList<MasterDb>();
		this.arraylist.addAll(Master_Tattoo);
		imageLoader = new ImageLoader(context);
	}

	public class ViewHolder {
		TextView Master_id;
		TextView Name;
		TextView Gender;
		ImageView image;
		
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
			view = inflater.inflate(R.layout.find_people_of_listview_item, null);
		
			// Locate the TextViews in listview_item.xml
			holder.Master_id = (TextView) view.findViewById(R.id.Master_id);
			holder.Name = (TextView) view.findViewById(R.id.Name);
			holder.Gender = (TextView) view.findViewById(R.id.Gender);
			// Locate the ImageView in listview_item.xml
			holder.image = (ImageView) view.findViewById(R.id.image);
			
			//imageView1 = (ImageView) view.findViewById(R.id.image);

			AnimationSet animationset = new AnimationSet(true);
			AlphaAnimation anim = new AlphaAnimation(0, 1);
			anim.setDuration(1000);
			animationset.addAnimation(anim);
			holder.image.startAnimation(animationset);
			
			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();
		}
		// Set the results into TextViews
		holder.Master_id.setText(Master_Tattoo.get(position).getMaster_id());
		holder.Name.setText(Master_Tattoo.get(position).getName());
		holder.Gender.setText(Master_Tattoo.get(position)
				.getGender());
		// Set the results into ImageView
		//new add
		//imageLoader.DisplayImage(worldpopulationlist.get(position).getFlagFile(),
			//	holder.flag);
		
		imageLoader.DisplayImage(Master_Tattoo.get(position).getimage(),
				holder.image);
		
		
		// Listen for ListView Item Click
		view.setOnClickListener(new OnClickListener() {

			@Override
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
				/*intent.putExtra("flag",
						(worldpopulationlist.get(position).getFlagFile()));*/
				intent.putExtra("image",
						(Master_Tattoo.get(position).getimage()));
				
				// Start SingleItemView Class
				context.startActivity(intent);
			}
		});
		return view;
	}

	private Resources getResources() {
		// TODO Auto-generated method stub
		return null;
	}

}
