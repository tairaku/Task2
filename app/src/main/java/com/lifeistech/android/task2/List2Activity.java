package com.lifeistech.android.task2;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.content.SharedPreferences.Editor;

import java.util.*;


public class List2Activity extends Activity {

    ListView listview;
    MyListAdapter adapter;

    private SharedPreferences date_sp2;
    private Editor date_editor2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list2);

        listview = (ListView) findViewById(R.id.listView);

        date_sp2 = getSharedPreferences("date2", MODE_PRIVATE);
        date_editor2 = date_sp2.edit();

        adapter = new MyListAdapter(this, R.layout.rowdata, AddListActivity.dataList2);
        listview.setAdapter(adapter);


        // アイテムクリック時ののイベントを追加
        /*今のところ、値がちゃんととれていない。*/
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent,
                                    View view, int pos, long id) {

                // 選択アイテムを取得
                Homework work = adapter.getItem(pos);
                String workDay = "" + work.getDay();

                date_editor2.putString("workDay", workDay);
                date_editor2.commit();

                Intent intent3 = new Intent(List2Activity.this, ListDetails.class);
                startActivity(intent3);
            }
        });
    }

    public void back(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void addlist(View v) {
        Intent intent2 = new Intent(this, AddListActivity.class);
        startActivity(intent2);
    }


    public void goTopart(View v) {
        //date_editor2.putInt("item_id", item_id);
        //date_editor2.commit();
        //date_editor2.putString("title2", title2);
        //date_editor2.putInt("month2", month2);
        //date_editor2.putInt("day2", day2);
        //date_editor2.commit();
        Intent intent3 = new Intent(this, ListDetails.class);
        startActivity(intent3);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list2, menu);
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