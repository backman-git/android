package com.example.backman.customlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by Backman on 2017/10/11.
 */

public class CustomLayout extends ViewGroup {

    private String tag = "customLayout";
    int hspace;
    int vspace;

    public CustomLayout(Context ctx){

        super(ctx);

        init(ctx);



    }

    public CustomLayout(Context ctx, AttributeSet attrs){

        super( ctx,  attrs,0);
        init(ctx);



    }
    public CustomLayout(Context ctx, AttributeSet attrs,int defStyle){
        super(ctx,attrs,defStyle);

        TypedArray t = ctx.obtainStyledAttributes(attrs,
                R.styleable.CustomLayout, 0, 0);
        hspace = t.getDimensionPixelSize(R.styleable.CustomLayout_hspace,
                hspace);
        vspace = t.getDimensionPixelSize(R.styleable.CustomLayout_vspace,
                vspace);

        Log.d(tag,"hspace:" + hspace);
        Log.d(tag,"vspace:" + vspace);
        t.recycle();
        init(ctx);

    }



    private void init(Context ctx){



    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        //layout attrs
        int rW = MeasureSpec.getSize(widthMeasureSpec);
        int rH = MeasureSpec.getSize(heightMeasureSpec);

        int cRowMaxW= 0;
        int cRowMaxH= 0;

        int ptrX=0;
        int ptrY=0;

        int nOfChild = this.getChildCount();

        int expectW=0;
        int expectH=0;

        for(int idx=0;idx<nOfChild;idx++){

            View child = this.getChildAt(idx);
            this.measureChild(child,widthMeasureSpec, heightMeasureSpec);
            int vw = child.getMeasuredWidth();
            int vh = child.getMeasuredHeight();
            // decide location
            if(ptrX+vw > rW){



                ptrX =0;
                ptrY +=cRowMaxH;
                LayoutParams lp = (LayoutParams)child.getLayoutParams();
                lp.x=ptrX;
                lp.y=ptrY;


                cRowMaxW=0;
                cRowMaxH=0;

            } else{

                LayoutParams lp = (LayoutParams)child.getLayoutParams();
                lp.x=ptrX;
                lp.y=ptrY;


            }
            ptrX+=vw;
            expectW = Math.max(expectW,ptrX);
            expectH = Math.max(expectH,ptrY);
            cRowMaxW = Math.max(cRowMaxW,vw);
            cRowMaxH = Math.max(cRowMaxH,vh);

        }

        setMeasuredDimension(resolveSize(expectW,widthMeasureSpec),resolveSize(expectH,heightMeasureSpec));





    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int numOfChildren = this.getChildCount();
        for (int i=0; i < numOfChildren; i++ )
        {
            View child = this.getChildAt(i);
            LayoutParams lp = (LayoutParams)child.getLayoutParams();
            child.layout(lp.x, lp.y, lp.x + child.getMeasuredWidth(), lp.y + child.getMeasuredHeight());
        }

    }



    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new CustomLayout.LayoutParams(getContext(), attrs);
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    }

    @Override
    protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        return new LayoutParams(p);
    }

    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return p instanceof CustomLayout.LayoutParams;
    }






    public static class LayoutParams extends ViewGroup.MarginLayoutParams{

        int x;
        int y;
        int spacing;
        String tag ="LayoutParams";

        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            TypedArray a =
                    c.obtainStyledAttributes(attrs, R.styleable.CustomLayout);

            spacing = a.getDimensionPixelSize(R.styleable.CustomLayout_Layout_layout_space, 0);
            Log.d(tag,"child spacing:" + spacing);
            a.recycle();
        }


        public LayoutParams(int width, int height) {
            super(width, height);
            spacing = 0;
        }

        public LayoutParams(ViewGroup.LayoutParams p) {
            super(p);
        }

        public LayoutParams(MarginLayoutParams source) {
            super(source);
        }


    }


}
