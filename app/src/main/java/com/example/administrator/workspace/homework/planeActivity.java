package com.example.administrator.workspace.homework;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Administrator on 2016/5/31.
 */
public class planeActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PlaneView p=new PlaneView(this);
         p.setOnTouchListener(p);
        setContentView(p);

    }
}
