package com.feedAustralia.android.pojo.Terms;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TermsData {
    @SerializedName("acceptence_required")
    @Expose
    private Boolean acceptenceRequired;
    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("document_title")
    @Expose
    private String documentTitle;
    @SerializedName("enabled")
    @Expose
    private Boolean enabled;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("legal_type")
    @Expose
    private String legalType;
    @SerializedName("program")
    @Expose
    private String program;
    @SerializedName("program_id")
    @Expose
    private Object programId;
    @SerializedName("updated_date")
    @Expose
    private String updatedDate;
    @SerializedName("version")
    @Expose
    private Integer version;

    public Boolean getAcceptenceRequired() {
        return acceptenceRequired;
    }

    public void setAcceptenceRequired(Boolean acceptenceRequired) {
        this.acceptenceRequired = acceptenceRequired;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDocumentTitle() {
        return documentTitle;
    }

    public void setDocumentTitle(String documentTitle) {
        this.documentTitle = documentTitle;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLegalType() {
        return legalType;
    }

    public void setLegalType(String legalType) {
        this.legalType = legalType;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public Object getProgramId() {
        return programId;
    }

    public void setProgramId(Object programId) {
        this.programId = programId;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

}
