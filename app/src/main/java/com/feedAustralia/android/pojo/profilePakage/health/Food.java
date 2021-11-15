
package com.feedAustralia.android.pojo.profilePakage.health;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Food {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("comments")
    @Expose
    private List<Object> comments = null;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Object> getComments() {
        return comments;
    }

    public void setComments(List<Object> comments) {
        this.comments = comments;
    }

}
