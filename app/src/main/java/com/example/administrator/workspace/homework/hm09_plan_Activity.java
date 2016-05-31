package com.example.administrator.workspace.homework;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import com.example.administrator.workspace.R;

/**
 * Created by Administrator on 2016/5/31.
 */
public class hm09_plan_Activity extends View implements View.OnTouchListener {
    Bitmap plane;
    Matrix m;

    float x,y,curx,cury,dx,dy;

    public hm09_plan_Activity(Context context) {
        super(context);
        plane= BitmapFactory.decodeResource(getResources(),R.drawable.plane);
        m=new Matrix();
        m.setScale(6,7);
        setOnTouchListener(this);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p=new Paint();
        canvas.drawBitmap(plane,curx,cury,p);


    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        curx=event.getX();
        cury=event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                if(!(x>=curx && x<=curx+plane.getWidth()) || !(y>=cury && y<=cury+plane.getHeight()))
                {
                    return true;
                }
                dx = x - curx;
                dy = y - cury;
            case MotionEvent.ACTION_MOVE:
                //case MotionEvent.ACTION_CANCEL:
                curx = x - dx;
                cury = y - dy;
                invalidate();
                return true;
        }
        return true;
    }
}
