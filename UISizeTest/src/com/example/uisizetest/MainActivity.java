package com.example.uisizetest;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // ��ȡ��ǰ��Ļ���ܶ�ֵ
        // ע�⣺ָ��һ���̶�ֵ��ʱ��ʹ��dp����Ϊ��λ��ָ�����ֵ�ʱ��ʹ��sp����Ϊ��λ
        float xdpi = getResources().getDisplayMetrics().xdpi;
        float ydpi = getResources().getDisplayMetrics().ydpi;
        
        // ��ӡ��ǰ��Ļ���ܶ�ֵ
        Log.d("x_y_dpi", "xdpi is " + xdpi);
        Log.d("x_y_dpi", "ydpi is " + ydpi);
        
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
