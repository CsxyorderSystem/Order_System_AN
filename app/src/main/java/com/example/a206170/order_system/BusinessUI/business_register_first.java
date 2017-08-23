package com.example.a206170.order_system.BusinessUI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.a206170.order_system.R;

/**
 * Created by 206170 on 2017/8/21.
 */

public class business_register_first extends AppCompatActivity {
    EditText province,info,person,phone;

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_register_first);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);

        }

        province=(EditText)findViewById(R.id.choose);
        province.setKeyListener(null);
        info=(EditText)findViewById(R.id.info);
        person=(EditText)findViewById(R.id.nameedit);
        phone=(EditText)findViewById(R.id.phone);
        button=(Button)findViewById(R.id.button);
        ///以上为实例化对象
    }
//添加监听器的时候记得加入input方法提示是否为空


    //以下是设置返回按钮
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish(); // back button
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    ///
    public void input(){
        String value=info.getText().toString();
        String value2=person.getText().toString();
        String value3=phone.getText().toString();
        if(value==null||value.trim().equals("")) {
            info.setError("请填写当前项");
        }
        if(value2==null||value2.trim().equals("")){
            person.setError("请选择当前项");
        }
        if(value3==null||value3.trim().equals("")){
            phone.setError("请选择当前项");
        }
        //以上是判断输入框是否为空的提示
    }
}