package com.example.administrator.workspace.homework;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2016/6/1.
 */
public class hm_board_Activity extends View implements View.OnTouchListener {
    Bitmap bt;
    Paint p;
    float x,y;
    Path path;
    Canvas canvas;
    public hm_board_Activity(Context context) {
        super(context);
        bt=Bitmap.createBitmap(720,1080, Bitmap.Config.ARGB_8888);
        canvas=new Canvas();
        path=new Path();
        p=new Paint();
        canvas.setBitmap(bt);
        p.setColor(Color.RED);
        p.setStrokeWidth(1);
        p.setAntiAlias(true);
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        float dx=event.getX();
        float dy=event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(dx,dy);
                x=dx;
                y=dy;
                break;
            case MotionEvent.ACTION_MOVE:
                path.quadTo(x,y,dx,dy);
                x=dx;
                y=dy;
                break;
            case MotionEvent.ACTION_UP:
               canvas.drawPath(path,p);
                path.reset();
                break;

        }
        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas1) {
        Paint p1=new Paint();
        canvas1.drawBitmap(bt,0,0,p1);
        canvas1.drawPath(path,p);
    }
}
