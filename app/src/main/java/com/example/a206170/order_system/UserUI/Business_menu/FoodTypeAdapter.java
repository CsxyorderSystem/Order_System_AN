package com.example.a206170.order_system.UserUI.Business_menu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.a206170.order_system.R;

import java.util.ArrayList;
import java.util.List;


public class FoodTypeAdapter extends RecyclerView.Adapter{
    private Context mContext;
    private ArrayList<Food_Type_domain> type_list;
    private int mSelectedNum;
    private List<onItemSelectedListener> mSelectedListenerList;

    public interface onItemSelectedListener{
        public void onLeftItemSelected(int postion,Food_Type_domain type);
    }

    public void addItemSelectedListener(onItemSelectedListener listener){
        if(mSelectedListenerList!=null)
            mSelectedListenerList.add(listener);
    }

    public void removeItemSelectedListener(onItemSelectedListener listener){
        if(mSelectedListenerList!=null && !mSelectedListenerList.isEmpty())
            mSelectedListenerList.remove(listener);
    }

    public FoodTypeAdapter(Context mContext,ArrayList<Food_Type_domain> type_list){
        this.mContext=mContext;
        this.type_list=type_list;
        this.mSelectedNum=-1;
        this.mSelectedListenerList=new ArrayList<>();
        if (type_list.size()>0)
            mSelectedNum=0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.left_menu_item, parent, false);
        LeftMenuViewHolder viewHolder = new LeftMenuViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Food_Type_domain food_type_domain=type_list.get(position);//获取选中类别名
        LeftMenuViewHolder viewHolder = (LeftMenuViewHolder)holder;
        viewHolder.F_type.setText(food_type_domain.getF_type());
        if(mSelectedNum==position){
            viewHolder.menuLayout.setSelected(true);
        }else{
            viewHolder.menuLayout.setSelected(false);
        }

    }

    @Override
    public int getItemCount() {
        return type_list.size();
    }

    //
    public void setSelectedNum(int selectedNum) {
        if(selectedNum<getItemCount() && selectedNum>=0 ) {
            this.mSelectedNum = selectedNum;
            notifyDataSetChanged();
        }
    }

    public int getSelectedNum() {
        return mSelectedNum;
    }
    private class LeftMenuViewHolder extends RecyclerView.ViewHolder{
        TextView F_type;
        LinearLayout menuLayout;

        public LeftMenuViewHolder(final View itemView){
            super(itemView);
            F_type=(TextView)itemView.findViewById(R.id.left_menu_textview);
            menuLayout = (LinearLayout)itemView.findViewById(R.id.left_menu_item);
            menuLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int clickPosition = getAdapterPosition();
//                    setSelectedNum(clickPosition);
                    notifyItemSelected(clickPosition);
                }
            });
        }

    }
    private void notifyItemSelected(int position) {
        if(mSelectedListenerList!=null && !mSelectedListenerList.isEmpty()){
            for(onItemSelectedListener listener:mSelectedListenerList){
                listener.onLeftItemSelected(position,type_list.get(position));
            }
        }
    }
}
