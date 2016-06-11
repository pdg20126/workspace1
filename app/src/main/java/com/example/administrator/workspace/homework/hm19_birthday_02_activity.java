package com.example.administrator.workspace.homework;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import com.example.administrator.workspace.R;

import java.util.Calendar;

/**
 * Created by pdg on 2016/6/11.
 */
public class hm19_birthday_02_activity extends FatherBarActivity {
    DatePicker dp;
    int year,month,day;
    Bundle b=new Bundle();
    @Override
    public void child(Bundle savedInstanceState) {
        setContentView(R.layout.hm19_birthday_02_layout);
        dp= (DatePicker) findViewById(R.id.datePicker);
        Calendar c=Calendar.getInstance();
        year=c.get(Calendar.YEAR);
        month=c.get(Calendar.MONTH);
        day=c.get(Calendar.DAY_OF_MONTH);
        dp.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                b.putInt("year",year);
                b.putInt("month",monthOfYear);
                b.putInt("day",dayOfMonth);
            }
        });

    }
    public void ok(View view){
        Intent i=new Intent(this,hm19_birthday_01_activity.class);
        i.putExtra("date",b);
        startActivity(i);
    }
}
