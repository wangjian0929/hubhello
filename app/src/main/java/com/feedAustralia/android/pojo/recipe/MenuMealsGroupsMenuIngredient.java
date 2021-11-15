
package com.feedAustralia.android.pojo.recipe;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MenuMealsGroupsMenuIngredient implements Serializable {

    @SerializedName("meals_group_id")
    @Expose
    private Integer mealsGroupId;
    @SerializedName("serving_size_formatted")
    @Expose
    private Object servingSizeFormatted;

    public Integer getMealsGroupId() {
        return mealsGroupId;
    }

    public void setMealsGroupId(Integer mealsGroupId) {
        this.mealsGroupId = mealsGroupId;
    }

    public Object getServingSizeFormatted() {
        return servingSizeFormatted;
    }

    public void setServingSizeFormatted(Object servingSizeFormatted) {
        this.servingSizeFormatted = servingSizeFormatted;
    }

}
