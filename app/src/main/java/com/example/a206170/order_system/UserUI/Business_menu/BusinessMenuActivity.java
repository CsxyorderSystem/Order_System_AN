package com.example.a206170.order_system.UserUI.Business_menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TabHost;

import com.example.a206170.order_system.R;

public class BusinessMenuActivity extends AppCompatActivity {
    private TabHost tabhost;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //去除标题栏阴影
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_business_menu);





        //返回按钮
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();

        if(actionBar != null){
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        //声明tabhost

        //得到TabHost对象实例
        tabhost =(TabHost) findViewById(R.id.mytab);
        //调用 TabHost.setup()
        tabhost.setup();
        //创建Tab标签
        tabhost.addTab(tabhost.newTabSpec("one").setIndicator("商品").setContent(R.id._business_menu));
        tabhost.addTab(tabhost.newTabSpec("two").setIndicator("评价").setContent(R.id.widget_layout_yellow));

    }
    //监听标题栏
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish(); // back button
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
