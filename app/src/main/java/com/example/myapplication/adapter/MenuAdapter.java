package com.example.myapplication.adapter;

import android.content.Context;

import com.example.myapplication.R;
import com.example.myapplication.bean.Menu;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewAdapter;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewHolder;

/**
 * <p>描述：（这里用一句话描述这个类的作用)</p>
 * 作者： zhouyou<br>
 * 日期： 2017/12/21 14:57 <br>
 * 版本： v1.0<br>
 */
public class MenuAdapter extends HelperRecyclerViewAdapter<Menu> {
    public MenuAdapter(Context context) {
        super(context, R.layout.menu_item1);
    }

    @Override
    protected void HelperBindData(HelperRecyclerViewHolder viewHolder, int position, Menu item) {
        viewHolder.setText(R.id.number, (position + 1) + "").setText(R.id.title, item.title);
    }
}
