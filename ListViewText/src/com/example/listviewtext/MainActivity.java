package com.example.listviewtext;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity {

	// �½����ݣ���ˮ��Ϊ����
	private String[] data = { "apple", "banana", "lemen", "lime", "orange",
			"pear", "blueberry", "taro", "persimmon", "avocado", "apricot",
			"strawberry" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// �������������������е����ݴ��ݵ�listview��
		// ArrayAdapterͨ�����͵ķ�ʽ��ָ��Ҫ������������ͣ�������������
		// ��һ��������ָ������ĵ�ǰ������
		// �ڶ���������ListView����ֵ�id���������һ��Android���õĲ���android.R.layout.simple_list_item_1
		// ����������������Ҫ��������ݣ���֮ǰԤ�����õ�dataˮ������
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				MainActivity.this, android.R.layout.simple_list_item_1, data);

		ListView listView = (ListView) findViewById(R.id.list_view);
		
		// �������õ����������󴫵ݽ�ȥ
		// ����ListView������֮��Ĺ����ͽ��������
		// ����ͨ�������ķ�ʽ���鿴��Ļ������ݣ������ݽ϶�������
		listView.setAdapter(adapter);
	}
}