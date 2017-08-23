package com.example.a206170.order_system.BusinessUI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a206170.order_system.R;

/**
 * Created by 206170 on 2017/8/23.
 */

public class business_register_second_lagel extends AppCompatActivity {
    Button save;
    EditText legalname,legalnumber;
    ImageView i1,i2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_register_second_legal);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            save=(Button)findViewById(R.id.save);
            legalname=(EditText)findViewById(R.id.legalname);
            legalnumber=(EditText)findViewById(R.id.legalnumber);
            i1=(ImageView)findViewById(R.id.legalfront);
            i2=(ImageView)findViewById(R.id.legalback);
            ///以上为实例化对象
        }
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
