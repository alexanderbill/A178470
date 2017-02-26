package com.mobcent.discuz.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.appbyme.dev.R;
import com.mobcent.common.ImageLoader;
import com.mobcent.common.JsonConverter;
import com.mobcent.common.SampleSlidingTabStrip;
import com.mobcent.common.ScreenUtil;
import com.mobcent.discuz.adapter.BoardListAdapter;
import com.mobcent.discuz.api.LqForumApi;
import com.mobcent.discuz.api.Sortby;
import com.mobcent.discuz.base.Tasker;
import com.mobcent.discuz.base.UIJumper;
import com.mobcent.discuz.bean.Base;
import com.mobcent.discuz.bean.BoardListResult;
import com.mobcent.discuz.bean.ClassificationTypeListBean;
import com.mobcent.discuz.bean.MoreNewResult;
import com.mobcent.discuz.fragments.HttpResponseHandler;
import com.mobcent.discuz.ui.BoardFilterPopup;
import com.mobcent.discuz.widget.LoadMoreViewManager;
import com.mobcent.discuz.widget.ViewHolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.mobcent.discuz.widget.LoadMoreViewManager.TYPE_ERROR;
import static com.mobcent.discuz.widget.LoadMoreViewManager.TYPE_NORMAL;
import static com.mobcent.discuz.widget.LoadMoreViewManager.TYPE_NO_MORE;


/**
 * Created by sun on 2016/9/10.
 */

public class BoardListDetailActivity extends BaseRefreshActivity {
    private static final int MAX_TOP_COUNT = 3;
    private static final String[] TAB_TITLES = new String[]{"全部", "最新", "精华"};
    private static final Sortby[] TAB_SROT = new Sortby[]{Sortby.ALL, Sortby.NEW, Sortby.ESSENCE};
    private int mCurrentTabIndex = 0 ;
    private int pageNum;
    private long id;
    private Sortby sortby = Sortby.ALL;
    private LoadMoreViewManager mMoreViewManager;
    private ListView listViewTopic;
    private ViewHolder mViewHolder;
    private TextView tvFollow;
    private View headerNav;
    private BoardFilterPopup filterPopup;

    private boolean isFollow;
    final private List<MoreNewResult.ListBean> mDataSet = new ArrayList<>();
    final private List<MoreNewResult.ListBean> mDataSetAll = new ArrayList<>();
    final private List<MoreNewResult.ListBean> mDataSetNew = new ArrayList<>();
    final private List<MoreNewResult.ListBean> mDataSetEssence = new ArrayList<>();

    private BoardListAdapter mAdapter;
    private boolean isClassicPanelShow = false;
    private BoardListResult dataResult;
    private int mBoardClassId;

    public static void start(Context context, long id) {
        Intent starter = new Intent(context, BoardListDetailActivity.class);
        starter.putExtra("id", id);
        context.startActivity(starter);
    }

    @Override
    public void initParams(Bundle bundle) {
        pageNum = 1;
        id = bundle.getLong("id");
    }

