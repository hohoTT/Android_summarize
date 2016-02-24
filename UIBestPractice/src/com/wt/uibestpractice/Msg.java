package com.wt.uibestpractice;

public class Msg {

	// 表示消息类型为：收到的消息
	public static final int TYPE_RECEIVED = 0;
	// 表示消息类型为：发送的消息
	public static final int TYPE_SENT = 1;
	
	// 表示消息的内容
	private String content;
	
	// 表示消息的类型
	private int type;
	
	public Msg(String content, int type) {
		// TODO Auto-generated constructor stub
		this.content = content;
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public int getType() {
		return type;
	}
	
}
