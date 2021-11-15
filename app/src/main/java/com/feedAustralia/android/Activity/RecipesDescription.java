package com.feedAustralia.android.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.ecloud.pulltozoomview.PullToZoomScrollViewEx;
import com.feedAustralia.android.AdpatersPagers.NutrientAdapterr;
import com.feedAustralia.android.pojo.recipe.IngredientsDatum;
import com.feedAustralia.android.R;
import com.feedAustralia.android.pojo.recipe.Meal;
import com.feedAustralia.android.pojo.recipe.Unit;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by asd on 11-02-2019.
 */

public class RecipesDescription extends BaseActivity {
    private PullToZoomScrollViewEx scrollView;
    ImageView iv_zoom;
    TextView Title,Ingredients,IngredientsDetails,Method;
    RecyclerView recyclerView4;
    NutrientAdapterr nutrientAdapter;
    RelativeLayout ViewLayout;
    NestedScrollView ScrollView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipes_description);
        loadViewForCode();
        scrollView =  findViewById(R.id.scroll_view);
        ViewLayout = findViewById(R.id.ViewLayout);


        iv_zoom = findViewById(R.id.iv_zoom);


        ViewLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Intent startingIntent = getIntent();
        Meal meal = (Meal)startingIntent.getSerializableExtra("meal");
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
        int mScreenHeight = localDisplayMetrics.heightPixels;
        int mScreenWidth = localDisplayMetrics.widthPixels;
        LinearLayout.LayoutParams localObject = new LinearLayout.LayoutParams(mScreenWidth, (int) (12.0F * (mScreenWidth / 20.0F)));
        scrollView.setHeaderLayoutParams(localObject);
        scrollView.setParallax(false);







    }
    public void loadViewForCode(){
        PullToZoomScrollViewEx scrollView =  findViewById(R.id.scroll_view);
        View zoomView = LayoutInflater.from(this).inflate(R.layout.recipe_zoom_view, null, false);
        View contentView = LayoutInflater.from(this).inflate(R.layout.recipe_content, null, false);
        Intent startingIntent = getIntent();
        Meal meal = (Meal)startingIntent.getSerializableExtra("meal");


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

        iv_zoom=zoomView.findViewById(R.id.iv_zoom);
        Title = zoomView.findViewById(R.id.Title);
        Ingredients = contentView.findViewById(R.id.Ingredients);
        IngredientsDetails = contentView.findViewById(R.id.IngredientsDetails);
        ScrollView = contentView.findViewById(R.id.ScrollView);
        Method = contentView.findViewById(R.id.Method);
        recyclerView4 = contentView.findViewById(R.id.recyclerView4);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView4.setLayoutManager(layoutManager);
        nutrientAdapter = new NutrientAdapterr(this, Supliments, perServe, perGrams);
        recyclerView4.setAdapter(nutrientAdapter);
        recyclerView4.setNestedScrollingEnabled(false);
        scrollView.setZoomView(zoomView);
        scrollView.setScrollContentView(contentView);
        scrollView.setZoomEnabled(true);


        Title.setText(meal.getName());
        Glide.with(this).load(meal.getImageUrl()).apply(RequestOptions.placeholderOf(R.drawable.mealplaceholder)).into(iv_zoom);
        Method.setText(meal.getMethodDescription());


        List<IngredientsDatum> data = meal.getIngredientsData();
        String ingradientData = "";
        int position = 0;
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

            if(position == units.size())
            ingradientData  = ingradientData + amount + " " + unitStr + " of " +name;
            else {
                ingradientData  = ingradientData + amount + " " + unitStr + " of " +name+"\n";

            }
            position++;
        }
        IngredientsDetails.setText(ingradientData);





    }
}








