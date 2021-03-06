
package com.feedAustralia.android.pojo.profilePakage.parent;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContactMobilePhone {

    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("type")
    @Expose
    private String type;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
