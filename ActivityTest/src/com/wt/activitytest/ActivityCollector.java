package com.wt.activitytest;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;

// 为随时随地退出程序创建的类

public class ActivityCollector extends Activity {

	public static List<Activity> activities = new ArrayList<Activity>();
	
	public static void addActivity(Activity activity) {
		activities.add(activity);
	}
	
	public static void removeActivity(Activity activity) {
		activities.remove(activity);
	}
	
	// 将list中暂存的活动全部进行销毁
	public static void finishAll() {
		for (Activity activity : activities) {
			if(!activity.isFinishing()){
				activity.finish();
			}
		}
	}
	
}
