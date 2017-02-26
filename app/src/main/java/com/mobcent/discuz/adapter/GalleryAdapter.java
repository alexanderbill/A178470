package com.mobcent.discuz.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.appbyme.dev.R;
import com.mobcent.common.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * 横向图片展示列表
 */
public class GalleryAdapter extends
            RecyclerView.Adapter<GalleryAdapter.ViewHolder>
    {
        private ViewGroup mContainer;
        private LayoutInflater mInflater;
        private List<String> mDatas;

        public GalleryAdapter(Context context, List<String> datats)
        {  
            mInflater = LayoutInflater.from(context);  
            mDatas = new ArrayList<>(datats);

        }

        public GalleryAdapter(Context context, ArrayList<String> arrayList, FrameLayout mPreviewLayout) {
            this(context, arrayList);
            mContainer = mPreviewLayout;
        }

        public List<String> getItem() {
            return mDatas;
        }
  
        public class ViewHolder extends RecyclerView.ViewHolder  
        {  
            public ViewHolder(View arg0)
            {  
                super(arg0);  
            }  
  
            ImageView mImg;
            View mDel;
        }  
  
        @Override  
        public int getItemCount()  
        {  
            return mDatas.size();  
        }  
  
        /** 
         * 创建ViewHolder 
         */  
        @Override  
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
        {  
            View view = mInflater.inflate(R.layout.item_pic_previeww,
                    viewGroup, false);  
            ViewHolder viewHolder = new ViewHolder(view);  
  
            viewHolder.mImg = (ImageView) view
                    .findViewById(R.id.img);
            viewHolder.mDel =  view
                    .findViewById(R.id.del);
            return viewHolder;  
        }  
  
        /** 
         * 设置值 
         */  
        @Override  
        public void onBindViewHolder(final ViewHolder viewHolder, final int i)  
        {
            ImageLoader.load(mDatas.get(i),viewHolder.mImg);
            viewHolder.mDel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mDatas.remove(i);
                    notifyDataSetChanged();
                    if(mDatas.isEmpty() && mContainer != null) {
                        mContainer.removeAllViews();
                    }
                }
            });
        }
  
    }  