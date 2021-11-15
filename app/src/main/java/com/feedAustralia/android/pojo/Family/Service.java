
package com.feedAustralia.android.pojo.Family;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Service {

    @SerializedName("group_id")
    @Expose
    private Integer groupId;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("scheme_id")
    @Expose
    private Integer schemeId;
    @SerializedName("service_id")
    @Expose
    private Integer serviceId;
    @SerializedName("service_logo")
    @Expose
    private String serviceLogo;
    @SerializedName("is_ccs")
    @Expose
    private Boolean isCcs;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("full_name")
    @Expose
    private String fullName;
    @SerializedName("group_name")
    @Expose
    private String groupName;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("past")
    @Expose
    private Boolean past;
    @SerializedName("bookings")
    @Expose
    private Boolean bookings;
    @SerializedName("bookme_novac")
    @Expose
    private Boolean bookmeNovac;
    @SerializedName("bookme")
    @Expose
    private Boolean bookme;
    @SerializedName("picture")
    @Expose
    private String picture;
    @SerializedName("enrolment_start")
    @Expose
    private String enrolmentStart;
    @SerializedName("service_ids")
    @Expose
    private List<Object> serviceIds = null;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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



    public String getServiceLogo() {
        return serviceLogo;
    }

    public void setServiceLogo(String serviceLogo) {
        this.serviceLogo = serviceLogo;
    }

    public Boolean getIsCcs() {
        return isCcs;
    }

    public void setIsCcs(Boolean isCcs) {
        this.isCcs = isCcs;
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

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getPast() {
        return past;
    }

    public void setPast(Boolean past) {
        this.past = past;
    }

    public Boolean getBookings() {
        return bookings;
    }

    public void setBookings(Boolean bookings) {
        this.bookings = bookings;
    }

    public Boolean getBookmeNovac() {
        return bookmeNovac;
    }

    public void setBookmeNovac(Boolean bookmeNovac) {
        this.bookmeNovac = bookmeNovac;
    }

    public Boolean getBookme() {
        return bookme;
    }

    public void setBookme(Boolean bookme) {
        this.bookme = bookme;
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

}
