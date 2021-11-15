
package com.feedAustralia.android.pojo.habit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EatingHabit {

    @SerializedName("effective_date")
    @Expose
    private String effectiveDate;
    @SerializedName("serves_amount")
    @Expose
    private Integer servesAmount;
    @SerializedName("child")
    @Expose
    private Child child;
    @SerializedName("meals_time")
    @Expose
    private MealsTime mealsTime;

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Integer getServesAmount() {
        return servesAmount;
    }

    public void setServesAmount(Integer servesAmount) {
        this.servesAmount = servesAmount;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public MealsTime getMealsTime() {
        return mealsTime;
    }

    public void setMealsTime(MealsTime mealsTime) {
        this.mealsTime = mealsTime;
    }

}
