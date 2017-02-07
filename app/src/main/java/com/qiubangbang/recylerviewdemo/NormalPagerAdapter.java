package com.qiubangbang.recylerviewdemo;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by qiubangbang on 2017/2/7.
 */

public class NormalPagerAdapter extends PagerAdapter {

    private String[] title = new String[]{"垂直", "水平", "瀑布流"};
    private int[] layout = new int[]{R.layout.normal_adapter1, R.layout.normal_adapter2, R.layout.normal_adapter3};
    private RecyclerView rv1;
    private RecyclerView rv2;
    private RecyclerView rv3;
    private Context mContext;

    public NormalPagerAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = View.inflate(mContext, layout[position], null);
        switch (position) {
            case 0:
                rv1 = (RecyclerView) view.findViewById(R.id.adapter1_recycler);
                rv1.setLayoutManager(new LinearLayoutManager(mContext));
                rv1.setAdapter(new NormalRecycleAdapter1(mContext,1));
                //添加分割线
                rv1.addItemDecoration(new CustomItemDecotor(mContext));
                break;
            case 1:
                rv2 = (RecyclerView) view.findViewById(R.id.adapter2_recycler);
                rv2.setLayoutManager(new GridLayoutManager(mContext, 4));
                rv2.setAdapter(new NormalRecycleAdapter1(mContext,2));
                break;
            case 2:
                rv3 = (RecyclerView) view.findViewById(R.id.adapter3_recycler);
                rv3.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
                rv3.setAdapter(new NormalRecycleAdapter1(mContext,3));
                break;
        }
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return title[position];
    }
}
