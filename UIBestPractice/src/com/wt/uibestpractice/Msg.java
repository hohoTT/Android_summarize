package com.wt.uibestpractice;

public class Msg {

	// ��ʾ��Ϣ����Ϊ���յ�����Ϣ
	public static final int TYPE_RECEIVED = 0;
	// ��ʾ��Ϣ����Ϊ�����͵���Ϣ
	public static final int TYPE_SENT = 1;
	
	// ��ʾ��Ϣ������
	private String content;
	
	// ��ʾ��Ϣ������
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
