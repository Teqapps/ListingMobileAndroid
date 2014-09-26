package master.tattoo.slidingmenu;

import info.androidhive.slidingmenu.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


public class SingleItemView extends Activity {
	// Declare Variables
	String Master_id;
	String Name;
	String Gender;
	String Tel;
	String Email;
	String Address;
	String Website;
	String image;
	String position;
	ImageLoader imageLoader = new ImageLoader(this);

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Get the view from singleitemview.xml
		setContentView(R.layout.singleitemview);

		Intent i = getIntent();
		// Get the result of rank
		Master_id = i.getStringExtra("Master_id");
		// Get the result of country
		Name = i.getStringExtra("Name");
		// Get the result of population
		Gender = i.getStringExtra("Gender");
		Tel = i.getStringExtra("Tel");
		Email = i.getStringExtra("Email");
		Address = i.getStringExtra("Address");
		Website = i.getStringExtra("Website");
		// Get the result of flag
		image = i.getStringExtra("image");

		// Locate the TextViews in singleitemview.xml
		TextView txtmaster = (TextView) findViewById(R.id.Master_id);
		TextView txtname = (TextView) findViewById(R.id.Name);
		TextView txtgender = (TextView) findViewById(R.id.Gender);

		// Locate the ImageView in singleitemview.xml
		ImageView img = (ImageView) findViewById(R.id.image);

		// Set results to the TextViews
		txtmaster.setText(Master_id);
		txtname.setText(Name);
		txtgender.setText(Gender);

		// Capture position and set results to the ImageView
		// Passes flag images URL into ImageLoader.class
		imageLoader.DisplayImage(image, img);
	}
}