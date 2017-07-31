package ai.loginpage3;
import android.app.*;
import java.io.*;

public class Apps extends Application
{
	@Override
	public void onCreate() {
		FontsOverride.setDefaultFont(this, "SERIF","fonts/apercu_regular.otf");
		super.onCreate();
	}
}
