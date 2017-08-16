package com.example.a206170.order_system;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class UserMainActivity extends AppCompatActivity implements
        HomeFragment.OnFragmentInteractionListener,
        ProjectFragment.OnFragmentInteractionListener,
        OrderFragment.OnFragmentInteractionListener,
        MyinfoFragment.OnFragmentInteractionListener{

    private TextView mTextMessage;
    private ViewPager mViewPager;//声明ViewPager
    private FragmentPagerAdapter mAdapter;//适配器
    private List<Fragment> mFragment;//Fragment集合
    private MenuItem menuItem;
    private BottomNavigationView bottomNavigationView;



    //点击导航栏切换Fragment
    BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mViewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_project:
                    mViewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_order:
                    mViewPager.setCurrentItem(2);
                    return true;
                case R.id.navigation_myinfo:
                    mViewPager.setCurrentItem(3);
                    return true;
            }
            return false;
        }

    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);
        //隐藏标题栏
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        mViewPager=(ViewPager) findViewById(R.id.viewpager);

        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);//去除底部导航栏动画

        initDatas();

    }
    //初始化事件
    private void initDatas(){
        mFragment=new ArrayList<>();
        //添加Fragment
        mFragment.add(new HomeFragment());
        mFragment.add(new ProjectFragment());
        mFragment.add(new OrderFragment());
        mFragment.add(new MyinfoFragment());

        //初始化适配器
        mAdapter=new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragment.get(position);
            }

            @Override
            public int getCount() {
                return mFragment.size();
            }
        };

        //设置ViewPage的适配器
        mViewPager.setAdapter(mAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener(){

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (menuItem != null) {
                    menuItem.setChecked(false);
                } else {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                menuItem = bottomNavigationView.getMenu().getItem(position);
                menuItem.setChecked(true);



            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);



    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
