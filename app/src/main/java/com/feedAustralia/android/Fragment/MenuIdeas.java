package com.feedAustralia.android.Fragment;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.feedAustralia.android.pojo.mealpkg.MealGroup;
import com.feedAustralia.android.Activity.RecipesDescription;
import com.feedAustralia.android.Activity.SessionManager;
import com.feedAustralia.android.R;
import com.feedAustralia.android.pojo.ApiInterface;
import com.feedAustralia.android.pojo.Meal.MealTime;
import com.feedAustralia.android.pojo.recipe.Group;
import com.feedAustralia.android.pojo.recipe.Meal;
import com.feedAustralia.android.pojo.recipe.RecipeDatum;
import java.util.ArrayList;
import java.util.List;

import pl.droidsonroids.gif.GifTextView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by asd on 04-02-2019.
 */

public class MenuIdeas extends Fragment implements View.OnClickListener {
    View view=null;
    RecyclerView recipeimageview,mealtimeview,foodgroupView;
    LinearLayout SelectedFood,AllFood;
    TextView meal,All;
    List<Meal> recipeData,recipeDataAll;
    RecipesAdapter recipesAdapter;
    FoodTimeAdapter foodAdapter;
    foodGroupAdapter foodGroupAdapter;
    public static MenuIdeas newInstance() {
        return new MenuIdeas();
    }
    Boolean loaddata = false;
    int value = 0;
    GifTextView loading;

