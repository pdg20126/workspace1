package com.example.administrator.workspace.homework;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.workspace.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/6/12.
 */
public class hm_baidu_gupiao_activity extends FatherBarActivity {
    EditText ed;
    TextView tv;
    @Override
    public void child(Bundle savedInstanceState) {
    setContentView(R.layout.hm_baidu_gupiao_layout);
        ed= (EditText) findViewById(R.id.edt);
        tv= (TextView) findViewById(R.id.textView);
    }
   public void findInfo(View view){
       Retrofit retrofit=new Retrofit.Builder()
               .baseUrl("http://apis.baidu.com")
               .addConverterFactory(GsonConverterFactory.create())
               .build();
       hm_baidu_gupiao baidu=retrofit.create(hm_baidu_gupiao.class);
       Call<hm_baidu_gupiao_bean> call=baidu.getgupiaoInfo("48b94ddd90c4f1752a1bb4615bd5c48a",ed.getText().toString(),"0");
        call.enqueue(new Callback<hm_baidu_gupiao_bean>() {
            @Override
            public void onResponse(Call<hm_baidu_gupiao_bean> call, Response<hm_baidu_gupiao_bean> response) {
                hm_baidu_gupiao_bean gp=response.body();
                ed.setText(gp.getRetData().getMarket().getShanghai()+""+gp.getRetData().getMarket().getShenzhen()+""+gp.getRetData().getMarket().getIXIC()+gp.getRetData().getMarket().getINX());
            }
            @Override
            public void onFailure(Call<hm_baidu_gupiao_bean> call, Throwable t) {

            }
        });
   }
}
