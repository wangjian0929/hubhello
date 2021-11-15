
package com.feedAustralia.android.pojo.analytics;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AnalyticsDatum {

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
    @SerializedName("is_repeatable")
    @Expose
    private Boolean isRepeatable;

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

    public Boolean getIsRepeatable() {
        return isRepeatable;
    }

    public void setIsRepeatable(Boolean isRepeatable) {
        this.isRepeatable = isRepeatable;
    }

}