    @Override
    protected View onCreateContentLayout(ViewGroup container, Bundle savedInstanceState) {
        listViewTopic = (ListView) getLayoutInflater().inflate(R.layout.listview_base, container, false);
        View contentView = getLayoutInflater().inflate(R.layout.borad_list_header, listViewTopic, false);
        mViewHolder = new ViewHolder(getContentView());
        listViewTopic.addHeaderView(contentView);
        mMoreViewManager = new LoadMoreViewManager(listViewTopic);
        mAdapter = new BoardListAdapter(this, mDataSet);
        listViewTopic.setAdapter(mAdapter);
        // tabs
        SampleSlidingTabStrip tabStrip = (SampleSlidingTabStrip) contentView.findViewById(R.id.tabs);
        tabStrip.setShouldExpand(true);
        tabStrip.setUnderlineHeight(1);
        tabStrip.setUnderlineColorResource(R.color.line_color);
        tabStrip.setIndicatorHeight(ScreenUtil.dip2px(this, 2));
        tabStrip.setIndicatorColorResource(R.color.dz_skin_custom_main_color);
        tabStrip.setTitles(Arrays.asList(TAB_TITLES));
        tabStrip.setTabChangeListener(new SampleSlidingTabStrip.OnTabChangeListener() {
            @Override
            public void onTabSelect(int pos) {
                boolean isChange = mCurrentTabIndex != pos;
                if (isChange) {
                    mCurrentTabIndex = pos;
                    sortby = TAB_SROT[pos];

                    // 指定的组别没有数据则刷新
                    if (!checkListDataValid()) {
                        showRereshingAnim();
                        onRefresh();
                    } else {
                        switchListView();
                    }
                }
            }
        });
        // 版块帖子类别
        filterPopup = new BoardFilterPopup(this);
        filterPopup.setCallback(new BoardFilterPopup.Callback() {
            @Override
            public void onItemChoose(int id) {
                boolean isChange = mBoardClassId != id;
                if (isChange) {
                    mBoardClassId = id;
                    showRereshingAnim();
                    onRefresh();
                }
            }

            @Override
            public void onDismiss() {
                if (!isClassicPanelShow) return;
                isClassicPanelShow = false;
                navIconAnim();
            }
        });
        headerNav = mViewHolder.getView(R.id.nav_expand);
        headerNav.setVisibility(View.VISIBLE);

        // 发帖
        ImageView imageView = mViewHolder.getView(R.id.nav_btn_more);
        imageView.setVisibility(View.VISIBLE);
        imageView.setImageResource(R.drawable.mc_forum_top_bar_button21_n);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dataResult != null) {
                    PublishTopicActivity.start(BoardListDetailActivity.this, dataResult.getForumInfo().getId());
                }
            }
        });

        return listViewTopic;
    }


    private void toggleFilterPopup() {
        if (dataResult == null) return;
        if (isClassicPanelShow) {
            isClassicPanelShow = false;
            filterPopup.dismiss();
        } else {
            isClassicPanelShow = true;
            filterPopup.showAsDropDown(mViewHolder.getView(R.id.nav_expand));
        }
        navIconAnim();
    }

    private void navIconAnim() {
        View expandIcon = mViewHolder.getView(R.id.nav_icon_expand);
        final RotateAnimation animation = new RotateAnimation(isClassicPanelShow ? 0 : 180f, isClassicPanelShow ? 180f : 0f, Animation.RELATIVE_TO_SELF,
                0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setFillAfter(true);
        animation.setDuration(400);
        expandIcon.startAnimation(animation);
    }

    @Override
    protected Tasker onExecuteRequest(HttpResponseHandler handler) {
        pageNum = 1;
        return LqForumApi.topicList(pageNum, getCurrentFilterId(), sortby.getName(), String.valueOf(id), this);
    }

    /**
     * api 加载更多
     */
    public void onLoadMore() {
        add(LqForumApi.topicList(++pageNum, getCurrentFilterId(), sortby.getName(), String.valueOf(id), new HttpResponseHandler() {
            @Override
            public void onSuccess(String result) {
                BoardListResult re = JsonConverter.format(result, BoardListResult.class);
                updateListView(re, false);
            }

            @Override
            public void onFail(String result) {
                mMoreViewManager.setFooterType(TYPE_ERROR);
            }
        }));
    }

    /**
     * api 关注
     *
     * @param toFollow
     */
    private void followBoard(final boolean toFollow, long id) {
        LqForumApi.userFavor((int) id, toFollow, new HttpResponseHandler() {
            @Override
            public void onSuccess(String result) {
                Base base = JsonConverter.format(result, Base.class);
                // 提示
                base.checkAlert(getBaseContext());

                // 显示
                if (base.isSuccess()) {
                    isFollow = toFollow;
                    updateFollowState(toFollow);
                }
            }

            @Override
            public void onFail(String result) {
                Base base = JsonConverter.format(result, Base.class);
                // 提示
                base.checkAlert(getBaseContext());
            }
        });

    }


    /**
     * 顶部版块分类id
     *
     * @return
     */
    private int getCurrentFilterId() {
        return mBoardClassId;
    }

    // 底部加载样式
    private void updateReplyLoadState(boolean hasMore) {
        mRefreshLayout.onLoadComplete();
        if (hasMore) {
            mRefreshLayout.setCanLoadMore();
            mMoreViewManager.setFooterType(TYPE_NORMAL);
        } else {
            mRefreshLayout.setNoMoreData();
            mMoreViewManager.setFooterType(TYPE_NO_MORE);
        }
    }

    @Override
    protected void showContent(String result) {

        dataResult = JsonConverter.format(result, BoardListResult.class);
        filterPopup.setData(dataResult);
        updateForumInfoView(dataResult.getForumInfo());
        updateTopListView(dataResult);
        updateNavExpandView(dataResult.getClassificationType_list());

        // 每次更新
        updateListView(dataResult, true);


    }

    // 顶部展开view
    private void updateNavExpandView(List<ClassificationTypeListBean> list) {
        if (list == null || list.isEmpty()) return;
        mViewHolder.getView(R.id.nav_icon_expand).setVisibility(View.VISIBLE);
        headerNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleFilterPopup();
            }
        });
    }

    private void updateTopListView(BoardListResult re) {
        ViewGroup group = mViewHolder.getView(R.id.board_top_post);
        group.removeAllViews();
        List<BoardListResult.TopTopicListBean> list = re.getTopTopicList();
        final int count = Math.min(list.size(), MAX_TOP_COUNT);
        for (int i = 0; i < count; i++) {
            View child = getLayoutInflater().inflate(R.layout.list_item_top_topic, group, false);
            group.addView(child);
            View lineView = new View(this);
            lineView.setBackgroundResource(R.color.line_color);
            group.addView(lineView, ViewGroup.LayoutParams.MATCH_PARENT, 1);
            TextView tv = (TextView) child.findViewById(R.id.text_view);
            tv.setText(list.get(i).getTitle());
            final long id = list.get(i).getId();
            child.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    UIJumper.jumpTopic(BoardListDetailActivity.this, id);
                }
            });
        }
        final long boardId = re.getForumInfo().getId();
        // 点击加载更多？
        if (list.size() > MAX_TOP_COUNT) {
            View childMore = getLayoutInflater().inflate(R.layout.list_item_top_more, group, false);
            childMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    UIJumper.jumpTopTopicList(BoardListDetailActivity.this, boardId);
                }
            });
            group.addView(childMore);
        }
    }

    private void updateForumInfoView(BoardListResult.ForumInfoBean forumInfo) {
        setHeaderTitle(forumInfo.getTitle());
        mViewHolder.setText(R.id.board_name_text, forumInfo.getTitle());
        mViewHolder.setText(R.id.board_topic_num, "主题：" + forumInfo.getPosts_total_num()
                + "  今日：" + forumInfo.getTd_posts_num());
        mViewHolder.setText(R.id.topic_list_foruminfo_boarddesc, forumInfo.getDescription());
        ImageView iconView = mViewHolder.getView(R.id.board_icon_img);
        ImageLoader.load(forumInfo.getIcon(), iconView, 8);

        // 关注版块
        tvFollow = mViewHolder.getView(R.id.topic_list_forum_focus);
        isFollow = forumInfo.getIs_focus() == 1;
        final int boardId = forumInfo.getId();
        tvFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                followBoard(!isFollow, boardId);
            }
        });
        updateFollowState(isFollow);
    }

    /**
     * 检查列表数据是否准备好，如果没有数据，调用server api
     * @return
     */
    private boolean checkListDataValid() {
        return nowDataSet().size() > 0;
    }


    private void updateListView(BoardListResult re, boolean clear) {
        if (clear) {
            mDataSet.clear();
            nowDataSet().clear();
        }
        mDataSet.addAll(re.getList());
        nowDataSet().addAll(re.getList());
        updateReplyLoadState(re.getHas_next() > 0);
        mDataSet.addAll(nowDataSet());
        mAdapter.notifyDataSetChanged();
    }

    private void switchListView() {
        mDataSet.clear();
        mDataSet.addAll(nowDataSet());
        mAdapter.notifyDataSetChanged();
    }

    private List<MoreNewResult.ListBean> nowDataSet() {
        switch (sortby) {
            case ALL:
                return mDataSetAll;
            case NEW:
                return mDataSetNew;
            case ESSENCE:
                return mDataSetEssence;
            default:
                return Collections.emptyList();
        }
    }


    // 更新关注状态
    private void updateFollowState(boolean isFollow) {
        tvFollow.setSelected(!isFollow);
        if (!isFollow) {
            tvFollow.setText(R.string.mc_forum_talk_follow);
        } else {
            tvFollow.setText(R.string.mc_forum_talk_already_follow);
        }
    }

    /**
     * 设置Navi Bar 标题
     *
     * @param title
     */
    public void setHeaderTitle(String title) {
        TextView textView = (TextView) findViewById(R.id.nav_title_sec);
        textView.setText(title);
    }

}
