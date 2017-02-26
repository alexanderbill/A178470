package com.mobcent.discuz.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.appbyme.dev.R;
import com.mobcent.discuz.base.constant.BaseIntentConstant;

import library.component.actionbar.AppActionBar;

public abstract class BasePopActivity
  extends FragmentActivity
  implements BaseIntentConstant
{
  private FrameLayout containerBox;
  private Fragment contentFragment;
  private AppActionBar appActionBar;
  
  protected Fragment getContentFragment()
  {
    return this.contentFragment;
  }


  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(initLayout());
    appActionBar = (AppActionBar)findViewById(R.id.app_action_bar);
  }
  
  protected String getLayoutName()
  {
    return "base_pop_activity";
  }
  
  protected void initActions() {}
  
  protected abstract Fragment initContentFragment();

  public int initLayout(){
    return R.layout.base_pop_activity;
  }
  
  protected void initViews()
  {
    this.containerBox = ((FrameLayout)findViewById(R.id.container_layout));
    this.contentFragment = initContentFragment();
    getSupportFragmentManager().beginTransaction().replace(this.containerBox.getId(), this.contentFragment).commit();
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (getContentFragment() != null) {
      getContentFragment().onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }

  protected <T> T $( int id) {
    return (T) findViewById(id);
  }

  public void showToast(String message){
    Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
  }

  public AppActionBar getAppActionBar(){
    return appActionBar;
  }

}