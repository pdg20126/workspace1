package com.example.administrator.workspace.homework;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.workspace.R;

/**
 * Created by Administrator on 2016/6/1.
 */
public class hm35_animationActivity extends FatherBarActivity implements View.OnTouchListener {
    ImageView iv;
    AnimationDrawable ad;
    MediaPlayer mp;


    @Override
    public void child(Bundle savedInstanceState) {
        setContentView(R.layout.hm_35animation_layout);
        iv= (ImageView) findViewById(R.id.image1);
        ad= (AnimationDrawable) iv.getBackground();


    }
    public void start(View view){
        ad.start();
        if (mp==null){
            mp=MediaPlayer.create(this, R.raw.bomb);
        }
        mp.start();

    }
    public void stop(View view){
        ad.stop();
        mp.stop();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
     if (event.getAction()==MotionEvent.ACTION_DOWN){

         ad.start();
     }
        return false;
    }
}
