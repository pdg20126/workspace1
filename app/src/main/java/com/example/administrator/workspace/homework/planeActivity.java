package com.example.administrator.workspace.homework;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;

/**
 * Created by Administrator on 2016/5/31.
 */
public class planeActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hm09_plan_Activity p=new hm09_plan_Activity(this);
         p.setOnTouchListener(p);
        setContentView(p);
        DisplayMetrics dm = getResources().getDisplayMetrics();
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        p.curx = width/2;
        p.cury = height/2;
        setContentView(p);

    }
}
