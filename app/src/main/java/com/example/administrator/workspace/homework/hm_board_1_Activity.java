package com.example.administrator.workspace.homework;

import android.app.Activity;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Administrator on 2016/6/1.
 */
public class hm_board_1_Activity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Paint p=new Paint();
        hm_board_Activity h=new hm_board_Activity(this);
        h.setOnTouchListener(h);
        setContentView(h);


    }
}
