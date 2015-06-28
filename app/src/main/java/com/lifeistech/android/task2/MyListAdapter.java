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
        Homework item = (Homework)getItem(position);

        // convertViewは使い回しされている可能性があるのでnullの時だけ新しく作る
        if (null == convertView) {
            convertView = layoutInflater_.inflate(R.layout.rowdata, null);
        }

        // CustomDataのデータをViewの各Widgetにセットする
        TextView textView1;
        textView1 = (TextView)convertView.findViewById(R.id.title);
        textView1.setText(item.getTitle());

        TextView textView2;
        textView2 = (TextView)convertView.findViewById(R.id.page);
        textView2.setText(item.getPage());

        return convertView;
    }
}


/*public class MyListAdapter extends ArrayAdapter<Homework> {
    private Context context;
    private int resource;
    private List<Homework> items;

    public MyListAdapter(Context context1, int resource1, List<Homework> items1) {
        super(context1, resource1, items1);

        context = context1;
        resource = resource1;
        items = items1;

    }

    @Override
    public Homework getItem(int position) {
        return super.getItem(position);
    }
}*/

/*
public class MyListAdapter extends ArrayAdapter<String> {
    public MyListAdapter(Context context, int resource, int textViewResourceId,
                         List<String> objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public MyListAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
    }

    public MyListAdapter(Context context, int resource, int textViewResourceId, String[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public MyListAdapter(Context context, int resource, String[] objects) {
        super(context, resource, objects);
    }

    public MyListAdapter(Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public MyListAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public String getItem(int position) {
        return super.getItem(position);
    }
}*/
