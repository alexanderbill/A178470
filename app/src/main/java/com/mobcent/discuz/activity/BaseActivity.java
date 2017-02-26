package com.mobcent.discuz.activity;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.litesuits.android.log.Log;
import com.mobcent.common.BackHandlerHelper;
import com.mobcent.discuz.application.DiscuzApplication;
import com.mobcent.discuz.base.TaskCleaner;
import com.mobcent.discuz.base.Tasker;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sun on 2016/8/29.
 */

public abstract  class BaseActivity extends FragmentActivity implements TaskCleaner {
    public static final int STATE_NONE = 0;
    public static final int STATE_REFRESH = 1;
    public static final int STATE_LOADMORE = 2;
    public static final int STATE_NOMORE = 3;
    public static final int STATE_PRESSNONE = 4;// 正在下拉但还没有到刷新的状态

    public static int mState = STATE_NONE;

    /** 是否沉浸状态栏 **/
    private boolean isSetStatusBar = false;
    /** 是否允许全屏 **/
    private boolean mAllowFullScreen = false;
    /** 是否输出日志信息 **/
    private boolean isDebug;
    private String APP_NAME;
    protected final String TAG = this.getClass().getSimpleName();
    protected ViewGroup mActivityContentView;

    /** 待清除任务队列 */
    final private List<Tasker> mNeedCancleTasks = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isDebug = DiscuzApplication.isDebug;
        APP_NAME = "LqForum";
        $Log(TAG + "-->onCreate()");
        Bundle bundle = getIntent().getExtras();
        initParams(bundle);
        mActivityContentView = (ViewGroup) getLayoutInflater()
                .inflate(bindLayout(), null);
        if (mAllowFullScreen) {
            this.getWindow().setFlags(
                    WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
            requestWindowFeature(Window.FEATURE_NO_TITLE);
        }
        if (isSetStatusBar) {
            steepStatusBar();
        }
        setContentView(mActivityContentView);
        initView(mActivityContentView, savedInstanceState);
        initData(this);
    }



    /**
     * [沉浸状态栏]
     */
    private void steepStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 透明状态栏
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 透明导航栏
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    /**
     * [初始化Bundle参数]
     *
     * @param bundle
     */
    public abstract void initParams(Bundle bundle);

    /**
     * [绑定布局]
     *
     * @return
     */
    public abstract int bindLayout();


    /**
     * [初始化控件]
     *
     * @param container
     * @param savedInstanceState
     */
    public abstract void initView(ViewGroup container, Bundle savedInstanceState);

    /**
     * [业务操作]
     *
     * @param mContext
     */
    public abstract void initData(Context mContext);

    public View getContentView() {
        return mActivityContentView;
    }

    /**
     * 添加待销毁任务
     * @param tasker
     */
    public void addPendingCancelTask(Tasker tasker) {
        mNeedCancleTasks.add(tasker);
    }

    @Override
    public void add(Tasker tasker) {
        mNeedCancleTasks.add(tasker);
    }

    @Override
    public void clean(Tasker tasker) {
        if (tasker != null && tasker.isRunning()) {
            tasker.cancel();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        $Log(TAG + "--->onResume()");
    }

    @Override
    public void onBackPressed() {
        if (!BackHandlerHelper.handleBackPress(this)) {
            super.onBackPressed();
        }
    }

    @Override
    protected void onDestroy() {
        for (Tasker tasker : mNeedCancleTasks) {
           clean(tasker);
        }
        super.onDestroy();
        $Log(TAG + "--->onDestroy()");
    }

    /**
     * [是否允许全屏]
     *
     * @param allowFullScreen
     */
    public void setAllowFullScreen(boolean allowFullScreen) {
        this.mAllowFullScreen = allowFullScreen;
    }

    /**
     * [是否设置沉浸状态栏]
     *
     */
    public void setSteepStatusBar(boolean isSetStatusBar) {
        this.isSetStatusBar = isSetStatusBar;
    }

    /**
     * [日志输出]
     *
     * @param msg
     */
    protected void $Log(String msg) {
        if (isDebug) {
            Log.d(APP_NAME, msg);
        }
    }

}
