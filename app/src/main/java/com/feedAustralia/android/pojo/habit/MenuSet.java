package com.feedAustralia.android.pojo.habit;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MenuSet {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("is_in_2_5_years_range")
    @Expose
    private Boolean isIn25YearsRange;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("oshc_service_id")
    @Expose
    private Object oshcServiceId;
    @SerializedName("meals_times")
    @Expose
    private Object mealsTimes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getIsIn25YearsRange() {
        return isIn25YearsRange;
    }

    public void setIsIn25YearsRange(Boolean isIn25YearsRange) {
        this.isIn25YearsRange = isIn25YearsRange;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getOshcServiceId() {
        return oshcServiceId;
    }

    public void setOshcServiceId(Object oshcServiceId) {
        this.oshcServiceId = oshcServiceId;
    }

    public Object getMealsTimes() {
        return mealsTimes;
    }

    public void setMealsTimes(Object mealsTimes) {
        this.mealsTimes = mealsTimes;
    }

}
