package com.example.listviewtext;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FruitAdapter extends ArrayAdapter<Fruit> {

	private int resourceId;
	
	public FruitAdapter(Context context, int textViewResourceId, 
			List<Fruit> objects) {
		super(context, textViewResourceId, objects);
		// TODO Auto-generated constructor stub
		
		resourceId = textViewResourceId;
	
	}

	// convertView���ڽ�֮ǰ���غõ����ݽ��л���
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		// ��ȡ��ǰ���Fruitʵ��
		Fruit fruit = getItem(position);
		
		// �Ż����룬����convertView���ListView������Ч��
		View view;
		ViewHolder viewHolder;
		
		if(convertView == null){
			view = LayoutInflater.from(getContext()).inflate(resourceId, null);
			
			viewHolder = new ViewHolder();
			viewHolder.fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
			viewHolder.fruitName = (TextView) view.findViewById(R.id.fruit_name);
		
			view.setTag(viewHolder);
		}
		else{
			view = convertView;
			viewHolder = (ViewHolder) view.getTag();
		}
		
//		ImageView fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
//		TextView fruitName = (TextView) view.findViewById(R.id.fruit_name);
//		
		viewHolder.fruitImage.setImageResource(fruit.getImageId());
		viewHolder.fruitName.setText(fruit.getName());
		
		return view;
	}
	
	// ����ViewHolder�ڲ��࣬���ڶԿؼ���ʵ�����л���
	class ViewHolder{
		
		ImageView fruitImage;
		TextView fruitName;
		
	}
	
}