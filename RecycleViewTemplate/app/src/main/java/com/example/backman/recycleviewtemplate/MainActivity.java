package com.example.backman.recycleviewtemplate;

import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> dataSet = new ArrayList<String>();

        for(int i=0;i<10;i++){
            dataSet.add(Integer.toString(i));
        }






    }

    public class 




}
