package com.example.administrator.workspace.homework;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.administrator.workspace.R;

/**
 * Created by pdg on 2016/6/11.
 */
public class hm11_radio_activity extends FatherBarActivity {
    @Override
    public void child(Bundle savedInstanceState) {
        setContentView(R.layout.hm11_radio_layout);
        RadioGroup rp1= (RadioGroup) findViewById(R.id.radiogroup1);
        rp1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.male){
                    Toast.makeText(hm11_radio_activity.this, "选择了男", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(hm11_radio_activity.this, "选择了女", Toast.LENGTH_SHORT).show();
                }
            }
        });
        CheckBox cb1= (CheckBox) findViewById(R.id.zhuanke);
        CheckBox cb2= (CheckBox) findViewById(R.id.benke);
        CheckBox cb3= (CheckBox) findViewById(R.id.yanjiusheng);
        cb1.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(hm11_radio_activity.this, "选择了专科", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(hm11_radio_activity.this, "取消选择专科", Toast.LENGTH_SHORT).show();
                }
            }
        });
        cb2.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(hm11_radio_activity.this, "选择了本科", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(hm11_radio_activity.this, "取消选择本科", Toast.LENGTH_SHORT).show();
                }
            }
        });
        cb3.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(hm11_radio_activity.this, "选择了研究生", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(hm11_radio_activity.this, "取消选择研究生", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
