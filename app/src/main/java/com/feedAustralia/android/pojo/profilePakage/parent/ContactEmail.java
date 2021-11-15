
package com.feedAustralia.android.pojo.profilePakage.parent;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContactEmail {

    @SerializedName("text")
    @Expose
    private String text;

    public String getType() {
        return text;
    }

    public void setType(String type) {
        this.text = type;
    }

}
