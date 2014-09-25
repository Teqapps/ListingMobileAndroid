package master.tattoo.slidingmenu;

import com.parse.Parse;
import com.parse.ParseACL;

import com.parse.ParseUser;
import com.parse.PushService;

import android.app.Application;

public class ParseApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();

		Parse.enableLocalDatastore(this);

		// Add your initialization code here
		//Parse.initialize(this, "Yugurv9y554OFFlB21CLrP1iMeENm4req3VSRn1K", "AaCuO0f5KhVpIovaN1cFsI6KSh1ytqufBazDsSLf");
		Parse.initialize(this, "X5ipXQpsYBTBQEtozIli4dZQUsEy8aigsfy1Ynd3",
				"8AybZTMuyy9hmgnneN15udBK4x8nlTWS4fZCXiJ0");
		PushService.subscribe(this, "", MainActivity.class);
		
		// PushService.setDefaultPushCallback(this, MainActivity.class);
		ParseUser.enableAutomaticUser();
		ParseACL defaultACL = new ParseACL();

		// If you would like all objects to be private by default, remove this
		// line.
		defaultACL.setPublicReadAccess(true);

		ParseACL.setDefaultACL(defaultACL, true);
	}

}
