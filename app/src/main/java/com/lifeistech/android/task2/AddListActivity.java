package com.lifeistech.android.task2;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
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
    EditText edittext;
    //EditText edittext2;
    Homework hw=new Homework();
    static MyListAdapter adapter4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_list);

        //adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);

        //adapter2 = new MyListAdapter(this,android.R.layout.simple_list_item_1,dataList);
        /*adapter3 = new MyListAdapter(
                this,
                android.R.layout.simple_list_item_1,
                dataList2
        );*/

        adapter4 = new MyListAdapter(this,android.R.layout.simple_list_item_1,dataList2);


    }

    public void addlist(View v){
        //EditTextオブジェクトを取得
        EditText edittext=(EditText)findViewById(R.id.editText);
        EditText edittext2=(EditText)findViewById(R.id.editText2);
        //入力された文字を取得
        String text = edittext.getText().toString();
        String page=edittext2.getText().toString();

        //要素の追加
        //dataList.add(text);
        //adapter.add(text);
        //adapter2.add(text);
        hw.setTitle(text);
        //hw.setPage("10");
        hw.setPage(page);
        dataList2.add(hw);
        //adapter3.add(hw);
        //adapter4.add(hw);

        Intent intent=new Intent(this,List2Activity.class);
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_list, menu);
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
