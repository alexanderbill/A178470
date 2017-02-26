package com.mobcent.discuz.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.appbyme.dev.R;
import com.mobcent.discuz.activity.PublishTopicActivity;
import com.mobcent.discuz.activity.ReportActivity;
import com.mobcent.discuz.base.UIJumper;
import com.mobcent.discuz.bean.ManagePanelBean;
import com.mobcent.discuz.bean.Reply;
import com.mobcent.discuz.bean.TopicReply;

import java.util.List;

import static android.R.attr.id;

/**
 * Created by sun on 2016/9/2.
 */
public class TopicActionPopup extends PopupWindow implements View.OnClickListener {
    private final List<ManagePanelBean> managePanel;
    private  TopicReply reply;
    private final int viewHeight;
    Context mContext;
    private long mTopicId;

    /**
     * 回复
     * @param context
     * @param reply
     */
    public TopicActionPopup(Context context, TopicReply reply) {
        super(context);
        this.managePanel = reply.getManagePanel();
        this.reply = reply;
        mContext = context;
        setBackgroundDrawable(
                new ColorDrawable(mContext.getResources().getColor(android.R.color.transparent)));
        setOutsideTouchable(true);
        setFocusable(true);
        setWindowLayoutMode(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        LayoutInflater inflater =
                (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.topic_detail1_opt_menu, null);
        setContentView(view);
        viewHeight = view.getMeasuredHeight();

        boolean showManagePanel = managePanel == null || managePanel.isEmpty();

        View manageView = view.findViewById(R.id.menu_manage_layout);
        manageView.setVisibility(showManagePanel ? View.GONE : View.VISIBLE);
        View reportView = view.findViewById(R.id.menu_report_layout);
        reportView.setVisibility(View.GONE);
        manageView.setOnClickListener(this);
        reportView.setOnClickListener(this);
        view.findViewById(R.id.menu_comment_layout).setOnClickListener(this);
    }

    /**
     * 帖子内容操作
     * @param context
     * @param m
     */
    public TopicActionPopup(Context context, List<ManagePanelBean> m, long topicId) {
        super(context);
        mTopicId = topicId;
        this.managePanel = m;
        mContext = context;
        setBackgroundDrawable(
                new ColorDrawable(mContext.getResources().getColor(android.R.color.transparent)));
        setOutsideTouchable(true);
        setFocusable(true);
        setWindowLayoutMode(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        LayoutInflater inflater =
                (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.topic_detail1_opt_menu, null);
        setContentView(view);
        viewHeight = view.getMeasuredHeight();

        boolean showManagePanel = managePanel == null || managePanel.isEmpty();

        View manageView = view.findViewById(R.id.menu_manage_layout);
        manageView.setVisibility(showManagePanel ? View.GONE : View.VISIBLE);
        View reportView = view.findViewById(R.id.menu_report_layout);
//        reportView.setVisibility(View.GONE);
        manageView.setOnClickListener(this);
        reportView.setOnClickListener(this);
        view.findViewById(R.id.menu_comment_layout).setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.menu_comment_layout:
//                UIJumper.reply(mContext, reply.get);
                PublishTopicActivity.start(mContext, Reply.buildQuote(0, reply.getTopicId(), null, reply.getReply_posts_id()));
                break;
            case R.id.menu_report_layout:
                long id = reply == null ? mTopicId : reply.getReply_posts_id();
                ReportActivity.start(mContext, id);
                break;
            case R.id.menu_manage_layout:

                showManageDialog();
                //管理帖子
                break;

        }
        dismiss();
    }

    private void showManageDialog() {
        String[] names = new String[managePanel.size()];
        for (int i = 0; i < managePanel.size(); i++) {
            names[i] = managePanel.get(i).getTitle();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle(mContext.getString(R.string.mc_forum_topic_function))
                .setCancelable(true)
                .setItems(names, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        UIJumper.to(mContext, managePanel.get(which).getAction());
                    }
                });
        builder.create().show();
    }

    public void showAsLeft(View anchor) {
        showAsDropDown(anchor, 0, -(viewHeight + anchor.getMeasuredHeight()) / 2);
    }
}