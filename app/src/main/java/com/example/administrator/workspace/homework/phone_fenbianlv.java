package com.example.administrator.workspace.homework;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.workspace.FatherBarActivity;
import com.example.administrator.workspace.R;

/**
 * Created by pdg on 2016/5/29.
 */
public class phone_fenbianlv extends FatherBarActivity {
    TextView hight;
    TextView weight;
    TextView midu;
    TextView dp1;



    @Override
    public void child(Bundle savedInstanceState) {
        setContentView(R.layout.phone_fenbianlv);
        hight= (TextView) findViewById(R.id.height);
        weight= (TextView) findViewById(R.id.weight);
        midu= (TextView) findViewById(R.id.text);
        dp1= (TextView) findViewById(R.id.dp);
    }

    public void  show(View view){
        DisplayMetrics dm=new DisplayMetrics();
        dm=getResources().getDisplayMetrics();
        int w=dm.widthPixels;
        int gao=dm.heightPixels;
        float d=dm.density;
        int dp=dm.densityDpi;
        hight.setText("手机的高度是"+w+"寸");
        weight.setText("高是"+gao+"寸");
        midu.setText("手机密度是"+d+"");
        dp1.setText("分辨率是"+dp);
    }
}
