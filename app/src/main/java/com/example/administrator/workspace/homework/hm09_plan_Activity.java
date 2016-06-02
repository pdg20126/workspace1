package com.example.administrator.workspace.homework;

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

import com.example.administrator.workspace.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

/**
 * Created by Administrator on 2016/5/31.
 */
public class hm09_plan_Activity extends View implements View.OnTouchListener {
    Handler h=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            Paint p=new Paint();
            super.handleMessage(msg);


        }
    };
    Bitmap plane;
    Bitmap bullet;
    Bitmap bufferBitmap;
    Canvas  bufferCanvas;
    Matrix m;
    Canvas c;
    float bullety;
    float x,y,dx,dy;
    float curx=500;
    float cury=800;
    List<bullet_bean> list=new ArrayList<bullet_bean>();
    public hm09_plan_Activity(Context context) {
        super(context);
        plane= BitmapFactory.decodeResource(getResources(),R.drawable.plane);
        bullet=BitmapFactory.decodeResource(getResources(),R.drawable.bullet_04);

    /*    bufferBitmap = Bitmap.createBitmap(720, 1080, Bitmap.Config.ARGB_8888);
        bufferCanvas = new Canvas();
        bufferCanvas.setBitmap(bufferBitmap);*/
        setOnTouchListener(this);
        hua();
        (new Thread(){
            @Override
            public void run() {
                super.run();
                bullet_bean bb=new bullet_bean();
                bb.setX(curx+plane.getWidth()/2);
                bb.setY(cury+plane.getHeight()/2);
                list.add(bb);
            }
        }).start();
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
                break;

        }
        invalidate();
        return true;

    }
    public void hua(){
        (new Thread(){
            @Override
            public void run() {
                while (true){
                    h.sendMessage(new Message());
                    try {
                        sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p=new Paint();
        canvas.drawBitmap(plane,curx,cury,p);

      /*  for (bullet_bean b:list){
            canvas.drawBitmap(bufferBitmap,0,0,p);
        }*/

        for(int i=0;i<20;i++){
          canvas.drawBitmap(bullet,list.get(i).getX(),list.get(i).getY(),p);
        }



    }
}
