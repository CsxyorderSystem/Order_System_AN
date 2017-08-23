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

public class businesss_register_second_gathering  extends AppCompatActivity {
    TextView openingbank,branchbank;
    EditText gatheringname,gatheringcard;
    RadioButton toself,topublic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_register_second_gathering);
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