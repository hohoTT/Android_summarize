package com.wt.activitytest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class ThirdActivity extends BaseActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		Log.d("ThirdActivity", "Task id is " + getTaskId());
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.third_layout);
		
		// 通过点击该按钮实现直接退出程序的功能
		Button button_destroy = (Button) findViewById(R.id.button_destroy);
		
		button_destroy.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				ActivityCollector.finishAll();
				
			}
		});
		
	}
		
}
