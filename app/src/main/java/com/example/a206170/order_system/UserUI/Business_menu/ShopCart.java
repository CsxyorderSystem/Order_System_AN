package com.example.a206170.order_system.UserUI.Business_menu;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/21.
 */

public class ShopCart {
    private int shoppingAccount;//商品总数
    private double shoppingTotalPrice;//商品总价钱
    private Map<Food_domain,Integer> shoppingSingle;//单个物品的总价价钱

    public ShopCart(){
        this.shoppingAccount = 0;
        this.shoppingTotalPrice = 0;
        this.shoppingSingle = new HashMap<>();
    }

    public int getShoppingAccount() {
        return shoppingAccount;
    }

    public double getShoppingTotalPrice() {
        return shoppingTotalPrice;
    }

    public Map<Food_domain, Integer> getShoppingSingleMap() {
        return shoppingSingle;
    }

    //添加菜品
    public boolean addShoppingSingle(Food_domain food){

        //计算数量
        int num = 0;
        if(shoppingSingle.containsKey(food)){
            num = shoppingSingle.get(food);
        }
        num+=1;
        shoppingSingle.put(food,num);
        Log.e("TAG", "addShoppingSingle: "+shoppingSingle.get(food));

        shoppingTotalPrice += food.getF_price();
        shoppingAccount++;
        return true;
    }


    public boolean subShoppingSingle(Food_domain food){
        int num = 0;
        if(shoppingSingle.containsKey(food)){
            num = shoppingSingle.get(food);
        }
        if(num<=0) return false;
        num--;

        shoppingSingle.put(food,num);
        if (num ==0) shoppingSingle.remove(food);

        shoppingTotalPrice -= food.getF_price();
        shoppingAccount--;
        return true;
    }

    public int getDishAccount() {
        return shoppingSingle.size();
    }

    //清空购物车
    public void clear(){
        this.shoppingAccount = 0;
        this.shoppingTotalPrice = 0;
        this.shoppingSingle.clear();
    }
}
