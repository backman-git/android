package com.example.backman.listviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    ArrayList<String> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data = new ArrayList<String>();
        for(int i=0;i<100;i++){
            data.add(Integer.toString(i));
        }


        ListView lV = (ListView) findViewById(R.id.listView);
        lV.setAdapter(new customAdapter());


    }

    private class customAdapter extends BaseAdapter{

        //access from host
        //ArrayList<String> mData;


        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup container) {

            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.list_cell, container, false);
            }

            TextView tv=(TextView)convertView.findViewById(R.id.textView);
            tv.setText(data.get(position));

            return convertView;
        }



    }
}
