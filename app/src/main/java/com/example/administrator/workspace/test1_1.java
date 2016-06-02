package com.example.administrator.workspace;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2016/6/2.
 */
public class test1_1 extends AsyncTask {
    private ImageView imageView;
    private ProgressBar progressBar;
    private Button button;

    public test1_1( ImageView imageView,
                        ProgressBar progressBar,Button button) {
        super();
        this.imageView = imageView;
        this.progressBar = progressBar;
        this.button=button;
    }


    @Override
    protected void onPreExecute() {
        // TODO Auto-generated method stub

        /*
         * 改方法在执行实际的后台操作时被UI线程调用，可以在该方法中做一些准备工作，比如
         *  Toast.makeText(context, "准备下载", Toast.LENGTH_LONG).show();
         */
        super.onPreExecute();
    }
    @Override
    protected Object doInBackground(Object[] params) {
        Bitmap bitmap=null;
        URL url= null;
        HttpURLConnection connection= null;
        try {
            url = new URL((String) params[0]);

            connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();


            InputStream inputStream=connection.getInputStream();
            bitmap= BitmapFactory.decodeStream(inputStream);
            inputStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        // inputStream.close();
             /*
              * 以下完全为了演示进度条，如果为了显示进度条可以把这个去掉
              */
             /*
             byte []buf=new byte[1024*4];
             inputStream=connection.getInputStream();
             int len=0;
             while ((inputStream.read(buf))!=-1) {
                len+=buf.length;
                publishProgress(len);
            }
         */



        return bitmap;
    }
}
