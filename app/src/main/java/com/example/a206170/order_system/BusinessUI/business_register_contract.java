package com.example.a206170.order_system.BusinessUI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.a206170.order_system.R;

/**
 * Created by 206170 on 2017/8/24.
 */

public class business_register_contract extends AppCompatActivity {
    Button next;
    EditText contract,idcard,bank,card,phone;
    RadioButton self,lincense;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_register_contract);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        next=(Button)findViewById(R.id.next);
        contract=(EditText)findViewById(R.id.contract);
        idcard=(EditText)findViewById(R.id.idcard);
        bank=(EditText)findViewById(R.id.bank);
        card=(EditText)findViewById(R.id.card);
        phone=(EditText)findViewById(R.id.phone);
        self=(RadioButton)findViewById(R.id.self);
        lincense=(RadioButton)findViewById(R.id.lincense);
        ///以上为实例化对象
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
}