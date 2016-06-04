package com.example.administrator.workspace.homework;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.workspace.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Created by pdg on 2016/6/4.
 */
public class hm01_helloworldActivity extends FatherBarActivity {
    TextView tv;
    Button b;
    @Override
    public void child(Bundle savedInstanceState) {
        setContentView(R.layout.hm01_helloworldlayout);

        tv= (TextView) findViewById(R.id.textView);

    }
    public  void getdata(View v){
        Date d=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-hh hh-mm-ss");
        String s=sdf.format(d);
        tv.setText(s);
    }
}
