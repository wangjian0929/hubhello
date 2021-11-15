
package com.feedAustralia.android.pojo.profilePakage.health;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Other {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("status")
    @Expose
    private Object status;
    @SerializedName("comments")
    @Expose
    private List<Object> comments = null;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public List<Object> getComments() {
        return comments;
    }

    public void setComments(List<Object> comments) {
        this.comments = comments;
    }

}
