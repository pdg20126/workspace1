package com.example.administrator.workspace.homework;

import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.administrator.workspace.R;

/**
 * Created by Administrator on 2016/5/31.
 */
public class hm25_city2_Activity extends FatherBarActivity {
    String[]pro={"黑龙江","辽 宁"};
    String[][]city={{"哈尔滨","佳木斯"},{"沈阳","大连"}};
    ExpandableListView elv;

    @Override
    public void child(Bundle savedInstanceState) {
        setContentView(R.layout.hm25_city2_layout);
        elv= (ExpandableListView) findViewById(R.id.city);
        ExpandableListAdapter ela=new ExpandableListAdapter() {
            @Override
            public void registerDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public void unregisterDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public int getGroupCount() {
                return pro.length;
            }

            @Override
            public int getChildrenCount(int groupPosition) {
                return city.length;
            }

            @Override
            public Object getGroup(int groupPosition) {
                return pro[groupPosition];
            }

            @Override
            public Object getChild(int groupPosition, int childPosition) {
                return city[groupPosition][childPosition];
            }

            @Override
            public long getGroupId(int groupPosition) {
                return groupPosition;
            }

            @Override
            public long getChildId(int groupPosition, int childPosition) {
                return childPosition;
            }

            @Override
            public boolean hasStableIds() {
                return false;
            }

            @Override
            public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
                TextView tv=new TextView(hm25_city2_Activity.this);
                tv.setText(pro[groupPosition]);
                return tv;
            }

            @Override
            public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
                TextView tv=new TextView(hm25_city2_Activity.this);
                tv.setText(city[groupPosition][childPosition]);
                return tv;
            }

            @Override
            public boolean isChildSelectable(int groupPosition, int childPosition) {
                return true;
            }

            @Override
            public boolean areAllItemsEnabled() {
                return false;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public void onGroupExpanded(int groupPosition) {

            }

            @Override
            public void onGroupCollapsed(int groupPosition) {

            }

            @Override
            public long getCombinedChildId(long groupId, long childId) {
                return 0;
            }

            @Override
            public long getCombinedGroupId(long groupId) {
                return 0;
            }
        };
        elv.setAdapter(ela);
        elv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Intent i=getIntent();
                i.putExtra("city",city[groupPosition][childPosition]);
                setResult(123,i);
                finish();
                return true;
            }
        });

    }
}
