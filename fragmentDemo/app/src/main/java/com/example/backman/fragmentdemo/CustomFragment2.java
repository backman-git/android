package com.example.backman.fragmentdemo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Backman on 2017/10/4.
 */


// two
public class CustomFragment2 extends Fragment implements View.OnClickListener {

    private  String tag = "cF2";

    private TextView a;
    private TextView b;
    private TextView res;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_layout2,container,false);

        Button calBtn = (Button) v.findViewById(R.id.cal);
        calBtn.setOnClickListener(this);

        a = (TextView) v.findViewById(R.id.numberA);
        b = (TextView) v.findViewById(R.id.numberB);
        res =(TextView) v.findViewById(R.id.res);

        return v;
    }


    @Override
    public void onClick(View v) {

        Log.d(tag,"cal");

        int vA = Integer.parseInt(a.getText().toString());
        int vB = Integer.parseInt(b.getText().toString());

        res.setText("= "+(vA+vB));




    }
}
