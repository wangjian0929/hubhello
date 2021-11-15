
package com.feedAustralia.android.pojo.profilePakage.identity;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Participant {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("home_phones")
    @Expose
    private List<HomePhone> homePhones = null;
    @SerializedName("work_phones")
    @Expose
    private List<WorkPhone> workPhones = null;
    @SerializedName("mobile_phones")
    @Expose
    private List<MobilePhone> mobilePhones = null;
    @SerializedName("emails")
    @Expose
    private List<String> emails = null;
    @SerializedName("relationship")
    @Expose
    private Object relationship;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<HomePhone> getHomePhones() {
        return homePhones;
    }

    public void setHomePhones(List<HomePhone> homePhones) {
        this.homePhones = homePhones;
    }

    public List<WorkPhone> getWorkPhones() {
        return workPhones;
    }

    public void setWorkPhones(List<WorkPhone> workPhones) {
        this.workPhones = workPhones;
    }

    public List<MobilePhone> getMobilePhones() {
        return mobilePhones;
    }

    public void setMobilePhones(List<MobilePhone> mobilePhones) {
        this.mobilePhones = mobilePhones;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public Object getRelationship() {
        return relationship;
    }

    public void setRelationship(Object relationship) {
        this.relationship = relationship;
    }

}
