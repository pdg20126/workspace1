package com.example.administrator.workspace.homework;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.administrator.workspace.R;

/**
 * Created by Administrator on 2016/5/31.
 */
public class hm25_city_Activity extends FatherBarActivity {
    EditText et;
    Intent i;
    @Override
    public void child(Bundle savedInstanceState) {
        setContentView(R.layout.hm25_city_layout);
        et= (EditText) findViewById(R.id.city);
        et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              i=new Intent(hm25_city_Activity.this,hm25_city2_Activity.class);
                startActivityForResult(i,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==123){
            String city=data.getStringExtra("city");
            et.setText(city);

        }
    }
}
