package com.mobcent.discuz.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.appbyme.dev.R;

import java.util.ArrayList;

/**
 * Created by ubuntu on 16-6-21.
 */
public class DiscuzFragment extends BaseFragment {

    private String[] CONTENT;
    private TextView[] tvs = {null, null ,null};
    private Fragment[] fragments;
    public String TAG = "DiscuzFragment";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.viewpager, container, false);
        //
        FragmentPagerAdapter adapter = new GoogleMusicAdapter(getChildFragmentManager());
        TextView tv0 = (TextView)view.findViewById(R.id.first);
        tv0.setText(CONTENT[0]);
        tv0.setSelected(true);
        tvs[0] = tv0;
        TextView tv1 = (TextView)view.findViewById(R.id.second);
        tv1.setText(CONTENT[1]);
        tvs[1] = tv1;
        TextView tv2 = (TextView)view.findViewById(R.id.third);
        tv2.setText(CONTENT[2]);
        tvs[2] = tv2;
        ViewPager pager = (ViewPager) view.findViewById(R.id.pager);
        pager.setAdapter(adapter);
        pager.setOffscreenPageLimit(2);

        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            public void onPageSelected(int position) {
                tvs[0].setSelected(false);
                tvs[1].setSelected(false);
                tvs[2].setSelected(false);
                tvs[position].setSelected(true);
            }

            public void onPageScrollStateChanged(int state) {

            }
        });
;
        return view;
    }

    class GoogleMusicAdapter extends FragmentPagerAdapter {
        public GoogleMusicAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments[position];
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return CONTENT[position % CONTENT.length].toUpperCase();
        }

        @Override
        public int getCount() {
            return CONTENT.length;
        }
    }

    public void setTitles(String[] titles) {
        CONTENT = titles;
    }

    public void setFragments(Fragment[] fs) {
        fragments = fs;
    }
}
