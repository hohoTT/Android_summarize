package com.wt.activitytest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
		
		// 获取数据
		Intent intent = getIntent();
		
		String param1 = intent.getStringExtra("param1");
		String param2 = intent.getStringExtra("param2");
		
		Log.d("ThirdActivity_data", param1);
		Log.d("ThirdActivity_data", param2);
		
	}
	
	// 增加actionStart()方法，实现传递数据的功能
	// 实现某一个活动（由context决定）传递数据到活动三中
	public static void actionStart(Context context, String data1, String data2) {
		
		Intent intent = new Intent(context, ThirdActivity.class);
		
		intent.putExtra("param1", data1);
		intent.putExtra("param2", data2);

		context.startActivity(intent);
	}
		
}
