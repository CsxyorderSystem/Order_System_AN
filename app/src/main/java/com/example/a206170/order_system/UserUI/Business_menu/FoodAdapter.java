package com.example.a206170.order_system.UserUI.Business_menu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.a206170.order_system.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/21.
 */

public class FoodAdapter extends RecyclerView.Adapter{
    private final int MENU_TYPE = 0;
    private final int DISH_TYPE = 1;
    private final int HEAD_TYPE = 2;

    private Context mContext;
    private static ArrayList<Food_Type_domain> food_typeList;
    private int mItemCount;
    private ShopCart shopCart;
    private ShopCartImp shopCartImp;

    public FoodAdapter(Context mContext, ArrayList<Food_Type_domain> food_typeList, ShopCart shopCart) {
        this.mContext = mContext;
        this.food_typeList = food_typeList;
        this.mItemCount = food_typeList.size();
        this.shopCart = shopCart;
        for (Food_Type_domain type : food_typeList) {
            mItemCount += type.getFood_list().size();
        }
    }
    //
    @Override
    public int getItemViewType(int position){
        int sum=0;
        for (Food_Type_domain type:food_typeList){
            if (position==sum){
                return MENU_TYPE;
            }
            sum+=type.getFood_list().size()+1;
        }
        return DISH_TYPE;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        if (viewType==MENU_TYPE){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.right_menu_item, parent, false);
            TypeViewHolder viewHolder = new TypeViewHolder(view);
            return viewHolder;
        }else{
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.right_dish_item, parent, false);
           FoodViewHolder viewHolder = new FoodViewHolder(view);
            return viewHolder;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position){
        if(getItemViewType(position)==MENU_TYPE){
            TypeViewHolder typeViewHolder=(TypeViewHolder)holder;
            if(typeViewHolder!=null){
                typeViewHolder.right_menu_title.setText(getTypeByPosition(position).getF_type());
                typeViewHolder.right_menu_layout.setContentDescription(position+"");
            }
            else{
                final FoodViewHolder foodViewHolder=(FoodViewHolder)holder;
                if(foodViewHolder!=null){
                    final Food_domain food=getFoodByPosition(position);
                    foodViewHolder.right_dish_name_tv.setText(food.getF_name());
                    foodViewHolder.right_dish_price_tv.setText(food.getF_price()+"");
                    foodViewHolder.right_dish_layout.setContentDescription(position+"");

                    //添加移除按钮
                    int count=0;
                    if(shopCart.getShoppingSingleMap().containsKey(food)){
                        count=shopCart.getShoppingSingleMap().get(food);
                    }
                    if(count<=0){
                        foodViewHolder.right_dish_remove_iv.setVisibility(View.GONE);
                        foodViewHolder.right_dish_account_tv.setVisibility(View.GONE);
                    }
                    else{
                        foodViewHolder.right_dish_remove_iv.setVisibility(View.VISIBLE);
                        foodViewHolder.right_dish_account_tv.setVisibility(View.VISIBLE);
                        foodViewHolder.right_dish_account_tv.setText(count+"");
                    }
                    //监听添加菜品按钮
                    foodViewHolder.right_dish_add_iv.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if(shopCart.addShoppingSingle(food)){
                                notifyItemChanged(position);
                                if(shopCartImp!=null)
                                    shopCartImp.add(view,position);
                            }
                        }
                    });
                    //监听移除菜品按钮
                    foodViewHolder.right_dish_remove_iv.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (shopCart.subShoppingSingle(food)){
                                notifyItemChanged(position);
                                if(shopCartImp!=null){
                                    shopCartImp.remove(view,position);
                                }
                            }
                        }
                    });
                }
            }
        }
    }

    public Food_Type_domain getTypeByPosition(int position){
    int sum=0;
        for(Food_Type_domain type:food_typeList){
            if(position==sum){
                return type;
            }
            sum+=type.getFood_list().size()+1;
        }
        return null;
    }
    //根据位置获取菜品
    public Food_domain getFoodByPosition(int position){
        for(Food_Type_domain type:food_typeList){
            if(position>0 && position<=type.getFood_list().size()){
                return type.getFood_list().get(position-1);
            }
            else{
                position-=type.getFood_list().size()+1;
            }
        }
        return null;
    }

    //
    public static Food_Type_domain getTypeOfTypeByPosition(int position){
        for(Food_Type_domain type:food_typeList){
            if (position==0)return type;
            if(position>0&&position<=type.getFood_list().size()){
                return type;
            }
            else{
                position-=type.getFood_list().size()+1;
            }
        }
        return null;
    }
    //获取计数
    @Override
    public int getItemCount() {
        return mItemCount;
    }

    public ShopCartImp getShopCartImp() {
        return shopCartImp;
    }

    public void setShopCartImp(BusinessMenuActivity shopCartImp) {
        this.shopCartImp = shopCartImp;
    }


    //菜品类别加载
    private class TypeViewHolder extends RecyclerView.ViewHolder{
        private LinearLayout right_menu_layout;
        private TextView right_menu_title;
        public TypeViewHolder(View itemView) {
            super(itemView);
            right_menu_layout = (LinearLayout)itemView.findViewById(R.id.right_menu_item);
            right_menu_title = (TextView)itemView.findViewById(R.id.right_menu_tv);
        }
    }
    //菜品加载
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
