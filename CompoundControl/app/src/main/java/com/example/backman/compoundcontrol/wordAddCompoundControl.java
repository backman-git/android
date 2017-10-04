package com.example.backman.compoundcontrol;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by Backman on 2017/10/3.
 */

public class wordAddCompoundControl extends LinearLayout implements View.OnClickListener {


    public wordAddCompoundControl(Context context) {
        super(context);
        init(context);

    }

    public wordAddCompoundControl(Context context, AttributeSet attrs){
        super(context,attrs,0);
        init(context);

    }

    public wordAddCompoundControl(Context context, AttributeSet attrs,int defStyle ){
        super(context,attrs,defStyle);
        init(context);



    }




    private void init(Context context){

        LayoutInflater lif =(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        lif.inflate(R.layout.word_add,this);

        Button b1 = (Button) this.findViewById(R.id.button);
        b1.setOnClickListener(this);
        Button b2 = (Button) this.findViewById(R.id.button2);
        b2.setOnClickListener(this);



    }


    @Override
    public void onClick(View v) {

    }
}
