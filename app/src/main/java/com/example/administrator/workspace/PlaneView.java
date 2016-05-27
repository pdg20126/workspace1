package com.example.administrator.workspace;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2016/5/27.
 */
public class PlaneView extends View implements View.OnTouchListener{
    Bitmap plane;
    float curx;
    float cury;
    float dx;
   float dy;
    public PlaneView(Context context) {
        super(context);
        plane= BitmapFactory.decodeResource(getResources(), R.drawable.airplane);
        setOnTouchListener(this);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint p=new Paint();
        canvas.drawBitmap(plane,curx,cury,p);
        super.onDraw(canvas);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        float x=event.getX();
        float y=event.getY();
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
