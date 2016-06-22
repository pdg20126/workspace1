package com.example.firstwork;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ToggleButton;

import junit.framework.Test;

public class MainActivity extends FatherBarActivity {
    ToggleButton tb;
    EditText et;

    @Override
    public void child(Bundle savedInstanceState) {
        setContentView(R.layout.layout_login);
        tb= (ToggleButton) findViewById(R.id.tgbtn_show_psw);
        et= (EditText) findViewById(R.id.edit_psw);
        et.setInputType(0x81);
        Toolbar t = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(t);
        getSupportActionBar().setTitle("登录");
        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    et.setInputType(0x90);
                }else {
                    et.setInputType(0x81);
                }
            }
        });
    }

}
