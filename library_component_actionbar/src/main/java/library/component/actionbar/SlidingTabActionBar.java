package library.component.actionbar;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import library.component.actionbar.sliding.SlidingTabLayout;


/**
 * Created by pangxiaomin on 16/11/28.
 */
public class SlidingTabActionBar extends AbsActionBar implements View.OnClickListener{

    private ImageView mLeftIcon;
    private SlidingTabLayout mSlidingTabLayout;
    private TextView mRightTitle;
    private View.OnClickListener onClickListenerRightTitle;

    public SlidingTabActionBar(Context context) {
        super(context);
    }

    public SlidingTabActionBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SlidingTabActionBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public int getLayoutId() {
        return R.layout.layout_sliding_tab_action_bar;
    }

    @Override
    public void initView(Context context) {
        super.initView(context);
        mLeftIcon = $(R.id.action_bar_left_icon);
        mSlidingTabLayout = $(R.id.action_bar_sliding_tab);
        mRightTitle = $(R.id.action_bar_right_title);

        mSlidingTabLayout.setCustomTabView(R.layout.view_sliding_tab_indicator, android.R.id.text1);
        mSlidingTabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.blue_title));
        mSlidingTabLayout.setDistributeEvenly(false);
    }

    @Override
    public void initEvent() {
        super.initEvent();
        mLeftIcon.setOnClickListener(this);
        mRightTitle.setOnClickListener(this);
    }

    public void setViewPager(ViewPager viewPager){
        mSlidingTabLayout.setViewPager(viewPager);
    }

    public void setRightTitle(int rightTitle, View.OnClickListener onClickListener){
        this.onClickListenerRightTitle = onClickListener;
        mRightTitle.setText(rightTitle);
        mRightTitle.setVisibility(VISIBLE);
    }

    public void setLeftOptionGone(){
        mLeftIcon.setVisibility(GONE);
    }

    public void setRightOptionVisible(){
        mRightTitle.setVisibility(VISIBLE);
    }

    public void setRightOptionGone(){
        mRightTitle.setVisibility(GONE);
    }

    public void setRightOptionVisibility(boolean isVisible){
        mRightTitle.setVisibility(isVisible?VISIBLE:GONE);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.action_bar_left_icon){
            ((Activity)getContext()).onBackPressed();
        }else if(v.getId() == R.id.action_bar_right_title){
            if(onClickListenerRightTitle!=null){
                onClickListenerRightTitle.onClick(v);
            }
        }
    }

    @Override
    public void setBackgroundAlpha(int alpha) {

    }
}
