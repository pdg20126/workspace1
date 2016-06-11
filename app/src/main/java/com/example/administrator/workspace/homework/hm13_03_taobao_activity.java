package com.example.administrator.workspace.homework;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.administrator.workspace.R;

/**
 * Created by pdg on 2016/6/11.
 */
public class hm13_03_taobao_activity extends FatherBarActivity {
    int[] i={R.drawable.icon_11,R.drawable.icon_28,R.drawable.icon_30,R.drawable.icon_33,R.drawable.icon_37};
    AdapterViewFlipper avf;
    @Override
    public void child(Bundle savedInstanceState) {
        setContentView(R.layout.hm13_03_taobao_layout);
        avf= (AdapterViewFlipper) findViewById(R.id.avf);
        BaseAdapter b=new BaseAdapter() {
            @Override
            public int getCount() {
                return i.length;
            }

            @Override
            public Object getItem(int position) {
                return i[position];
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView iv=new ImageView(hm13_03_taobao_activity.this);
                iv.setImageResource(i[position]);
                return iv;
            }
        };
        avf.setAdapter(b);
        avf.setFlipInterval(1000);
        avf.startFlipping();
    }
    public void last(View view){
        avf.showPrevious();
        avf.stopFlipping();
    }
    public void next(View view){
        avf.showNext();
        avf.stopFlipping();
    }
    public void auto(View view){
        avf.startFlipping();
    }
}
