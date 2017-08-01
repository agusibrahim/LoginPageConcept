package ai.loginpage3.Fragment;
import android.support.v4.app.Fragment;
import android.view.View;
import android.os.Bundle;
import ai.loginpage3.R;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import devs.mulham.horizontalcalendar.HorizontalCalendar;
import java.util.Calendar;
import devs.mulham.horizontalcalendar.HorizontalCalendarListener;
import java.util.Date;
import devs.mulham.horizontalcalendar.HorizontalCalendarView;
import android.graphics.*;
import android.widget.*;
import java.text.*;
import android.support.v4.content.ContextCompat;
import ai.loginpage3.StatusBarUtil;
import android.view.animation.OvershootInterpolator;

public class DashboardFragment extends Fragment
{

	private Calendar endDate,startDate;
	private HorizontalCalendar horizontalCalendar;
	private View bgheadr, profpic, txtusername, ic_menu2,ic_menu1,lst1,lst2,lst3,lst4;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		endDate = Calendar.getInstance();
		endDate.add(Calendar.MONTH, 1);
		startDate = Calendar.getInstance();
		startDate.add(Calendar.MONTH, -1);
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v=inflater.inflate(R.layout.fragment_dashboard, container, false);
		ic_menu1=v.findViewById(R.id.fragmentdashboardMenu1);
		ic_menu2=v.findViewById(R.id.fragmentdashboardMenu2);
		profpic=v.findViewById(R.id.fragmentdashboardPic);
		txtusername=v.findViewById(R.id.fragmentdashboardUsername);
		bgheadr=v.findViewById(R.id.fragmentdashboardImageView1);
		lst1=v.findViewById(R.id.fragmentdashboardLinearLayout1);
		lst2=v.findViewById(R.id.fragmentdashboardLinearLayout2);
		lst3=v.findViewById(R.id.fragmentdashboardLinearLayout3);
		lst4=v.findViewById(R.id.fragmentdashboardLinearLayout4);
		StatusBarUtil.setPaddingSmart(getActivity(), ic_menu1);
		StatusBarUtil.setPaddingSmart(getActivity(), ic_menu2);
		bgheadr.animate().setStartDelay(0).scaleX(2).scaleY(2).setDuration(0).start();
		horizontalCalendar = new HorizontalCalendar.Builder(v, R.id.calendarView)
			.startDate(startDate.getTime())
			.endDate(endDate.getTime())
			.datesNumberOnScreen(5)
			.dayNameFormat("EEE")
			.dayNumberFormat("dd")
			.monthFormat("MMM")
			.selectorColor(ContextCompat.getColor(getActivity(), R.color.color_login_button))
			.textSize(13f, 23f, 13f)
			.showDayName(true)
			.showMonthName(true)
			.textColor(Color.LTGRAY, Color.WHITE)
			.selectedDateBackground(Color.TRANSPARENT)
			.build();
		
		return v;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO: Implement this method
	
	}
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		resetanim(lst1);
		resetanim(lst2);
		resetanim(lst3);
		resetanim(lst4);
		txtusername.animate().setStartDelay(300).setDuration(2000).alpha(1).start();
		profpic.animate().setStartDelay(0).setDuration(0).scaleX(0).scaleY(0).start();
		profpic.animate().setStartDelay(500).setDuration(2000).setInterpolator(new OvershootInterpolator()).scaleX(1).scaleY(1).start();
		lst1.animate().setStartDelay(0).setDuration(1000).translationY(0).alpha(1).scaleX(1).scaleY(1).start();
		lst2.animate().setStartDelay(200).setDuration(1000).translationY(0).alpha(1).scaleX(1).scaleY(1).start();
		lst3.animate().setStartDelay(400).setDuration(1000).translationY(0).alpha(1).scaleX(1).scaleY(1).start();
		lst4.animate().setStartDelay(600).setDuration(1000).translationY(0).alpha(1).scaleX(1).scaleY(1).start();
		bgheadr.animate().setStartDelay(200).setDuration(1500).scaleX(1).scaleY(1).start();
		
        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
				@Override
				public void onDateSelected(Date date, int position) {
					//Toast.makeText(getContext(), DateFormat.getDateInstance().format(date) + " is selected!", Toast.LENGTH_SHORT).show();
				}

			});
	}
	private void resetanim(View v){
		v.animate().setStartDelay(0).setDuration(0).translationY(-200).scaleX(1).scaleY(1).start();
	}
}
