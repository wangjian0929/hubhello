
package com.feedAustralia.android.pojo.habit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MenuMealTime {

    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("is_in_8_hours_period")
    @Expose
    private Boolean isIn8HoursPeriod;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("position")
    @Expose
    private Integer position;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getIsIn8HoursPeriod() {
        return isIn8HoursPeriod;
    }

    public void setIsIn8HoursPeriod(Boolean isIn8HoursPeriod) {
        this.isIn8HoursPeriod = isIn8HoursPeriod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

}
