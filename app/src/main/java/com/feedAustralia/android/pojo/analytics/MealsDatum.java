
package com.feedAustralia.android.pojo.analytics;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MealsDatum {

    @SerializedName("meals")
    @Expose
    private List<Object> meals = null;
    @SerializedName("meals_time")
    @Expose
    private MealsTime mealsTime;
    @SerializedName("menu_id")
    @Expose
    private Object menuId;
    @SerializedName("user_id")
    @Expose
    private Object userId;
    @SerializedName("effective_date")
    @Expose
    private String effectiveDate;

    public List<Object> getMeals() {
        return meals;
    }

    public void setMeals(List<Object> meals) {
        this.meals = meals;
    }

    public MealsTime getMealsTime() {
        return mealsTime;
    }

    public void setMealsTime(MealsTime mealsTime) {
        this.mealsTime = mealsTime;
    }

    public Object getMenuId() {
        return menuId;
    }

    public void setMenuId(Object menuId) {
        this.menuId = menuId;
    }

    public Object getUserId() {
        return userId;
    }

    public void setUserId(Object userId) {
        this.userId = userId;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

}
