package com.wt.activitytest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class FirstActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// 用于除去活动中的标题栏
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.first_layout);
	}
}
