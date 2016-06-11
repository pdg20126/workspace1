package com.example.administrator.workspace.homework;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SimpleAdapter;

import com.example.administrator.workspace.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pdg on 2016/6/11.
 */
public class hm15_autosearch_activity extends FatherBarActivity {
    ListView lv;
    SearchView sv;
    testbean tb = new testbean();
    List<Map<String, Object>> l = new ArrayList<Map<String, Object>>();
    Handler h = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle b = msg.getData();
            String s = b.getString("ss");
            Gson g = new Gson();
            tb = g.fromJson(s, testbean.class);
            List<testbean.ResultBean> list = tb.getResult();

            if(list!=null) {
                l.clear();
                for (testbean.ResultBean rb : list) {
                    Map<String, Object> m = new HashMap<String, Object>();
                    m.put("name", rb.getName());
                    l.add(m);
                }
            }

            SimpleAdapter sa = new SimpleAdapter(hm15_autosearch_activity.this, l, R.layout.hm15_autosearch_layout, new String[]{"name"}, new int[]{R.id.text});
            lv.setAdapter(sa);
        }
    };
    @Override
    public void child(Bundle savedInstanceState) {

    }
}
