package com.example.backman.compoundcontrol;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Backman on 2017/10/10.
 *
 *    just for demo custom control, No optimum in it.
 *
 *
 *
 */

public class SingleChooseItem extends LinearLayout implements View.OnClickListener {

    String tag ="SingleChooseItem";

    CheckBox cB1;
    CheckBox cB2;
    TextView tVC1;
    TextView tVC2;

    public SingleChooseItem(Context ctx) {
        super(ctx);

        this.init(ctx);
    }

    public SingleChooseItem(Context ctx,AttributeSet attrs){

        super(ctx,attrs);

        this.init(ctx);
    }

    public SingleChooseItem(Context ctx,AttributeSet attrs,int defStyle){

        super(ctx,attrs,defStyle);
        this.init(ctx);

    }





    public void init(Context ctx){

        LayoutInflater lif = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        lif.inflate(R.layout.single_choose_item,this);

        cB1 = (CheckBox) this.findViewById(R.id.cB1);
        cB1.setOnClickListener(this);
        cB2 = (CheckBox) this.findViewById(R.id.cB2);
        cB2.setOnClickListener(this);

        tVC1 = (TextView) this.findViewById(R.id.tVC1);
        tVC2 = (TextView) this.findViewById(R.id.tVC2);





    }

    @Override
    public void onClick(View v) {

        CheckBox clickView = (CheckBox) v;

        switch (v.getId()){

            case R.id.cB1:{


                if (clickView.isChecked() ){
                    Log.d(tag,"choice 1 checked");
                    cB2.setChecked(false);
                    tVC1.setBackgroundColor(Color.BLACK);
                    tVC2.setBackgroundColor(Color.WHITE);

                }
                else{
                    Log.d(tag,"choice 1 unchecked");
                    tVC1.setBackgroundColor(Color.WHITE);
                    

                }


                break;
            }


            case R.id.cB2:{


                if (clickView.isChecked() ){
                    Log.d(tag,"choice 2 checked");
                    cB1.setChecked(false);
                    tVC1.setBackgroundColor(Color.WHITE);
                    tVC2.setBackgroundColor(Color.BLACK);

                }
                else{
                    Log.d(tag,"choice 2 unchecked");
                    tVC2.setBackgroundColor(Color.WHITE);
                }


                break;
            }




        }



    }





}
