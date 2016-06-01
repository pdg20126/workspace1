package com.example.administrator.workspace.homework;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.administrator.workspace.R;

/**
 * Created by Administrator on 2016/5/26.
 */
public abstract class FatherBarActivity extends AppCompatActivity {
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        child(savedInstanceState);
        Toolbar t = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(t);
        getSupportActionBar().setTitle("我的作业");
        i=new Intent(this,homeworkActivity.class);
         getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        t.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){

                    case R.id.normal_btn:
                        AlertDialog.Builder adb=new AlertDialog.Builder(FatherBarActivity.this);
                        adb.setTitle("~~~作者~~~");
                        adb.setMessage("~~庞东国~~");
                        adb.create().show();
                        break;
                    case android.R.id.home:

                        finish();
                        break;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home){

            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater mif=new MenuInflater(this);
        mif.inflate(R.menu.toolbar_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    public abstract void child(Bundle savedInstanceState);

}
