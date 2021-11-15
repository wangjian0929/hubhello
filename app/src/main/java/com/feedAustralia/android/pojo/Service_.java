
package com.feedAustralia.android.pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Service_ {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("full_name")
    @Expose
    private String fullName;
    @SerializedName("scheme_id")
    @Expose
    private Integer schemeId;

    @SerializedName("service_id")
    @Expose
    private Integer serviceId;
    @SerializedName("group_id")
    @Expose
    private Integer groupId;
    @SerializedName("group_name")
    @Expose
    private String groupName;
    @SerializedName("picture")
    @Expose
    private String picture;
    @SerializedName("enrolment_start")
    @Expose
    private String enrolmentStart;
    @SerializedName("service_ids")
    @Expose
    private List<Object> serviceIds = null;
    @SerializedName("past")
    @Expose
    private Boolean past;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(Integer schemeId) {
        this.schemeId = schemeId;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }


    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getEnrolmentStart() {
        return enrolmentStart;
    }

    public void setEnrolmentStart(String enrolmentStart) {
        this.enrolmentStart = enrolmentStart;
    }

    public List<Object> getServiceIds() {
        return serviceIds;
    }

    public void setServiceIds(List<Object> serviceIds) {
        this.serviceIds = serviceIds;
    }

    public Boolean getPast() {
        return past;
    }

    public void setPast(Boolean past) {
        this.past = past;
    }

}
