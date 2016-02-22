package com.wt.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
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

		// 显式启动第二个活动
		Button button_explicit = (Button) findViewById(R.id.button_explicit);

		button_explicit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				// 以下为显式意图的使用
				// 第一个参数content为--启动活动的上下文    第二个参数class为--想要启动的目标活动
				Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
				// 启动活动，接受intent参数
				startActivity(intent);
				
			}
		});
		
		
		// 隐式启动第二个活动
		Button button_implicit = (Button) findViewById(R.id.button_implicit);
		
		button_implicit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				// 以下为隐式意图的使用
				// 每个 intent 只能指定一个 action，但是可以指定多个 category
				// 但是需要注意的是需要和 AndroidManifest.xml 中的action和category一致
				Intent intent = new Intent("com.wt.activitytest.ACTION_START");
				intent.addCategory("com.wt.activitytest.MY_CATEGORY");
				startActivity(intent);
			}
		});
		
		// 调用系统浏览器打开百度网页
		Button button_baidu = (Button) findViewById(R.id.button_baidu);
		
		button_baidu.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				// Intent.ACTION_VIEW 为Android系统中内置的动作
				Intent intent = new Intent(Intent.ACTION_VIEW);
				
				// 通过 Uri.parse() 方法将一个网址字符串解析成一个Uri对象
				intent.setData(Uri.parse("http://www.baidu.com"));
				
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
