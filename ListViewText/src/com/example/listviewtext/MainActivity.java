package com.example.listviewtext;

import java.util.ArrayList;
import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity {

	// 新建数据（以水果为例）
	private String[] data = { "Apple", "Banana", "Blueberries", "Cherries",
			"Lemon", "Mango", "Orange", "Peach", "Strawberry", "Watermelon" };

	private List<Fruit> fruitList = new ArrayList<Fruit>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// 借助适配器来将数组中的数据传递到listview中
		// ArrayAdapter通过泛型的方式来指定要适配的数据类型，共有三个参数
		// 第一个参数：指定传入的当前上下文
		// 第二个参数：ListView子项布局的id，这里的是一个Android内置的布局android.R.layout.simple_list_item_1
		// 第三个参数：传入要适配的数据，即之前预先设置的data水果数据
		// ArrayAdapter<String> adapter = new ArrayAdapter<String>(
		// MainActivity.this, android.R.layout.simple_list_item_1, data);

		// 以下是含有水果头像的配置器
		// 初始化水果的数据
		initFruits();

		FruitAdapter adapter = new FruitAdapter(MainActivity.this,
				R.layout.fruit_item, fruitList);

		ListView listView = (ListView) findViewById(R.id.list_view);

		// 将构建好的适配器对象传递进去
		// 这样ListView和数据之间的关联就建立完成了
		// 即可通过滚动的方式来查看屏幕外的数据（当数据较多的情况）
		 listView.setAdapter(adapter);
	}

	private void initFruits() {
		Fruit apple = new Fruit("Apple", R.drawable.apple);
		fruitList.add(apple);

		Fruit banana = new Fruit("Banana", R.drawable.banana);
		fruitList.add(banana);
		
		Fruit blueberries = new Fruit("Blueberries", R.drawable.blueberries);
		fruitList.add(blueberries);
		
		Fruit cherries = new Fruit("Cherries", R.drawable.cherries);
		fruitList.add(cherries);
		
		Fruit lemon = new Fruit("Lemon", R.drawable.lemon);
		fruitList.add(lemon);
		
		Fruit mango = new Fruit("Mango", R.drawable.mango);
		fruitList.add(mango);
		
		Fruit orange = new Fruit("Orange", R.drawable.orange);
		fruitList.add(orange);
		
		Fruit strawberry = new Fruit("Strawberry", R.drawable.strawberry);
		fruitList.add(strawberry);
		
		Fruit watermelon = new Fruit("Watermelon", R.drawable.watermelon);
		fruitList.add(watermelon);
	}

}
