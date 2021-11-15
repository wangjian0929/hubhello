
package com.feedAustralia.android.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Privileges {

    @SerializedName("children")
    @Expose
    private String children;
    @SerializedName("attendance")
    @Expose
    private String attendance;
    @SerializedName("vacancies")
    @Expose
    private String vacancies;
    @SerializedName("reports")
    @Expose
    private String reports;
    @SerializedName("scheme_details")
    @Expose
    private String schemeDetails;
    @SerializedName("parents_logins")
    @Expose
    private String parentsLogins;
    @SerializedName("log")
    @Expose
    private Boolean log;
    @SerializedName("ccms_info")
    @Expose
    private String ccmsInfo;
    @SerializedName("hubhello_settings")
    @Expose
    private Boolean hubhelloSettings;
    @SerializedName("hubhello_gallery")
    @Expose
    private String hubhelloGallery;
    @SerializedName("hubhello_news")
    @Expose
    private String hubhelloNews;
    @SerializedName("hubhello_alerts")
    @Expose
    private Boolean hubhelloAlerts;
    @SerializedName("hubhello_feedau_access")
    @Expose
    private Boolean hubhelloFeedauAccess;
    @SerializedName("hubhello_feedau_edit_menu")
    @Expose
    private Boolean hubhelloFeedauEditMenu;
    @SerializedName("hubhello_feedau_purchase")
    @Expose
    private Boolean hubhelloFeedauPurchase;
    @SerializedName("hubhello_feedau_purchase_woolworths_acc")
    @Expose
    private Boolean hubhelloFeedauPurchaseWoolworthsAcc;
    @SerializedName("hubhello_bookme_access")
    @Expose
    private Boolean hubhelloBookmeAccess;
    @SerializedName("hubhello_bookme_edit_events")
    @Expose
    private Boolean hubhelloBookmeEditEvents;
    @SerializedName("hubhello_bookme_settings")
    @Expose
    private Boolean hubhelloBookmeSettings;
    @SerializedName("hubhello_educate_access")
    @Expose
    private Boolean hubhelloEducateAccess;

    public String getChildren() {
        return children;
    }

    public void setChildren(String children) {
        this.children = children;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public String getVacancies() {
        return vacancies;
    }

    public void setVacancies(String vacancies) {
        this.vacancies = vacancies;
    }

    public String getReports() {
        return reports;
    }

    public void setReports(String reports) {
        this.reports = reports;
    }

    public String getSchemeDetails() {
        return schemeDetails;
    }

    public void setSchemeDetails(String schemeDetails) {
        this.schemeDetails = schemeDetails;
    }

    public String getParentsLogins() {
        return parentsLogins;
    }

    public void setParentsLogins(String parentsLogins) {
        this.parentsLogins = parentsLogins;
    }

    public Boolean getLog() {
        return log;
    }

    public void setLog(Boolean log) {
        this.log = log;
    }

    public String getCcmsInfo() {
        return ccmsInfo;
    }

    public void setCcmsInfo(String ccmsInfo) {
        this.ccmsInfo = ccmsInfo;
    }

    public Boolean getHubhelloSettings() {
        return hubhelloSettings;
    }

    public void setHubhelloSettings(Boolean hubhelloSettings) {
        this.hubhelloSettings = hubhelloSettings;
    }

    public String getHubhelloGallery() {
        return hubhelloGallery;
    }

    public void setHubhelloGallery(String hubhelloGallery) {
        this.hubhelloGallery = hubhelloGallery;
    }

    public String getHubhelloNews() {
        return hubhelloNews;
    }

    public void setHubhelloNews(String hubhelloNews) {
        this.hubhelloNews = hubhelloNews;
    }

    public Boolean getHubhelloAlerts() {
        return hubhelloAlerts;
    }

    public void setHubhelloAlerts(Boolean hubhelloAlerts) {
        this.hubhelloAlerts = hubhelloAlerts;
    }

    public Boolean getHubhelloFeedauAccess() {
        return hubhelloFeedauAccess;
    }

    public void setHubhelloFeedauAccess(Boolean hubhelloFeedauAccess) {
        this.hubhelloFeedauAccess = hubhelloFeedauAccess;
    }

    public Boolean getHubhelloFeedauEditMenu() {
        return hubhelloFeedauEditMenu;
    }

    public void setHubhelloFeedauEditMenu(Boolean hubhelloFeedauEditMenu) {
        this.hubhelloFeedauEditMenu = hubhelloFeedauEditMenu;
    }

    public Boolean getHubhelloFeedauPurchase() {
        return hubhelloFeedauPurchase;
    }

    public void setHubhelloFeedauPurchase(Boolean hubhelloFeedauPurchase) {
        this.hubhelloFeedauPurchase = hubhelloFeedauPurchase;
    }

    public Boolean getHubhelloFeedauPurchaseWoolworthsAcc() {
        return hubhelloFeedauPurchaseWoolworthsAcc;
    }

    public void setHubhelloFeedauPurchaseWoolworthsAcc(Boolean hubhelloFeedauPurchaseWoolworthsAcc) {
        this.hubhelloFeedauPurchaseWoolworthsAcc = hubhelloFeedauPurchaseWoolworthsAcc;
    }

    public Boolean getHubhelloBookmeAccess() {
        return hubhelloBookmeAccess;
    }

    public void setHubhelloBookmeAccess(Boolean hubhelloBookmeAccess) {
        this.hubhelloBookmeAccess = hubhelloBookmeAccess;
    }

    public Boolean getHubhelloBookmeEditEvents() {
        return hubhelloBookmeEditEvents;
    }

    public void setHubhelloBookmeEditEvents(Boolean hubhelloBookmeEditEvents) {
        this.hubhelloBookmeEditEvents = hubhelloBookmeEditEvents;
    }

    public Boolean getHubhelloBookmeSettings() {
        return hubhelloBookmeSettings;
    }

    public void setHubhelloBookmeSettings(Boolean hubhelloBookmeSettings) {
        this.hubhelloBookmeSettings = hubhelloBookmeSettings;
    }

    public Boolean getHubhelloEducateAccess() {
        return hubhelloEducateAccess;
    }

    public void setHubhelloEducateAccess(Boolean hubhelloEducateAccess) {
        this.hubhelloEducateAccess = hubhelloEducateAccess;
    }

}
