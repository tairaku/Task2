package com.lifeistech.android.task2;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.*;
import android.widget.*;


import java.util.ArrayList;


public class AddListActivity extends Activity {

    static ArrayAdapter<String> adapter2;
    static ArrayList<Homework> dataList2 = new ArrayList<Homework>();
    Homework hw=new Homework();
    static MyListAdapter adapter4;
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
        hw.setTitle(text);
        hw.setPage(page);
        hw.setMonth(mon);
        hw.setDay(da);
        dataList2.add(hw);

        Intent intent=new Intent(this,List2Activity.class);
        startActivity(intent);

    }


    public void datepick(View v){
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
