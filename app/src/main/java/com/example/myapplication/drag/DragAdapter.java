package com.example.myapplication.drag;

import android.content.Context;

import com.example.myapplication.R;
import com.example.myapplication.util.MakePicUtil;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewDragAdapter;
import com.zhouyou.recyclerview.adapter.HelperRecyclerViewHolder;

/**
 * <p>描述：item可以移动拖拽的适配器</p>
 *
 *
 * 作者： zhouyou<br>
 * 日期： 2016/10/31 16:24<br>
 * 版本： v2.0<br>
 */
public class DragAdapter extends HelperRecyclerViewDragAdapter<String> {
    public DragAdapter(Context context) {
        super(context, R.layout.adapter_draggable_layout);
    }

    @Override
    protected void HelperBindData(HelperRecyclerViewHolder viewHolder, int position, String item) {
        viewHolder.setText(R.id.tv,item).setImageResource(R.id.image, MakePicUtil.makePic(position));
    }
}
