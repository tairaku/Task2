package com.lifeistech.android.task2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class ListDetails extends Activity {

    TextView textview;

    TextView textview11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_details);

        Homework homework = (Homework) getIntent().getExtras().getSerializable("homework");
        Date now = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(now);
        calendar.set(Calendar.MONTH, homework.getMonth() - 1);
        calendar.set(Calendar.DAY_OF_MONTH, homework.getDay());
        Date limit = calendar.getTime();

        int day_diff = (int) (limit.getTime() - now.getTime()) / (1000 * 60 * 60 * 24);

        /*うまく値がとれていない!*/

        textview = (TextView) findViewById(R.id.textView13);
        textview11 = (TextView) findViewById(R.id.textView11);
        textview11.setText("英語の教科書");
        textview.setText(day_diff + "日");
    }

    public void backToMenu(View v) {
        Intent intent = new Intent(this, List2Activity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_details, menu);
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
