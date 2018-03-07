package com.caohua.zhousaito.dragdemo;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.caohua.zhousaito.dragdemo.adapter.DragDetailFragmentPagerAdapter;
import com.caohua.zhousaito.dragdemo.fragment.OneFragment;

import java.util.ArrayList;
import java.util.List;

public class DragViewPagerActivity extends AppCompatActivity {

    private TabLayout tab;
    private ViewPager viewPager;
    private List<Fragment> fragments = new ArrayList<>();
    private String[] titleTab = {"商品","详情","评价"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_view_pager);
        initView();
    }

    private void initView() {
        fragments.add(new OneFragment());
        fragments.add(new OneFragment());
        fragments.add(new OneFragment());
        tab = ((TabLayout) findViewById(R.id.view_pager_tab));
        viewPager = ((ViewPager) findViewById(R.id.view_pager));
        tab.setupWithViewPager(viewPager);
        viewPager.setAdapter(new DragDetailFragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return titleTab[position];
            }
        });
    }
}
