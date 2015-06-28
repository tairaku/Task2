package com.lifeistech.android.task2;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class List2Activity extends ActionBarActivity {

    Homework homework;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list2);
        String[] array ={"Apple","Banana","Orange"};
        //ArrayAdapter<String> array2=AddListActivity.adapter;
        ArrayAdapter<String> array3=AddListActivity.adapter2;
        //ArrayAdapter<Homework> array4=AddListActivity.adapter4;
        ArrayAdapter arrayadapter=new ArrayAdapter(this,R.layout.rowdata2,array);
        //ListView listview =(ListView)findViewById(R.id.listView);
        //MyListAdapter myadapter=new MyListAdapter(this,R.layout.rowdata2,)
        List<Homework> items = new ArrayList<Homework>();
        //listview.setAdapter(arrayadapter);
        //listview.setAdapter(array2);
        //listview.setAdapter(array3);
        //listview.setAdapter(array4);
        homework=new Homework();

        //MyListAdapter adapter4=new MyListAdapter(this,0,AddListActivity.dataList2);
        //MyListAdapter adapter5=AddListActivity.adapter4;
        //ListView listview4=(ListView)findViewById(R.id.listView);
        //listview4.setAdapter(adapter4);


        ListView listview =(ListView)findViewById(R.id.listView);

        //ListView listview5=(ListView)findViewById(R.id.listView);
        //listview5.setAdapter(adapter5);


        //homework.setTitle("aaaa");
        //homework.setPage("10");
        //items.add(homework);


        ListAdapter adapter = new MyListAdapter(this, R.layout.rowdata, AddListActivity.dataList2);
        listview.setAdapter(adapter);
    }

    public void back(View v){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void addlist(View v){
        Intent intent=new Intent(this,AddListActivity.class);
        startActivity(intent);
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
