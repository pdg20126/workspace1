package com.example.administrator.workspace.homework;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.administrator.workspace.homework.FatherBarActivity;
import com.example.administrator.workspace.R;

/**
 * Created by pdg on 2016/5/29.
 */
public class homeworkActivity extends FatherBarActivity {

    ListView lv;
    String[]s={"获取手机分辨率","点击图片循环","画出心形","短信验证测试框","回到桌面查看联系人发送短信","选择省份城市","计算器布局","弹球游戏","手机归属地","下拉列表先是学历","radio练习"
            ,"局部显示图片","图片上传","完成自动搜索","仿照淘宝做listview","做一个搜索框","toast3个选项卡","国际化设置","异步任务的下载显示进度条","横竖屏"};
     Class []bb={phone_fenbianlv.class,home_picture.class,heartActivity.class, Hm12Activity.class,Telphone_Activity.class,hm25_city_Activity.class};
    @Override
    public void child(Bundle savedInstanceState) {
        setContentView(R.layout.homework_layout);
        lv= (ListView) findViewById(R.id.home_list);
        final ArrayAdapter aa=new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,s);
        lv.setAdapter(aa);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent ii=new Intent(homeworkActivity.this,bb[i]);
                 startActivity(ii);


            }
        });
    }
}
