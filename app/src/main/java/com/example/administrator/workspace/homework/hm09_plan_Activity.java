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
    Bitmap bullet;
    Matrix m;
    Canvas c;
    float bullety;
    float x,y,curx,cury,dx,dy;

    public hm09_plan_Activity(Context context) {
        super(context);
        plane= BitmapFactory.decodeResource(getResources(),R.drawable.plane);
        bullet=BitmapFactory.decodeResource(getResources(),R.drawable.bullet_04);
        setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        x=event.getX();
        y=event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                dx=x-curx;
                dy=y-cury;
                break;
            case MotionEvent.ACTION_MOVE:
                curx=x-dx;
                cury=y-dy;
                bullety=cury-plane.getHeight();
                bullety=bullety-20;
                break;
        }
        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p=new Paint();
        canvas.drawBitmap(plane,curx,cury,p);
        canvas.drawBitmap(bullet,curx-20,bullety,p);

    }
}
