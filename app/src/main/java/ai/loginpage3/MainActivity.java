package ai.loginpage3;

import android.os.*;
import android.support.v7.app.AppCompatActivity;
import ai.loginpage3.Fragment.LoginFragment;
import android.support.v4.app.Fragment;
import ai.loginpage3.Fragment.DashboardFragment;
import android.widget.Button;
import android.animation.ValueAnimator;
import android.view.animation.*;
import android.view.View;
import android.widget.Toast;
import android.support.v4.content.res.ResourcesCompat;
import android.view.ViewGroup.*;
import android.widget.RelativeLayout;
import android.support.v4.view.animation.*;
import android.media.MediaPlayer;
import android.view.TextureView;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Surface;
import android.graphics.SurfaceTexture;
import android.content.res.AssetFileDescriptor;
import android.animation.*;
import android.util.*;
import com.daasuu.ei.*;
import android.widget.ProgressBar;
import android.graphics.Color;
import android.graphics.PorterDuff;

public class MainActivity extends AppCompatActivity 
{
	Fragment frag_login, frag_dashboard;
	ProgressBar pbar;
	View button_login, button_label,button_icon,ic_menu1,ic_menu2;
	private DisplayMetrics dm;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		pbar=(ProgressBar) findViewById(R.id.mainProgressBar1);
		button_icon=findViewById(R.id.button_icon);
		button_label=findViewById(R.id.button_label);

		
		dm=getResources().getDisplayMetrics();
		button_login=findViewById(R.id.button_login);
		button_login.setTag(0);
		pbar.getIndeterminateDrawable().setColorFilter(Color.WHITE, PorterDuff.Mode.MULTIPLY);
		StatusBarUtil.immersive(this);
		
		frag_login=new LoginFragment();
		frag_dashboard=new DashboardFragment();
		getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, frag_login).commit();
		final ValueAnimator va=new ValueAnimator();
		va.setDuration(1500);
		va.setInterpolator(new DecelerateInterpolator());
		va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){
				@Override
				public void onAnimationUpdate(ValueAnimator p1) {
					RelativeLayout.LayoutParams button_login_lp= (RelativeLayout.LayoutParams) button_login.getLayoutParams();
					button_login_lp.width=Math.round(p1.getAnimatedValue());
					button_login.setLayoutParams(button_login_lp);
				}
			});
		button_login.animate().translationX(dm.widthPixels+button_login.getMeasuredWidth()).setDuration(0).setStartDelay(0).start();
		button_login.animate().translationX(0).setStartDelay(6500).setDuration(1500).setInterpolator(new OvershootInterpolator()).start();
		button_login.setOnClickListener(new View.OnClickListener(){
				@Override
				public void onClick(View p1) {
					if((int)button_login.getTag()==1){
						return;
					}else if((int)button_login.getTag()==2){
						button_login.animate().x(dm.widthPixels/2).y(dm.heightPixels/2).setInterpolator(new EasingInterpolator(Ease.CUBIC_IN)).setListener(null).setDuration(1000).setStartDelay(0).start();
						button_login.animate().setStartDelay(600).setDuration(1000).scaleX(40).scaleY(40).setInterpolator(new EasingInterpolator(Ease.CUBIC_IN_OUT)).start();
						button_icon.animate().alpha(0).rotation(90).setStartDelay(0).setDuration(800).start();
						return;
					}
					button_login.setTag(1);
					va.setFloatValues(button_login.getMeasuredWidth(), button_login.getMeasuredHeight());
					va.start();
					pbar.animate().setStartDelay(300).setDuration(1000).alpha(1).start();
					button_label.animate().setStartDelay(100).setDuration(500).alpha(0).start();
					button_login.animate().setInterpolator(new FastOutSlowInInterpolator()).setStartDelay(4000).setDuration(1000).scaleX(30).scaleY(30).setListener(new Animator.AnimatorListener(){
							@Override
							public void onAnimationStart(Animator p1) {
								pbar.animate().setStartDelay(0).setDuration(0).alpha(0).start();
							}

							@Override
							public void onAnimationEnd(Animator p1) {
								try{
								getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, frag_dashboard).disallowAddToBackStack().commitAllowingStateLoss();
								}catch(Exception e){}
								button_login.animate().setStartDelay(0).alpha(1).setDuration(1000).scaleX(1).scaleY(1).x(dm.widthPixels-button_login.getMeasuredWidth()-100).y(dm.heightPixels-button_login.getMeasuredHeight()-100).setListener(new Animator.AnimatorListener(){

										@Override
										public void onAnimationStart(Animator p1) {
											// TODO: Implement this method
										}

										@Override
										public void onAnimationEnd(Animator p1) {
											button_icon.animate().setDuration(0).setStartDelay(0).rotation(85).alpha(1).start();
											button_icon.animate().setDuration(2000).setInterpolator(new BounceInterpolator()).setStartDelay(0).rotation(0).start();
											button_login.setTag(2);
										}

										@Override
										public void onAnimationCancel(Animator p1) {
											// TODO: Implement this method
										}

										@Override
										public void onAnimationRepeat(Animator p1) {
											// TODO: Implement this method
										}
									}).start();
							}

							@Override
							public void onAnimationCancel(Animator p1) {
								// TODO: Implement this method
							}

							@Override
							public void onAnimationRepeat(Animator p1) {
								// TODO: Implement this method
							}
						}).start();
					
					
				}
			});
    }

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		
	}
}
