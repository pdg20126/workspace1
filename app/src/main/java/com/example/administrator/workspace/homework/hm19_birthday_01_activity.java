package com.example.administrator.workspace.homework;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.administrator.workspace.R;

/**
 * Created by pdg on 2016/6/11.
 */
public class hm19_birthday_01_activity extends FatherBarActivity {
    EditText et;

    @Override
    public void child(Bundle savedInstanceState) {
        setContentView(R.layout.hm19_birthday_01_layout);
        et = (EditText) findViewById(R.id.editText5);
        if (getIntent().getBundleExtra("date") != null) {
            Bundle b = getIntent().getBundleExtra("date");
            int year = b.getInt("year");
            int month = b.getInt("month") + 1;
            int day = b.getInt("day");
            et.setText(year + "年" + month + "月" + day + "日");
        }

    }
    public void birth(View view){
        Intent i=new Intent(this,hm19_birthday_02_activity.class);
        startActivity(i);
    }
}
