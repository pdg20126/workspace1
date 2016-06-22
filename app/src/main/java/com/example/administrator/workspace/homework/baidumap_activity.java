package com.example.administrator.workspace.homework;

import android.app.Activity;
import android.os.Bundle;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;
import com.example.administrator.workspace.R;

/**
 * Created by pdg on 2016/6/19.
 */
public class baidumap_activity extends Activity {
    private MapView mv;
    BaiduMap bm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.baidumap_layout);
        initView();
    }

    private void initView() {
        mv= (MapView) findViewById(R.id.mymap);
       bm=mv.getMap();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mv.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mv.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mv.onDestroy();
    }
}
