package com.example.a206170.order_system.BusinessUI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a206170.order_system.R;

/**
 * Created by 206170 on 2017/8/22.
 */

public class business_register_first_upphoto extends AppCompatActivity {
    TextView show1,show2,show3;
    Button up1,up2,up3;
    ImageView iv1,iv2,iv3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_register_first_upphoto);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);

        }
        //以上是设置返回按钮
        show1=(TextView)findViewById(R.id.show1);
        show2=(TextView)findViewById(R.id.show2);
        show3=(TextView)findViewById(R.id.show3);
        up1=(Button)findViewById(R.id.up1);
        up2=(Button)findViewById(R.id.up2);
        up3=(Button)findViewById(R.id.up3);
        iv1=(ImageView)findViewById(R.id.outside);
        iv2=(ImageView)findViewById(R.id.inside);
        iv3=(ImageView)findViewById(R.id.logo);
//以上是实例化








//        这里写方法


    }

    //以下是设置返回按钮
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish(); // back butto
            case R.id.save:
                break;
            default:

                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    //保存按钮
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.save,menu);
        return true;
    }


}
