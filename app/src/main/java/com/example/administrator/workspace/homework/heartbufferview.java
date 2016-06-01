package com.example.administrator.workspace.homework;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2016/6/1.
 */
public class heartbufferview extends View implements View.OnTouchListener {

    Canvas bufferCanvas;

    Bitmap bufferBitmap;
    float x, y;


    public heartbufferview(Context context) {
        super(context);
        bufferBitmap = Bitmap.createBitmap(720, 1080, Bitmap.Config.ARGB_8888);
        bufferCanvas = new Canvas();
        bufferCanvas.setBitmap(bufferBitmap);

    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Paint p=new Paint();
        p.setAntiAlias(true);
        p.setStrokeWidth(5);


        if (event.getAction() == MotionEvent.ACTION_DOWN) {
          x = event.getX();
          y = event.getY();
            int c=0xff000000+(int)(Math.random()*0xffffff);
            p.setColor(c);
            for (float i = -2; i <= 2; i += 0.001) {

                float iy = (float) Math.sqrt(2 * Math.sqrt(i * i) - i * i);
                double oy =  -2.14 * Math.sqrt(Math.sqrt(2) - Math.sqrt(Math.abs(i)));
                float ooy = (float) oy;
                bufferCanvas.drawPoint(i * 100 + x, -iy * 100 + y, p);
                bufferCanvas.drawPoint(i * 100 +x, -ooy * 100 +y, p);
            }
               for (float i = -2; i <= 2; i += 0.001) {
                float iy = (float) Math.sqrt(2 * Math.sqrt(i * i) - i * i);
                double oy =  -2.14 * Math.sqrt(Math.sqrt(2) - Math.sqrt(Math.abs(i)));
                float ooy = (float) oy;
                bufferCanvas.drawPoint(i * 80 + x, -iy * 80 + y, p);
                bufferCanvas.drawPoint(i * 80 +x, -ooy * 80 +y, p);
            }

            invalidate();

        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint p=new Paint();

        canvas.drawBitmap(bufferBitmap,0,0,p);
    }
}