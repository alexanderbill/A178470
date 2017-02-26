package library.component.actionbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by pangxiaomin on 16/11/28.
 */
public abstract class AbsActionBar extends RelativeLayout{

    public AbsActionBar(Context context) {
        super(context);
        initView(context);
        initEvent();
    }

    public AbsActionBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
        initEvent();
    }

    public AbsActionBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }


    public void initView(Context context){
        View.inflate(context,getLayoutId(),this);
    }

    public void initEvent(){}

    public abstract int getLayoutId();

    public abstract void setBackgroundAlpha(int alpha);

    public <T> T $(int id){
        return (T) findViewById(id);
    }

}
