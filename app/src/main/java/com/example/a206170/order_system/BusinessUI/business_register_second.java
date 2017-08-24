package com.example.a206170.order_system.BusinessUI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.a206170.order_system.R;

/**
 * Created by 206170 on 2017/8/22.
 */

public class business_register_second extends AppCompatActivity {
    Button next;
    LinearLayout lincense,legal,permission;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_register_second);
        next=(Button)findViewById(R.id.next);
        lincense=(LinearLayout)findViewById(R.id.lincense);
        legal=(LinearLayout)findViewById(R.id.legal);
        permission=(LinearLayout)findViewById(R.id.permission);
        ///以上为实例化对象
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);

        }
        //以上为actionbar的返回按钮
        //以下为实现监听器
        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.permission:
                        permission();
                        break;
                    case R.id.legal:
                         legal();
                        break;
                    case R.id.lincense:
                        lincense();
                        break;
                    case R.id.next:
                        next();
                        break;
                }
            }
        };
        lincense.setOnClickListener(listener);
        permission.setOnClickListener(listener);
        legal.setOnClickListener(listener);
        next.setOnClickListener(listener);
    }
    //以下是设置返回按钮
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish(); // back button
            case R.id.save:
                break;
            default:

                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    //执行permission跳转
    public void permission(){
        Intent intent=new Intent(business_register_second.this,business_register_second_permission.class);
        startActivity(intent);
    }
    //执行legal跳转
    public void legal(){
        Intent intent=new Intent(business_register_second.this,business_register_second_lagel.class);
        startActivity(intent);
    }
    //执行lincense跳转
    public void lincense(){
        Intent intent=new Intent(business_register_second.this,business_register_second_lincense.class);
        startActivity(intent);
    }
    //以下为跳转至下一步
    public void next(){
        Intent intent=new Intent(business_register_second.this,business_register_third_gathering.class);
        startActivity(intent);
    }
}