    String melasstr;
    String snack,custommeals;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.menu_ideas, container, false);
        SelectedFood = view.findViewById(R.id.SelectedFood);
        meal = view.findViewById(R.id.meals);
        loading = view.findViewById(R.id.loading);

        All = view.findViewById(R.id.All);
        AllFood = view.findViewById(R.id.AllFood);
        AllFood.setOnClickListener(this);
        recipeimageview = view.findViewById(R.id.recipeimageview);
        SelectedFood =view.findViewById(R.id.SelectedFood);
        SelectedFood.setOnClickListener(this);
        recipeimageview.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mealtimeview = view.findViewById(R.id.mealtimeView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mealtimeview.setLayoutManager(layoutManager);
        foodgroupView = view.findViewById(R.id.foodgroupView);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getActivity());
        foodgroupView.setLayoutManager(layoutManager1);
        return view;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.SelectedFood:
                if (value ==0){
                    mealtimeview.setVisibility(View.VISIBLE);
                    value =1;
                }else if (value ==1){
                    mealtimeview.setVisibility(View.GONE);
                    value = 0;
                }
                break;
            case R.id.AllFood:
                if (value ==0){

                    foodgroupView.setAdapter(null);
                    foodgroupView.setAdapter(foodGroupAdapter);
                    foodgroupView.setVisibility(View.VISIBLE);
                    value =1;
                }else if (value ==1){
                    foodgroupView.setVisibility(View.GONE);
                    value = 0;
                }
                break;

        }
    }


    public void  apitime(){

        String auth_token =SessionManager.getAuth_token(getActivity());
        String childId = SessionManager.child(getActivity());
        String schemeId = SessionManager.Schemeid(getActivity());
        String serviceId = SessionManager.serviceId(getActivity());
        if(serviceId.equals(""))
            serviceId = null;
        if(schemeId.equals(""))
            schemeId = null;
        ApiInterface apiInterface = ApiInterface.retrofit.create(ApiInterface.class);
        Call<List<MealTime>> Service = apiInterface.timelist(childId,schemeId,serviceId,auth_token);
        Service.enqueue(new Callback<List<MealTime>>() {
            @Override
            public void onResponse(Call<List<MealTime>> call, Response<List<MealTime>> response) {
                List<MealTime> mealtime = response.body();

                List<MealTime> mealtimes  = new ArrayList<>();
                for(MealTime meal:mealtime){

                    if(meal.getId()!=null)
                        mealtimes.add(meal);
                }


                if (mealtimes != null && mealtimes.size()>0){
                    String melaslunch  = mealtimes.get(0).getName();
                    meal.setText(melaslunch);
                    foodAdapter = new FoodTimeAdapter(getActivity(),mealtimes);
                    mealtimeview.setAdapter(foodAdapter);
                    Api(mealtimes.get(0).getId());

                }else{
                    Toast.makeText(getActivity(), "Failed", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<List<MealTime>> call, Throwable t) {
                Log.d("fff", "onFailure: "+t);

            }
        });
    }




    public void apigroup() {
        loading.setVisibility(View.VISIBLE);
        loaddata = true;
        String auth_token =SessionManager.getAuth_token(getActivity());
        String childId = SessionManager.child(getActivity());
        String schemeId = SessionManager.Schemeid(getActivity());
        String serviceId = SessionManager.serviceId(getActivity());
        if(serviceId.equals(""))
            serviceId = null;
        if(schemeId.equals(""))
            schemeId = null;
        ApiInterface apiInterface = ApiInterface.retrofit.create(ApiInterface.class);
        Call<List<MealGroup>> Service = apiInterface.mealgroup(childId,schemeId,serviceId,auth_token);
        Service.enqueue(new Callback<List<MealGroup>>() {
            @Override
            public void onResponse(Call<List<MealGroup>> call, Response<List<MealGroup>> response) {
                List<MealGroup> groups = response.body();
                if (groups !=null && groups.size()>0){
                    All.setText("All food groups");

                    MealGroup group = new MealGroup();
                    group.setId(0);
                    group.setName("All food groups");
                    groups.add(0,group);
                    foodGroupAdapter = new foodGroupAdapter(getActivity(),groups);
                    foodgroupView.setAdapter(foodGroupAdapter);
                    apitime();
                }else{
                    Toast.makeText(getActivity(), "Failed", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<List<MealGroup>> call, Throwable t) {
                Log.d("error", "onFailure: "+t);
            }
        });
    }
    public void Api(Integer mealTimeId){
        String Auth_token= SessionManager.getAuth_token(getActivity());
        String childID = SessionManager.child(getActivity());
        String schemeID = SessionManager.Schemeid(getActivity());
        ApiInterface apiInterface = ApiInterface.retrofit.create(ApiInterface.class);
        String serviceId = SessionManager.serviceId(getActivity());
        if(serviceId.equals(""))
            serviceId = null;
        if(schemeID.equals(""))
            schemeID = null;
        Call<List<RecipeDatum>> Service = apiInterface.recipelist(childID,schemeID,serviceId,mealTimeId,Auth_token);
        Service.enqueue(new Callback<List<RecipeDatum>>() {
            @Override
            public void onResponse(Call<List<RecipeDatum>> call, Response<List<RecipeDatum>> response) {


                recipeData = response.body().get(0).getMeals();
                recipeDataAll = new ArrayList<Meal>();
                recipeDataAll.addAll(recipeData);
                if (recipeData != null){
                    recipesAdapter = new RecipesAdapter(getActivity(),recipeData);
                    recipeimageview.setAdapter(recipesAdapter);
                    recipesAdapter.notifyDataSetChanged();
                }else{
                    Toast.makeText(getActivity(), "Failed", Toast.LENGTH_SHORT).show();
                }
                loading.setVisibility(View.GONE);

            }
            @Override
            public void onFailure(Call<List<RecipeDatum>> call, Throwable t) {
                Toast.makeText(getActivity(), "respone"+t, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void ApiCustomMeals(){
        String Auth_token= SessionManager.getAuth_token(getActivity());
        String childID = SessionManager.child(getActivity());
        String schemeID = SessionManager.Schemeid(getActivity());
        ApiInterface apiInterface = ApiInterface.retrofit.create(ApiInterface.class);
        String serviceId = SessionManager.serviceId(getActivity());
        if(serviceId.equals(""))
            serviceId = null;
        if(schemeID.equals(""))
            schemeID = null;
        Call<List<RecipeDatum>> Service = apiInterface.recipelistCustomMeals(childID,schemeID,serviceId,"true",Auth_token);
        Service.enqueue(new Callback<List<RecipeDatum>>() {
            @Override
            public void onResponse(Call<List<RecipeDatum>> call, Response<List<RecipeDatum>> response) {

                List<RecipeDatum> data = response.body();
                if(data!=null && data.size()>0) {
                    recipeData = response.body().get(0).getMeals();
                    recipeDataAll = new ArrayList<Meal>();
                    recipeDataAll.addAll(recipeData);
                    if (recipeData != null) {
                        recipesAdapter = new RecipesAdapter(getActivity(), recipeData);
                        recipeimageview.setAdapter(recipesAdapter);
                        recipesAdapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(getActivity(), "Failed", Toast.LENGTH_SHORT).show();
                    }
                    loading.setVisibility(View.GONE);

                }
                else
                {
                    Toast.makeText(getActivity(), "Failed", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<List<RecipeDatum>> call, Throwable t) {
                Toast.makeText(getActivity(), "respone"+t, Toast.LENGTH_SHORT).show();
            }
        });
    }



    public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.ViewHolder> {
        Activity activity;
        List<Meal> recipeData;
        public RecipesAdapter(FragmentActivity activity, List<Meal> recipeData) {
            this.activity =activity;
            this.recipeData=recipeData;
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
//            final List<Meal> meals = recipeData.get(0).getMeals();
            Meal selectedMeal = recipeData.get(position);
            Glide.with(activity).load(selectedMeal.getImageUrl()).apply(RequestOptions.placeholderOf(R.drawable.mealplaceholder)).into(holder.imageItem);
            holder.name.setText(selectedMeal.getName());
            holder.itemlayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(activity,RecipesDescription.class);
                    Meal selectedMeal = recipeData.get(position);
                    intent.putExtra("meal",selectedMeal);
                    activity.startActivity(intent);
                }
            });
        }
        @Override
        public int getItemCount() {
            return recipeData.size();
        }
        public class ViewHolder extends RecyclerView.ViewHolder{
            RelativeLayout itemlayout;
            ImageView imageItem;
            TextView name;
            public ViewHolder(View itemView) {
                super(itemView);
                itemlayout = itemView.findViewById(R.id.itemlayout);
                imageItem = itemView.findViewById(R.id.imageItem);
                name = itemView.findViewById(R.id.name);
            }
        }
    }
    public class FoodTimeAdapter extends RecyclerView.Adapter<FoodTimeAdapter.ViewHolder> {
        Activity activity;
        List<MealTime> dayInterval;
        private int lastSelectedPosition = 0;
        public FoodTimeAdapter(FragmentActivity activity, List<MealTime> dayInterval) {
            this.activity = activity;
            this.dayInterval=dayInterval;
        }
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.food_item,parent,false);
            return new ViewHolder(view) ;
        }
        @Override
        public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
            holder.listOption.setText(dayInterval.get(position).getName());


            if(position==0)
                holder.seperator.setVisibility(View.VISIBLE);
            else
                holder.seperator.setVisibility(View.GONE);


            if(lastSelectedPosition == position)
            {
                holder.checkbox.setVisibility(View.VISIBLE);
                holder.checkbox.setChecked(true);
            }
            else {
                holder.checkbox.setVisibility(View.GONE);
                holder.checkbox.setChecked(false);
            }
            holder.listOne.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    if(dayInterval.get(position).getCode().equals("custom_meals"))
                    {
                        loading.setVisibility(View.VISIBLE);
                        ApiCustomMeals();
                    }
                    else
                    {
                        loading.setVisibility(View.VISIBLE);
                        Api(dayInterval.get(position).getId());
                    }
                    lastSelectedPosition = position;
                    meal.setText(dayInterval.get(position).getName());
                    mealtimeview.setVisibility(View.INVISIBLE);
                    notifyDataSetChanged();

                }
            });
        }
        @Override
        public int getItemCount() {
            return dayInterval.size();
        }
        public class ViewHolder extends RecyclerView.ViewHolder{
            TextView listOption;
            RadioButton checkbox;
            RelativeLayout listOne;
            View seperator;
            public ViewHolder(View itemView) {
                super(itemView);
                listOne = itemView.findViewById(R.id.listOne);
                listOption = itemView.findViewById(R.id.listOption);
                checkbox = itemView.findViewById(R.id.checkbox);
                seperator = itemView.findViewById(R.id.seperator);

            }
        }
    }
    public class foodGroupAdapter extends RecyclerView.Adapter<foodGroupAdapter.ViewHolder>{
        Activity activity;
        List<MealGroup> allfood;
        private int lastSelectedPosition = 0;

        public foodGroupAdapter(Activity activity, List<MealGroup> allfood) {
            this.activity=activity;
            this.allfood=allfood;
        }
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.food_item,parent,false);
            return new ViewHolder(view);
        }
        @Override
        public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
            holder.listOption.setText(allfood.get(position).getName());


            if(position==0)
                holder.seperator.setVisibility(View.VISIBLE);
            else
                holder.seperator.setVisibility(View.GONE);

            if(lastSelectedPosition == position)
            {
                holder.checkbox.setVisibility(View.VISIBLE);
                holder.checkbox.setChecked(true);
            }
            else {
                holder.checkbox.setVisibility(View.GONE);
                holder.checkbox.setChecked(false);
            }

            holder.listOne.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lastSelectedPosition = position;
                    All.setText(allfood.get(position).getName());
                    foodgroupView.setVisibility(View.INVISIBLE);

                    if(allfood.get(position).getName().equals("All food groups"))
                    {
                        recipeData.clear();
                        recipeData.addAll(recipeDataAll);
                        recipesAdapter.notifyDataSetChanged();
                    }
                    else {
                        List<Meal> meals = new ArrayList<>();
                        for(Meal meal : recipeDataAll)
                        {
                            List<Group> groups = meal.getGroups();
                            for(Group group : groups)
                            {
                                if(allfood.get(position).getCode().equals(group.getCode()))
                                {
                                    if(group.getIsActive())
                                    {
                                        meals.add(meal);
                                    }
                                }
                            }
                        }
                        recipeData.clear();
                        recipeData.addAll(meals);
                        recipesAdapter.notifyDataSetChanged();

                    }


                }
            });
        }
        @Override
        public int getItemCount() {
            return allfood.size();
        }
        public class ViewHolder extends RecyclerView.ViewHolder{
            TextView listOption;
            RadioButton checkbox;
            RelativeLayout listOne;
            View seperator;
            public ViewHolder(View itemView) {
                super(itemView);
                listOne = itemView.findViewById(R.id.listOne);
                listOption = itemView.findViewById(R.id.listOption);
                checkbox = itemView.findViewById(R.id.checkbox);
                seperator = itemView.findViewById(R.id.seperator);

            }
        }
    }
}




























