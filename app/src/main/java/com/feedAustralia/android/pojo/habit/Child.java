
package com.feedAustralia.android.pojo.habit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Child {

    @SerializedName("child_first_name")
    @Expose
    private String childFirstName;
    @SerializedName("child_last_name")
    @Expose
    private String childLastName;
    @SerializedName("id")
    @Expose
    private Integer id;

    public String getChildFirstName() {
        return childFirstName;
    }

    public void setChildFirstName(String childFirstName) {
        this.childFirstName = childFirstName;
    }

    public String getChildLastName() {
        return childLastName;
    }

    public void setChildLastName(String childLastName) {
        this.childLastName = childLastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
