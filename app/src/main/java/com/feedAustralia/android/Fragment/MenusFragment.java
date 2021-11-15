//package com.journaldev.android.Fragment;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.graphics.Color;
//import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentActivity;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.CalendarView;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.PopupWindow;
//import android.widget.RatingBar;
//import android.widget.RelativeLayout;
//import android.widget.ScrollView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.bumptech.glide.Glide;
//import com.bumptech.glide.request.RequestOptions;
//import MenuDescription;
//import ProfileMain;
//import SessionManager;
//import com.journaldev.android.R;
//import ApiInterface;
//import Group;
//import Meal;
//import MealsDatum;
//import MenuData;
//import MealsDataList;
//import Nutrition;
//import Nutrition_;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.List;
//import de.hdodenhof.circleimageview.CircleImageView;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
///**
// * Created by asd on 22-02-2019.
// */
//
//public class MenusFragment extends Fragment implements View.OnClickListener {
//    RecyclerView recyclerView,recyclerview1,recyclerView4;
//    WeekAdapter weekAdapter;
//    MenusAdapter menusAdapter;
//    //    NutrientAdapter nutrientAdapter;
//    View view=null;
//    ScrollView scrollView;
//    RatingBar ratingBar;
//    TextView PacifDate;
//    LinearLayoutManager layoutManager1,layoutManager2;
//    CircleImageView profile_image;
//    ImageView calenderView,settings;
//    private PopupWindow mDropdown = null;
//    LayoutInflater mInflater;
//    Calendar calendar;
//    CalendarView calendarView;
//    public static MenusFragment newInstance() {
//        return new MenusFragment();
//    }
//    String GetDate,SetDAte;
//    List<MenuData> myRetroClas;
//    String MeatStr,VegetablesStr,BreadStr,FruitStr,DairyStr;
//    TextView meatquantity,Dairyquantity,Breadquantity,Fruitquantity,Vegetablesquantity;
//    Group meal_group;
//
//    TextView EnergyServe;
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
//    {
//        view = inflater.inflate(R.layout.fragment_menu, container, false);
//        calendar = Calendar.getInstance();
//        meatquantity =view.findViewById(R.id.meatquantity);
//        Dairyquantity =view.findViewById(R.id.Dairyquantity);
//        Breadquantity =view.findViewById(R.id.Breadquantity);
//        Fruitquantity =view.findViewById(R.id.Fruitquantity);
//        Vegetablesquantity =view.findViewById(R.id.Vegetablesquantity);
//        EnergyServe = view.findViewById(R.id.EnergyServe);
//        myRetroClas = new ArrayList<>();
//        ArrayList<String> Supliments = new ArrayList<>();
//        Supliments.add("Energy");
//        Supliments.add("Protein");
//        Supliments.add("Fat - total");
//        Supliments.add("Carbohydrate - total");
//        Supliments.add("Carbohydrate - Sugar");
//        Supliments.add("Sodium");
//        ArrayList<String> perServe = new ArrayList<>();
//        perServe.add(" 2881.5 kj");
//        perServe.add("    28.4 g");
//        perServe.add("    16.3 g");
//        perServe.add("    95.6 g");
//        perServe.add("    45.5 g");
//        perServe.add("   769.2 g");
//
//        ArrayList<String> perGrams = new ArrayList<>();
//        perGrams.add(" 550.6 kj");
//        perGrams.add("    4.1 g");
//        perGrams.add("    3.5 g");
//        perGrams.add("   18.9 g");
//        perGrams.add("    8.2 g");
//        perGrams.add("  131.0 g");
//
//        calendar.set(Calendar.MONTH, Calendar.NOVEMBER);
//        calendar.set(Calendar.DAY_OF_MONTH, 9);
//        calendar.set(Calendar.YEAR, 2012);
//        calendar.add(Calendar.DAY_OF_MONTH, 1);
//        calendar.add(Calendar.YEAR, 1);
//        calendarView = view.findViewById(R.id.calendarView);
//        PacifDate = view.findViewById(R.id.PacifDate);
//        profile_image = view.findViewById(R.id.profile_image);
//        profile_image.setOnClickListener(this);
//        calenderView =view.findViewById(R.id.calenderView);
//        calenderView.setOnClickListener(this);
//        settings = view.findViewById(R.id.settings);
//        settings.setOnClickListener(this);
//        scrollView = view.findViewById(R.id.scrollView);
//        ratingBar = view.findViewById(R.id.ratingBar);
//        ratingBar.setRating(5.00f);
//        recyclerView = view.findViewById(R.id.recyclerView);
//        recyclerView.setNestedScrollingEnabled(false);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
//        recyclerView.setLayoutManager(layoutManager);
//        Api();
//        ApiClient();
//        recyclerview1  = view.findViewById(R.id.recyclerview1);
//        recyclerview1.setNestedScrollingEnabled(false);
//        layoutManager1 = new LinearLayoutManager(getActivity());
//        recyclerview1.setLayoutManager(layoutManager1);
//
////        NutriApi();
////        recyclerView4 = view.findViewById(R.id.recyclerView4);
////        recyclerView4.setNestedScrollingEnabled(false);
////        layoutManager2 = new LinearLayoutManager(getActivity());
////        recyclerView4.setLayoutManager(layoutManager2);
////        nutrientAdapter = new NutrientAdapter(getActivity(),Supliments,perServe,perGrams);
////        recyclerView4.setAdapter(nutrientAdapter);
//        return view;
//    }
//    public void Api(){
//        Toast.makeText(getActivity(), SessionManager.getAuth_token(getActivity()), Toast.LENGTH_SHORT).show();
//        String Auth_token=SessionManager.getAuth_token(getActivity());
//        ApiInterface apiClent = ApiInterface.retrofit.create(ApiInterface.class);
//        Call<List<MenuData>> Service = apiClent.menulist("2421373","6830","1805",
//                "2019-02-19","week","true","true","true",Auth_token);
//        Service.enqueue(new Callback<List<MenuData>>() {
//            @Override
//            public void onResponse(Call<List<MenuData>> call, Response<List<MenuData>> response) {
//                List <MenuData>  myRetroClas = response.body();
//                if (myRetroClas !=null){
//                    for (int i = 0; i <myRetroClas.size() ; i++) {
//                        SetDAte = myRetroClas.get(i).getDate();
//                        PacifDate.setText(convertTime(SetDAte));
//                    }
//                    weekAdapter = new WeekAdapter(getActivity(), myRetroClas);
//                    recyclerView.setAdapter(weekAdapter);
//                }
//                else{
//                    Toast.makeText(getActivity(), "Invalid Data", Toast.LENGTH_SHORT).show();
//                }
//            }
//            @Override
//            public void onFailure(Call<List<MenuData>> call, Throwable t) {
//                Toast.makeText(getActivity(), "Failure"+t, Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//    private String convertTime(String setDAte) {
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        SimpleDateFormat format1 = new SimpleDateFormat("MMM, dd, yyyy");
//        java.util.Date date = null;
//        try {
//            date = format.parse(setDAte);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        String convertedDate = format1.format(date);
//        return convertedDate;
//    }
//    public  void ApiClient(){
//        String Auth_token=SessionManager.getAuth_token(getActivity());
//        ApiInterface apiInterface = ApiInterface.retrofit.create(ApiInterface.class);
//        Call<List<MealsDataList>> Service = apiInterface.menulistone("2421373","6830","1805",
//                "2019-02-18","day","true","true","true",Auth_token);
//        Service.enqueue(new Callback<List<MealsDataList>>() {
//            @Override
//            public void onResponse(Call<List<MealsDataList>> call, Response<List<MealsDataList>> response) {
//                List<MealsDataList> myRetroClas = response.body();
//                Nutrition_ nutrition = myRetroClas.get(0).getNutrition();
//                String  Energy = String.valueOf(Double.valueOf(nutrition.getEnergy()));
//                EnergyServe.setText(Energy);
//                if (myRetroClas != null && myRetroClas.size()>0){
//                    MealsDataList menuData = myRetroClas.get(0);
//                    List<MealsDatum> mealsDatum =  menuData.getMealsData();
//                    List<Meal> meals = new ArrayList<>();
//                    for (int i = 0; i <mealsDatum.size() ; i++) {
//                        MealsDatum meal_group =   mealsDatum.get(i);
//                        List<Meal> meal = meal_group.getMeals();
//                        for(Meal mea : meal)
//                        {
//                            String meal_time =  meal_group.getMealsTime().getName();
//                            mea.setMealTime(meal_time);
//                            meals.add(mea);
//                        }
//                    }
//                    menusAdapter = new MenusAdapter(getActivity(),meals);
//                    recyclerview1.setAdapter(menusAdapter);
//                }
//                else{
//                    Toast.makeText(getActivity(), "Invalid Data", Toast.LENGTH_SHORT).show();
//                }
//            }
//            @Override
//            public void onFailure(Call<List<MealsDataList>> call, Throwable t) {
//                Log.d("Failure", "onFailure: "+t);
//            }
//        });
//    }
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.profile_image:
//                Intent intent = new Intent(getActivity(), ProfileMain.class);
//                startActivity(intent);
//                break;
//            case R.id.calenderView:
//
//                break;
//            case R.id.settings:
////                initiatePopupWindow();
//                break;
//        }
//    }
//    public class WeekAdapter extends RecyclerView.Adapter<WeekAdapter.ViewHolder>{
//        Activity activity;
//        int  row_index = -1;
//        List<MenuData> RetroClas;
////        List<MealsDataList> RetroClas;
//        public WeekAdapter(FragmentActivity activity, List<MenuData> myRetroClas) {
//            this.activity=activity;
//            this.RetroClas =  myRetroClas;
//        }
//        @NonNull
//        @Override
//        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//            View view = inflater.inflate(R.layout.week_item,parent,false);
//            return new ViewHolder(view);
//        }
//        @Override
//        public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
//            holder.DateText.setText(ConvertTime(RetroClas.get(position).getDate()));
//            holder.DayText.setText(RetroClas.get(position).getWeekday());
//            List<MealsDatum> meals = RetroClas.get(position).getMealsData();
//            String mealstr = "";
//            for (int i = 0; i <meals.size() ; i++) {
//               MealsDatum meal_group =   meals.get(i);
//                List<Meal> meal = meal_group.getMeals();
//                for(Meal mea : meal)
//                {
//                    mealstr = mealstr +"\n"+ mea.getName();
//                }
//            }
//            holder.FoodItemOne.setText(mealstr);
//            holder.groupLayout.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    row_index=position;
//                    notifyDataSetChanged();
//                    ApiClient();
//                    GetDate = RetroClas.get(position).getDate();
//                    PacifDate.setText(convertTime(GetDate));
////                    NutriApi();
//                }
//            });
//            if(row_index==position){
//                holder.groupLayout.setBackgroundColor(Color.parseColor("#0a90ce0b"));
//            }
//            else
//            {
//                holder.groupLayout.setBackgroundColor(Color.parseColor("#ffffff"));
//            }
//        }
//        private String convertTime(String GetDate) {
//            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//            SimpleDateFormat format1 = new SimpleDateFormat("MMM, dd, yyyy");
//            java.util.Date date = null;
//            try {
//                date = format.parse(GetDate);
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//            String convertedDate = format1.format(date);
//            return convertedDate;
//        }
//        private String ConvertTime(String updateDate) {
//            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//            SimpleDateFormat format1 = new SimpleDateFormat("d");
//            java.util.Date date = null;
//            try {
//                date = format.parse(updateDate);
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//            String convertedDate = format1.format(date);
//            return convertedDate;
//        }
//        @Override
//        public int getItemCount() {
//            return RetroClas.size();
//        }
//        public class ViewHolder extends RecyclerView.ViewHolder {
//            LinearLayout groupLayout;
//            TextView DateText, DayText, FoodItemOne;
//            public ViewHolder(View itemView) {
//                super(itemView);
//                groupLayout = itemView.findViewById(R.id.groupLayout);
//                DateText = itemView.findViewById(R.id.DateText);
//                DayText = itemView.findViewById(R.id.DayText);
//                FoodItemOne = itemView.findViewById(R.id.FoodItemOne);
//            }
//        }
//    }
//    public class MenusAdapter extends RecyclerView.Adapter<MenusAdapter.ViewHolder>{
//        Activity activity;
//        List<Meal> myRetroClas;
////        public MenusAdapter(FragmentActivity activity, List<Meal> myRetroClas) {
////            this.activity=activity;
////            this.myRetroClas=myRetroClas;
////        }
//
//
//        public MenusAdapter(FragmentActivity activity, List<Meal> myRetroClas) {
//            this.activity=activity;
//            this.myRetroClas=myRetroClas;
//        }
//        @NonNull
//        @Override
//        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//            View view = inflater.inflate(R.layout.menu_item,parent,false);
//            return new ViewHolder(view);
//        }
//        @Override
//        public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
//            holder.MenuName.setText(myRetroClas.get(position).getMealTime());
//            holder.menuItemName.setText(myRetroClas.get(position).getName());
//            Glide.with(activity)
//                    .load(myRetroClas.get(position).getImageUrl()).
//                    apply(RequestOptions.placeholderOf(R.drawable.burger).error(R.drawable.burger)).into(holder.roundedImageView);
//            List<Group> group = myRetroClas.get(position).getGroups();
//            for (int i = 0; i < group.size(); i++) {
//                meal_group = group.get(i);
//                if(meal_group.getCode().equals("meat") && meal_group.getIsActive())
//                {
//                    holder.Meat.setText(meal_group.getName());
//                    MeatStr = String.valueOf(new Double(meal_group.getAmount()));
//                    meatquantity.setText(MeatStr);
//                    holder.MeatValue.setText(MeatStr);
//                    holder.Forth.setVisibility(View.VISIBLE);
//                }
//                else if(meal_group.getCode().equals("dairy") && meal_group.getIsActive() )
//                {
//                    holder.Dairy.setText(meal_group.getName());
//                    DairyStr = String.valueOf(new Double(meal_group.getAmount()));
//                    Dairyquantity.setText(DairyStr);
//                    holder.DairyValue.setText(DairyStr);
//                    holder.Second.setVisibility(View.VISIBLE);
//                }
//                else if(meal_group.getCode().equals("cereal") && meal_group.getIsActive())
//                {
//                    holder.Bread.setText(meal_group.getName());
//                    BreadStr = String.valueOf(new Double(meal_group.getAmount()));
//                    Breadquantity.setText(BreadStr);
//                    holder.BreadValue.setText(BreadStr);
//                    holder.Third.setVisibility(View.VISIBLE);
//                }
//                else if(meal_group.getCode().equals("fruit") && meal_group.getIsActive())
//                {
//                    holder.Fruit.setText(meal_group.getName());
//                    FruitStr = String.valueOf(new Double(meal_group.getAmount()));
//                    Fruitquantity.setText(FruitStr);
//                    holder.FruitValue.setText(FruitStr);
//                    holder.First.setVisibility(View.VISIBLE);
//                }
//                else if(meal_group.getCode().equals("vegetables") && meal_group.getIsActive())
//                {
//                    holder.Vegetables.setText(meal_group.getName());
//                    VegetablesStr = String.valueOf(new Double(meal_group.getAmount()));
//                    Vegetablesquantity.setText(VegetablesStr);
//                    holder.VegetablesValue.setText(VegetablesStr);
//                    holder.Fifth.setVisibility(View.VISIBLE);
//                }
//            }
//            holder.ParseData.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(activity, MenuDescription.class);
//                    intent.putExtra("MealTime",myRetroClas.get(position).getMealTime());
//                    intent.putExtra("MealName",myRetroClas.get(position).getName());
//                    intent.putExtra("Description",myRetroClas.get(position).getMethodDescription());
//                    intent.putExtra("Fruit_Str",holder.Fruit.getText().toString());
//                    intent.putExtra("Fruit_Values",holder.FruitValue.getText().toString());
//                    intent.putExtra("Dairy_Str",holder.Dairy.getText().toString());
//                    intent.putExtra("Dairy_Values",  holder.DairyValue.getText().toString());
//                    intent.putExtra("Bread_Str",holder.Bread.getText().toString());
//                    intent.putExtra("Bread_Values", holder.BreadValue.getText().toString());
//                    intent.putExtra("Meat_Str",holder.Meat.getText().toString());
//                    intent.putExtra("Meat_Values",holder.MeatValue.getText().toString());
//                    intent.putExtra("Vegetables_Str",holder.Vegetables.getText().toString());
//                    intent.putExtra("Vegetables_Values", holder.VegetablesValue.getText().toString());
//                    intent.putExtra("ImageUrl",myRetroClas.get(position).getImageUrl());
//                    startActivity(intent);
//                }
//            });
//        }
//        @Override
//        public int getItemCount() {
//            return myRetroClas.size();
//        }
//        public class ViewHolder extends RecyclerView.ViewHolder{
//            TextView MenuName,menuItemName,Fruit,FruitValue,Dairy,DairyValue,Bread,BreadValue,Meat,MeatValue,Vegetables,VegetablesValue;
//            RelativeLayout ParseData;
//            ImageView roundedImageView;
//            RelativeLayout First,Second,Third,Forth,Fifth;
//            public ViewHolder(View itemView) {
//                super(itemView);
//                MenuName = itemView.findViewById(R.id.MenuName);
//                ParseData = itemView.findViewById(R.id.ParseData);
//                roundedImageView = itemView.findViewById(R.id.roundedImageView);
//                menuItemName = itemView.findViewById(R.id.menuItemName);
//                Fruit = itemView.findViewById(R.id.Fruit);
//                FruitValue = itemView.findViewById(R.id.FruitValue);
//                Fruit = itemView.findViewById(R.id.Fruit);
//                FruitValue = itemView.findViewById(R.id.FruitValue);
//                Dairy = itemView.findViewById(R.id.Dairy);
//                DairyValue = itemView.findViewById(R.id.DairyValue);
//                Bread = itemView.findViewById(R.id.Bread);
//                BreadValue = itemView.findViewById(R.id.BreadValue);
//                Meat = itemView.findViewById(R.id.Meat);
//                MeatValue = itemView.findViewById(R.id.MeatValue);
//                Vegetables = itemView.findViewById(R.id.Vegetables);
//                VegetablesValue = itemView.findViewById(R.id.VegetablesValue);
//                First =  itemView.findViewById(R.id.First);
//                Second =  itemView.findViewById(R.id.Second);
//                Third =  itemView.findViewById(R.id.Third);
//                Forth =  itemView.findViewById(R.id.Forth);
//                Fifth =  itemView.findViewById(R.id.Fifth);
//            }
//        }
//    }
////    public void NutriApi(){
////        String Auth_token=SessionManager.getAuth_token(getActivity());
////        ApiInterface apiInterface = ApiInterface.retrofit.create(ApiInterface.class);
////        Call<List<MealsDataList>> Service = apiInterface.menulistone("2421373","6830","1805","2019-02-18",
////                "day","true","true","true",Auth_token);
////        Service.enqueue(new Callback<List<MealsDataList>>() {
////            @Override
////            public void onResponse(Call<List<MealsDataList>> call, Response<List<MealsDataList>> response) {
////                List<MealsDataList> mealsdata = response.body();
////                if (mealsdata != null && mealsdata.size()>0){
////                    for (int i = 0; i <mealsdata.size(); i++) {
////                       Nutrition_ Nutri = mealsdata.get(i).getNutrition();
////                        Log.d("GetData", "onResponse: "+Nutri.getEnergy());
////                        try {
////                           String Energy = String.valueOf(new Double(Nutri.getEnergy()));
////                            EnergyServe.setText(Energy);
////                            Toast.makeText(getActivity(), Energy, Toast.LENGTH_SHORT).show();
////                       }catch (Exception e){
////                           Log.d("Error", "onResponse: "+e);
////                       }
////                    }
////                }
////                else{
////                    Toast.makeText(getActivity(), "Invalid Data", Toast.LENGTH_SHORT).show();
////                }
////            }
////            @Override
////            public void onFailure(Call<List<MealsDataList>> call, Throwable t) {
////                Toast.makeText(getActivity(), "failed"+t, Toast.LENGTH_SHORT).show();
////            }
////        });
////    }
////    public class NutrientAdapter  extends RecyclerView.Adapter<NutrientAdapter.ViewHolder> {
////        Activity activity;
////        public NutrientAdapter(Activity activity) {
////            this.activity=activity;
////        }
////        @NonNull
////        @Override
////        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
////            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
////            View view = inflater.inflate(R.layout.nutri_item,parent,false);
////            return new ViewHolder(view);
////        }
////        @Override
////        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
////
////            if (position  % 2 == 0){
////                holder.MainLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
////            }else {
////                holder.MainLayout.setBackgroundColor(Color.parseColor("#F3F3F3"));
////            }
////        }
////        @Override
////        public int getItemCount() {
//////            return Supliments.size();
////            return 7;
////        }
////        public class ViewHolder extends RecyclerView.ViewHolder{
////            TextView Suplliment,ServingsQuantity,PerGrams;
////            LinearLayout MainLayout;
////            public ViewHolder(View itemView) {
////                super(itemView);
////                Suplliment = itemView.findViewById(R.id.Suplliment);
////                ServingsQuantity = itemView.findViewById(R.id.ServingsQuantity);
////                PerGrams = itemView.findViewById(R.id.PerGrams);
////                MainLayout = itemView.findViewById(R.id.MainLayout);
////            }
////        }
////    }
//
//
//
//
//
//
//
//
//
//
//
//
////    public class NutrientAdapter  extends RecyclerView.Adapter<NutrientAdapter.ViewHolder> {
////        Activity activity;
////        ArrayList<String> Supliments;
////        ArrayList<String> PerServe;
////        ArrayList<String> PerGrams;
////        public NutrientAdapter(Activity activity, ArrayList<String> supliments, ArrayList<String> perServe, ArrayList<String> perGrams) {
////            this.activity=activity;
////            this.Supliments=supliments;
////            this.PerServe=perServe;
////            this.PerGrams=perGrams;
////        }
////        @NonNull
////        @Override
////        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
////            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
////            View view = inflater.inflate(R.layout.nutri_item,parent,false);
////            return new ViewHolder(view);
////        }
////        @Override
////        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
////            holder.Suplliment.setText(Supliments.get(position));
////            holder.ServingsQuantity.setText(PerServe.get(position));
////            holder.PerGrams.setText(PerGrams.get(position));
////            if (position  % 2 == 0){
////                holder.MainLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
////            }else {
////                holder.MainLayout.setBackgroundColor(Color.parseColor("#F3F3F3"));
////            }
////        }
////        @Override
////        public int getItemCount() {
////            return Supliments.size();
////
////
////
////        }
////        public class ViewHolder extends RecyclerView.ViewHolder{
////            TextView Suplliment,ServingsQuantity,PerGrams;
////            LinearLayout MainLayout;
////            public ViewHolder(View itemView) {
////                super(itemView);
////                Suplliment = itemView.findViewById(R.id.Suplliment);
////                ServingsQuantity = itemView.findViewById(R.id.ServingsQuantity);
////                PerGrams = itemView.findViewById(R.id.PerGrams);
////                MainLayout = itemView.findViewById(R.id.MainLayout);
////            }
////        }
////    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//    //    public PopupWindow initiatePopupWindow(){
////        try {
////            mInflater = (LayoutInflater) getActivity()
////                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
////            View layout = mInflater.inflate(R.layout.popup_layout, null);
////            final LinearLayout Week = layout.findViewById(R.id.Week);
////            final LinearLayout Month = layout.findViewById(R.id.Month);
////            final ImageView Checkedone = layout.findViewById(R.id.Checkedone);
////            final ImageView Checkedtwo = layout.findViewById(R.id.Checkedtwo);
////            final RelativeLayout HideLayout = layout.findViewById(R.id.HideLayout);
////
////            layout.measure(View.MeasureSpec.UNSPECIFIED,
////                    View.MeasureSpec.UNSPECIFIED);
////            mDropdown = new PopupWindow(layout, FrameLayout.LayoutParams.WRAP_CONTENT,
////                    FrameLayout.LayoutParams.WRAP_CONTENT,true);
////            mDropdown.showAsDropDown(settings, 5, 5);
////            Week.setOnClickListener(new View.OnClickListener() {
////                @Override
////                public void onClick(View v) {
////                    Checkedone.setVisibility(View.VISIBLE);
////                    Checkedtwo.setVisibility(View.INVISIBLE);
////                    HideLayout.setVisibility(View.GONE);
////                    CalnderShow();
////                }
////            });
////            Month.setOnClickListener(new View.OnClickListener() {
////                @Override
////                public void onClick(View v) {
////                    Checkedtwo.setVisibility(View.VISIBLE);
////                    Checkedone.setVisibility(View.INVISIBLE);
////                }
////            });
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////        return mDropdown;
////    }
////    private PopupWindow CalnderShow() {
////        try {
////            mInflater = (LayoutInflater) getActivity()
////                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
////            View layout = mInflater.inflate(R.layout.calnder_layout, null);
////            final CalendarView calendarView = layout.findViewById(R.id.calendarView);
////            layout.measure(View.MeasureSpec.UNSPECIFIED,
////                    View.MeasureSpec.UNSPECIFIED);
////            mDropdown = new PopupWindow(layout, FrameLayout.LayoutParams.MATCH_PARENT,
////                    FrameLayout.LayoutParams.WRAP_CONTENT,true);
////            mDropdown.showAsDropDown(settings, 5, 5);
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////        return mDropdown;
////    }
//}
//
//
//
//
//
//
//
//
