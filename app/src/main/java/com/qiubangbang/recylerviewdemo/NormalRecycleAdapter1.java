package com.qiubangbang.recylerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by qiubangbang on 2017/2/7.
 */

public class NormalRecycleAdapter1 extends RecyclerView.Adapter {

    private Context mContext;
    private int mPages;

    public NormalRecycleAdapter1(Context mContext, int pages) {
        this.mContext = mContext;
        this.mPages = pages;
    }

    @Override
    public int getItemCount() {
        return 50;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_normal_adapter1, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.textView.setText("item: " + position);
        if (mPages == 3) {
            ViewGroup.LayoutParams layoutParams = myViewHolder.relativeLayout.getLayoutParams();
            layoutParams.height = (90 + new Random().nextInt(40)) * 3;
            myViewHolder.relativeLayout.setLayoutParams(layoutParams);
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        private RelativeLayout relativeLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.adapter1_rl);
        }
    }

}
