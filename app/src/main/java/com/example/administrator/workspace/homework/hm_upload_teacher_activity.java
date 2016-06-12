package com.example.administrator.workspace.homework;

import android.content.Intent;
import android.os.*;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.administrator.workspace.R;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Part;
import retrofit2.http.Url;

/**
 * Created by Administrator on 2016/6/12.
 */
public class hm_upload_teacher_activity extends FatherBarActivity {
    EditText ed1;
    EditText ed2;
    EditText ed3;
    EditText ed4;


    @Override
    public void child(Bundle savedInstanceState) {
        setContentView(R.layout.hm_upload_teacher_layout);
        ed1 = (EditText) findViewById(R.id.name);
        ed2 = (EditText) findViewById(R.id.id);
        ed3 = (EditText) findViewById(R.id.birth);
        ed4 = (EditText) findViewById(R.id.filename);
        ed4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(hm_upload_teacher_activity.this,hm37_sdcard_image_activity.class);
                startActivityForResult(i,0);
            }
        });
    }
    public void upload(View view){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.1.188:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        hm_upload_teacher upi = retrofit.create(hm_upload_teacher.class);
        File file = new File(ed4.getText().toString());
        RequestBody requestBody1 =  RequestBody.create(MediaType.parse("multipart/form-data"), file);
        Call<Message> c=upi.uploadStudentInfo(ed1.getText().toString(),ed2.getText().toString(),ed3.getText().toString(),file.getName(),requestBody1);
        c.enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                Message m = response.body();
            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {

            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 123){
            String birth = data.getStringExtra("birth");
            ed4.setText(birth);
        }
    }
}
