package com.example.administrator.workspace.homework;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.administrator.workspace.R;

/**
 * Created by pdg on 2016/6/4.
 */
public class hm02_image_Activity extends FatherBarActivity {
    ImageView iv;
    @Override
    public void child(Bundle savedInstanceState) {
        setContentView(R.layout.hm02_image_layout);
        iv= (ImageView) findViewById(R.id.imageView);
        iv.setImageResource(R.drawable.airplane);
    }
}
