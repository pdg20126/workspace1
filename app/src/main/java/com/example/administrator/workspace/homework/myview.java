package com.example.administrator.workspace.homework;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.OnTouch;

/**
 * Created by pdg on 2016/5/29.
 */
public class myview extends View  implements View.OnTouchListener{
    Bitmap bt;
    List<heartbean> list=new ArrayList<heartbean>();
    public myview(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p=new Paint();
        p.setAntiAlias(true);
        p.setStrokeWidth(5);
        for (heartbean mm:list) {
            p.setColor(mm.getColor());
            for (float i = -2; i <= 2; i += 0.001) {
                float iy = (float) Math.sqrt(2 * Math.sqrt(i * i) - i * i);
                double oy =  -2.14 * Math.sqrt(Math.sqrt(2) - Math.sqrt(Math.abs(i)));
                float ooy = (float) oy;
                canvas.drawPoint(i * 100 + mm.getX(), -iy * 100 + mm.getY(), p);
                canvas.drawPoint(i * 100 + mm.getX(), -ooy * 100 + mm.getY(), p);


            }
        }

    }


    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        heartbean b=new heartbean();
        if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
            float x=motionEvent.getX();
            float y= motionEvent.getY();
            b.setX(x);
            b.setY(y);
            int c=0xff000000+(int)(Math.random()*0xffffff);
            b.setColor(c);
            list.add(b);
            invalidate();
        }
        return false;
    }
}
