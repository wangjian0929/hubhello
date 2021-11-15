
package com.feedAustralia.android.pojo.Menu;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meal implements Serializable {

    @SerializedName("meal_time")
    @Expose
    private String mealTime;
    public String getMealTime() {
        return mealTime;
    }

    public void setMealTime(String mealTime) {
        this.mealTime = mealTime;
    }


    @SerializedName("from_edit")
    @Expose
    private Boolean fromEdit;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("ideas_meal_id")
    @Expose
    private String ideasMealId;
    @SerializedName("method_description")
    @Expose
    private String methodDescription;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("serves_amount")
    @Expose
    private Integer servesAmount;
    @SerializedName("thumbnail_url")
    @Expose
    private String thumbnailUrl;
    @SerializedName("mini_image_url")
    @Expose
    private String miniImageUrl;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("groups")
    @Expose
    private List<Group> groups = null;
    @SerializedName("allergies")
    @Expose
    private List<Allergy> allergies = null;

    public Boolean getFromEdit() {
        return fromEdit;
    }

    public void setFromEdit(Boolean fromEdit) {
        this.fromEdit = fromEdit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdeasMealId() {
        return ideasMealId;
    }

    public void setIdeasMealId(String ideasMealId) {
        this.ideasMealId = ideasMealId;
    }

    public String getMethodDescription() {
        return methodDescription;
    }

    public void setMethodDescription(String methodDescription) {
        this.methodDescription = methodDescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getServesAmount() {
        return servesAmount;
    }

    public void setServesAmount(Integer servesAmount) {
        this.servesAmount = servesAmount;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getMiniImageUrl() {
        return miniImageUrl;
    }

    public void setMiniImageUrl(String miniImageUrl) {
        this.miniImageUrl = miniImageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<Allergy> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<Allergy> allergies) {
        this.allergies = allergies;
    }

}
