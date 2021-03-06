package com.wt.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class SecondActivity extends BaseActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		Log.d("SecondActivity", "Task id is " + getTaskId());
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.second_layout);
		
		// 以下是通过调用系统拨号界面
		Button button_tel = (Button) findViewById(R.id.button_tel);
		
		button_tel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				Intent intent = new Intent(Intent.ACTION_DIAL);
				intent.setData(Uri.parse("tel:10086"));
				startActivity(intent);
				
			}
		});
		
		// 以下为SecondActivity从FirstActivity中获取数据
//		Intent intent = getIntent();
//		String data = intent.getStringExtra("extra_data");
//		Log.d("SecondActivity_data", data);
		
		
		// 以下为对应活动一中的startActivityForResult()方法对应的点击事件
		// 用于完成返回数据给上一个活动（活动一与活动二之间）
		Button button_2 = (Button) findViewById(R.id.button_2);
		button_2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				Intent intent = new Intent();
				intent.putExtra("data_return", "Hello FirstActivity");
				setResult(RESULT_OK, intent);
				finish();
				
			}
		});
		
		// 添加销毁当前活动，返回FirstActivity
		Button button_back_first = (Button) findViewById(R.id.button_back_first);

//		button_back_first.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				finish();
//			}
//		});
		
		button_back_first.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
//				Intent intent = new Intent(SecondActivity.this, FirstActivity.class);
//				startActivity(intent);
				
				Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
				startActivity(intent);
				
			}
		});
		
		
		// 调用ThirdActivity中的actionStart方法进行数据的传递
		Button button_pass_third = (Button) findViewById(R.id.button_pass_third);
		
		button_pass_third.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				ThirdActivity.actionStart(SecondActivity.this, "data_one", "data_two");
				
			}
		});
		
	}
	
	// 重写onBackPressed()方法,实现不用点击Button2按钮也可将消息传回活动一

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
//		super.onBackPressed();

		Intent intent = new Intent();
		intent.putExtra("data_return", "Hello FirstActivity");
		setResult(RESULT_OK, intent);
		finish();
		
	}
	
}
