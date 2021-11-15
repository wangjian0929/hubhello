
package com.feedAustralia.android.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CwaAgreement {

    @SerializedName("child_id")
    @Expose
    private Integer childId;
    @SerializedName("child_name")
    @Expose
    private String childName;
    @SerializedName("service_name")
    @Expose
    private String serviceName;
    @SerializedName("pdf_path")
    @Expose
    private String pdfPath;
    @SerializedName("submitted_at")
    @Expose
    private Object submittedAt;
    @SerializedName("scheme_id")
    @Expose
    private Integer schemeId;
    @SerializedName("signed_at")
    @Expose
    private String signedAt;
    @SerializedName("signed")
    @Expose
    private Boolean signed;

    public Integer getChildId() {
        return childId;
    }

    public void setChildId(Integer childId) {
        this.childId = childId;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getPdfPath() {
        return pdfPath;
    }

    public void setPdfPath(String pdfPath) {
        this.pdfPath = pdfPath;
    }

    public Object getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(Object submittedAt) {
        this.submittedAt = submittedAt;
    }

    public Integer getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(Integer schemeId) {
        this.schemeId = schemeId;
    }

    public String getSignedAt() {
        return signedAt;
    }

    public void setSignedAt(String signedAt) {
        this.signedAt = signedAt;
    }

    public Boolean getSigned() {
        return signed;
    }

    public void setSigned(Boolean signed) {
        this.signed = signed;
    }

}
