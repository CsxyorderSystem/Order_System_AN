package com.example.a206170.order_system.BusinessUI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.a206170.order_system.R;

/**
 * Created by 206170 on 2017/8/21.
 */

public class business_register_main extends AppCompatActivity {
    EditText editText,textView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_register_main);
        textView=(EditText) findViewById(R.id.typeET);
        editText=(EditText)findViewById(R.id.nameET);
        textView.setKeyListener(null);
        button=(Button)findViewById(R.id.button);
        ///实例化对象
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        //以上是textview的监听器
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }

        });
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b){
                    input();
                }
            }
        });
        //以上是edittext的监听器

    }
    public void input(){
        String value=editText.getText().toString();
        String value2=textView.getText().toString();
        if(value==null||value.trim().equals("")) {
            editText.setError("请填写当前项");
        }
            if(value2==null||value2.trim().equals("")){
                textView.setError("请选择当前项");
    }
        //以上是判断输入框是否为空的提示
}
}