package library.component.actionbar;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by pangxiaomin on 16/11/28.
 * 通用布局,适合左中右三部分
 */
public class AppActionBar extends AbsActionBar implements View.OnClickListener {

    private static final int ALPHA_100 = 255;
    private static final int ALPHA_60 = 153;
    private View mBackground;

    private TextView mLeftTitle;
    private ImageView mLeftIcon;

    private TextView mCenterTitle;

    private ImageView mRightIcon;
    private TextView mRightTitle;

    private View.OnClickListener onClickListenerLeftTitle;
    private View.OnClickListener onClickListenerLeftIcon;
    private View.OnClickListener onClickListenerRightIcon;
    private View.OnClickListener onClickListenerRightTitle;

    public AppActionBar(Context context) {
        super(context);
    }

    public AppActionBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AppActionBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void initView(Context context) {
        super.initView(context);
        mBackground = $(R.id.action_bar_background);
        mLeftTitle = $(R.id.action_bar_left_title);
        mLeftIcon = $(R.id.action_bar_left_icon);
        mRightIcon = $(R.id.action_bar_right_icon);
        mCenterTitle = $(R.id.action_bar_center_title);
        mRightTitle = $(R.id.action_bar_right_title);

        mCenterTitle.setText(R.string.app_name);
        mBackground.setBackgroundColor(getResources().getColor(R.color.blue_title));
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        return super.onSaveInstanceState();
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        super.onRestoreInstanceState(state);
    }

    /**设置导航栏背景色*/
    public void setBackgroundColor(int color){
        mBackground.setBackgroundColor(color);
    }

    /**右侧副标题可用状态*/
    public void setRightOptionEnable(boolean enable){
        mRightTitle.setEnabled(enable);
    }

    public boolean getRightOptionEnabled(){
        return mRightTitle.isEnabled();
    }

    @Override
    public int getLayoutId() {
        return R.layout.app_action_bar;
    }

    public void setTitle(int resourceId) {
        mCenterTitle.setText(getResources().getString(resourceId));
    }

    public void setTitle(String title) {
        mCenterTitle.setText(title);
    }

    public String getTitle(){
        return mCenterTitle.getText().toString();
    }

    public void setLeftOptionVisible(){
        mLeftIcon.setVisibility(VISIBLE);
    }

    public void setLeftOptionGone(){
        mLeftIcon.setVisibility(GONE);
    }
    public void setRightOptionVisible(){
        mRightIcon.setVisibility(VISIBLE);
        mRightTitle.setVisibility(VISIBLE);
    }

    public void setRightOptionGone(){
        mRightIcon.setVisibility(GONE);
        mRightTitle.setVisibility(GONE);
    }

    /**用于背景渐变*/
    @Override
    public void setBackgroundAlpha(int alpha){
        if(alpha == 0){
            mBackground.setBackgroundColor(getResources().getColor(R.color.transparent));
        }else{
            mBackground.setBackgroundColor(getResources().getColor(R.color.blue_title));
            mBackground.getBackground().setAlpha(alpha);
        }

        if(alpha > 153){//超过60%
            mCenterTitle.setTextColor(getResources().getColor(R.color.white_title));
            int currentTextColor = mCenterTitle.getCurrentTextColor();
            //字体的渐变需要重新计算,背景60%-100% 时对应字体0%-100%
            float alphaText =  (((float)alpha-ALPHA_60)/(ALPHA_100-ALPHA_60))*ALPHA_100;
            mCenterTitle.setTextColor(Color.argb((int)alphaText, Color.red(currentTextColor), Color.green(currentTextColor), Color.blue(currentTextColor)));
        }else{
            mCenterTitle.setTextColor(getResources().getColor(R.color.transparent));
        }
    }

    @Override
    public void initEvent() {
        super.initEvent();
        mLeftIcon.setOnClickListener(this);
        mRightIcon.setOnClickListener(this);
        mRightTitle.setOnClickListener(this);
        this.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.action_bar_left_icon){

            if(onClickListenerLeftIcon != null){
                onClickListenerLeftIcon.onClick(v);
            }else{
                ((Activity)getContext()).onBackPressed();
            }

        } if(v.getId() == R.id.action_bar_left_title){

            if(onClickListenerLeftTitle != null){
                onClickListenerLeftTitle.onClick(v);
            }else{
                ((Activity)getContext()).onBackPressed();
            }

        }else if(v.getId() == R.id.action_bar_right_icon){

            if(onClickListenerRightIcon != null){
                onClickListenerRightIcon.onClick(v);
            }

        }else if(v.getId() == R.id.action_bar_right_title){

            if(onClickListenerRightTitle != null){
                onClickListenerRightTitle.onClick(v);
            }

        }
    }

    public void setLeftIcon(int resourceId, View.OnClickListener onClickListener){
        this.onClickListenerLeftIcon = onClickListener;
        mLeftIcon.setImageResource(resourceId);
    }

    public void setRightIcon(int resourceId, View.OnClickListener onClickListener){
        this.onClickListenerRightIcon = onClickListener;
        mRightIcon.setImageResource(resourceId);
        mRightTitle.setVisibility(GONE);
        mRightIcon.setVisibility(VISIBLE);
    }

    public void setLeftTitle(int leftTitle, View.OnClickListener onClickListener){
        this.onClickListenerLeftTitle = onClickListener;
        mLeftTitle.setText(leftTitle);
        mLeftTitle.setVisibility(VISIBLE);
        mLeftIcon.setVisibility(GONE);
    }

    public void setRightTitle(int rightTitle, View.OnClickListener onClickListener){
        this.onClickListenerRightTitle = onClickListener;
        mRightTitle.setText(rightTitle);
        mRightTitle.setVisibility(VISIBLE);
        mRightIcon.setVisibility(GONE);
    }

    public void setRightTitle(String rightTitle, View.OnClickListener onClickListener){
        this.onClickListenerRightTitle = onClickListener;
        mRightTitle.setText(rightTitle);
        mRightTitle.setVisibility(VISIBLE);
        mRightIcon.setVisibility(GONE);
    }

    public View getRightTitleView(){
        return mRightTitle;
    }

}
