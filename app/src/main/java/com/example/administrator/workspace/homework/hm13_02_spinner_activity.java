package com.example.administrator.workspace.homework;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.administrator.workspace.R;

/**
 * Created by pdg on 2016/6/11.
 */
public class hm13_02_spinner_activity extends FatherBarActivity {
    String[] ss={"高中","专科","本科","研究生","博士生"};
    @Override
    public void child(Bundle savedInstanceState) {
        setContentView(R.layout.hm13_02_spinner_layout);
        Spinner s= (Spinner) findViewById(R.id.spinner);
        ArrayAdapter aa=new ArrayAdapter(this,android.R.layout.simple_list_item_1,ss);
        s.setAdapter(aa);
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String t="你选择的是"+ss[position];
                Toast.makeText(hm13_02_spinner_activity.this,t , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    }

