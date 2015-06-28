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
    ListView listview;
    ListAdapter adapter;
    Homework remove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list2);
        String[] array ={"Apple","Banana","Orange"};
        ArrayAdapter<String> array3=AddListActivity.adapter2;
        ArrayAdapter arrayadapter=new ArrayAdapter(this,R.layout.rowdata2,array);
        List<Homework> items = new ArrayList<Homework>();

        homework=new Homework();
        remove=new Homework();



        listview =(ListView)findViewById(R.id.listView);



        adapter = new MyListAdapter(this, R.layout.rowdata, AddListActivity.dataList2);
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
