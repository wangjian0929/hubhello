package com.feedAustralia.android.AdpatersPagers;


/**
 * Created by asd on 06-02-2019.
 */



//public class WeekAdapter extends RecyclerView.Adapter<WeekAdapter.ViewHolder>{
//    Activity activity;
//    int  row_index = -1;
//    List<MenuData> RetroClas;
//    public WeekAdapter(FragmentActivity activity, List<MenuData> myRetroClas) {
//        this.activity=activity;
//        this.RetroClas =  myRetroClas;
//    }
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//        View view = inflater.inflate(R.layout.week_item,parent,false);
//        return new ViewHolder(view);
//    }
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder,final int position) {
//        holder.DateText.setText(ConvertTime(RetroClas.get(position).getDate()));
//        holder.DayText.setText(RetroClas.get(position).getWeekday());
//        holder.FoodItemOne.setText(RetroClas.get(position).getMealsData().get(0).getMeals().get(0).getName());
//        holder.FoodItemTwo.setText(RetroClas.get(position).getMealsData().get(0).getMeals().get(1).getName());
//        holder.FoodItemThree.setVisibility(View.GONE);
//        holder.groupLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                row_index=position;
//                notifyDataSetChanged();
//
//            }
//
//        });
//        if(row_index==position){
//            holder.groupLayout.setBackgroundColor(Color.parseColor("#0a90ce0b"));
//        }
//        else
//        {
//            holder.groupLayout.setBackgroundColor(Color.parseColor("#ffffff"));
//        }
//    }
//    private String ConvertTime(String updateDate) {
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        SimpleDateFormat format1 = new SimpleDateFormat("dd");
//        java.util.Date date = null;
//        try {
//            date = format.parse(updateDate);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        String convertedDate = format1.format(date);
//        return convertedDate;
//    }
//    @Override
//    public int getItemCount() {
//        return RetroClas.size();
//    }
//    public class ViewHolder extends RecyclerView.ViewHolder{
//        LinearLayout groupLayout;
//        TextView DateText,DayText,FoodItemOne,FoodItemTwo,FoodItemThree;
//        public ViewHolder(View itemView) {
//            super(itemView);
//            groupLayout = itemView.findViewById(R.id.groupLayout);
//            DateText  = itemView.findViewById(R.id.DateText);
//            DayText  = itemView.findViewById(R.id.DayText);
//            FoodItemOne  = itemView.findViewById(R.id.FoodItemOne);
//            FoodItemTwo  = itemView.findViewById(R.id.FoodItemTwo);
//            FoodItemThree  = itemView.findViewById(R.id.FoodItemThree);
//
//        }
//    }
//}


































//        ArrayList<Meal> GetName = new ArrayList<>();
//        if (GetName.add(RetroClas.get(position).getMealsData().get(0).getMeals().get(2))){
//            for (int i = 0; i <GetName.size() ; i++) {
//                holder.FoodItemThree.setVisibility(View.VISIBLE);
//                holder.FoodItemThree.setText(GetName.get(2).getName());
//            }
//        }
//        else{
//            holder.FoodItemThree.setVisibility(View.GONE);
//            Toast.makeText(activity, "", Toast.LENGTH_SHORT).show();
//        }

