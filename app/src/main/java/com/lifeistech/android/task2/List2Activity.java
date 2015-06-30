package com.lifeistech.android.task2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class List2Activity extends Activity {

    Homework homework;

    ListView listview;

    MyListAdapter adapter;

    Homework remove;

    int month2;

    int day2;

    String title2;

    static int item_id;

    static String item_id2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list2);
        ArrayAdapter<String> array3 = AddListActivity.adapter2;
        List<Homework> items = new ArrayList<Homework>();

        homework = new Homework();
        remove = new Homework();

        listview = (ListView) findViewById(R.id.listView);

        adapter = new MyListAdapter(this, R.layout.rowdata, AddListActivity.dataList2);
        listview.setAdapter(adapter);

        // アイテムクリック時ののイベントを追加
        /*今のところ、値がちゃんととれていない。*/
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                // 選択アイテムを取得
                Homework homework = adapter.getItem(pos);
                Intent intent = new Intent(List2Activity.this, ListDetails.class);
                intent.putExtra("homework", homework);
                startActivity(intent);
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
