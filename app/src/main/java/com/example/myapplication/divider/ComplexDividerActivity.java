package com.example.myapplication.divider;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;


import com.example.myapplication.BaseActivity;
import com.example.myapplication.R;
import com.example.myapplication.bean.Menu;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>描述：复杂分割线</p>
 * 作者： zhouyou<br>
 * 日期： 2017/12/22 13:38 <br>
 * 版本： v1.0<br>
 */
public class ComplexDividerActivity extends BaseActivity {
    ComplexAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
        
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.menu_recyclerview);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
            recyclerView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(OrientationHelper.VERTICAL);
        recyclerView.setLayoutManager(manager);
        adapter = new ComplexAdapter(this);
        recyclerView.setAdapter(adapter);

        //复杂的分割线
        recyclerView.addItemDecoration(new com.zhouyou.recyclerview.divider.HorizontalDividerItemDecoration.Builder(this)
                .paintProvider(adapter)
                .visibilityProvider(adapter)
                .marginProvider(adapter)
                .build());
        
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
