package com.example.a206170.order_system.UserUI.Business_menu;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/21.
 */

public class Food_Type_domain {
    private String F_type;
    private ArrayList<Food_domain> food_list;

    public void setF_type(String f_type) {
        this.F_type = f_type;
    }

    public void setFood_list(ArrayList<Food_domain> food_list) {
        this.food_list = food_list;
    }

    public Food_Type_domain(){

    }

    public String getF_type() {
        return F_type;
    }

    public ArrayList<Food_domain> getFood_list() {
        return food_list;
    }

    public  Food_Type_domain(String F_type, ArrayList food_list){
        this.F_type=F_type;
        this.food_list=food_list;
    }
}
