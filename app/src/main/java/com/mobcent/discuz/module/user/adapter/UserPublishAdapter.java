package com.mobcent.discuz.module.user.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.appbyme.dev.R;
import com.mobcent.discuz.module.user.adapter.viewholder.ItemPublishViewHolder;

/**
 * Created by pangxiaomin on 16/11/20.
 */
public class UserPublishAdapter extends RecyclerView.Adapter {

    private Context context;

    public UserPublishAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemPublishViewHolder(View.inflate(context, R.layout.item_recycler_publish,null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }
}
