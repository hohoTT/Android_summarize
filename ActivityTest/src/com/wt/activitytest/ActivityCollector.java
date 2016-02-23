package com.wt.activitytest;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;

// Ϊ��ʱ����˳����򴴽�����

public class ActivityCollector extends Activity {

	public static List<Activity> activities = new ArrayList<Activity>();
	
	public static void addActivity(Activity activity) {
		activities.add(activity);
	}
	
	public static void removeActivity(Activity activity) {
		activities.remove(activity);
	}
	
	// ��list���ݴ�Ļȫ����������
	public static void finishAll() {
		for (Activity activity : activities) {
			if(!activity.isFinishing()){
				activity.finish();
			}
		}
	}
	
}