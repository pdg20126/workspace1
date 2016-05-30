package com.example.administrator.workspace.homework;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.workspace.homework.FatherBarActivity;
import com.example.administrator.workspace.R;

/**
 * Created by Administrator on 2016/5/30.
 */
public class home_picture extends FatherBarActivity {
    int a=0;
    @Override
    public void child(Bundle savedInstanceState) {
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
