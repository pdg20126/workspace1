package com.example.administrator.workspace.homework;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import com.example.administrator.workspace.R;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Administrator on 2016/6/2.
 */
public class hm_loadfile_Activity extends FatherBarActivity  {
    EditText ed;
    ImageView iv;
    String writeURL;
    ProgressDialog pd;
    Button bt;
    @Override
    public void child(Bundle savedInstanceState) {
        setContentView(R.layout.hm_loadfile_layout);
        ed= (EditText) findViewById(R.id.ed);
        writeURL =ed.getText().toString();
        ed.setText("http://photocdn.sohu.com/20110927/Img320705637.jpg");
        iv= (ImageView) findViewById(R.id.show);
        bt= (Button) findViewById(R.id.bt1);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downTask mTask=new downTask();
                mTask.execute();
            }
        });
    }

    public void savefile( String s) throws IOException {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            File sd=Environment.getExternalStorageDirectory();
            File tf=new File(sd.getCanonicalPath()+"tupian.jpg");

        }

    }
    class downTask extends AsyncTask<URL,Integer,Bitmap>{


        @Override
        protected Bitmap doInBackground(URL... params) {
            Bitmap bitmap = null;
            try {
                URL url = new URL(writeURL);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoInput(true);
                connection.connect();
                pd.setMax(connection.getContentLength());
                InputStream inputStream = connection.getInputStream();
                bitmap = BitmapFactory.decodeStream(inputStream);
             byte []buf=new byte[1024*4];
             inputStream=connection.getInputStream();
             int len=0;
             while ((inputStream.read(buf))!=-1) {
                len+=buf.length;
                publishProgress(len);
            }
                inputStream.close();
                return bitmap;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return  bitmap;
        }
            @Override
        protected void onPreExecute() {
            pd=new ProgressDialog(hm_loadfile_Activity.this);
            pd.setTitle("");
            pd.setMessage("");
            pd.setCancelable(true);
            pd.setMax(1);
            pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            pd.setIndeterminate(false);
            pd.show();
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            iv.setImageBitmap(bitmap);
            pd.setMessage("下载完成");


        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            int value=values[0];
            pd.setProgress(value);
            super.onProgressUpdate(values);
        }


    }
}

