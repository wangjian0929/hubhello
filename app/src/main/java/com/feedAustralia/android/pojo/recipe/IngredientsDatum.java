
package com.feedAustralia.android.pojo.recipe;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IngredientsDatum implements Serializable {

    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("is_liquid")
    @Expose
    private Boolean isLiquid;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("units")
    @Expose
    private List<Unit> units = null;
    @SerializedName("menu_meals_groups_menu_ingredients")
    @Expose
    private List<MenuMealsGroupsMenuIngredient> menuMealsGroupsMenuIngredients = null;
    @SerializedName("meals_label")
    @Expose
    private MealsLabel mealsLabel;
    @SerializedName("amount")
    @Expose
    private Double amount;
    @SerializedName("recipe_name")
    @Expose
    private String recipeName;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getIsLiquid() {
        return isLiquid;
    }

    public void setIsLiquid(Boolean isLiquid) {
        this.isLiquid = isLiquid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Unit> getUnits() {
        return units;
    }

    public void setUnits(List<Unit> units) {
        this.units = units;
    }

    public List<MenuMealsGroupsMenuIngredient> getMenuMealsGroupsMenuIngredients() {
        return menuMealsGroupsMenuIngredients;
    }

    public void setMenuMealsGroupsMenuIngredients(List<MenuMealsGroupsMenuIngredient> menuMealsGroupsMenuIngredients) {
        this.menuMealsGroupsMenuIngredients = menuMealsGroupsMenuIngredients;
    }

    public MealsLabel getMealsLabel() {
        return mealsLabel;
    }

    public void setMealsLabel(MealsLabel mealsLabel) {
        this.mealsLabel = mealsLabel;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

}
