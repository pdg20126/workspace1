package com.example.administrator.workspace.homework;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.workspace.R;

/**
 * Created by pdg on 2016/5/29.
 */
public class picture extends Activity {
    int a=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.picture_layout);
        final int []arr={R.drawable.airplane,R.drawable.icon_11,R.drawable.icon_13,R.drawable.icon_18};
        final ImageView iv= (ImageView) findViewById(R.id.picture);
        iv.setImageResource(arr[0]);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv.setImageResource(arr[++a%arr.length]);
            }
        });
    }
}
