package com.example.administrator.workspace;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Administrator on 2016/5/26.
 */
public class ToolBarActivity extends FatherBarActivity {

    @Override
    public void child(Bundle savedInstanceState) {
        setContentView(R.layout.toolbar);
    }
   /* public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {

            case R.id.normal_btn:
                Toast.makeText(ToolBarActivity.this, "点击的是菜单项！", Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:
                Toast.makeText(ToolBarActivity.this, "点击了Home图标", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }*/
  
}
