package com.example.administrator.workspace.homework;

import android.app.Activity;
import android.content.CursorLoader;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.workspace.R;

/**
 * Created by Administrator on 2016/5/31.
 */
public class Telphone_Activity extends FatherBarActivity {
    TextView pName;
    TextView pNum;
    @Override
    public void child(Bundle savedInstanceState) {
        setContentView(R.layout.telphone_layout);
        Button bt= (Button) findViewById(R.id.btn1);
        pName= (TextView) findViewById(R.id.show);
        pNum= (TextView) findViewById(R.id.phone);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent();
                i.setAction(Intent.ACTION_GET_CONTENT);
                i.setType("vnd.android.cursor.item/phone");
                startActivityForResult(i,0);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==0&&requestCode== Activity.RESULT_OK){
            Uri u=data.getData();
            CursorLoader cl=new CursorLoader(this,u,null,null,null,null);
            Cursor c=cl.loadInBackground();
            if (c.moveToFirst()){
                String contactId=c.getString(c.getColumnIndex(ContactsContract.Contacts._ID));
                String name = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                String phoneNum="查无此人";
                Cursor phoneC = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,ContactsContract.CommonDataKinds.Phone.CONTACT_ID+" = "+contactId,null,null);
                while(phoneC.moveToNext())
                {
                    phoneNum = phoneNum + " " + phoneC.getString(phoneC.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                }

                phoneC.close();
                pName.setText(name);
                pNum.setText(phoneNum);
            }
            c.close();
        }
    }
    public void callOther(View view)
    {
        Intent i = new Intent();
        i.setAction(Intent.ACTION_DIAL);
        String data = "tel:15040138915";
        i.setData(Uri.parse(data));
        startActivity(i);
    }
    public void returnHome(View view){
        Intent i=new Intent();
        i.setAction(Intent.ACTION_MAIN);
       i.addCategory(Intent.CATEGORY_HOME);
        startActivity(i);
    }
    public  void turnbaidu(View view){

        Uri uri = Uri.parse("http://www.baidu.com");
        i = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(i);
    }
    public void sendMsg(View view){
       /* i=new Intent(Intent.ACTION_VIEW);
        i.putExtra("sms-body","The sms text");
        i.setType("vnd.android-dir/mns-sms");
        startActivity(i);*/
        Uri uri = Uri.parse("smsto:18321804319");
        i = new Intent(Intent.ACTION_SENDTO, uri);
        i.putExtra("sms_body","瞅啥呢！\n瞅你咋地");
        startActivity(i);
    }
}
