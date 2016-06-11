package com.example.administrator.workspace.homework;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ViewSwitcher;

import com.example.administrator.workspace.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by pdg on 2016/6/11.
 */
public class hm14_turnview_activity extends FatherBarActivity {
    ViewSwitcher vs;
    Timer t;
    Handler h=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            vs.showNext();
        }
    };
    @Override
    public void child(Bundle savedInstanceState) {
        setContentView(R.layout.hm14_turnview_layout);
        vs= (ViewSwitcher) findViewById(R.id.switcher);
        heartActivity a=new heartActivity();
        hm02_image_Activity b=new hm02_image_Activity();
        t=new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                Message m=new Message();
                m.what=1;
                h.sendMessage(m);
            }
        },100,3000);
    }
    }

