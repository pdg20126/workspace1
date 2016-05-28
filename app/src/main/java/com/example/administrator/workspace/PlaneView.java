package com.example.administrator.workspace;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

import android.os.Handler;

import android.os.Message;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/27.
 */
public class PlaneView extends View implements View.OnTouchListener{
    Handler h=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
                if (list.size()!=0){
                for (int i=0;i<list.size();i++){
                     ay = list.get(i).getY();
                    list.get(i).setY(ay - 20);
                    if (ay<0){
                        list.remove(list.get(i));
                    }
                }
                }
            by+=1;
            if (by>100){
                by=0;
            }
            invalidate();
        }
    };
    float by=0;
    Matrix m;
    Bitmap plane;
    Bitmap bullet;
   float curx;
    float cury;
    float dx;
   float dy,ay;
    boolean bl=true;
    boolean bl1=true;
    List<bullet_bean> list=new ArrayList<bullet_bean>();
    public PlaneView(Context context) {
        super(context);
        plane= BitmapFactory.decodeResource(getResources(), R.drawable.plane);
        bullet=BitmapFactory.decodeResource(getResources(),R.drawable.bullet_04);
        m=new Matrix();
        m.setScale(6,7);
        setOnTouchListener(this);
    }

    @Override
    protected void onDraw( Canvas canvas) {
        super.onDraw(canvas);
       final Paint p=new Paint();

        canvas.drawBitmap(plane,curx,cury,p);
        if (bl){
            bl=false;
            (new Thread(){
                @Override
                public void run() {
                    super.run();
                    while (cury > 1500) {
                        try {
                            sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        cury -= 5;
                        Message m = new Message();
                        m.what = 1;
                        h.sendMessage(m);
                    }
                    (new Thread(){
                        @Override
                        public void run() {
                            super.run();
                            while (true){
                                bullet_bean bb=new bullet_bean();
                                bb.setX(curx+plane.getWidth()-bullet.getWidth()+20);
                                bb.setY(cury-50);
                                list.add(bb);
                                try {
                                    sleep(60);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                    ).start();
                }
            }).start();
        }
        for(int i=0;i<list.size();i++){
            cury=cury-bullet.getHeight();
            canvas.drawBitmap(bullet,list.get(i).getX(),list.get(i).getY(),p);

        }

    }



    @Override
    public boolean onTouch(View v, MotionEvent event) {
        float x=event.getX();
        float y=event.getY();
        if (bl1) {
           bl1=false;
            (new Thread() {
                @Override
                public void run() {
                    super.run();
                    while (true) {
                        Message m = new Message();
                        m.what = 1;
                        h.sendMessage(m);
                        try {
                            sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
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
