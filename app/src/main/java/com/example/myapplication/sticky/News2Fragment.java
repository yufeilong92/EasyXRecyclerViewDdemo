package com.example.myapplication.sticky;

import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.myapplication.R;
import com.example.myapplication.adapter.MyAdapter;
import com.example.myapplication.bean.TestBean;
import com.example.myapplication.refresh.BaseFragment;
import com.zhouyou.recyclerview.XRecyclerView;
import com.zhouyou.recyclerview.adapter.BaseRecyclerViewAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>描述：新闻fragemnt</p>
 * 作者： zhouyou<br>
 * 日期： 2018/1/24 15:25 <br>
 * 版本： v1.0<br>
 */
public class News2Fragment extends BaseFragment {
    private XRecyclerView mRecyclerView;
    private MyAdapter mAdapter;
    private String new_name;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_recyclerview;
    }

    @Override
    protected void initView(View contentView) {
        mRecyclerView = findView(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        
        mRecyclerView.setLoadingMoreEnabled(true);
        mRecyclerView.setPullRefreshEnabled(false);

        mRecyclerView.setHasFixedSize(true);
        
        mAdapter = new MyAdapter(mContext);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void bindEvent() {
        mRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
            }

            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        List<TestBean> list = new ArrayList<TestBean>();
                        int size = mAdapter.getItemCount();//适配器中已有的数据
                        for (int i = 0; i < 30; i++) {
                            String name = new_name + "  张三:" + (i + size);
                            String age = new_name + "   年龄:" + (i + size);
                            TestBean testBean = new TestBean(name, age);
                            list.add(testBean);
                        }

                        mAdapter.addItemsToLast(list);
                        mRecyclerView.refreshComplete();
                        mRecyclerView.setLoadingMoreEnabled(true);
                    }
                }, 3000);
            }
        });

        //设置item事件监听
        mAdapter.setOnItemClickListener(new BaseRecyclerViewAdapter.OnItemClickListener<TestBean>() {
            @Override
            public void onItemClick(View view, TestBean item, int position) {
                Toast.makeText(mContext, "我是item " + position, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void initData() {
        new_name = getArguments().getString("name");
        List<TestBean> list = new ArrayList<TestBean>();
        int size = mAdapter.getItemCount();//适配器中已有的数据
        for (int i = 0; i < 30; i++) {
            String name = new_name + "  张三:" + (i + size);
            String age = new_name + "   年龄:" + (i + size);
            TestBean testBean = new TestBean(name, age);
            list.add(testBean);
        }
        mAdapter.setListAll(list);
    }

}
