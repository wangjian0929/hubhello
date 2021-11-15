//package com.feedAustralia.android.AdpatersPagers;
//
//import android.app.Activity;
//import android.support.annotation.NonNull;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//import android.widget.Toast;
//import com.feedAustralia.android.R;
//
//public class MutliChildAdapter extends RecyclerView.Adapter<MutliChildAdapter.ViewHolder> {
//    Activity activity;
//    RelativeLayout childLayout;
//    public MutliChildAdapter(Activity activity, RelativeLayout childLayout) {
//        this.activity=activity;
//        this.childLayout=childLayout;
//    }
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
//        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//        View view = inflater.inflate(R.layout.child_itemscount,parent,false);
//        return new ViewHolder(view);
//        childLayout.setVisibility(View.GONE);
//    }
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
//        holder.layoutChild.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                childLayout.setVisibility(View.GONE);
//                Toast.makeText(activity, "Checked"+position, Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//    @Override
//    public int getItemCount() {
//        return 5;
//    }
//    public class ViewHolder extends RecyclerView.ViewHolder{
//        TextView textChild;
//        ImageView imageChild;
//        RelativeLayout layoutChild;
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            textChild = itemView.findViewById(R.id.textChild);
//            imageChild = itemView.findViewById(R.id.imageChild);
//            layoutChild = itemView.findViewById(R.id.layoutChild);
//
//        }
//    }
//}
