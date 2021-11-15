package com.feedAustralia.android.pojo.Menu;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.feedAustralia.android.pojo.MenuOne.Nutrition_;


public class MenuData {
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("weekday")
    @Expose
    private String weekday;
    @SerializedName("meals_data")
    @Expose
    private List<MealsDatum> mealsData = null;
    @SerializedName("mode")
    @Expose
    private String mode;
    @SerializedName("is_open_day")
    @Expose
    private Object isOpenDay;
    @SerializedName("open_days")
    @Expose
    private Object openDays;
    @SerializedName("menu_id")
    @Expose
    private Integer menuId;
    @SerializedName("effective_date")
    @Expose
    private String effectiveDate;
    @SerializedName("is_repeatable")
    @Expose
    private Boolean isRepeatable;
    @SerializedName("is_repeatable_in_meal_time")
    @Expose
    private Boolean isRepeatableInMealTime;
    @SerializedName("is_repeatable_in_cycles_on")
    @Expose
    private Boolean isRepeatableInCyclesOn;
    @SerializedName("is_not_repeatable")
    @Expose
    private Boolean isNotRepeatable;
    @SerializedName("groups")
    @Expose

    private List<Group__> groups = null;
    @SerializedName("nutritional_rating")
    @Expose
    private Integer nutritionalRating;


    @SerializedName("nutrition")
    @Expose
    private Nutrition_ nutrition;

    public Nutrition_ getNutrition() {
        return nutrition;
    }

    public void setNutrition(Nutrition_ nutrition) {
        this.nutrition = nutrition;
    }






    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public List<MealsDatum> getMealsData() {
        return mealsData;
    }

    public void setMealsData(List<MealsDatum> mealsData) {
        this.mealsData = mealsData;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Object getIsOpenDay() {
        return isOpenDay;
    }

    public void setIsOpenDay(Object isOpenDay) {
        this.isOpenDay = isOpenDay;
    }

    public Object getOpenDays() {
        return openDays;
    }

    public void setOpenDays(Object openDays) {
        this.openDays = openDays;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Boolean getIsRepeatable() {
        return isRepeatable;
    }

    public void setIsRepeatable(Boolean isRepeatable) {
        this.isRepeatable = isRepeatable;
    }

    public Boolean getIsRepeatableInMealTime() {
        return isRepeatableInMealTime;
    }

    public void setIsRepeatableInMealTime(Boolean isRepeatableInMealTime) {
        this.isRepeatableInMealTime = isRepeatableInMealTime;
    }

    public Boolean getIsRepeatableInCyclesOn() {
        return isRepeatableInCyclesOn;
    }

    public void setIsRepeatableInCyclesOn(Boolean isRepeatableInCyclesOn) {
        this.isRepeatableInCyclesOn = isRepeatableInCyclesOn;
    }

    public Boolean getIsNotRepeatable() {
        return isNotRepeatable;
    }

    public void setIsNotRepeatable(Boolean isNotRepeatable) {
        this.isNotRepeatable = isNotRepeatable;
    }

    public List<Group__> getGroups() {
        return groups;
    }

    public void setGroups(List<Group__> groups) {
        this.groups = groups;
    }

    public Integer getNutritionalRating() {
        return nutritionalRating;
    }

    public void setNutritionalRating(Integer nutritionalRating) {
        this.nutritionalRating = nutritionalRating;
    }

}
