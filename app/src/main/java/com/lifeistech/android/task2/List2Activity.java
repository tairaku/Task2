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

    Homework homework;
    ListView listview;
    ListAdapter adapter;
    Homework remove;
    private SharedPreferences date_sp2;
    private Editor date_editor2;
    int month2;
    int day2;
    String title2;
    static int item_id;
    static String item_id2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list2);
        ArrayAdapter<String> array3=AddListActivity.adapter2;
        List<Homework> items = new ArrayList<Homework>();

        homework=new Homework();
        remove=new Homework();

        date_sp2 = getSharedPreferences("date2", MODE_PRIVATE);
        date_editor2 = date_sp2.edit();

        listview =(ListView)findViewById(R.id.listView);



        adapter = new MyListAdapter(this, R.layout.rowdata, AddListActivity.dataList2);
        listview.setAdapter(adapter);


        // アイテムクリック時ののイベントを追加
        /*今のところ、値がちゃんととれていない。*/
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent,
                                    View view, int pos, long id) {

                // 選択アイテムを取得
                ListView listView2 = (ListView) parent;
                String item = (String) listView2.getItemAtPosition(pos);
                //itemid = Integer.parseInt(item);
                //item_id=pos;
                //item_id=((ListView) parent).getItemAtPosition(pos);
                item_id2=(String)((ListView) parent).getItemAtPosition(pos);
                date_editor2.putString("item_id2", item_id2);
                date_editor2.commit();


            }
        });
    }

    public void back(View v){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void addlist(View v){
        Intent intent2=new Intent(this,AddListActivity.class);
        startActivity(intent2);
    }


    public void goTopart(View v){
        //date_editor2.putInt("item_id", item_id);
        //date_editor2.commit();
        //date_editor2.putString("title2", title2);
        //date_editor2.putInt("month2", month2);
        //date_editor2.putInt("day2", day2);
        //date_editor2.commit();
        Intent intent3=new Intent(this,ListDetails.class);
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
