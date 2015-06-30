package com.lifeistech.android.task2;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.*;
import android.widget.TextView;


public class ListDetails extends Activity {

    private SharedPreferences date_sp2;
    int pos;
    String pos2;
    TextView textview;
    TextView textview11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_details);

        date_sp2 = getSharedPreferences("date2", MODE_PRIVATE);

        pos2= date_sp2.getString("item_id2", "13");
        textview=(TextView)findViewById(R.id.textView13);
        textview11=(TextView)findViewById(R.id.textView11);
        textview11.setText("英語の教科書");
        textview.setText(pos2/*List2Activity.item_id2*/+"日");
    }

    public void backToMenu(View v){
        Intent intent=new Intent(this,List2Activity.class);
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
