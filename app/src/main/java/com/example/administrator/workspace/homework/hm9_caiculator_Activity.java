package com.example.administrator.workspace.homework;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.GridLayout;

import com.example.administrator.workspace.R;

import java.io.File;

/**
 * Created by Administrator on 2016/6/7.
 */
public class hm9_caiculator_Activity extends Activity {
    GridLayout gl;
    String []chars=new String[]{
            "7","8","9","÷",
            "4","5","6","×",
            "3","2","1","-",
            ".","0","=","+"
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hm09_calculator_layout);
        gl= (GridLayout) findViewById(R.id.root);
            for(int i=0;i<chars.length;i++ ){
                Button bt=new Button(this);
                bt.setText(chars[i]);
                bt.setTextSize(30);
             bt.setPadding(5,35,5,35);
            GridLayout.Spec rowspec=GridLayout.spec(i/4+2);
            GridLayout.Spec columnspec=GridLayout.spec(i%4);
            GridLayout.LayoutParams params=new GridLayout.LayoutParams(rowspec,columnspec);
            params.setGravity(Gravity.FILL);
            gl.addView(bt,params);
        }
    }
}
