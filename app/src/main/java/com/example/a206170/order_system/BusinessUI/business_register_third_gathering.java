package com.example.a206170.order_system.BusinessUI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.a206170.order_system.R;

/**
 * Created by 206170 on 2017/8/23.
 */

public class business_register_third_gathering extends AppCompatActivity {
    TextView openingbank,branchbank;
    EditText gatheringname,gatheringcard;
    RadioButton toself,topublic;
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_register_third_gathering);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);

        }
        openingbank=(TextView)findViewById(R.id.openingbank);
        branchbank=(TextView)findViewById(R.id.branchbank);
        gatheringname=(EditText)findViewById(R.id.gatheringname);
        gatheringcard=(EditText)findViewById(R.id.gatheringcard);
        toself=(RadioButton)findViewById(R.id.toself);
        topublic=(RadioButton)findViewById(R.id.topublic);
        next=(Button)findViewById(R.id.save);
        ///以上为实例化对象
        //以下为监听button
        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            switch (view.getId()){
                case R.id.save:
                    next();
                    break;
            }
            }
        };
       next.setOnClickListener(listener);
    }
    //以下是设置返回按钮
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish(); // back button
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    //以下是跳转页面按钮的实现
    public void next(){
        Intent intent=new Intent(business_register_third_gathering.this,business_register_contract.class);
        startActivity(intent);
    }
}