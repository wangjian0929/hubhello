package com.feedAustralia.android.AdpatersPagers;
import android.app.Activity;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.feedAustralia.android.R;
import com.feedAustralia.android.pojo.habit.FilterEatingHabit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by asd on 12-02-2019.
 */

public class EatingAdapter extends RecyclerView.Adapter<EatingAdapter.ViewHolder> {
    Activity activity;
    List<FilterEatingHabit> eatingHabitList;
    String selectedDate = "";
    public EatingAdapter(FragmentActivity activity, List<FilterEatingHabit> eatingHabitList) {
        this.activity=activity;
        this.eatingHabitList =eatingHabitList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.eating_item,parent,false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Date current = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        selectedDate = format.format(current);
        holder.textDate.setText(convertDate(eatingHabitList.get(position).getEatingDate()));
        holder.textDay.setText(dayConvert(eatingHabitList.get(position).getEatingDate()));
        holder.texMonth.setText(monthConvert(eatingHabitList.get(position).getEatingDate()));

        ItemsAdapter itemsAdapter = new ItemsAdapter(activity,eatingHabitList.get(position).getEatingHabits(),position);
        holder.recyclerviewEating.setAdapter(itemsAdapter);

        if(selectedDate.equals(eatingHabitList.get(position).getEatingDate())) {
            holder.layoutCurrent.setVisibility(View.VISIBLE);
            holder.textDate.setTextColor(Color.parseColor("#ffffff"));
        }
        else {
            holder.layoutCurrent.setVisibility(View.GONE);
            holder.textDate.setTextColor(Color.parseColor("#91ce0c"));

        }
    }
    private String convertDate(String updateDate) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format1 = new SimpleDateFormat("dd");
        java.util.Date date = null;
        try {
            date = format.parse(updateDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String convertedDate = format1.format(date);
        return convertedDate;
    }

    private String dayConvert(String updateDate) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format1 = new SimpleDateFormat("EEEE");
        java.util.Date date = null;
        try {
            date = format.parse(updateDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String convertedDate = format1.format(date);
        return convertedDate;
    }

    private String monthConvert(String updateDate) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format1 = new SimpleDateFormat("MMM yyyy");
        java.util.Date date = null;
        try {
            date = format.parse(updateDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String convertedDate = format1.format(date);
        return convertedDate;
    }


    @Override
    public int getItemCount() {
        return eatingHabitList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        RecyclerView recyclerviewEating;
        TextView textDate,textDay,texMonth;
        ItemsAdapter itemsAdapter;
        RelativeLayout layoutCurrent;

        public ViewHolder(View itemView) {
            super(itemView);
            texMonth = itemView.findViewById(R.id.texMonth);
            textDate = itemView.findViewById(R.id.textDate);
            textDay = itemView.findViewById(R.id.textDay);
            recyclerviewEating = itemView.findViewById(R.id.recyclerviewEating);
            LinearLayoutManager layoutManager = new LinearLayoutManager(activity);
            layoutCurrent = itemView.findViewById(R.id.layoutCurrent);
            recyclerviewEating.setLayoutManager(layoutManager);




        }
    }
}
