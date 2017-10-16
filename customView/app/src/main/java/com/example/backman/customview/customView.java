package com.example.backman.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.graphics.Color;


/**
 * Created by Backman on 2017/10/2.
 */

// circle with words!




// measure -> layout -> draw
public class customView extends View implements View.OnClickListener
{

    public  static  String tag = "customView";

    int radius =100;
    int strokeWidth=10;
    int strokeColor = Color.GREEN;
    int textColor = Color.BLACK;
    int TextSize = 10;
    String sLabel = "Hello custom view";
    int textSize=30;


    public customView(Context context){
        super(context);
        init(null);

    }

    public customView(Context context,AttributeSet attrs){

        super(context,attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,R.styleable.customView,0,0);
        init(a);

    }

    public customView(Context context, AttributeSet attrs,int defStyle) {
        super(context, attrs,defStyle);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,R.styleable.customView,0,0);
        init(a);




    }



    public void init(TypedArray attrs){


        if(attrs != null){

            try{

                radius = attrs.getInteger(R.styleable.customView_bxRadius,radius);
                strokeWidth = attrs.getInteger(R.styleable.customView_bxStrokeWidth,strokeWidth);
                strokeColor = attrs.getColor(R.styleable.customView_bxStrokeColor,strokeColor);
                textColor = attrs.getColor(R.styleable.customView_bxTextColor,textColor);
                textSize = attrs.getInteger(R.styleable.customView_bxTextSize,textSize);
                sLabel = attrs.getString(R.styleable.customView_bxBannerContent);




            }finally {
                attrs.recycle();
            }



        }


        this.setOnClickListener(this);
        this.setClickable(true);
        this.setSaveEnabled(true);

    }



    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        //step 1. measure
        //may tear down to function
        int mWidthMode = MeasureSpec.getMode(widthMeasureSpec);
        int mHeightMode = MeasureSpec.getMode(heightMeasureSpec);
        int frameWidth = 0;
        int frameHeight =0;

        //width
        switch (mWidthMode){

            case MeasureSpec.UNSPECIFIED:{
                frameWidth = radius*2;
                Log.d(tag,"W MeasureSpec.UNSPECIFIED");
                break;
            }
            case MeasureSpec.AT_MOST:{
                frameWidth = radius*2;
                Log.d(tag,"W MeasureSpec.AT_Most");
                break;
            }
            case MeasureSpec.EXACTLY:{
                frameWidth = MeasureSpec.getSize(widthMeasureSpec);
                Log.d(tag,"W MeasureSpec.Exactly");
                break;

            }
        }


        //height
        switch (mHeightMode){

            case MeasureSpec.UNSPECIFIED:{
                Log.d(tag,"H MeasureSpec.UNSPECIFIED");
                frameHeight = radius*2;
                break;
            }
            case MeasureSpec.AT_MOST:{
                Log.d(tag,"H MeasureSpec.At_most");
                frameHeight = radius*2;
                break;

            }
            case MeasureSpec.EXACTLY:{
                Log.d(tag,"H MeasureSpec.exactly");
                frameHeight = MeasureSpec.getSize(heightMeasureSpec);
                break;
            }
        }

        Log.d(tag, "onMeasure: (width,height): "+"("+frameWidth+","+frameHeight+")");
        setMeasuredDimension(frameWidth,frameHeight);
    }






    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int w = this.getWidth();
        int h = this.getHeight();
        int r = radius;
        Log.d(tag, "onDraw: "+r);
        canvas.drawCircle(w/2,h/2,r,this.getBrush(this.strokeColor,this.strokeWidth));
        canvas.drawText(this.sLabel,w/4,h/2,this.getBrush(this.textColor,this.textSize));

    }
    private Paint getBrush(int color,int size)
    {
        Paint p = new Paint();
        p.setAntiAlias(true);
        p.setStrokeWidth(size);
        p.setColor(color);
        p.setStyle(Paint.Style.STROKE);
        p.setTextSize(size);
        return p;
    }


    @Override
    public void onClick(View v) {

        Log.d(tag, "onClick:");
        radius/=2;
        textSize*=1.5;
        requestLayout();
        invalidate();

    }


    public static class SavedState extends BaseSavedState{

        int radius;
        int textSize;

        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {

            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }
            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };



        public SavedState(Parcelable state) {
            super(state);

        }

        public SavedState(Parcel in ){
            super(in);

            this.radius = in.readInt();
            this.textSize = in.readInt();

        }



        @Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);

            out.writeInt(radius);
            out.writeInt(textSize);


        }
    }


    @Override
    protected Parcelable onSaveInstanceState() {

        Parcelable state=super.onSaveInstanceState();
        SavedState savedState = new SavedState(state);
        savedState.radius = this.radius;
        savedState.textSize = this.textSize;
        Log.d(tag,"onSave");

        return savedState;


    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {

        if (!(state instanceof SavedState)) {
            super.onRestoreInstanceState(state);
            return;
        }
        //it is our state
        SavedState savedState = (SavedState)state;
        //Peel it and give the child to the super class
        super.onRestoreInstanceState(savedState.getSuperState());
        this.radius = savedState.radius;
        this.textSize = savedState.textSize;
        Log.d(tag,"onLoad");
    }


}




