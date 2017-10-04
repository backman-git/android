package com.example.backman.fragmentdemo;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Backman on 2017/10/3.
 */

public class CustomFragment extends Fragment implements View.OnClickListener{

    String tag = "CustomFragment";
    TextView tvF1;
    int count=0;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v =inflater.inflate(R.layout.fragment_layout, container, false);
        tvF1 = (TextView) v.findViewById(R.id.tvF1);
        Button countBtn = (Button)v.findViewById(R.id.addOne);
        countBtn.setOnClickListener(this);

        return v;
    }


    @Override
    public void onClick(View v) {

        Log.d(tag,"word change");
        tvF1.setText("count "+count++);


    }
}
