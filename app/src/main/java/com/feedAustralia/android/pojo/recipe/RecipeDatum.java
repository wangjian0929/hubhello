package com.feedAustralia.android.pojo.recipe;
import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RecipeDatum implements Serializable {

    @SerializedName("meals_time_name")
    @Expose
    private String mealsTimeName;
    @SerializedName("meals")
    @Expose
    private List<Meal> meals = null;

    public String getMealsTimeName() {
        return mealsTimeName;
    }

    public void setMealsTimeName(String mealsTimeName) {
        this.mealsTimeName = mealsTimeName;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

}
