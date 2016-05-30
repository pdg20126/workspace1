package com.example.administrator.workspace.homework;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;

import com.example.administrator.workspace.*;
import com.example.administrator.workspace.homework.FatherBarActivity;

import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by Administrator on 2016/5/25.
 */
public class Hm12Activity extends FatherBarActivity {
    Handler h=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==0){
                btn.setText("获取验证码");
                btn.setEnabled(true);
                t.cancel();
            }else {
                btn.setText("获取中.."+msg.what+"秒");
            }
        }
    };

    Button btn;
    Timer t;

    @Override
    public void child(Bundle savedInstanceState) {
        setContentView(R.layout.hm12_layout);
        btn= (Button) findViewById(R.id.send);
    }

    public void sendMsg(View view){
        btn.setEnabled(false);
        btn.setText("获取中");
        t=new Timer();
        t.schedule(new TimerTask() {
            int time=5;
            @Override
            public void run() {
                Message message=new Message();
                message.what=time--;
                h.sendMessage(message);

            }
        },100,1000);
    }
}
