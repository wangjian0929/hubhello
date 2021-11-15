
package com.feedAustralia.android.pojo.profilePakage.parent;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ParentIdentity {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("contact_mobile_phones")
    @Expose
    private List<ContactMobilePhone> contactMobilePhones = null;
    @SerializedName("contact_emails")
    @Expose
    private List<ContactEmail> contactEmails = null;
    @SerializedName("gender")
    @Expose
    private Object gender = null;
    @SerializedName("birthday")
    @Expose
    private Object birthday = null;
    @SerializedName("last_name")
    @Expose
    private Object lastName = null;
    @SerializedName("first_name")
    @Expose
    private Object firstName = null;
    @SerializedName("middle_names")
    @Expose
    private Object middleNames = null;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ContactMobilePhone> getContactMobilePhones() {
        return contactMobilePhones;
    }

    public void setContactMobilePhones(List<ContactMobilePhone> contactMobilePhones) {
        this.contactMobilePhones = contactMobilePhones;
    }

    public List<ContactEmail> getContactEmails() {
        return contactEmails;
    }

    public void setContactEmails(List<ContactEmail> contactEmails) {
        this.contactEmails = contactEmails;
    }

    public Object getGender() {
        return gender;
    }

    public void setGender(Object gender) {
        this.gender = gender;
    }

    public Object getBirthday() {
        return birthday;
    }

    public void setBirthday(Object birthday) {
        this.birthday = birthday;
    }

    public Object getLastName() {
        return lastName;
    }

    public void setLastName(Object lastName) {
        this.lastName = lastName;
    }

    public Object getFirstName() {
        return firstName;
    }

    public void setFirstName(Object firstName) {
        this.firstName = firstName;
    }

    public Object getMiddleNames() {
        return middleNames;
    }

    public void setMiddleNames(Object middleNames) {
        this.middleNames = middleNames;
    }

}
