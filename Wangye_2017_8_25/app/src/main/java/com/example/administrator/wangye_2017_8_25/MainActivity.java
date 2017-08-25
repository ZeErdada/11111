package com.example.administrator.wangye_2017_8_25;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.wangye_2017_8_25.Adapter.MyBlankAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tab_layout;
    private ViewPager view_pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找控件
        tab_layout = (TabLayout) findViewById(R.id.tab_layout);
        view_pager = (ViewPager) findViewById(R.id.view_pager);
        //初始化ViewPager
        initPager();


    }

    private void initPager() {
        //创建集合
        List<Fragment> list = new ArrayList<>();
        list.add(new BlankFragment1());
        list.add(new BlankFragment2());
        //创建适配器
        MyBlankAdapter adapter = new MyBlankAdapter(getSupportFragmentManager());
        adapter.setFragment(list);
        //设置适配器
        view_pager.setAdapter(adapter);
        //创建指示器
        tab_layout.addTab(tab_layout.newTab());
        tab_layout.addTab(tab_layout.newTab());
        //与viewpager相关联
        tab_layout.setupWithViewPager(view_pager);
        //设置Title
        tab_layout.getTabAt(0).setText("Tab1");
        tab_layout.getTabAt(1).setText("Tab2");
    }
}
