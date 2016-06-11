package com.example.administrator.workspace.homework;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.workspace.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pdg on 2016/6/11.
 */
public class hm23_much_dialog_activity extends FatherBarActivity {
    String[] s=new String[]{"c","c++","java","c#","html"};
    boolean[] bb;
    @Override
    public void child(Bundle savedInstanceState) {
        setContentView(R.layout.hm23_much_dialog_layout);

    }
    public void show(View view){
        bb=new boolean[]{true,false,false,false,false};

        AlertDialog.Builder b=new AlertDialog.Builder(this);
        b.setTitle("多选测试");
        b.setIcon(R.drawable.icon_13);
        b.setMultiChoiceItems(s, new boolean[]{true, false, false, false, false}, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if(isChecked){
                    bb[which]=true;
                }else{
                    bb[which]=false;
                }
            }
        });
        b.setNegativeButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                List<String> l=new ArrayList<String>();
                for(int i=0;i<bb.length;i++){
                    if(bb[i]){
                        l.add(s[i]);
                    }
                }
                String a="";
                for(String aa:l){
                    a=a+aa;
                }
                Toast.makeText(hm23_much_dialog_activity.this, "选择了"+a, Toast.LENGTH_SHORT).show();
            }
        });
        b.setPositiveButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        b.create().show();

    }
}
