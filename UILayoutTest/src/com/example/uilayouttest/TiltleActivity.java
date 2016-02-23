package com.example.uilayouttest;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

// 创建自定义控件,实现返回和编辑的功能按钮

public class TiltleActivity extends LinearLayout {

	// 需要对标题栏布局进行动态加载
	// 通过LayoutInflater.from(context).inflate(R.layout.title, this)方法
	// 第一个参数是要加载的布局文件的id
	// 第二个参数是给加载好的布局再添加一个父布局
	public TiltleActivity(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub

		LayoutInflater.from(context).inflate(R.layout.title, this);

		Button titleBack = (Button) findViewById(R.id.title_back);

		titleBack.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				((Activity) getContext()).finish();

			}
		});

		Button titleEdit = (Button) findViewById(R.id.title_edit);

		titleEdit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Toast.makeText(getContext(), "you clicked Edit button",
						Toast.LENGTH_SHORT).show();

			}
		});

	}

}
