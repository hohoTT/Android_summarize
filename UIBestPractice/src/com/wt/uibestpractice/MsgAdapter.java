package com.wt.uibestpractice;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MsgAdapter extends ArrayAdapter<Msg> {

	private int resourceId;
	
	public MsgAdapter(Context context, int textViewResourceId,
			List<Msg> objects) {
		super(context, textViewResourceId, objects);
		// TODO Auto-generated constructor stub
		
		resourceId = textViewResourceId;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
//		return super.getView(position, convertView, parent);
		
		Msg msg = getItem(position);
		
		View view;
		ViewHolder viewHolder;
		
		if(convertView == null){
			view = LayoutInflater.from(getContext()).inflate(resourceId, null);
			
			viewHolder = new ViewHolder();
			
			viewHolder.leftLayout = (LinearLayout) view.findViewById(R.id.left_layout);
			viewHolder.rightLayout = (LinearLayout) view.findViewById(R.id.right_layout);
			
			viewHolder.leftMsg = (TextView) view.findViewById(R.id.left_msg);
			viewHolder.rightMsg = (TextView) view.findViewById(R.id.right_msg);
		
			view.setTag(viewHolder);
		}
		else{
			view = convertView;
			viewHolder = (ViewHolder) view.getTag();
		}
		
		// 增加对消息的判断
		// 如果是收到的消息，则显示左边的消息布局，将右边的消息布局隐藏
		if(msg.getType() == Msg.TYPE_RECEIVED){
			viewHolder.leftLayout.setVisibility(View.VISIBLE);
			viewHolder.rightLayout.setVisibility(View.GONE);
			viewHolder.leftMsg.setText(msg.getContent());
		}
		// 如果是发送的消息，则显示右边的消息布局，将左边的消息布局隐藏
		else{
			viewHolder.rightLayout.setVisibility(View.VISIBLE);
			viewHolder.leftLayout.setVisibility(View.GONE);
			viewHolder.rightMsg.setText(msg.getContent());
		}
		
		return view;
	}

	// 创建内部类ViewHolder用于提高ListView的效率
	class ViewHolder{
		
		LinearLayout leftLayout;
		
		LinearLayout rightLayout;
		
		TextView leftMsg;
		
		TextView rightMsg;
		
	}
	
}
