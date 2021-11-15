package com.feedAustralia.android.AdpatersPagers;

import android.app.Activity;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.feedAustralia.android.R;
import com.feedAustralia.android.pojo.habit.EatingHabit;

import java.util.List;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {
    Activity activity;
    List<EatingHabit> eatingHabitList;
    int mainposition;

    public ItemsAdapter(Activity activity, List<EatingHabit> eatingHabitList,int position) {
        this.activity=activity;
        this.eatingHabitList  = eatingHabitList;
        this.mainposition = position;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.eating_sub_item,parent,false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.textfooditem.setText(eatingHabitList.get(position).getMealsTime().getName());

        int serve = eatingHabitList.get(position).getServesAmount();


        if(serve==1)
            holder.imageActive.setBackgroundResource(R.drawable.serveone);
        else if(serve==2)
            holder.imageActive.setBackgroundResource(R.drawable.servetwo);
        else if(serve==3)
            holder.imageActive.setBackgroundResource(R.drawable.servethree);
        else if(serve==100)
            holder.imageActive.setBackgroundResource(R.drawable.serve100);
        else if(serve==101)
            holder.imageActive.setBackgroundResource(R.drawable.serve101);
        else if(serve==-1)
            holder.imageActive.setBackgroundResource(R.drawable.redcircle);
        else if(serve==0)
            holder.imageActive.setBackgroundResource(R.drawable.buttongrey);
        else
            holder.imageActive.setBackgroundResource(R.drawable.buttongrey);


        if(mainposition%2 == 0)
        {
            if (position %2!=0){
                holder.MainLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
                holder.imageLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
            }
            else  {
                holder.MainLayout.setBackgroundColor(Color.parseColor("#F3F3F3"));
                holder.imageLayout.setBackgroundColor(Color.parseColor("#F3F3F3"));
            }

        }
        else
        {
            if (position %2==0){
                holder.MainLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
                holder.imageLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
            }
            else  {
                holder.MainLayout.setBackgroundColor(Color.parseColor("#F3F3F3"));
                holder.imageLayout.setBackgroundColor(Color.parseColor("#F3F3F3"));
            }


        }


    }
    @Override
    public int getItemCount() {
        return eatingHabitList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textfooditem;
        ImageView imageActive;
        RelativeLayout MainLayout,imageLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            textfooditem = itemView.findViewById(R.id.textfooditem);
            imageActive = itemView.findViewById(R.id.imageActive);
            MainLayout = itemView.findViewById(R.id.Snack);
            imageLayout = itemView.findViewById(R.id.rightView);



        }
    }
}
