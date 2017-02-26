package com.mobcent.discuz.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.appbyme.dev.R;
import com.mobcent.discuz.bean.BoardListResult;
import com.mobcent.discuz.bean.ClassificationTypeListBean;
import com.mobcent.discuz.widget.ComAdapter;
import com.mobcent.discuz.widget.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sun on 2016/9/9.
 * 版块分类筛选
 */

public class BoardFilterPopup extends BasePopup {
    private final GridView gridView;
    private final ClassificationTypeListBean mDefaultBean;
    private Callback callback;
    private final List<ClassificationTypeListBean> list = new ArrayList<>();
    private boolean noRefresh = true;

    public BoardFilterPopup(final Context context) {
        super(context);
        setWindowLayoutMode(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        gridView = (GridView) getContentView().findViewById(R.id.popup_grid_view);
        gridView.setBackgroundResource(R.color.white);
        getContentView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        mDefaultBean = new ClassificationTypeListBean();
        mDefaultBean.setClassificationType_id(0);
        mDefaultBean.setClassificationType_name("全部");
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }


    public void setData(BoardListResult result) {
        if (noRefresh && list.size() > 0) return;

        list.clear();
        list.add(mDefaultBean);
        list.addAll(result.getClassificationType_list());
        gridView.setAdapter(new ComAdapter<ClassificationTypeListBean>(mContext, R.layout.popup_grid_item, list
        ) {
            @Override
            public void customSet(ViewHolder holder, final int position) {
                holder.setText(R.id.popup_grid_text, getItem(position).getClassificationType_name());
                holder.getConvertView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (callback != null) {
                            callback.onItemChoose(getItem(position).getClassificationType_id());
                        }
                        dismiss();
                    }
                });
            }
        });
    }

    @Override
    public void dismiss() {
        super.dismiss();
        if (callback != null) {
            callback.onDismiss();
        }
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.popup_list_view;
    }

    public interface Callback {
        void onItemChoose(int id);
        void onDismiss();
    }

}
