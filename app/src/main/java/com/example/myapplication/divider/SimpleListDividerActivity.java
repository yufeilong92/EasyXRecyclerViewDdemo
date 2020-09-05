package com.example.myapplication.divider;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.BaseActivity;
import com.example.myapplication.R;
import com.example.myapplication.adapter.MenuAdapter;
import com.example.myapplication.bean.Menu;

import java.util.ArrayList;
import java.util.List;

public class SimpleListDividerActivity extends BaseActivity {
    MenuAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.menu_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        
        recyclerView.addItemDecoration(new com.zhouyou.recyclerview.divider.HorizontalDividerItemDecoration.Builder(this).build());
        
        adapter = new MenuAdapter(this);
        recyclerView.setAdapter(adapter);
        adapter.setListAll(getList());
    }

    private List<Menu> getList() {
        List<Menu> menus = new ArrayList<>();
        int count=50;
        for (int i = 0; i < count; i++) {
            menus.add(new Menu(i, "测试", ""));
        }
        return menus;
    }
}
