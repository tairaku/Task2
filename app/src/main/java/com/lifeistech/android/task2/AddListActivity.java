package com.lifeistech.android.task2;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class AddListActivity extends Activity {

    static ArrayAdapter<String> adapter;
    static ArrayAdapter<String> adapter2;
    static ArrayAdapter<Homework> adapter3;
    static ArrayList<String> dataList = new ArrayList<String>();
    static ArrayList<Homework> dataList2 = new ArrayList<Homework>();
    ListView list;
    //EditText edittext;
    //EditText edittext2;
    Homework hw=new Homework();
    static MyListAdapter adapter4;
    Date date=new Date();
    EditText edittext;
    EditText edittext2;
    String text;
    String page;
    int mon;
    int da;
    TextView dayday;

    private SharedPreferences date_sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_list);

        dayday=(TextView)findViewById(R.id.button4);
        dayday.setText("○月△日");

        //adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);

        //adapter2 = new MyListAdapter(this,android.R.layout.simple_list_item_1,dataList);
        /*adapter3 = new MyListAdapter(
                this,
                android.R.layout.simple_list_item_1,
                dataList2
        );*/

        adapter4 = new MyListAdapter(this,android.R.layout.simple_list_item_1,dataList2);

        date_sp = getSharedPreferences("date", MODE_PRIVATE);
    }

    public void addlist(View v){
        //EditTextオブジェクトを取得
        edittext=(EditText)findViewById(R.id.editText);
        edittext2=(EditText)findViewById(R.id.editText2);
        //入力された文字を取得
        text = edittext.getText().toString();
        page=edittext2.getText().toString();
        mon= date_sp.getInt("month", -1);
        da= date_sp.getInt("day", -1);


        //要素の追加
        //dataList.add(text);
        //adapter.add(text);
        //adapter2.add(text);
        hw.setTitle(text);
        //hw.setPage("10");
        hw.setPage(page);
        hw.setMonth(mon);
        hw.setDay(da);
        dataList2.add(hw);
        //adapter3.add(hw);
        //adapter4.add(hw);

        Intent intent=new Intent(this,List2Activity.class);
        startActivity(intent);

    }


    public void datepick(View v){
        //Intent intent2=new Intent(this,DataPicker.class);
        //startActivity(intent2);

        Intent intent2 = new Intent(this, DataPicker.class);
        int requestCode = 123;
        startActivityForResult(intent2, requestCode);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_list, menu);
        return true;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle bundle = data.getExtras();

        switch (requestCode) {
            case 123:
                if (resultCode == RESULT_OK) {
                    mon=bundle.getInt("month");
                    da=bundle.getInt("day");
                    dayday.setText(String.valueOf(mon)+"月"+String.valueOf(da)+"日");


                } else if (resultCode == RESULT_CANCELED) {
                    
                }
                break;

            default:
                break;
        }
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
