package com.feedAustralia.android.Activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.feedAustralia.android.R;

import java.util.ArrayList;

public class CustomMonth extends AppCompatActivity implements View.OnClickListener {
    RecyclerView recyclerMonth;
    MonthAdapter monthAdapter;
    ArrayList<String> monthlist;
    ArrayList<String> monthyear;
    TextView textmonth;
    RelativeLayout nextLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_month);
        recyclerMonth = findViewById(R.id.recyclerMonth);
        textmonth = findViewById(R.id.textmonth);
        nextLayout = findViewById(R.id.nextLayout);
        nextLayout.setOnClickListener(this);
        monthlist = new ArrayList<>();
        monthlist.add("Jan");
        monthlist.add("Feb");
        monthlist.add("Mar");
        monthlist.add("Apr");
        monthlist.add("May");
        monthlist.add("Jun");
        monthlist.add("Jul");
        monthlist.add("Aug");
        monthlist.add("Sept");
        monthlist.add("Oct");
        monthlist.add("Nov");
        monthlist.add("Dec");
        monthyear = new ArrayList<>();
        monthyear.add("January 2019");
        monthyear.add("February 2019");
        monthyear.add("March 2019");
        monthyear.add("April 2019");
        monthyear.add("May 2019");
        monthyear.add("June 2019");
        monthyear.add("July 2019");
        monthyear.add("August 2019");
        monthyear.add("September 2019");
        monthyear.add("October 2019");
        monthyear.add("November 2019");
        monthyear.add("December 2019");
        recyclerMonth.setLayoutManager(new GridLayoutManager(this, 4));
        monthAdapter = new MonthAdapter(this,monthlist,monthyear);
        recyclerMonth.setAdapter(monthAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.nextLayout:
                break;
        }
    }
    public class MonthAdapter extends RecyclerView.Adapter<MonthAdapter.ViewHolder>{
        Activity activity;
        ArrayList<String> monthlist;
        private int lastSelectedPosition = 0;
        ArrayList<String> monthyear;

        public MonthAdapter(Activity activity, ArrayList<String> monthlist,ArrayList<String> monthyear) {
            this.activity = activity;
            this.monthlist = monthlist;
            this.monthyear = monthyear;
        }
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.cutom_item, parent,false);
            return new ViewHolder(view);
        }
        @Override
        public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
            holder.btnjan.setText(monthlist.get(position));
            if(lastSelectedPosition == position)
            {
                holder.btnjan.setBackgroundColor(Color.parseColor("#0a90ce0b"));
            }
            else {
                holder.btnjan.setBackgroundColor(Color.parseColor("#ffffff"));
            }
            holder.btnjan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lastSelectedPosition = position;
                    notifyDataSetChanged();
                    textmonth.setText(monthyear.get(position));
                    Toast.makeText(activity, ""+""+position, Toast.LENGTH_SHORT).show();
                }
            });
        }
        @Override
        public int getItemCount() {
            return monthlist.size();
        }
        public class ViewHolder extends RecyclerView.ViewHolder{
            Button btnjan;
            public ViewHolder(View itemView) {
                super(itemView);
                btnjan = itemView.findViewById(R.id.btnjan);
            }
        }
    }
}

