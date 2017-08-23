package com.example.a206170.order_system.UserUI.Business_menu;

/**
 * Created by Administrator on 2017/8/21.
 */

public class Food_domain {
    /*
     int F_id;
    String F_name,F_image,F_type,F_estimate,F_describe,F_number,F_discount,F_uptime;
    float F_price;

    public Food_domain(int F_id, String F_name, int F_price, String F_image,
                       String F_type, String F_estimate, String F_describe,
                       String F_number, String F_discount, String F_uptime)
    {
        this.F_id=F_id;
        this.F_name=F_name;
        this.F_price=F_price;
        this.F_image=F_image;
        this.F_type=F_type;
        this.F_estimate=F_estimate;
        this.F_describe=F_describe;
        this.F_number=F_number;
        this.F_discount=F_discount;
        this.F_uptime=F_uptime;

    }


    public int getF_id() {
        return F_id;
    }

    public void setF_id(int f_id) {
        F_id = f_id;
    }

    public String getF_name() {
        return F_name;
    }

    public void setF_name(String f_name) {
        F_name = f_name;
    }

    public String getF_image() {
        return F_image;
    }

    public void setF_image(String f_image) {
        F_image = f_image;
    }

    public String getF_type() {
        return F_type;
    }

    public void setF_type(String f_type) {
        F_type = f_type;
    }

    public String getF_estimate() {
        return F_estimate;
    }

    public void setF_estimate(String f_estimate) {
        F_estimate = f_estimate;
    }

    public String getF_describe() {
        return F_describe;
    }

    public void setF_describe(String f_describe) {
        F_describe = f_describe;
    }

    public String getF_number() {
        return F_number;
    }

    public void setF_number(String f_number) {
        F_number = f_number;
    }

    public String getF_discount() {
        return F_discount;
    }

    public void setF_discount(String f_discount) {
        F_discount = f_discount;
    }

    public String getF_uptime() {
        return F_uptime;
    }

    public void setF_uptime(String f_uptime) {
        F_uptime = f_uptime;
    }

    public float getF_price() {
        return F_price;
    }

    public void setF_price(float f_price) {
        F_price = f_price;
    }
*/
    private String F_Name;
    private double F_Price;
    private int F_discount;
    private int F_number;

    public Food_domain(String F_Name,double F_Price,int F_number){
        this.F_Name = F_Name;
        this.F_Price = F_Price;
        this.F_discount = F_discount;
        this.F_number = F_number;
    }


    public String getDishName() {
        return F_Name;
    }

    public String getF_Name() {
        return F_Name;
    }

    public void setF_Name(String f_Name) {
        F_Name = f_Name;
    }

    public double getF_Price() {
        return F_Price;
    }

    public void setF_Price(double f_Price) {
        F_Price = f_Price;
    }

    public int getF_discount() {
        return F_discount;
    }

    public void setF_discount(int f_discount) {
        F_discount = f_discount;
    }

    public int getF_number() {
        return F_number;
    }

    public void setF_number(int f_number) {
        F_number = f_number;
    }

    public int hashCode(){
        int code = this.F_Name.hashCode()+(int)this.F_Price;
        return code;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==this)return true;

        return obj instanceof Food_domain &&
                this.F_Name.equals(((Food_domain)obj).F_Name) &&
                this.F_Price ==  ((Food_domain)obj).F_Price &&
                this.F_discount == ((Food_domain)obj).F_discount &&
                this.F_number == ((Food_domain)obj).F_number;
    }



}
