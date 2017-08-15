package com.example.a206170.order_system.LoginAndSign;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.a206170.order_system.R;

public class RegisterActivity extends AppCompatActivity {

    private Button register_button,back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"就不给你注册",Toast.LENGTH_SHORT).show();
            }
        });


        //返回按钮
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
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





   /* private View.OnClickListener onClickListener=new View.OnClickListener(){

        @Override
        public void onClick(View view) {
            switch (view.getId()){

                case R.id.register_comfirm_button:
                    Toast.makeText(getApplicationContext(),"就不给你注册",Toast.LENGTH_SHORT).show();
            }
        }
    };*/

    public void init(){
        register_button=(Button)findViewById(R.id.register_comfirm_button);
        back_button=(Button)findViewById(R.id.home);
    }



}

