package com.example.administrator.workspace.homework;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.baidu.tts.client.SpeechSynthesizer;
import com.baidu.tts.client.TtsMode;
import com.example.administrator.workspace.R;

/**
 * Created by Administrator on 2016/6/6.
 */
public class hm_baiduspeakerActivity extends FatherBarActivity {
    EditText txt;

    SpeechSynthesizer speechSynthesizer;
    @Override
    public void child(Bundle savedInstanceState) {
        setContentView(R.layout.hm_baiduspeaker_layout);

        txt = (EditText) findViewById(R.id.txt);
        speechSynthesizer = SpeechSynthesizer.getInstance();
        speechSynthesizer.setContext(this);
        speechSynthesizer.setAppId("8224325");
        speechSynthesizer.setApiKey("5vicuieeXBGGjhSorQze4LrY", "f73b8b5c628361c1b7a7eef9ec432afd");
        speechSynthesizer.initTts(TtsMode.ONLINE);

    }
    public void playSound(View view)
    {
        speechSynthesizer.speak(txt.getText().toString());
    }

}
