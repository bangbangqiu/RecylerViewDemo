package com.qiubangbang.recylerviewdemo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RecyclerViewBaseUseActivity extends AppCompatActivity {

    @Bind(R.id.viewpager)
    ViewPager viewpager;
    @Bind(R.id.activity_recycler_view_base_use)
    RelativeLayout activityRecyclerViewBaseUse;
    @Bind(R.id.tabLayout)
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_base_use);
        ButterKnife.bind(this);
        initData();
        eventBind();
        tabLayout.setupWithViewPager(viewpager);

    }

    private void initData() {
        viewpager.setAdapter(new NormalPagerAdapter(this));
    }

    private void eventBind() {
    }
}
