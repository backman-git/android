package com.example.backman.debugpurpose;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int c=0;
        for (int idx =0;idx<100; idx++)
            c++;



    }
}
