package com.example.myapplication.state;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.BaseActivity;
import com.example.myapplication.R;
import com.example.myapplication.adapter.MenuAdapter;
import com.example.myapplication.bean.Menu;
import com.zhouyou.recyclerview.adapter.BaseRecyclerViewAdapter;
import com.zhouyou.recyclerview.divider.HorizontalDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>描述：分割线住界面</p>
 * 作者： zhouyou<br>
 * 日期： 2017/12/22 13:38 <br>
 * 版本： v1.0<br>
 */
public class StateMainActivity extends BaseActivity {
    MenuAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.menu_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MenuAdapter(this);
        recyclerView.setAdapter(adapter);

        recyclerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(this)
                //.drawable(R.drawable.divider_sample)//.9图
                .drawable(R.drawable.divider_shape)//shape文件
                .size(10)
                .build());

        adapter.setListAll(getList());

        adapter.setOnItemClickListener(new BaseRecyclerViewAdapter.OnItemClickListener<Menu>() {
            @Override
            public void onItemClick(View view, Menu item, int position) {
                switch (item.id) {
                    case 0:
                        gotoActivity(ListEmptyStateActivity.class);
                        break;
                    case 1:
                        gotoActivity(GridEmptyStateActivity.class);
                        break;
                    case 2:
                        gotoActivity(XListEmptyStateActivity.class);
                        break;
                }
            }
        });

    }

    private List<Menu> getList() {
        List<Menu> menus = new ArrayList<>();
        menus.add(new Menu(0, "List 状态页面", ""));
        menus.add(new Menu(1, "Grid 状态页面", ""));
        menus.add(new Menu(2, "XRecyclerView List 状态页面", ""));
        return menus;
    }

    public void gotoActivity(Class clazz) {
        Intent intent = new Intent();
        intent.setClass(this, clazz);
        startActivity(intent);
    }
}
