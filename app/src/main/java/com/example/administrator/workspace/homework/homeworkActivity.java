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
    String[]s={"作业1：hello world！","作业2：放一个图片","作业3：获取手机分辨率","作业4：点击图片循环","作业5：画出心形","作业6：布局1","作业6：布局2","作业7：霓虹灯","作业8：位置布局","作业9：计算器","作业9_1：飞机","作业9_02:关联电话号码","作业10：qq布局","作业10_02：搜索布局","作业11：radio弹出选择内容","作业12：短信验证测试框","作业12_02：api查询手机归属地","作业13：展开的listview","作业13_02:学历列表","video",
            "作业13_03:图片自动播放","作业14：view切换","作业15：完成自动搜索","作业17：gridview两列显示图片","作业19：日期选择view跳转",
            "作业20：tabhost选项卡","作业23：多选dialog","作业24：回到桌面查看联系人发送短信","作业25：选择城市省份","作业26：横竖屏的不同排列","音频录制","录制视频","选择省份城市","frame动画","画板","下载任务","百度tts","共享stuDB","radio练习"
            ,"局部显示图片","图片上传","仿照淘宝做listview","做一个搜索框","toast3个选项卡","国际化设置","异步任务的下载显示进度条","横竖屏" };
     Class []bb={hm01_helloworldActivity.class,hm02_image_Activity.class,phone_fenbianlv.class,home_picture.class,heartActivity.class,hm06_01_Activity.class ,hm06_02_Activity.class,hm07_turncolor_Activity.class,hm08_buju_Activity.class,hm9_caiculator_Activity.class,planeActivity.class,hm09_02_Activity.class,hm10_qq_Activity.class,hm10_02_search_Activity.class,hm11_radio_activity.class,Hm12Activity.class,hm12_02_phone_city_activity.class,hm13_openlist_activity.class,hm13_02_spinner_activity.class,
                  hm13_03_taobao_activity.class,hm14_turnview_activity.class,hm15_autosearch_activity.class,hm17_gridview_activity.class,hm19_birthday_01_activity.class,
            hm20_tabhost_activity.class, hm23_much_dialog_activity.class,Telphone_Activity.class,hm25_city_Activity.class,hm26_h_v_activity.class,hm_video_Activity.class,hm_recorder_activity.class,hm_recodervideo_Activity.class,hm35_animationActivity.class,hm_board_1_Activity.class
,hm_loadfile_Activity.class,hm_baiduspeakerActivity.class,hm_Provider_Activity.class};
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
