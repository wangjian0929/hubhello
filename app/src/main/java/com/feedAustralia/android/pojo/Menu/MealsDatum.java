
package com.feedAustralia.android.pojo.Menu;

import java.util.List;

import com.feedAustralia.android.pojo.MenuOne.Group_;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MealsDatum {

    @SerializedName("meals")
    @Expose
    private List<Meal> meals = null;
    @SerializedName("groups")
    @Expose
    private List<com.feedAustralia.android.pojo.MenuOne.Group_> groups = null;
    @SerializedName("meals_time")
    @Expose
    private MealsTime mealsTime;
    @SerializedName("menu_id")
    @Expose
    private Integer menuId;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("effective_date")
    @Expose
    private String effectiveDate;

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public List<com.feedAustralia.android.pojo.MenuOne.Group_> getGroups() {
        return groups;
    }

    public void setGroups(List<Group_> groups) {
        this.groups = groups;
    }

    public MealsTime getMealsTime() {
        return mealsTime;
    }

    public void setMealsTime(MealsTime mealsTime) {
        this.mealsTime = mealsTime;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

}
