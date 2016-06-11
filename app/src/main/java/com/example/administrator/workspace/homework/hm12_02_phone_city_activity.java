package com.example.administrator.workspace.homework;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.workspace.R;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by pdg on 2016/6/11.
 */
public class hm12_02_phone_city_activity extends FatherBarActivity {
    EditText et;
    String s;
    TextView tv;
    Handler h=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            Bundle b=msg.getData();
            String result=b.get("ss").toString();
            Gson g=new Gson();
            homework_api_guishu_bean gs=g.fromJson(result,homework_api_guishu_bean.class);
            if(gs.getRetMsg().equals("success")){
                tv.setText(gs.getRetData().getProvince()+""+gs.getRetData().getCity()+""+gs.getRetData().getSupplier());
            }else{
                tv.setText(gs.getRetMsg());
            }
        }
    };

    public void chakan(View view){
        s=et.getText().toString();
        (new Thread(){
            @Override
            public void run() {
                String httpUrl = "http://apis.baidu.com/apistore/mobilenumber/mobilenumber";
                String httpArg = "phone="+s;
                BufferedReader reader = null;
                String result = null;
                StringBuffer sbf = new StringBuffer();
                httpUrl = httpUrl + "?" + httpArg;
                try {
                    URL url = new URL(httpUrl);
                    HttpURLConnection connection = (HttpURLConnection) url
                            .openConnection();
                    connection.setRequestMethod("GET");
                    // 填入apikey到HTTP header
                    connection.setRequestProperty("apikey",  "4383014a2e3615a560e13c94b40816e8");
                    connection.connect();
                    InputStream is = connection.getInputStream();
                    reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                    String strRead = null;
                    while ((strRead = reader.readLine()) != null) {
                        sbf.append(strRead);
                        sbf.append("\r\n");
                    }
                    reader.close();
                    result = sbf.toString();
                    Message m=new Message();
                    Bundle b=new Bundle();
                    b.putString("ss",result);
                    m.setData(b);
                    h.sendMessage(m);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }

    @Override
    public void child(Bundle savedInstanceState) {
        setContentView(R.layout.hm12_02_phone_city_layout);
        et= (EditText) findViewById(R.id.input);
        tv= (TextView) findViewById(R.id.textView2);
    }
}