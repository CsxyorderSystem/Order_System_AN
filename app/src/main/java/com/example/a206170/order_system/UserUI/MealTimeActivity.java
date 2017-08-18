package com.example.a206170.order_system.UserUI;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.a206170.order_system.LoginAndSign.ForgetPasswordActivity;
import com.example.a206170.order_system.LoginAndSign.LoginActivity;
import com.example.a206170.order_system.R;

import java.util.Calendar;

public class MealTimeActivity extends AppCompatActivity {

    private Button set_breakfest,set_lunch,set_dinner;
    private TextView breakfest_time,lunch_time,dinner_time;
    private int minute, hourOfDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_time);

        //返回按钮
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


        //声明
        init();

        set_breakfest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPickDlg(breakfest_time);
            }
        });



        set_lunch.setOnClickListener(onClickListener);
        set_dinner.setOnClickListener(onClickListener);
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

    public void init(){
        set_breakfest=(Button)findViewById(R.id.set_breakfast_time);
        set_lunch=(Button)findViewById(R.id.set_lunch_time);
        set_dinner=(Button)findViewById(R.id.set_dinner_time);

        breakfest_time=(TextView)findViewById(R.id.breakfast_time);
        lunch_time=(TextView)findViewById(R.id.lunch_time);
        dinner_time=(TextView)findViewById(R.id.dinner_time);

        Calendar calendar = Calendar.getInstance();
        hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
        minute=calendar.get(Calendar.MINUTE);
    }
    protected Dialog showPickDlg(final TextView timeText){
        Calendar calendar=Calendar.getInstance();
        Dialog dialog = null;
        TimePickerDialog.OnTimeSetListener timeListener=new  TimePickerDialog.OnTimeSetListener(){
            @Override
            public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                timeText.setText(hourOfDay+":"+minute);

            }
        };
        dialog=new TimePickerDialog(this,timeListener,calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),false);
        //这条很重要，不要删
        dialog.show();
        return dialog;
    }
    private View.OnClickListener onClickListener=new View.OnClickListener(){

        @Override
        public void onClick(View view) {
            switch (view.getId()){

                case R.id.set_breakfast_time:
                    showPickDlg(breakfest_time);
                    break;
                case R.id.set_lunch_time:
                    showPickDlg(lunch_time);
                    break;
                case R.id.set_dinner_time:
                    showPickDlg(dinner_time);
                    break;

            }
        }
    };


}



