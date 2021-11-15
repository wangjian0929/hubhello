
package com.feedAustralia.android.pojo.recipe;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Allergy implements Serializable {

    @SerializedName("allergy_type")
    @Expose
    private Integer allergyType;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("note")
    @Expose
    private Object note;
    @SerializedName("position")
    @Expose
    private Integer position;
    @SerializedName("short_name")
    @Expose
    private String shortName;
    @SerializedName("the_parent_record_id")
    @Expose
    private String theParentRecordId;

    public Integer getAllergyType() {
        return allergyType;
    }

    public void setAllergyType(Integer allergyType) {
        this.allergyType = allergyType;
    }

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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getNote() {
        return note;
    }

    public void setNote(Object note) {
        this.note = note;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getTheParentRecordId() {
        return theParentRecordId;
    }

    public void setTheParentRecordId(String theParentRecordId) {
        this.theParentRecordId = theParentRecordId;
    }

}
