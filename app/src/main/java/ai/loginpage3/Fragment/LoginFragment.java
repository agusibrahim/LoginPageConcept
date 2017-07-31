package ai.loginpage3.Fragment;
import android.support.v4.app.Fragment;
import android.view.View;
import android.os.Bundle;
import ai.loginpage3.R;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.animation.ValueAnimator;
import android.view.animation.*;
import android.widget.Button;
import ai.loginpage3.MainActivity;
import android.util.*;
import android.media.*;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.flaviofaria.kenburnsview.RandomTransitionGenerator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;

public class LoginFragment extends Fragment
{
	Button button_login;
	View form_login, imglogo, label_signup, darkoverlay;
	KenBurnsView kbv;
	private DisplayMetrics dm;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v=inflater.inflate(R.layout.fragment_login, container, false);
		dm=getResources().getDisplayMetrics();
		form_login=v.findViewById(R.id.form_login);
		imglogo=v.findViewById(R.id.fragmentloginLogo);
		kbv=(KenBurnsView) v.findViewById(R.id.fragmentloginKenBurnsView1);
		darkoverlay=v.findViewById(R.id.fragmentloginView1);
		label_signup=v.findViewById(R.id.label_signup);
		return v;
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		RandomTransitionGenerator generator = new RandomTransitionGenerator(20000, new AccelerateDecelerateInterpolator());
		kbv.setTransitionGenerator(generator);
		imglogo.animate().setStartDelay(5000).setDuration(2000).alpha(1).start();
		darkoverlay.animate().setStartDelay(5000).setDuration(2000).alpha(0.6f).start();
		label_signup.animate().setStartDelay(6000).setDuration(2000).alpha(1).start();
		form_login.animate().translationY(dm.heightPixels).setStartDelay(0).setDuration(0).start();
		form_login.animate().translationY(0).setDuration(1500).alpha(1).setStartDelay(6000).start();
	}
}
// auto typing with adb (for demo purpose)
// sleep 6;input text "agusibrahim@mail.com";input keyevent 61;input text "thisispasswd"

