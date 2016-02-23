package com.example.uiwidgetest;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements OnClickListener {

	private boolean flag = true;

	private Button button_show_EditText;
	private Button button_change_image;
	private Button button;
	private EditText editText;
	private ImageView imageView;
	private ProgressBar progressBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		button_show_EditText = (Button) findViewById(R.id.button_show_EditText);
		button_show_EditText.setOnClickListener(this);

		button_change_image = (Button) findViewById(R.id.button_change_image);
		button_change_image.setOnClickListener(this);

		button = (Button) findViewById(R.id.button);
		button.setOnClickListener(this);

		editText = (EditText) findViewById(R.id.edit_text);

		imageView = (ImageView) findViewById(R.id.image_view);

		progressBar = (ProgressBar) findViewById(R.id.progress_bar);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.button_show_EditText:
			// �˴��༭button_show_EditText��ť�ĵ���¼�
			// ͨ�������ť����ȡEditText�����������

			String inputText = editText.getText().toString();
			Toast.makeText(MainActivity.this, inputText, Toast.LENGTH_SHORT)
					.show();

			break;

		case R.id.button_change_image:
			// ͨ�����button_change_image��ť���ı�ͼƬ
			// ʹ��if����ͼƬ���л�
			if (flag) {
				imageView.setImageResource(R.drawable.music);
				flag = false;
			} else {
				imageView.setImageResource(R.drawable.img);
				flag = true;
			}
			break;

		case R.id.button:

			// һ��������ΪԲȦ����ʽ
			// ���һ�°�ť�ý�������ʧ���ٵ��һ�°�ť�ð�ť����
			// if(progressBar.getVisibility() == View.GONE){
			// progressBar.setVisibility(View.VISIBLE);
			// }
			// else{
			// progressBar.setVisibility(View.GONE);
			// }

			// ����������Ϊ��������ʽ
			// ʵ�ֶ�̬�ĸ��Ľ������Ľ���
			// ÿ���һ�θð�ť��ʵ����ԭ���Ļ����϶�̬�ļ�10
			// int progress = progressBar.getProgress();
			// progress += 10;
			// progressBar.setProgress(progress);

			// AlertDialog��ʹ��
			// AlertDialog�����ڵ�ǰ�Ľ��浯��һ���Ի���
			// ����Ի������ö������н���Ԫ��֮�ϵ�
			// һ��AlertDialog����������ʾһЩ�ǳ���Ҫ�����ݻ򾯸����Ϣ
			// AlertDialog.Builder dialog = new AlertDialog.Builder(
			// MainActivity.this);
			// dialog.setTitle("This is Dialog");
			// dialog.setMessage("Something important");
			// dialog.setCancelable(false);
			//
			// dialog.setPositiveButton("OK", new
			// DialogInterface.OnClickListener() {
			//
			// @Override
			// public void onClick(DialogInterface dialog, int which) {
			// // TODO Auto-generated method stub
			//
			// }
			// });
			//
			// dialog.setNegativeButton("Cancel", new
			// DialogInterface.OnClickListener() {
			//
			// @Override
			// public void onClick(DialogInterface dialog, int which) {
			// // TODO Auto-generated method stub
			//
			// }
			// });
			//
			// dialog.show();

			// ProgressDialog��ʹ��
			// progressDialog����һ���Ի����ܹ����ε������ؼ��Ľ�������
			// progressDialog���ڶԻ�������ʾһ��������
			// һ�����ڱ�ʾ��ǰ�Ĳ����ȽϺ�ʱ�����û����ĵĵȴ�
			ProgressDialog progressDialog = new ProgressDialog(
					MainActivity.this);
			progressDialog.setTitle("This is ProgressDialog");
			progressDialog.setMessage("Loading...");
			
			// �����ʱ�����Ϊfalse����progressDialog�ǲ���ͨ��Back��ȡ������
			// ��ʱ���һ��Ҫ�ڴ��������ÿ���
			// �����ݼ������ʱ����Ҫ����progressDialog��dismiss()�������رնԻ���
			// ����progressDialog����һֱ����
			progressDialog.setCancelable(true);
			
			progressDialog.show();
			
			break;

		default:
			break;
		}
	}
}