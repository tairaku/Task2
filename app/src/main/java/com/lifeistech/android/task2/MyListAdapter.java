package com.lifeistech.android.task2;

import android.content.Context;
import android.view.*;
import android.widget.*;

import java.util.*;

public class MyListAdapter extends ArrayAdapter<Homework> {
    private LayoutInflater layoutInflater_;

    public MyListAdapter(Context context, int textViewResourceId, List<Homework> objects) {
        super(context, textViewResourceId, objects);
        layoutInflater_ = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 特定の行(position)のデータを得る
        Homework item = (Homework) getItem(position);

        // convertViewは使い回しされている可能性があるのでnullの時だけ新しく作る
        if (null == convertView) {
            convertView = layoutInflater_.inflate(R.layout.rowdata, null);
        }

        // CustomDataのデータをViewの各Widgetにセットする
        TextView textView1;
        textView1 = (TextView) convertView.findViewById(R.id.title);
        textView1.setText(item.getTitle());

        TextView textView2;
        textView2 = (TextView) convertView.findViewById(R.id.page);
        textView2.setText(item.getPage());

        TextView textView3;
        textView3 = (TextView) convertView.findViewById(R.id.day);
        textView3.setText(String.valueOf(item.getMonth()) + "月" + String.valueOf(item.getDay()) + "日");


        return convertView;
    }
}