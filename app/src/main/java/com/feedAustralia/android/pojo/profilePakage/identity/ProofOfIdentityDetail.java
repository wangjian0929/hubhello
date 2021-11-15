
package com.feedAustralia.android.pojo.profilePakage.identity;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProofOfIdentityDetail {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("card_number")
    @Expose
    private Object cardNumber;
    @SerializedName("expiry")
    @Expose
    private Object expiry;
    @SerializedName("extra_detail")
    @Expose
    private Object extraDetail;
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

    public Object getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Object cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Object getExpiry() {
        return expiry;
    }

    public void setExpiry(Object expiry) {
        this.expiry = expiry;
    }

    public Object getExtraDetail() {
        return extraDetail;
    }

    public void setExtraDetail(Object extraDetail) {
        this.extraDetail = extraDetail;
    }

    public List<Object> getComments() {
        return comments;
    }

    public void setComments(List<Object> comments) {
        this.comments = comments;
    }

}
