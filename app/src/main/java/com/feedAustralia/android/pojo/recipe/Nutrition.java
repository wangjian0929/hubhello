
package com.feedAustralia.android.pojo.recipe;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Nutrition implements Serializable {

    @SerializedName("energy")
    @Expose
    private Double energy;
    @SerializedName("protein")
    @Expose
    private Double protein;
    @SerializedName("fat_total")
    @Expose
    private Double fatTotal;
    @SerializedName("fat_saturated")
    @Expose
    private Double fatSaturated;
    @SerializedName("available_carbohydrate")
    @Expose
    private Double availableCarbohydrate;
    @SerializedName("total_sugars")
    @Expose
    private Double totalSugars;
    @SerializedName("sodium")
    @Expose
    private Double sodium;
    @SerializedName("protein_percentage")
    @Expose
    private Double proteinPercentage;
    @SerializedName("fat_total_percentage")
    @Expose
    private Double fatTotalPercentage;
    @SerializedName("available_carbohydrate_percentage")
    @Expose
    private Double availableCarbohydratePercentage;
    @SerializedName("total_sugars_percentage")
    @Expose
    private Double totalSugarsPercentage;
    @SerializedName("sodium_percentage")
    @Expose
    private Double sodiumPercentage;
    @SerializedName("energy_100g")
    @Expose
    private Double energy100g;
    @SerializedName("protein_100g")
    @Expose
    private Double protein100g;
    @SerializedName("fat_total_100g")
    @Expose
    private Double fatTotal100g;
    @SerializedName("fat_saturated_100g")
    @Expose
    private Double fatSaturated100g;
    @SerializedName("available_carbohydrate_100g")
    @Expose
    private Double availableCarbohydrate100g;
    @SerializedName("total_sugars_100g")
    @Expose
    private Double totalSugars100g;
    @SerializedName("sodium_100g")
    @Expose
    private Double sodium100g;

    public Double getEnergy() {
        return energy;
    }

    public void setEnergy(Double energy) {
        this.energy = energy;
    }

    public Double getProtein() {
        return protein;
    }

    public void setProtein(Double protein) {
        this.protein = protein;
    }

    public Double getFatTotal() {
        return fatTotal;
    }

    public void setFatTotal(Double fatTotal) {
        this.fatTotal = fatTotal;
    }

    public Double getFatSaturated() {
        return fatSaturated;
    }

    public void setFatSaturated(Double fatSaturated) {
        this.fatSaturated = fatSaturated;
    }

    public Double getAvailableCarbohydrate() {
        return availableCarbohydrate;
    }

    public void setAvailableCarbohydrate(Double availableCarbohydrate) {
        this.availableCarbohydrate = availableCarbohydrate;
    }

    public Double getTotalSugars() {
        return totalSugars;
    }

    public void setTotalSugars(Double totalSugars) {
        this.totalSugars = totalSugars;
    }

    public Double getSodium() {
        return sodium;
    }

    public void setSodium(Double sodium) {
        this.sodium = sodium;
    }

    public Double getProteinPercentage() {
        return proteinPercentage;
    }

    public void setProteinPercentage(Double proteinPercentage) {
        this.proteinPercentage = proteinPercentage;
    }

    public Double getFatTotalPercentage() {
        return fatTotalPercentage;
    }

    public void setFatTotalPercentage(Double fatTotalPercentage) {
        this.fatTotalPercentage = fatTotalPercentage;
    }

    public Double getAvailableCarbohydratePercentage() {
        return availableCarbohydratePercentage;
    }

    public void setAvailableCarbohydratePercentage(Double availableCarbohydratePercentage) {
        this.availableCarbohydratePercentage = availableCarbohydratePercentage;
    }

    public Double getTotalSugarsPercentage() {
        return totalSugarsPercentage;
    }

    public void setTotalSugarsPercentage(Double totalSugarsPercentage) {
        this.totalSugarsPercentage = totalSugarsPercentage;
    }

    public Double getSodiumPercentage() {
        return sodiumPercentage;
    }

    public void setSodiumPercentage(Double sodiumPercentage) {
        this.sodiumPercentage = sodiumPercentage;
    }

    public Double getEnergy100g() {
        return energy100g;
    }

    public void setEnergy100g(Double energy100g) {
        this.energy100g = energy100g;
    }

    public Double getProtein100g() {
        return protein100g;
    }

    public void setProtein100g(Double protein100g) {
        this.protein100g = protein100g;
    }

    public Double getFatTotal100g() {
        return fatTotal100g;
    }

    public void setFatTotal100g(Double fatTotal100g) {
        this.fatTotal100g = fatTotal100g;
    }

    public Double getFatSaturated100g() {
        return fatSaturated100g;
    }

    public void setFatSaturated100g(Double fatSaturated100g) {
        this.fatSaturated100g = fatSaturated100g;
    }

    public Double getAvailableCarbohydrate100g() {
        return availableCarbohydrate100g;
    }

    public void setAvailableCarbohydrate100g(Double availableCarbohydrate100g) {
        this.availableCarbohydrate100g = availableCarbohydrate100g;
    }

    public Double getTotalSugars100g() {
        return totalSugars100g;
    }

    public void setTotalSugars100g(Double totalSugars100g) {
        this.totalSugars100g = totalSugars100g;
    }

    public Double getSodium100g() {
        return sodium100g;
    }

    public void setSodium100g(Double sodium100g) {
        this.sodium100g = sodium100g;
    }

}
