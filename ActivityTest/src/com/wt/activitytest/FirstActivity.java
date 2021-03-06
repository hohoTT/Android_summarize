package com.wt.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
//		Log.d("FirstActivity", this.toString());
		Log.d("FirstActivity", "Task id is " + getTaskId());
		
		// 用于除去活动中的标题栏
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.first_layout);

		Button button1 = (Button) findViewById(R.id.button_1);

		// 点击按钮 button1 显示 Toast，为按钮注册点击事件
//		button1.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				Toast.makeText(FirstActivity.this, "You clicked Button 1",
//						Toast.LENGTH_SHORT).show();
//			}
//		});
		
		// 通过button1的点击事件研究活动的启动模式
		// 模式在AndroidManifest.xml文件活动中的android:launchMode里进行设置
		
		// 一、standard模式（为活动自动使用的模式，即默认使用的模式）
		// 每点击一次按钮就会创建出来一个FirstActivity的实例
		// standard该模式就是，系统不会在乎这个活动是否已经在返回栈中存在
		// 每次启动都会创建该活动的一个新的实例
		
		// 二、singleTop模式
		// 当活动已经处于栈顶的位置，则不会创建新的活动，此时只有该活动的一个实例
		// 如果活动不是处于栈顶的位置，则依旧会创建新的活动
		// 该模式可以很好的解决重复创建栈顶活动的问题
		
		// 三、singleTask模式
		// 让某个活动在整个的应用程序中的上下文只存在一个实例
		
		// 四、singleInstance模式
		// 不管是哪一个应用程序来访问这个活动，都共用一个返回栈
		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				// 一、standard模式（为活动自动使用的模式，即默认使用的模式）
//				Intent intent = new Intent(FirstActivity.this, FirstActivity.class);
				
				Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
				
				startActivity(intent);
				
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
		
		// 向下一个活动传递数据
//		Button button_pass = (Button) findViewById(R.id.button_pass);
//		
//		button_pass.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//
//				String data = "Hello SecondActivity";
//				Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
//				// 第一个参数为键（即：extra_data），用于后面从Intent中取值
//				// 第二个参数才是真正要传递的数据（即：data）
//				intent.putExtra("extra_data", data);
//				startActivity(intent);
//				
//			}
//		});
		
		// 返回数据给上一个活动（活动一与活动二之间）
		Button button_for_result = (Button) findViewById(R.id.button_for_result);
		
		button_for_result.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
				
				//使用startActivityForResult方法启动活动二
				// 第一个参数为intent
				// 第二个参数为请求码，用于在之后的回调中判断数据的来源
				// 请求码只要是一个唯一值就可以了
				startActivityForResult(intent, 1);
			
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
	
	
	// 活动二销毁之后回调到上一个活动(即：活动一)的onActivityResult()方法
	// 重写方法用于完成返回数据给上一个活动（活动一与活动二之间），来得到活动二传递的数据
	// onActivityResult()方法共有三个参数
	// 参数一（即：requestCode）: 我们在启动活动时传入的请求码
	// 参数二（即：resultCode） : 我们在返回数据时传入的处理结果
	// 参数三（即：data） : 携带者返回数据的intent
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
//		super.onActivityResult(requestCode, resultCode, data);
		
		switch (requestCode) {
		case 1:
			if (resultCode == RESULT_OK){
				String returnedData = data.getStringExtra("data_return");
				Log.d("FirstActivity_data", returnedData);
			}
			break;

		default:

		}
	}
	
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.d("FirstActivity", "onRestart");
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.d("FirstActivity", "onDestroy");
	}
	
}
