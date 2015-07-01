package com.lifeistech.android.task2;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.*;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;


public class ListDetails extends Activity {

    private SharedPreferences date_sp2;
    TextView textview;
    TextView textview11;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_details);

        textview = (TextView) findViewById(R.id.textView13);
        textview11 = (TextView) findViewById(R.id.textView11);
        image = (ImageView) findViewById(R.id.imageView4);
        image.setImageResource(R.drawable.img5);

        /*値を取得*/
        date_sp2 = getSharedPreferences("date2", MODE_PRIVATE);
        String worktitle=date_sp2.getString("workTitle","-1");
        String workmonth=date_sp2.getString("workMonth", "-1");
        String workday = date_sp2.getString("workDay", "-1");
        int deadline=Integer.valueOf(workmonth)*30+Integer.valueOf(workday);//仮の計算

        /*今日の日付とってくる*/
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH)+1;// 1 - 12
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int today = month*30+day; //仮

        int intday = deadline-today;
        String dayday=String.valueOf(intday);

        if(intday==1){ //締め切りまで、あと1日なら画像が変化
            image.setImageResource(R.drawable.img3);
        }
        else if(intday<=5 && intday>1){
            image.setImageResource(R.drawable.img6);
        }else{
            image.setImageResource(R.drawable.img5);
        }

        textview11.setText(worktitle);
        textview.setText(dayday + "日!!!");
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