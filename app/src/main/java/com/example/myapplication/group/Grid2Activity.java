package com.example.myapplication.group;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.BaseActivity;
import com.example.myapplication.R;
import com.example.myapplication.group.adapter.GroupedGridSpanListAdapter;
import com.example.myapplication.group.bean.GroupBean;
import com.example.myapplication.group.util.GroupModel;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewHolder;


/**
 * 子项为Grid布局的分组列表。给RecyclerView的LayoutManager
 * 设置为{@link GroupedGridLayoutManager}即可。
 */
public class Grid2Activity extends BaseActivity {

    private RecyclerView rvList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_list);

        rvList = (RecyclerView) findViewById(R.id.rv_list);

        GroupedGridSpanListAdapter adapter = new GroupedGridSpanListAdapter(this, GroupModel.getGroups(20, 5));
        adapter.setOnHeaderClickListener(new com.zhouyou.recyclerview.group.GroupedRecyclerViewAdapter.OnHeaderClickListener<GroupBean>() {
            @Override
            public void onHeaderClick(com.zhouyou.recyclerview.group.GroupedRecyclerViewAdapter adapter, HelperRecyclerViewHolder holder, int groupPosition, GroupBean item) {
                Toast.makeText(Grid2Activity.this, "组头：groupPosition = " + groupPosition,
                        Toast.LENGTH_LONG).show();
            }
        });
        adapter.setOnFooterClickListener(new com.zhouyou.recyclerview.group.GroupedRecyclerViewAdapter.OnFooterClickListener<GroupBean>() {
            @Override
            public void onFooterClick(com.zhouyou.recyclerview.group.GroupedRecyclerViewAdapter adapter, HelperRecyclerViewHolder holder,
                                      int groupPosition, GroupBean item) {
                Toast.makeText(Grid2Activity.this, "组尾：groupPosition = " + groupPosition,
                        Toast.LENGTH_LONG).show();
            }
        });
        adapter.setOnChildClickListener(new com.zhouyou.recyclerview.group.GroupedRecyclerViewAdapter.OnChildClickListener<GroupBean>() {
            @Override
            public void onChildClick(com.zhouyou.recyclerview.group.GroupedRecyclerViewAdapter adapter, HelperRecyclerViewHolder holder,
                                     int groupPosition, int childPosition, GroupBean item) {
                Toast.makeText(Grid2Activity.this, "子项：groupPosition = " + groupPosition
                                + ", childPosition = " + childPosition,
                        Toast.LENGTH_LONG).show();
            }
        });

        //必须放在setAdapter之前，切记！切记！切记！
        rvList.setLayoutManager(new GridLayoutManager(this, 3));
        
        rvList.setAdapter(adapter);
    }
}
