package com.example.administrator.workspace.homework;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.example.administrator.workspace.R;

/**
 * Created by pdg on 2016/6/11.
 */
public class hm26_h_v_activity extends FatherBarActivity {
    GridView gv;
    String[] s={"第1项","第2项","第3项","第4项","第5项","第6项","第7项","第8项","第9项","第10项","第11项","第12项"};
    @Override
    public void child(Bundle savedInstanceState) {
        setContentView(R.layout.hm26_h_v_layout);
        gv= (GridView) findViewById(R.id.gridView2);
        ArrayAdapter aa=new ArrayAdapter(this,android.R.layout.simple_list_item_1,s);
        gv.setAdapter(aa);
    }
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation==Configuration.ORIENTATION_LANDSCAPE){
            gv.setNumColumns(4);
        }else{
            gv.setNumColumns(3);
        }
    }
}
