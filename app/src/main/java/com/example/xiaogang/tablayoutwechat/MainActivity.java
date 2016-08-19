package com.example.xiaogang.tablayoutwechat;

import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private MyFragmentPagerAdapter myFragmentPagerAdapter;
    private List<Fragment>fragmentList;
    private String[] titles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
    }

    private void initview() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        fragmentList = new ArrayList<>();
        fragmentList.add(new Fragment1());
        fragmentList.add(new Fragment2());
        fragmentList.add(new Fragment3());
        fragmentList.add(new Fragment4());
        titles = new String[]{"微信","通讯录","发现","我"};
        myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),fragmentList,titles);
        viewPager.setAdapter(myFragmentPagerAdapter);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            Drawable h = null;
            switch (i) {
                case 0:
                    h = getResources().getDrawable(R.drawable.we);
                    //h = getResources().getDrawable(R.mipmap.ic_launcher);
                    break;
                case 1:
                    //h = getResources().getDrawable(R.mipmap.ic_launcher);

                    h = getResources().getDrawable(R.drawable.book);
                    break;
                case 2:
                    //h = getResources().getDrawable(R.mipmap.ic_launcher);

                    h = getResources().getDrawable(R.drawable.discover);
                    break;
                case 3:
                    //h = getResources().getDrawable(R.mipmap.ic_launcher);

                    h = getResources().getDrawable(R.drawable.me);
                    break;
            }
            tab.setIcon(h);
        }
    }
}
