package com.example.a206170.order_system.UserUI.Business_menu;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.a206170.order_system.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/22.
 */

public class PopupAdapter extends RecyclerView.Adapter {

    private static String TAG = "PopupDishAdapter";
    private ShopCart shopCart;
    private Context context;
    private int itemCount;
    private ArrayList<Food_domain> FoodList;
    private ShopCartImp shopCartImp;

    public PopupAdapter(Context context, ShopCart shopCart){
        this.shopCart = shopCart;
        this.context = context;
        this.itemCount = shopCart.getDishAccount();
        this.FoodList = new ArrayList<>();
        FoodList.addAll(shopCart.getShoppingSingleMap().keySet());
        Log.e(TAG, "PopupDishAdapter: "+this.itemCount );
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.right_dish_item, parent, false);
        FoodViewHolder viewHolder = new FoodViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        FoodViewHolder foodViewHolder=(FoodViewHolder)holder;
        final Food_domain food= getDishByPosition(position);
        if(food!=null){
            foodViewHolder.right_dish_name_tv.setText(food.getF_Name());
            foodViewHolder.right_dish_price_tv.setText(food.getF_Price()+"");
            int num = shopCart.getShoppingSingleMap().get(food);
            foodViewHolder.right_dish_account_tv.setText(num+"");

            foodViewHolder.right_dish_add_iv.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                    if(shopCart.addShoppingSingle(food)){
                        notifyItemChanged(position);
                        if(shopCartImp!=null)
                            shopCartImp.add(view,position);
                    }
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return this.itemCount;
    }

    public Food_domain getDishByPosition(int position){
        return FoodList.get(position);
    }

    public ShopCartImp getShopCartImp() {
        return shopCartImp;
    }

    public void setShopCartImp(ShopCartImp shopCartImp) {
        this.shopCartImp = shopCartImp;
    }

    private class FoodViewHolder extends RecyclerView.ViewHolder{
        private TextView right_dish_name_tv;
        private TextView right_dish_price_tv;
        private LinearLayout right_dish_layout;
        private ImageView right_dish_remove_iv;
        private ImageView right_dish_add_iv;
        private TextView right_dish_account_tv;

        public FoodViewHolder(View itemView) {
            super(itemView);
            right_dish_name_tv = (TextView)itemView.findViewById(R.id.right_dish_name);
            right_dish_price_tv = (TextView)itemView.findViewById(R.id.right_dish_price);
            right_dish_layout = (LinearLayout)itemView.findViewById(R.id.right_dish_item);
            right_dish_remove_iv = (ImageView)itemView.findViewById(R.id.right_dish_remove);
            right_dish_add_iv = (ImageView)itemView.findViewById(R.id.right_dish_add);
            right_dish_account_tv = (TextView) itemView.findViewById(R.id.right_dish_account);
        }

    }
}
