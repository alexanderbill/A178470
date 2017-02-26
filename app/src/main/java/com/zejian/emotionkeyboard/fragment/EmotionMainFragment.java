package com.zejian.emotionkeyboard.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.appbyme.dev.R;
import com.mobcent.common.FragmentBackHandler;
import com.zejian.emotionkeyboard.adapter.NoHorizontalScrollerVPAdapter;
import com.zejian.emotionkeyboard.emotionkeyboardview.EmotionKeyboard;
import com.zejian.emotionkeyboard.emotionkeyboardview.NoHorizontalScrollerViewPager;
import com.zejian.emotionkeyboard.model.ImageModel;
import com.zejian.emotionkeyboard.utils.EmotionUtils;
import com.zejian.emotionkeyboard.utils.GlobalOnItemClickManagerUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zejian
 * Time  16/1/6 下午5:26
 * Email shinezejian@163.com
 * Description:表情主界面
 */
public class EmotionMainFragment extends BaseFragment implements FragmentBackHandler {
    //是否隐藏bar上的编辑框和发生按钮
    public static final String HIDE_BAR_EDITTEXT_AND_BTN="hide bar's editText and btn";

    //当前被选中底部tab
    private static final String CURRENT_POSITION_FLAG="CURRENT_POSITION_FLAG";

    //表情面板
    protected EmotionKeyboard mEmotionKeyboard;

    protected EditText bar_edit_text;
    protected ImageView bar_image_add_btn;
    protected Button bar_btn_send;
    protected LinearLayout rl_editbar_bg;

    //需要绑定的内容view
    private View contentView;

    //不可横向滚动的ViewPager
    private NoHorizontalScrollerViewPager viewPager;

    //是否隐藏bar上的编辑框和发生按钮,默认不隐藏
    private boolean isHidenBarEditTextAndBtn=false;

    protected List<Fragment> fragments=new ArrayList<>();

    // 自己指定的EditText
    private EditText mCustomEditText;


    /**
     * 创建与Fragment对象关联的View视图时调用
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main_emotion, container, false);
        isHidenBarEditTextAndBtn= args.getBoolean(EmotionMainFragment.HIDE_BAR_EDITTEXT_AND_BTN);
        initView(rootView);
        mEmotionKeyboard = EmotionKeyboard.with(getActivity())
                .setEmotionView(rootView.findViewById(R.id.ll_emotion_layout))//绑定表情面板
                .bindToContent(contentView)//绑定内容view
                .bindToEditText(useCustomEditText() ? mCustomEditText : ((EditText) rootView.findViewById(R.id.bar_edit_text)))//判断绑定那种EditView
                .bindToEmotionButton(rootView.findViewById(R.id.emotion_button));//绑定表情按钮
        if (enableExtraPanel()) {
            mEmotionKeyboard.bindExtraButton(rootView.findViewById(R.id.bar_image_add_btn), viewPager);
        }
        mEmotionKeyboard.build();
        initListener();
        initDatas();
        //创建全局监听
        GlobalOnItemClickManagerUtils globalOnItemClickManager= GlobalOnItemClickManagerUtils.getInstance(getActivity());

        if(useCustomEditText()){
            // 使用指定的CustomEditText
            globalOnItemClickManager.attachToEditText(mCustomEditText);
            mEmotionKeyboard.bindToEditText(mCustomEditText);
        }else{
            //绑定当前Bar的编辑框
            globalOnItemClickManager.attachToEditText(bar_edit_text);
        }
        return rootView;
    }

    private boolean useCustomEditText() {
        return mCustomEditText != null;
    }

    /**
     * 获得内容页面
     * @return
     */
    public EditText getEditText() {
       return (EditText) getView().findViewById(R.id.bar_edit_text);
    }

    /**
     * 绑定内容view
     * @param contentView
     * @return
     */
    public void bindToContentView(View contentView){
        this.contentView=contentView;
    }

    public void hidePanel() {
        mEmotionKeyboard.hideAllPanel();
    }

    /**
     * 设定指定的EditText
     * @param editText
     */
    public void bindCustomEditText(EditText editText){
        mCustomEditText = editText;
    }

    /**
     * 初始化view控件
     */
    protected void initView(View rootView){
        viewPager= (NoHorizontalScrollerViewPager) rootView.findViewById(R.id.vp_emotionview_layout);

        bar_edit_text= (EditText) rootView.findViewById(R.id.bar_edit_text);
        bar_image_add_btn= (ImageView) rootView.findViewById(R.id.bar_image_add_btn);
        bar_btn_send= (Button) rootView.findViewById(R.id.bar_btn_send);
        rl_editbar_bg= (LinearLayout) rootView.findViewById(R.id.rl_editbar_bg);
        if(isHidenBarEditTextAndBtn){//隐藏
            bar_edit_text.setVisibility(View.GONE);
            bar_image_add_btn.setVisibility(View.GONE);
            bar_btn_send.setVisibility(View.GONE);
            rl_editbar_bg.setBackgroundResource(R.color.bg_edittext_color);
        }else{
            bar_edit_text.setVisibility(View.VISIBLE);
            bar_image_add_btn.setVisibility(View.VISIBLE);
            bar_btn_send.setVisibility(View.VISIBLE);
            rl_editbar_bg.setBackgroundResource(R.drawable.shape_bg_reply_edittext);
        }
    }

    //-------------------- 子类继承用------------------------------

    /**
     * 初始化监听器
     */
    protected void initListener(){

    }

    /**
     * 数据操作,这里是测试数据，请自行更换数据
     */
    protected void initDatas(){
        //创建fragment的工厂类
        FragmentFactory factory=FragmentFactory.getSingleFactoryInstance();
        //创建修改实例
        EmotiomComplateFragment f1= (EmotiomComplateFragment) factory.getFragment(EmotionUtils.EMOTION_CLASSIC_TYPE);
        fragments.add(f1);
        addOtherPanelFragment(fragments);
        NoHorizontalScrollerVPAdapter adapter =new NoHorizontalScrollerVPAdapter(getActivity().getSupportFragmentManager(),fragments);
        viewPager.setAdapter(adapter);
    }

    protected void addOtherPanelFragment(List<Fragment> fragments) {

    }

    protected boolean enableExtraPanel() {
        return false;
    }

    //------------------------------------------------------------

    /**
     * 是否拦截返回键操作，如果此时表情布局未隐藏，先隐藏表情布局
     * @return true则隐藏表情布局，拦截返回键操作
     *         false 则不拦截返回键操作
     */
    public boolean isInterceptBackPress(){
        return mEmotionKeyboard.interceptBackPress();
    }

    @Override
    public boolean onBackPressed() {
        return isInterceptBackPress();
    }
}


