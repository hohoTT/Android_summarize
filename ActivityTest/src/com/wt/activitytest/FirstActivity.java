package com.wt.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// 用于除去活动中的标题栏
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.first_layout);

		Button button1 = (Button) findViewById(R.id.button_1);

		// 点击按钮 button1 显示 Toast，为按钮注册点击事件
		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(FirstActivity.this, "You clicked Button 1",
						Toast.LENGTH_SHORT).show();
			}
		});

		// 启动第二个活动
		Button button_start_SecondActivity = (Button) findViewById(R.id.button_start_SecondActivity);

		button_start_SecondActivity.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// 第一个参数content为--启动活动的上下文    第二个参数class为--想要启动的目标活动
				Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
				// 启动活动，接受intent参数
				startActivity(intent);
			}
		});
		
		
		// 添加销毁活动的按钮
		Button button_finish = (Button) findViewById(R.id.button_finish);

		button_finish.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		// 为当前活动创建菜单
		getMenuInflater().inflate(R.menu.main, menu);

		// true 表示允许创建的菜单显示出来
		return true;

		// return super.onCreateOptionsMenu(menu);
	}

	// 定义菜单相应事件
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub

		switch (item.getItemId()) {
		case R.id.add_item:
			Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show();
			break;

		case R.id.remove_item:
			Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT)
					.show();
			break;

		default:

		}

		return true;

		// return super.onOptionsItemSelected(item);
	}
}
