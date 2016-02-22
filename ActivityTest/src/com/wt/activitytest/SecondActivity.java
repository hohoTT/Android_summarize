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

public class SecondActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.second_layout);
		
		// ������ͨ������ϵͳ���Ž���
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
		
		// ����ΪSecondActivity��FirstActivity�л�ȡ����
//		Intent intent = getIntent();
//		String data = intent.getStringExtra("extra_data");
//		Log.d("SecondActivity_data", data);
		
		
		// ����Ϊ��Ӧ�һ�е�startActivityForResult()������Ӧ�ĵ���¼�
		// ������ɷ������ݸ���һ������һ����֮�䣩
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
		
		// �������ٵ�ǰ�������FirstActivity
		Button button_back_first = (Button) findViewById(R.id.button_back_first);

		button_back_first.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
	}
	
	// ��дonBackPressed()����,ʵ�ֲ��õ��Button2��ťҲ�ɽ���Ϣ���ػһ

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