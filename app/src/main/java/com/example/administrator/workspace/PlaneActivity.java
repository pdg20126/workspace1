package com.example.administrator.workspace;

import android.app.Activity;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.DisplayMetrics;

/**
 * Created by Administrator on 2016/5/27.
 */
public class PlaneActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DisplayMetrics dm=getResources().getDisplayMetrics();
        PlaneView p=new PlaneView(this);
        int width = dm.widthPixels;
        int height = dm.heightPixels;


        p.curx = width/2;
        p.cury= height/2;
        setContentView(p);

    }
}
