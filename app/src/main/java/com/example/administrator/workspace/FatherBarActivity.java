package com.example.administrator.workspace;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;

/**
 * Created by Administrator on 2016/5/26.
 */
public abstract class FatherBarActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        child(savedInstanceState);
        Toolbar t = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(t);
        getSupportActionBar().setTitle("天狗");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater mif=new MenuInflater(this);
        mif.inflate(R.menu.toolbar_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    public abstract void child(Bundle savedInstanceState);

}
