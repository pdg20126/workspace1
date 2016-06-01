package com.example.administrator.workspace.homework;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by pdg on 2016/5/29.
 */
public class heartActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        heartbufferview m=new heartbufferview(this);
        m.setOnTouchListener(m);
        setContentView(m);



    }
}
