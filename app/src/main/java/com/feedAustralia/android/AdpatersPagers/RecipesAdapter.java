package com.feedAustralia.android.AdpatersPagers;
import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.feedAustralia.android.Activity.RecipesDescription;
import com.feedAustralia.android.R;

/**
 * Created by asd on 11-02-2019.
 */

public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.ViewHolder> {
    Activity activity;
    public RecipesAdapter(FragmentActivity activity) {
        this.activity =activity;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recipes_item, parent,false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.itemlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity,RecipesDescription.class);
                activity.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return 50;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        RelativeLayout itemlayout;
        public ViewHolder(View itemView) {
            super(itemView);
            itemlayout = itemView.findViewById(R.id.itemlayout);
        }
    }
}
