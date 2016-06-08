package com.example.administrator.workspace.homework;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;

import com.example.administrator.workspace.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2016/5/31.
 */
public class hm09_plan_Activity extends View implements View.OnTouchListener {
   Handler h=new Handler(){
        @Override
        public void handleMessage(Message msg) {

            invalidate();
            super.handleMessage(msg);



        }
    };
    Bitmap plane;
    Bitmap bullet;
    Bitmap enemyBitmap;
    Bitmap enemyBitmap2;
    Matrix m;
    Canvas c;
    float bullety;
    float x,y,dx,dy;
    float curx;
    float cury;
    Timer t;
    Timer t2;
    Timer t3;
    int height;
    int weight;
    boolean flag=true;
    boolean flag1=true;
    List<bullet_bean> list=new ArrayList<bullet_bean>();
    List<enemy_bean> list1=new ArrayList<enemy_bean>();
    public hm09_plan_Activity(Context context) {
        super(context);
        plane= BitmapFactory.decodeResource(getResources(),R.drawable.plane_1);
        bullet=BitmapFactory.decodeResource(getResources(),R.drawable.bullet_04);
        enemyBitmap=BitmapFactory.decodeResource(getResources(),R.drawable.plane_1);
        Matrix m2=new Matrix();
        m2.setRotate(180);
        Bitmap bb=Bitmap.createBitmap(enemyBitmap,0,0,enemyBitmap.getWidth(),enemyBitmap.getHeight(),m2,false);
        Matrix m3=new Matrix();
        m3.setScale(0.5f,0.5f);
        enemyBitmap2=Bitmap.createBitmap(bb,0,0,enemyBitmap.getWidth(),enemyBitmap.getHeight(),m3,false);
        setOnTouchListener(this);
        DisplayMetrics dm=new DisplayMetrics();
        dm=getResources().getDisplayMetrics();
        height=dm.heightPixels;
        weight=dm.widthPixels;
    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        x=event.getX();
        y=event.getY();
        if (flag1){
            flag1=false;
            (new Thread(){
                @Override
                public void run() {
                    super.run();
                    while(cury>1500){
                        try {
                            sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        cury+=5;
                        Message m=new Message();
                        m.what=1;
                        h.sendMessage(m);
                    }
                }
            }).start();
            flag=true;
        }
        if (flag){
            flag=false;
            (new Thread(){
                @Override
                public void run() {
                    super.run();
                    while(true){
                        bullet_bean bb=new bullet_bean();
                        bb.setX(curx+plane.getWidth()/2);
                        bb.setY((cury+plane.getHeight()));
                        list.add(bb);
                        try {
                            sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Message m=new Message();
                        h.sendMessage(m);
                    }
                }
            }).start();
            (new Thread(){
                @Override
                public void run() {
                    super.run();
                    while(true){
                        enemy_bean eb=new enemy_bean();
                        float cx= (float) (Math.random()*height);
                        eb.setX(cx);
                        eb.setY(0);
                        list1.add(eb);
                        try {
                            sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }

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
            case  MotionEvent.ACTION_UP:
                break;

        }
        return true;
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p=new Paint();
        p.setStrokeWidth(10);
        canvas.drawBitmap(plane,curx,cury,p);
/*        if(list.size()!=0&&list1.size()!=0){
            for(int i=list.size();i<list.size();i--){
                for (int j=list1.size();j<list1.size();j--){
                    float  bbx=list.get(i).getX();
                    float bby=list.get(i).getY();
                    float ebx=list1.get(i).getX();
                    float eby=list1.get(i).getY();
                    if (bbx>ebx&&bbx<ebx+enemyBitmap.getWidth()){
                        if(bby<bby+enemyBitmap.getHeight()&&bby>eby){
                            list.remove(i);
                            list1.remove(j);
                            break;
                        }
                    }
                }
            }*/
            for (int i=0;i<list.size();i++){
                bullet_bean  b1=list.get(i);
                b1.setY(b1.getY()+50);
                canvas.drawRect(b1.getX(),5,b1.getY(),5,p);
              //  canvas.drawLine(b1.getX(),b1.getY(),b1.getX(),b1.getY()+20,p);
                // canvas.drawLine(b1.getX()+(plane.getWidth()/2)+20,b1.getY(),b1.getX()+(plane.getWidth()/2)+20,b1.getY()-20,p);

            }
            for(int i=list1.size()-1;i>=0;i--){
                enemy_bean d = list1.get(i);
                bullet_bean b=list.get(i);
                d.setY(d.getY()+20);
                canvas.drawBitmap(enemyBitmap2,d.getX(),d.getY(),p);
                if(d.getY()>height){
                    list1.remove(i--);
                }

        }
        }
            }
        //}



