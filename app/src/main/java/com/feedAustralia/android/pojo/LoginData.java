
package com.feedAustralia.android.pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginData {


    @SerializedName("message")
    @Expose
    private String message;


    @SerializedName("error")
    @Expose
    private String error;


    @SerializedName("suspended")
    @Expose
    private Boolean suspended;


    @SerializedName("legal_label")
    @Expose
    private String legalLabel;


    @SerializedName("legal_type")
    @Expose
    private String legalType;

    @SerializedName("program")
    @Expose
    private String program;



    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("cover_picture_url")
    @Expose
    private String coverPictureUrl;
    @SerializedName("age")
    @Expose
    private Integer age;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("user_avatar")
    @Expose
    private Object userAvatar;
    @SerializedName("user_name")
    @Expose
    private String userName;
    @SerializedName("user_first_name")
    @Expose
    private String userFirstName;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("active_family_member_id")
    @Expose
    private Integer activeFamilyMemberId;
    @SerializedName("active_family_member_type")
    @Expose
    private String activeFamilyMemberType;
    @SerializedName("active_family_member_service_id")
    @Expose
    private Object activeFamilyMemberServiceId;
    @SerializedName("active_family_member_scheme_id")
    @Expose
    private Integer activeFamilyMemberSchemeId;
    @SerializedName("act_as_service")
    @Expose
    private Boolean actAsService;
    @SerializedName("act_as_enterprise")
    @Expose
    private Boolean actAsEnterprise;
    @SerializedName("need_to_enter_email")
    @Expose
    private Boolean needToEnterEmail;
    @SerializedName("need_to_verify_email")
    @Expose
    private Boolean needToVerifyEmail;
    @SerializedName("privileges")
    @Expose
    private Privileges privileges;
    @SerializedName("need_to_verify_mobile_number")
    @Expose
    private Boolean needToVerifyMobileNumber;
    @SerializedName("force_mobile_verification")
    @Expose
    private Boolean forceMobileVerification;
    @SerializedName("verified_citizen")
    @Expose
    private Boolean verifiedCitizen;
    @SerializedName("verified_phone")
    @Expose
    private Boolean verifiedPhone;
    @SerializedName("approval_fields")
    @Expose
    private List<Object> approvalFields = null;
    @SerializedName("cwa_agreements")
    @Expose
    private List<List<CwaAgreement>> cwaAgreements = null;
    @SerializedName("updated_ip_payers")
    @Expose
    private List<Object> updatedIpPayers = null;
    @SerializedName("view")
    @Expose
    private View view;
    @SerializedName("feed_au_is_active")
    @Expose
    private List<FeedAuIsActive> feedAuIsActive = null;
    @SerializedName("feed_au_is_active_and_not_provide_meals")
    @Expose
    private Boolean feedAuIsActiveAndNotProvideMeals;
    @SerializedName("is_controlled_service")
    @Expose
    private Boolean isControlledService;
    @SerializedName("child_id")
    @Expose
    private Object childId;
    @SerializedName("mode")
    @Expose
    private String mode;
    @SerializedName("modes")
    @Expose
    private List<String> modes = null;
    @SerializedName("hubwiki_mode")
    @Expose
    private String hubwikiMode;
    @SerializedName("first_login")
    @Expose
    private Boolean firstLogin;
    @SerializedName("current_user_service_id")
    @Expose
    private Object currentUserServiceId;
    @SerializedName("new_password_url")
    @Expose
    private String newPasswordUrl;
    @SerializedName("enter_email_url")
    @Expose
    private String enterEmailUrl;
    @SerializedName("verify_email_url")
    @Expose
    private String verifyEmailUrl;
    @SerializedName("need_to_change_password")
    @Expose
    private Boolean needToChangePassword;
    @SerializedName("auth_token")
    @Expose
    private String authToken;
    @SerializedName("show_tour")
    @Expose
    private Boolean showTour;
    @SerializedName("show_feedau_tour")
    @Expose
    private Boolean showFeedauTour;
    @SerializedName("show_repeating_meals_alert")
    @Expose
    private Object showRepeatingMealsAlert;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public String getLegalLabel() {
        return legalLabel;
    }

    public void setLegalLabel(String legalLabel) {
        this.legalLabel = legalLabel;
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

    public Boolean getSuspended() {
        return suspended;
    }

    public void setSuspended(Boolean suspended) {
        this.suspended = suspended;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCoverPictureUrl() {
        return coverPictureUrl;
    }

    public void setCoverPictureUrl(String coverPictureUrl) {
        this.coverPictureUrl = coverPictureUrl;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Object getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(Object userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getActiveFamilyMemberId() {
        return activeFamilyMemberId;
    }

    public void setActiveFamilyMemberId(Integer activeFamilyMemberId) {
        this.activeFamilyMemberId = activeFamilyMemberId;
    }

    public String getActiveFamilyMemberType() {
        return activeFamilyMemberType;
    }

    public void setActiveFamilyMemberType(String activeFamilyMemberType) {
        this.activeFamilyMemberType = activeFamilyMemberType;
    }

    public Object getActiveFamilyMemberServiceId() {
        return activeFamilyMemberServiceId;
    }

    public void setActiveFamilyMemberServiceId(Object activeFamilyMemberServiceId) {
        this.activeFamilyMemberServiceId = activeFamilyMemberServiceId;
    }

    public Integer getActiveFamilyMemberSchemeId() {
        return activeFamilyMemberSchemeId;
    }

    public void setActiveFamilyMemberSchemeId(Integer activeFamilyMemberSchemeId) {
        this.activeFamilyMemberSchemeId = activeFamilyMemberSchemeId;
    }

    public Boolean getActAsService() {
        return actAsService;
    }

    public void setActAsService(Boolean actAsService) {
        this.actAsService = actAsService;
    }

    public Boolean getActAsEnterprise() {
        return actAsEnterprise;
    }

    public void setActAsEnterprise(Boolean actAsEnterprise) {
        this.actAsEnterprise = actAsEnterprise;
    }

    public Boolean getNeedToEnterEmail() {
        return needToEnterEmail;
    }

    public void setNeedToEnterEmail(Boolean needToEnterEmail) {
        this.needToEnterEmail = needToEnterEmail;
    }

    public Boolean getNeedToVerifyEmail() {
        return needToVerifyEmail;
    }

    public void setNeedToVerifyEmail(Boolean needToVerifyEmail) {
        this.needToVerifyEmail = needToVerifyEmail;
    }

    public Privileges getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Privileges privileges) {
        this.privileges = privileges;
    }

    public Boolean getNeedToVerifyMobileNumber() {
        return needToVerifyMobileNumber;
    }

    public void setNeedToVerifyMobileNumber(Boolean needToVerifyMobileNumber) {
        this.needToVerifyMobileNumber = needToVerifyMobileNumber;
    }

    public Boolean getForceMobileVerification() {
        return forceMobileVerification;
    }

    public void setForceMobileVerification(Boolean forceMobileVerification) {
        this.forceMobileVerification = forceMobileVerification;
    }

    public Boolean getVerifiedCitizen() {
        return verifiedCitizen;
    }

    public void setVerifiedCitizen(Boolean verifiedCitizen) {
        this.verifiedCitizen = verifiedCitizen;
    }

    public Boolean getVerifiedPhone() {
        return verifiedPhone;
    }

    public void setVerifiedPhone(Boolean verifiedPhone) {
        this.verifiedPhone = verifiedPhone;
    }

    public List<Object> getApprovalFields() {
        return approvalFields;
    }

    public void setApprovalFields(List<Object> approvalFields) {
        this.approvalFields = approvalFields;
    }

    public List<List<CwaAgreement>> getCwaAgreements() {
        return cwaAgreements;
    }

    public void setCwaAgreements(List<List<CwaAgreement>> cwaAgreements) {
        this.cwaAgreements = cwaAgreements;
    }

    public List<Object> getUpdatedIpPayers() {
        return updatedIpPayers;
    }

    public void setUpdatedIpPayers(List<Object> updatedIpPayers) {
        this.updatedIpPayers = updatedIpPayers;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public List<FeedAuIsActive> getFeedAuIsActive() {
        return feedAuIsActive;
    }

    public void setFeedAuIsActive(List<FeedAuIsActive> feedAuIsActive) {
        this.feedAuIsActive = feedAuIsActive;
    }

    public Boolean getFeedAuIsActiveAndNotProvideMeals() {
        return feedAuIsActiveAndNotProvideMeals;
    }

    public void setFeedAuIsActiveAndNotProvideMeals(Boolean feedAuIsActiveAndNotProvideMeals) {
        this.feedAuIsActiveAndNotProvideMeals = feedAuIsActiveAndNotProvideMeals;
    }

    public Boolean getIsControlledService() {
        return isControlledService;
    }

    public void setIsControlledService(Boolean isControlledService) {
        this.isControlledService = isControlledService;
    }

    public Object getChildId() {
        return childId;
    }

    public void setChildId(Object childId) {
        this.childId = childId;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public List<String> getModes() {
        return modes;
    }

    public void setModes(List<String> modes) {
        this.modes = modes;
    }

    public String getHubwikiMode() {
        return hubwikiMode;
    }

    public void setHubwikiMode(String hubwikiMode) {
        this.hubwikiMode = hubwikiMode;
    }

    public Boolean getFirstLogin() {
        return firstLogin;
    }

    public void setFirstLogin(Boolean firstLogin) {
        this.firstLogin = firstLogin;
    }

    public Object getCurrentUserServiceId() {
        return currentUserServiceId;
    }

    public void setCurrentUserServiceId(Object currentUserServiceId) {
        this.currentUserServiceId = currentUserServiceId;
    }

    public String getNewPasswordUrl() {
        return newPasswordUrl;
    }

    public void setNewPasswordUrl(String newPasswordUrl) {
        this.newPasswordUrl = newPasswordUrl;
    }

    public String getEnterEmailUrl() {
        return enterEmailUrl;
    }

    public void setEnterEmailUrl(String enterEmailUrl) {
        this.enterEmailUrl = enterEmailUrl;
    }

    public String getVerifyEmailUrl() {
        return verifyEmailUrl;
    }

    public void setVerifyEmailUrl(String verifyEmailUrl) {
        this.verifyEmailUrl = verifyEmailUrl;
    }

    public Boolean getNeedToChangePassword() {
        return needToChangePassword;
    }

    public void setNeedToChangePassword(Boolean needToChangePassword) {
        this.needToChangePassword = needToChangePassword;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public Boolean getShowTour() {
        return showTour;
    }

    public void setShowTour(Boolean showTour) {
        this.showTour = showTour;
    }

    public Boolean getShowFeedauTour() {
        return showFeedauTour;
    }

    public void setShowFeedauTour(Boolean showFeedauTour) {
        this.showFeedauTour = showFeedauTour;
    }

    public Object getShowRepeatingMealsAlert() {
        return showRepeatingMealsAlert;
    }

    public void setShowRepeatingMealsAlert(Object showRepeatingMealsAlert) {
        this.showRepeatingMealsAlert = showRepeatingMealsAlert;
    }

}
