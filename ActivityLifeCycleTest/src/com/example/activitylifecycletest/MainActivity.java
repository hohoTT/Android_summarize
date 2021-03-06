package com.example.activitylifecycletest;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {
	
	public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        
        // 取出之前保存的数据
        if(savedInstanceState != null){
        	String tempData = savedInstanceState.getString("data_key");
        	Log.d(TAG, tempData);
        }
    
        Button startNormalActivity = (Button) findViewById(R.id.start_normal_activity);
        
        startNormalActivity.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, NormalActivity.class);
				startActivity(intent);
			}
			
		});
        
        Button startDialogActivity = (Button) findViewById(R.id.start_dialog_activity);
        
        startDialogActivity.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, DialogActivity.class);
				startActivity(intent);
			}
		});
        
    }
    
    @Override
    protected void onStart() {
    	// TODO Auto-generated method stub
    	super.onStart();
    	Log.d(TAG, "onStart");
    }
    
    @Override
    protected void onResume() {
    	// TODO Auto-generated method stub
    	super.onResume();
    	Log.d(TAG, "onResume");
    }
    
    @Override
    protected void onPause() {
    	// TODO Auto-generated method stub
    	super.onPause();
    	Log.d(TAG, "onPause");
    }
    
    @Override
    protected void onStop() {
    	// TODO Auto-generated method stub
    	super.onStop();
    	Log.d(TAG, "onStop");
    }
    
    @Override
    protected void onDestroy() {
    	// TODO Auto-generated method stub
    	super.onDestroy();
    	Log.d(TAG, "onDestroy");
    }
    
    @Override
    protected void onRestart() {
    	// TODO Auto-generated method stub
    	super.onRestart();
    	Log.d(TAG, "onRestart");
    }
    
    // onSaveInstanceState()方法保证一定在活动被回收之前调用
    // 通过onSaveInstanceState()这个方法可以解决活动被回收时临时数据得不到保存的问题
    @Override
    protected void onSaveInstanceState(Bundle outState) {
    	// TODO Auto-generated method stub
    	super.onSaveInstanceState(outState);
    	String tempData = "Something you just typed";
    	outState.putString("data_key", tempData);
    }
    
}
