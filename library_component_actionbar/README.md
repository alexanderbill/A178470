####通用AppActionBar  

支持左-中-右三部分布局  
支持左(icon or text)  
支持中(text)  
支持中(icon or text)    

支持设置对应的listenter,左边icon默认是返回。  
支持背景渐变0~100%,文字渐变从60%~100%,形成良好的视觉效果。  

如何使用?  
在Activity的layout中引用:  
   <include  
        layout="@layout/include_app_action_bar" />  
在Activity的BaseActivity/BaseFragment中:  
 public AppActionBar getAppActionBar(){  
    return appActionBar;  
  }  
在Activity中可根据当前需求:  
getAppActionBar().setTitle(R.string.home_title);  
getAppActionBar().setRightTitle(R.string.title,listener);  
getAppActionBar().setRightIcon(R.drawable.home_icon,listener);  
getAppActionBar().setBackgroundAlpha(0);//设置透明背景  
getAppActionBar()....


####PS:参照用户资料页UserHomeActivity。

