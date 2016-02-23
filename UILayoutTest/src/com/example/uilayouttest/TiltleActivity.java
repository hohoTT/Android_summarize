package com.example.uilayouttest;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

// �����Զ���ؼ�,ʵ�ַ��غͱ༭�Ĺ��ܰ�ť

public class TiltleActivity extends LinearLayout {

	// ��Ҫ�Ա��������ֽ��ж�̬����
	// ͨ��LayoutInflater.from(context).inflate(R.layout.title, this)����
	// ��һ��������Ҫ���صĲ����ļ���id
	// �ڶ��������Ǹ����غõĲ���������һ��������
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