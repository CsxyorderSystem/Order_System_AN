package com.example.a206170.order_system.BusinessUI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.a206170.order_system.R;

/**
 * Created by 206170 on 2017/8/23.
 */

public class business_register_second_lincense  extends AppCompatActivity {
    Button save;
    EditText lincense,legalname,lincensenumber,lincenseplace;
    TextView lincensedate;
    RadioButton r1,r2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_register_second_lincense);
        save=(Button)findViewById(R.id.save);
        lincense=(EditText)findViewById(R.id.lincensename);
        legalname=(EditText)findViewById(R.id.legalname);
        lincensenumber=(EditText)findViewById(R.id.lincensenumber);
        lincenseplace=(EditText)findViewById(R.id.lincenseplace);
        lincensedate=(TextView)findViewById(R.id.setdate);
        r1=(RadioButton)findViewById(R.id.rb1);
        r2=(RadioButton)findViewById(R.id.rb2);
        ///以上为实例化对象

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);

        }
        //以上为actionbar的返回按钮
        //需要添加方法如果点击r2弹出日历然后显示setdate的一行界面
        //实例化监听各种界面Linearlayout





    }
    //以下是设置返回按钮
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish(); // back butto
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}