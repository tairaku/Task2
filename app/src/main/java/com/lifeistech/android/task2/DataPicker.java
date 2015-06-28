package com.lifeistech.android.task2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.content.SharedPreferences.Editor;


public class DataPicker extends ActionBarActivity {

    DatePicker picker;
    private int month;
    private int day;

    private SharedPreferences date_sp;
    private Editor date_editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_picker);

        //month=picker.getMonth()+1;
        //day=picker.getDayOfMonth();
        date_sp = getSharedPreferences("date", MODE_PRIVATE);
        date_editor = date_sp.edit();
        picker = (DatePicker) findViewById(R.id.datePicker);
    }

    public void pickok(View v){
        month=picker.getMonth()+1;
        day=picker.getDayOfMonth();
        date_editor.putInt("month", month);
        date_editor.putInt("day", day);
        date_editor.commit();
        //Intent intent=new Intent(this,AddListActivity.class);
        //startActivity(intent);
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt("month",month);
        bundle.putInt("day",day);
        intent.putExtras(bundle);

        setResult(RESULT_OK,intent);


        finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_data_picker, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
