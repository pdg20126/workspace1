package com.example.administrator.workspace;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

/**
 * Created by Administrator on 2016/6/2.
 */
public class test1 extends Activity {
    private EditText editText;
    private Button button;
    private ProgressBar progressBar;
    private ImageView imageView;
    private static final String URL_STRING="http://photocdn.sohu.com/20110927/Img320705637.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hm_loadfile_layout);

        editText=(EditText) findViewById(R.id.ed);
        editText.setText(URL_STRING);
        button=(Button) findViewById(R.id.bt1);

        imageView=(ImageView) findViewById(R.id.show);
        button.setOnClickListener(new ButtonListener());
    }

    class ButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            test1_1 mTask=new test1_1(imageView, progressBar,button);
            mTask.execute(URL_STRING);
        }

    }


}

