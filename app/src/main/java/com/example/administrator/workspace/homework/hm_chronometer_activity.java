package com.example.administrator.workspace.homework;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

import com.example.administrator.workspace.R;

/**
 * Created by Administrator on 2016/6/13.
 */
public class hm_chronometer_activity extends FatherBarActivity {
    Chronometer ch;
    Button btn;
    @Override
    public void child(Bundle savedInstanceState) {
        setContentView(R.layout.hm_chronometer_layout);
        ch= (Chronometer) findViewById(R.id.ch);
        btn= (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch.setBase(SystemClock.elapsedRealtime());
                ch.start();
            }
        });
        ch.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if (SystemClock.elapsedRealtime()-ch.getBase()>20*1000){
                    ch.stop();
                    btn.setEnabled(true);
                }
            }
        });
    }
}
