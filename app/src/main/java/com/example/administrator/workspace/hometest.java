package com.example.administrator.workspace;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.administrator.workspace.homework.phone_fenbianlv;

/**
 * Created by pdg on 2016/5/29.
 */
public class hometest extends Activity {
    Intent ii;
    ListView lv;
    String[]s={"获取手机分辨率","点击图片循环","画出心形","霓虹灯","飞机","计算器布局","短信验证测试框","弹球游戏","手机归属地","下拉列表先是学历","radio练习"
            ,"局部显示图片","图片上传","完成自动搜索","仿照淘宝做listview","做一个搜索框","toast3个选项卡","国际化设置","异步任务的下载显示进度条","横竖屏"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homework_layout);
        lv= (ListView) findViewById(R.id.home_list);
        ArrayAdapter aa=new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,s);
        lv.setAdapter(aa);
                    lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            if (i==0){
                                ii =new Intent(hometest.this,phone_fenbianlv.class);
                                startActivity(ii);
                }
            }
        });

    }
}
