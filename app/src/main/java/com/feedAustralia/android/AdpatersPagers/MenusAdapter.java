package com.feedAustralia.android.AdpatersPagers;


/**
 * Created by asd on 07-02-2019.
 */



//public class MenusAdapter extends RecyclerView.Adapter<MenusAdapter.ViewHolder> {
//    Activity activity;
//    List<MenuData> myRetroClas;
//    public MenusAdapter(FragmentActivity activity, List<MenuData> myRetroClas) {
//        this.activity=activity;
//        this.myRetroClas=myRetroClas;
//    }
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//        View view = inflater.inflate(R.layout.menu_item,parent,false);
//        return new ViewHolder(view);
//    }
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        holder.MenuName.setText(myRetroClas.get(position).getMealsData().get(1).getMealsTime().getName());
//
//    }
//    @Override
//    public int getItemCount() {
//        return myRetroClas.size();
//    }
//    public class ViewHolder extends RecyclerView.ViewHolder{
//        TextView MenuName;
//        RelativeLayout ParseData;
//        public ViewHolder(View itemView) {
//            super(itemView);
//            MenuName = itemView.findViewById(R.id.MenuName);
//            ParseData = itemView.findViewById(R.id.ParseData);
//        }
//    }
//}










//        if (myRetroClas.get(position).getMealsData().get(position).getMealsTime().getPosition().equals(0)){
//            holder.MenuName.setText(myRetroClas.get(position).getMealsData().get(position).getMealsTime().getName());
//        } else if (myRetroClas.get(position).getMealsData().get(position).getMealsTime().getPosition().equals(1)){
//            holder.MenuName.setText(myRetroClas.get(position).getMealsData().get(position).getMealsTime().getName());
//        }else if (myRetroClas.get(position).getMealsData().get(position).getMealsTime().getPosition().equals(2)){
//            holder.MenuName.setText(myRetroClas.get(position).getMealsData().get(position).getMealsTime().getName());
//        }
//        holder.MenuName.setText(myRetroClas.get(position).getMealsData().get(position).getMealsTime().getPosition());
//        holder.MenuName.setText(myRetroClas.get(position).getMealsData().get(position).getMealsTime());
//        holder.ParseData.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(activity, "Postion"+ position, Toast.LENGTH_SHORT).show();
//            }
//        });

































//public class MenusAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
//    private final int Header = 0;
//    private final int Menu_Item = 1;
//    private final LayoutInflater inflater;
//    Activity activity;
//    List<MenuData> myRetroClas;
//
//    public MenusAdapter(Activity activity, List<MenuData> myretroclas){
//        this.activity = activity;
//        this.myRetroClas = myretroclas;
//        inflater = LayoutInflater.from(activity);
//    }
//    @Override
//    public int getItemViewType(int position) {
//        int viewType = 0;
//        return viewType;
//    }
//    @NonNull
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
//        switch(viewType)
//        {
//            case 1:
//                View view1=LayoutInflater.from(activity).inflate(R.layout.header_item,viewGroup,false);
//                return new TextViewHolder(view1);
//            case 0:
//                View view2=LayoutInflater.from(activity).inflate(R.layout.menu_item,viewGroup,false);
//                return new Item1Holder(view2);
//        }
//        return null;
//    }
//    @Override
//    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int i) {
//        if(holder instanceof TextViewHolder){
//            ((TextViewHolder) holder).MenuName.setText((myRetroClas.get(i).getMealsData().get(i).getMealsTime().getName()));
//        }else if(holder instanceof Item1Holder){
////            ((Item1Holder) holder).itemTextView.setText();
//        }
//    }
//
//    @Override
//    public int getItemCount() {
//        return myRetroClas.size();
//    }
//
//    class TextViewHolder extends RecyclerView.ViewHolder {
//        TextView MenuName;
//        public TextViewHolder(View itemView) {
//            super(itemView);
//            MenuName = itemView.findViewById(R.id.MenuName);
//        }
//    }
//    class Item1Holder extends RecyclerView.ViewHolder {
//        TextView itemTextView;
//        RelativeLayout ParseData;
//        public Item1Holder(View itemView) {
//            super(itemView);
////            itemTextView = itemView.findViewById(R.id.tv);
//        }
//    }
//}
