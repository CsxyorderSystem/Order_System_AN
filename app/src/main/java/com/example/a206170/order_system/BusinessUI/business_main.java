package com.example.a206170.order_system.BusinessUI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a206170.order_system.R;

/**
 * Created by 206170 on 2017/8/21.
 */

public class business_main extends AppCompatActivity {
    TextView textView;
    ImageView imageView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_main);
        textView=(TextView)findViewById(R.id.textView);
        imageView=(ImageView)findViewById(R.id.imageView);
        button=(Button)findViewById(R.id.button);
        ///以上为实例化对象
        View.OnClickListener mylistenter=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.button:
                    intent();
                }
            }
        };
        button.setOnClickListener(mylistenter);
    }
    //以下是跳转到注册界面，填写类型和店铺名称
    public void intent(){
        Intent intent=new Intent(business_main.this,business_register_main.class);
        startActivity(intent);

    }
}
