package com.example.uilayouttest;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // LinearLayout���Բ��ֵ�ʹ��
//        setContentView(R.layout.activity_main);
//        setContentView(R.layout.layout_gravity);
//        setContentView(R.layout.layout_weight);
        
        // RelativeLayout��Բ�������ڸ����ֽ��еĶ�λʹ��
//        setContentView(R.layout.relative_layout_one);
        
        // RelativeLayout��Բ�������ڿؼ����еĶ�λʹ��
//        setContentView(R.layout.relative_layout_two);
        
        // FrameLayout���ֵ�ʹ�ã��ڽ�����Ƭ��ʱ���õģ�һ���õĺ���
        setContentView(R.layout.frame_layout);
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}