package com.example.administrator.workspace.homework;

import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.example.administrator.workspace.R;

import java.util.regex.Matcher;

/**
 * Created by Administrator on 2016/6/6.
 */
public class hm_Provider_Activity extends FatherBarActivity {
    ListView list;
    ContentResolver cr;
    Uri uri=Uri.parse("content;//com.ralph.second/student");
    Uri uri2=Uri.parse("content;//com.ralph.second/student/0");
    @Override
    public void child(Bundle savedInstanceState) {
        setContentView(R.layout.hm_provider_layout);
        list= (ListView) findViewById(R.id.list);
        cr=getContentResolver();
    }
    public void allstudent(View view){
         Cursor c=cr.query(uri2,null,null,null,null);
        SimpleCursorAdapter sca=new SimpleCursorAdapter(this,R.layout.ex09_row_layout,c,new String[]{"name","age"},new int[]{R.id.studName,R.id.studAge});
        list.setAdapter(sca);


    }
    public void student(View view){

    }
}
