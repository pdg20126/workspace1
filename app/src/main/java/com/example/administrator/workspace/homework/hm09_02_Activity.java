package com.example.administrator.workspace.homework;

import android.os.Bundle;
import android.widget.QuickContactBadge;

import com.example.administrator.workspace.R;

/**
 * Created by Administrator on 2016/6/7.
 */
public class hm09_02_Activity extends FatherBarActivity {
    QuickContactBadge qcb;
    @Override
    public void child(Bundle savedInstanceState) {
        setContentView(R.layout.hm09_02__layout);
        qcb= (QuickContactBadge) findViewById(R.id.badge);
        qcb.assignContactFromPhone("4008308300",true);

    }
}
