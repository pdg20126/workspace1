package com.example.administrator.workspace.homework;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Context;
import android.os.Bundle;
import android.widget.TabHost;

import com.example.administrator.workspace.R;

/**
 * Created by pdg on 2016/6/11.
 */
public class hm20_tabhost_activity extends TabActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hm20_tabhost_layout);
        TabHost host = getTabHost();

        TabHost.TabSpec tab1 = host.newTabSpec("tab1").setIndicator("欢迎您好").setContent(R.id.tab1);
        host.addTab(tab1);

        TabHost.TabSpec tab2 = host.newTabSpec("tab2").setIndicator("我的图片").setContent(R.id.tab2);
        host.addTab(tab2);

        TabHost.TabSpec tab3 = host.newTabSpec("tab3").setIndicator("我的相册").setContent(R.id.tab3);
        host.addTab(tab3);
    }
}
