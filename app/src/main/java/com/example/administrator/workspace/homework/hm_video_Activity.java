package com.example.administrator.workspace.homework;

import android.app.Activity;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.administrator.workspace.R;

import java.io.File;

/**
 * Created by Administrator on 2016/6/8.
 */
public class hm_video_Activity extends Activity {
    VideoView videoView;
    MediaController mc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hm_video_layout);
        videoView= (VideoView) findViewById(R.id.video);
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        mc=new MediaController(this);
       // File video=new File("/mnt/sdcard/mm.mp4");
        File video=new File("mnt/sdcard/myvideo.mp4");
        if (video.exists()){
            videoView.setVideoPath(video.getAbsolutePath());
            videoView.setMediaController(mc);
            mc.setMediaPlayer(videoView);
            videoView.requestFocus();
        }
    }
}
