
package com.feedAustralia.android.pojo.MenuOne;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Unit  implements Serializable {

    @SerializedName("formatted_ratio")
    @Expose
    private Double formattedRatio;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("position")
    @Expose
    private Integer position;
    @SerializedName("selected")
    @Expose
    private Boolean selected;

    public Double getFormattedRatio() {
        return formattedRatio;
    }

    public void setFormattedRatio(Double formattedRatio) {
        this.formattedRatio = formattedRatio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

}
