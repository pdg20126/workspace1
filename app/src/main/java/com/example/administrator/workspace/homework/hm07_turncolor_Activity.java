package com.example.administrator.workspace.homework;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.example.administrator.workspace.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2016/6/6.
 */
public class hm07_turncolor_Activity extends  FatherBarActivity {
    int c=0;
    int []arr={R.id.t1,R.id.t2,R.id.t3,R.id.t4,R.id.t5,R.id.t6};
    int [] color={Color.RED,Color.BLUE,Color.BLACK,Color.GREEN,Color.YELLOW,Color.WHITE};

    Handler h=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            for(int i=0;i<5;i++){
                TextView tv=(TextView) findViewById(arr[i]);
                int s=i+c;
                if(s>4){
                    s=s%5;
                }
                tv.setBackgroundColor(color[s]);
            }
            c++;


        }
    };
    @Override
    public void child(Bundle savedInstanceState) {
        setContentView(R.layout.hm07_turncolor_layout);
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    Message m=new Message();
                    m.what=00;
                    h.sendMessage(m);
                }
            },0,200);
    }
}
