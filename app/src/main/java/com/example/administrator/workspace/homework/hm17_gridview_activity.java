package com.example.administrator.workspace.homework;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.workspace.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pdg on 2016/6/11.
 */
public class hm17_gridview_activity extends Activity {
    GridView gv;
    List<Map<String,String>> list=new ArrayList<Map<String,String>>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hm17_gridview_layout);
        gv= (GridView) findViewById(R.id.gridView);
        for(int i=0;i<=5;i++){
            Map<String,String> m=new HashMap();
            m.put("pic",R.drawable.plane+"");
            m.put("name","sss");
            list.add(m);
        }
        myadapter my=new myadapter();
        gv.setAdapter(my);
    }
    class  myadapter extends BaseAdapter{

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return list.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater li = LayoutInflater.from(hm17_gridview_activity.this);
            View view1 = li.inflate(R.layout.hm17_gridview_item_layout,null);

            ImageView iv= (ImageView) view1.findViewById(R.id.imageView);
            TextView tv= (TextView) view1.findViewById(R.id.text123);
            Map<String,String> m=list.get(i);
            iv.setImageResource(Integer.parseInt(m.get("pic")));
            tv.setText(m.get("name"));
            return view1;
        }
    }
}
