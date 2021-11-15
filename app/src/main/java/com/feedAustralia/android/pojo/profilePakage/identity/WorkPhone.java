
package com.feedAustralia.android.pojo.profilePakage.identity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WorkPhone {

    @SerializedName("number")
    @Expose
    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
