package com.feedAustralia.android.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.feedAustralia.android.AdpatersPagers.NutrientAdapterr;
import com.feedAustralia.android.Fragment.ImageFragment;
import com.feedAustralia.android.pojo.MenuOne.Group;
import com.feedAustralia.android.pojo.MenuOne.Meal;
import com.feedAustralia.android.R;
import com.feedAustralia.android.pojo.MenuOne.IngredientsDatum;
import com.feedAustralia.android.pojo.MenuOne.Unit;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by asd on 09-02-2019.
 */

public class MenuDescription extends BaseActivity implements View.OnClickListener {
    RecyclerView recyclerView4;
    NutrientAdapterr nutrientAdapter;
    NestedScrollView ScrollView;
    RelativeLayout ImageLayout;
    RelativeLayout ViewLayout;
    String TAG = ImageFragment.class.getName();
    android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
    String MealTime,MealName,description,MeatStr = null,VegetablesStr = null,BreadStr = null,FruitStr = null,DairyStr = null,ImageUrl;
    String MeatValues,VegetablesValues,BreadValues,FruitValues,DairyValues;
    TextView MenuName,menuItemName,Fruit,FruitValue,Dairy,DairyValue,Bread,BreadValue,Meat,MeatValue,VegetablesData,VegetablesValue;
    TextView ingradientTV,Method;
    ImageView roundedImageView;
    RelativeLayout First,Second,Third,Forth,Fifth;
    String Tips;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_description);
        ViewLayout = findViewById(R.id.ViewLayout);
        ingradientTV = findViewById(R.id.ingradientTV);
        MenuName = findViewById(R.id.MenuName);
        menuItemName = findViewById(R.id.menuItemName);
        roundedImageView = findViewById(R.id.roundedImageView);
        Fruit = findViewById(R.id.Fruit);
        Dairy = findViewById(R.id.Dairy);
        Bread = findViewById(R.id.Bread);
        Meat = findViewById(R.id.Meat);
        VegetablesData = findViewById(R.id.VegetablesData);
        FruitValue = findViewById(R.id.FruitValue);
        DairyValue = findViewById(R.id.DairyValue);
        BreadValue = findViewById(R.id.BreadValue);
        MeatValue = findViewById(R.id.MeatValue);
        VegetablesValue = findViewById(R.id.VegetablesValue);
        Method = findViewById(R.id.Method);
        First = findViewById(R.id.First);
        Second = findViewById(R.id.Second);
        Third = findViewById(R.id.Third);
        Forth = findViewById(R.id.Forth);
        Fifth = findViewById(R.id.Fifth);
        Intent startingIntent = getIntent();
        Meal meal = (Meal)startingIntent.getSerializableExtra("meal");
        MenuName.setText(meal.getMealTime());
        menuItemName.setText(meal.getName());
        Method.setText(meal.getMethodDescription());
        Glide.with(this).load(meal.getThumbnailUrl()).apply(RequestOptions.placeholderOf(R.drawable.mealplaceholder)).into(roundedImageView);

        List<IngredientsDatum> data = meal.getIngredientsData();
        String ingradientData = "";
        for(IngredientsDatum ingradient : data)
        {
            String amount =   String.format("%.1f",ingradient.getAmount());
            String name = ingradient.getName();
            List<Unit> units = ingradient.getUnits();
            List<Unit> filtered = new ArrayList<Unit>();
            for(Unit unit : units) {
                if(unit.getSelected())
                    filtered.add(unit);
            }
            String unitStr = "";
            if(filtered!=null && filtered.size()>0) {
                unitStr  = filtered.get(0).getName();
            }
            ingradientData  = ingradientData + amount + " " + unitStr + " of " +name+"\n";
        }
        ingradientTV.setText(ingradientData);

        List<Group> group = meal.getGroups();
        for (int i = 0; i < group.size(); i++) {
            Group meal_group = group.get(i);
            if (meal_group.getCode().equals("meat") && meal_group.getIsActive()) {
                Meat.setText(meal_group.getName());
                MeatStr = String.valueOf(new Double(meal_group.getAmount()));
                MeatValue.setText(MeatStr+" "+"serves");
                Forth.setVisibility(View.VISIBLE);
            } else if (meal_group.getCode().equals("dairy") && meal_group.getIsActive()) {
                Dairy.setText(meal_group.getName());
                DairyStr = String.valueOf(new Double(meal_group.getAmount()));
                DairyValue.setText(DairyStr+" "+"serves");
                Second.setVisibility(View.VISIBLE);
            } else if (meal_group.getCode().equals("cereal") && meal_group.getIsActive()) {
                Bread.setText(meal_group.getName());
                BreadStr = String.valueOf(new Double(meal_group.getAmount()));
                BreadValue.setText(BreadStr+" "+"serves");
                Third.setVisibility(View.VISIBLE);
            } else if (meal_group.getCode().equals("fruit") && meal_group.getIsActive()) {
                Fruit.setText(meal_group.getName());
                FruitStr = String.valueOf(new Double(meal_group.getAmount()));
                FruitValue.setText(FruitStr+" "+"serves");
                First.setVisibility(View.VISIBLE);
            } else if (meal_group.getCode().equals("vegetables") && meal_group.getIsActive()) {
                VegetablesData.setText(meal_group.getName());
                VegetablesStr = String.valueOf(new Double(meal_group.getAmount()));
                VegetablesValue.setText(VegetablesStr+" "+"serves");
                Fifth.setVisibility(View.VISIBLE);
            }
        }
        ViewLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ArrayList<String> Supliments = new ArrayList<>();
        Supliments.add("Energy");
        Supliments.add("Protein");
        Supliments.add("Fat - total");
        Supliments.add("Carbohydrate - total");
        Supliments.add("Carbohydrate - Sugar");
        Supliments.add("Sodium");

        ArrayList<String> perServe = new ArrayList<>();
        String energy = String.format("%.1f kJ", meal.getNutrition().getEnergy());
        String protein = String.format("%.1f g", meal.getNutrition().getProtein());
        String fat_total = String.format("%.1f g", meal.getNutrition().getFatTotal());
        String carbohydrate_total = String.format("%.1f g", meal.getNutrition().getAvailableCarbohydrate());
        String carbohydrate_sugar = String.format("%.1f g", meal.getNutrition().getTotalSugars());
        String sodium = String.format("%.1f mg", meal.getNutrition().getSodium());

        perServe.add(energy);
        perServe.add(protein);
        perServe.add(fat_total);
        perServe.add(carbohydrate_total);
        perServe.add(carbohydrate_sugar);
        perServe.add(sodium);

        ArrayList<String> perGrams = new ArrayList<>();
        String energy100g = (String.format("%.1f kJ", meal.getNutrition().getEnergy100g()));
        String protein100g = (String.format("%.1f g", meal.getNutrition().getProtein100g()));
        String fat_total100g = (String.format("%.1f g", meal.getNutrition().getFatTotal100g()));
        String carbohydrate_total100g = (String.format("%.1f g", meal.getNutrition().getAvailableCarbohydrate100g()));
        String carbohydrate_sugar100g = (String.format("%.1f g", meal.getNutrition().getTotalSugars100g()));
        String sodium100g = (String.format("%.1f mg", meal.getNutrition().getSodium100g()));

        perGrams.add(energy100g);
        perGrams.add(protein100g);
        perGrams.add(fat_total100g);
        perGrams.add(carbohydrate_total100g);
        perGrams.add(carbohydrate_sugar100g);
        perGrams.add(sodium100g);

        recyclerView4 = findViewById(R.id.recyclerView4);
        recyclerView4.setNestedScrollingEnabled(false);
        LinearLayoutManager  layoutManager = new LinearLayoutManager(this);
        recyclerView4.setLayoutManager(layoutManager);
        nutrientAdapter = new NutrientAdapterr(this, Supliments, perServe, perGrams);
        recyclerView4.setAdapter(nutrientAdapter);
        recyclerView4.setNestedScrollingEnabled(false);
        ScrollView = findViewById(R.id.ScrollView);
        recyclerView4.setNestedScrollingEnabled(false);
        ImageLayout = findViewById(R.id.ImageLayout);
        ImageLayout.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ImageLayout:
                Bundle bundle = new Bundle();
                ImageFragment newFragment = ImageFragment.newInstance();
                newFragment.show(fm, "dialog");
                break;
        }
    }
}