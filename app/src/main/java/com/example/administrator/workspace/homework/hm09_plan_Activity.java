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
            super.handleMessage(msg);
            invalidate();

        }
    };
    Bitmap plane;
    Bitmap bullet;
    Bitmap enemyBitmap;

    Matrix m;
    Canvas c;
    float bullety;
    float x,y,dx,dy;
    float curx=500;
    float cury=800;
    Timer t;
    Timer t2;
    Timer t3;
    boolean flag=true;
    boolean flag1=true;
    List<bullet_bean> list=new ArrayList<bullet_bean>();
    List<enemy_bean> list1=new ArrayList<enemy_bean>();
    public hm09_plan_Activity(Context context) {
        super(context);
        plane= BitmapFactory.decodeResource(getResources(),R.drawable.plane_1);
        bullet=BitmapFactory.decodeResource(getResources(),R.drawable.bullet_04);
        enemyBitmap=BitmapFactory.decodeResource(getResources(),R.drawable.plane_1);
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
                if (flag){
                    refresh();
                    flag=false;
                }
                addbullet();
                addenemy();
            case MotionEvent.ACTION_MOVE:
                curx=x-dx;
                cury=y-dy;
                bullety=cury-plane.getHeight();
                break;
            case  MotionEvent.ACTION_UP:
                t.cancel();
                t2.cancel();
                break;
        }
        invalidate();
        return true;
    }
    public  void setbullet(){
        bullet_bean b=new bullet_bean();
        b.setX(curx);
        b.setY(cury);
        list.add(b);
    }
    public void addbullet(){
        t=new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                setbullet();
            }
        },0,60);
    }
    public  void refresh(){
        t2=new Timer();
        t2.schedule(new TimerTask() {
            @Override
            public void run() {
                h.sendMessage(new Message());
            }
        },0,3000);
    }
    public  void setenemy(){
        enemy_bean eb=new enemy_bean();
        int xx= (int) (Math.random()*900+20);
        eb.setX(xx);
        eb.setY(-150);
        list1.add(eb);
    }
    public  void addenemy(){
        t3=new Timer();
        t3.schedule(new TimerTask() {
            @Override
            public void run() {
                setenemy();
            }
        },0,500);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p=new Paint();
        p.setStrokeWidth(10);
       // p.setColor(Color.RED);
        canvas.drawBitmap(plane,curx,cury,p);
        if (list.size()!=0){
            for (int i=list.size()-1;i>=0;i--){
                bullet_bean  b1=list.get(i);
                b1.setY(b1.getY()-40);
                canvas.drawLine(b1.getX()+(plane.getWidth()/2),b1.getY(),b1.getX()+(plane.getWidth()/2),b1.getY()-20,p);
               // canvas.drawLine(b1.getX()+(plane.getWidth()/2)+20,b1.getY(),b1.getX()+(plane.getWidth()/2)+20,b1.getY()-20,p);
                if (b1.getY()<=0){
                    list.remove(i--);
                }
            }
        }
        if(list1.size() != 0){
            for(int i=list1.size()-1;i>=0;i--){
                enemy_bean d = list1.get(i);
                d.setY(d.getY()+100);
                canvas.drawBitmap(enemyBitmap,d.getX(),d.getY(),p);
                if(d.getY()>700){
                    list1.remove(i--);
                }
            }
        }


    }
}
