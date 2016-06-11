package com.example.administrator.workspace.homework;

import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.administrator.workspace.R;

/**
 * Created by pdg on 2016/6/11.
 */
public class hm13_openlist_activity extends FatherBarActivity{
    String[] groupname={"吉林","辽宁","黑龙江","四川"};
    String[][]groupinfo={{"吉林","长春","四平"},{"沈阳","大连","鞍山"},{"哈尔滨","齐齐哈尔","佳木斯"},
            {"成都","绵阳","乐山"}};
    @Override
    public void child(Bundle savedInstanceState) {
        setContentView(R.layout.hm13_openlist_layout);
        ExpandableListAdapter ea=new ExpandableListAdapter() {
            @Override
            public void registerDataSetObserver(DataSetObserver dataSetObserver) {

            }

            @Override
            public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

            }

            @Override
            public int getGroupCount() {
                return groupname.length;
            }

            @Override
            public int getChildrenCount(int i) {
                return groupinfo[i].length;
            }

            @Override
            public Object getGroup(int i) {
                return groupname[i];
            }

            @Override
            public Object getChild(int i, int i1) {
                return  groupinfo[i][i1];
            }

            @Override
            public long getGroupId(int i) {
                return i;
            }

            @Override
            public long getChildId(int i, int i1) {
                return i1;
            }

            @Override
            public boolean hasStableIds() {
                return false;
            }

            @Override
            public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
                LayoutInflater li = LayoutInflater.from(hm13_openlist_activity.this);
                View v = li.inflate(android.R.layout.simple_list_item_1,null);
                TextView tv = (TextView) v.findViewById(android.R.id.text1);
                tv.setPadding(90,0,0,0);
                tv.setText(groupname[i]);
                return v;
            }

            @Override
            public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
                TextView tv = new TextView(hm13_openlist_activity.this);
                tv.setText(groupinfo[i][i1]);
                return tv;
            }

            @Override
            public boolean isChildSelectable(int i, int i1) {
                return false;
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
            public void onGroupExpanded(int i) {

            }

            @Override
            public void onGroupCollapsed(int i) {

            }

            @Override
            public long getCombinedChildId(long l, long l1) {
                return l1;
            }

            @Override
            public long getCombinedGroupId(long l) {
                return l;
            }
        };
        ExpandableListView ev= (ExpandableListView) findViewById(R.id.grouplist);
        ev.setAdapter(ea);
        ev.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Bundle b=new Bundle();
                b.putString("city",groupinfo[groupPosition][childPosition]);
                Intent i=new Intent(hm13_openlist_activity.this,hm25_city_Activity.class);
                i.putExtra("city",b);
                startActivity(i);
                return true;
            }
        });
    }
}
