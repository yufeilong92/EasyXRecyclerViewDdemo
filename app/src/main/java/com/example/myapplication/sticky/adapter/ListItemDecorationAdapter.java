package com.example.myapplication.sticky.adapter;

import android.content.Context;

import com.example.myapplication.R;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewAdapter;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewHolder;

/**
 * <p>描述：ItemDecoration adapter演示</p>
 * 作者： zhouyou<br>
 * 日期： 2018/6/27 11:12 <br>
 * 版本： v1.0<br>
 */
public class ListItemDecorationAdapter extends HelperRecyclerViewAdapter<StockInfo> {
    public ListItemDecorationAdapter(Context context) {
        super(context, R.layout.item_dectoration_data, R.layout.item_dectoration_header);
    }

    @Override
    protected void HelperBindData(HelperRecyclerViewHolder viewHolder, int position, StockInfo item) {
        if (item.getItemType() == StockInfo.TYPE_HEADER) {//是Sticky item
            viewHolder.setText(R.id.tv_title, item.getName());
        } else if (item.getItemType() == StockInfo.TYPE_DATA) {//是data item
            viewHolder.setText(R.id.tv_title, item.getName());
        }
    }

    //不重写的时候返回默认是0，也就是只会加载第一个布局
    @Override
    public int checkLayout(StockInfo item, int position) {
        if(item.getItemType()==StockInfo.TYPE_HEADER){
            return 1;
        }else {
            return 0;
        }
    }
}


