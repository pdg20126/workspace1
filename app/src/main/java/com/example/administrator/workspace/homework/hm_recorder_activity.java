package com.example.administrator.workspace.homework;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.example.administrator.workspace.R;
import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2016/6/8.
 */
public class hm_recorder_activity extends FatherBarActivity {
    MediaRecorder recorder;
    MediaPlayer mp;
    File file;
    @Override
    public void child(Bundle savedInstanceState) {
        setContentView(R.layout.hm_reccoder);
    }
    public void record(View view)
    {
        file = new File("/mnt/sdcard/sound1.amr");
        try{
            recorder = new MediaRecorder();
            recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            recorder.setOutputFile(file.getAbsolutePath());

            recorder.prepare();
            recorder.start();
        }catch(Exception e){
            Log.e("error",e.getMessage());
        }
    }

    public void stop(View view) throws IOException {
        if(file != null && file.exists())
        {
            recorder.stop();
            recorder.release();
            recorder = null;
            file = null;
            mp=new MediaPlayer();
            mp.setDataSource("/mnt/sdcard/sound1.amr");
            mp.prepare();
            mp.start();
        }
    }

    @Override
    protected void onDestroy() {
        if(file != null && file.exists())
        {
            recorder.stop();
            recorder.release();
            recorder = null;
            file = null;
        }
        super.onDestroy();
    }
}
