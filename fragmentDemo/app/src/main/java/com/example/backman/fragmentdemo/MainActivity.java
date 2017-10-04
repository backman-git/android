package com.example.backman.fragmentdemo;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String tag ="Main activity";
    private  FragmentManager fragmentManager = getFragmentManager();
    private  String currentFagment ;
    CustomFragment cF1 = new CustomFragment();
    CustomFragment2 cF2 = new CustomFragment2();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Button changeBtn = (Button) findViewById(R.id.changBtn);

        changeBtn.setOnClickListener(this);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        this.currentFagment = "cF1";
        fragmentTransaction.add(R.id.fragmentContainer,cF1,this.currentFagment).commit();

    }


    @Override
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.changBtn:{
                Log.d(tag,"change fragment");
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                if (this.currentFagment.equals("cF1")){
                    this.currentFagment = "cF2";
                    fragmentTransaction.replace(R.id.fragmentContainer,cF2).commit();
                }else{
                    this.currentFagment="cF1";
                    fragmentTransaction.replace(R.id.fragmentContainer,cF1).commit();
                }


                break;}


        }

    }
}
