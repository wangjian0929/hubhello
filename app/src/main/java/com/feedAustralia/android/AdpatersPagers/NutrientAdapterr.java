package com.feedAustralia.android.AdpatersPagers;

import android.app.Activity;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.feedAustralia.android.R;
import java.util.ArrayList;

/**
 * Created by asd on 19-02-2019.
 */

public class NutrientAdapterr extends RecyclerView.Adapter<NutrientAdapterr.ViewHolder> {
    Activity activity;
    ArrayList<String> Supliments;
    ArrayList<String> PerServe;
    ArrayList<String> PerGrams;
    public NutrientAdapterr(Activity activity, ArrayList<String> supliments, ArrayList<String> perServe, ArrayList<String> perGrams) {
        this.activity=activity;
        this.Supliments=supliments;
        this.PerServe=perServe;
        this.PerGrams=perGrams;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.nutri_item,parent,false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.Suplliment.setText(Supliments.get(position));
        holder.ServingsQuantity.setText(PerServe.get(position));
        holder.PerGrams.setText(PerGrams.get(position));
        if (position  % 2 == 0){
            holder.MainLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }else {
            holder.MainLayout.setBackgroundColor(Color.parseColor("#F3F3F3"));
        }
    }
    @Override
    public int getItemCount() {
        return Supliments.size();



    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView Suplliment,ServingsQuantity,PerGrams;
        LinearLayout MainLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            Suplliment = itemView.findViewById(R.id.Suplliment);
            ServingsQuantity = itemView.findViewById(R.id.ServingsQuantity);
            PerGrams = itemView.findViewById(R.id.PerGrams);
            MainLayout = itemView.findViewById(R.id.MainLayout);
        }
    }
}
