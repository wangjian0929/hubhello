
package com.feedAustralia.android.pojo.profilePakage.identity;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IdentityData {

    @SerializedName("private_health_fund")
    @Expose
    private String privateHealthFund;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("prior_names")
    @Expose
    private List<Object> priorNames = null;
    @SerializedName("prior_name_exist")
    @Expose
    private String priorNameExist;
    @SerializedName("contact_address")
    @Expose
    private ContactAddress contactAddress;
    @SerializedName("contact_home_phones")
    @Expose
    private List<Object> contactHomePhones = null;
    @SerializedName("contact_mobile_phones")
    @Expose
    private List<ContactMobilePhone> contactMobilePhones = null;
    @SerializedName("contact_emails")
    @Expose
    private List<ContactEmail> contactEmails = null;
    @SerializedName("contact_websites")
    @Expose
    private List<Object> contactWebsites = null;
    @SerializedName("contact_parent_to_child")
    @Expose
    private String contactParentToChild;
    @SerializedName("languages")
    @Expose
    private List<Language> languages = null;
    @SerializedName("education")
    @Expose
    private List<Education> education = null;
    @SerializedName("gender")
    @Expose
    private List<String> gender = null;
    @SerializedName("birthday")
    @Expose
    private List<String> birthday = null;
    @SerializedName("last_name")
    @Expose
    private List<String> lastName = null;
    @SerializedName("first_name")
    @Expose
    private List<String> firstName = null;
    @SerializedName("middle_names")
    @Expose
    private List<String> middleNames = null;
    @SerializedName("culture")
    @Expose
    private List<String> culture = null;
    @SerializedName("place_of_birth")
    @Expose
    private List<String> placeOfBirth = null;
    @SerializedName("religious_activities")
    @Expose
    private List<String> religiousActivities = null;
    @SerializedName("aspects_of_background")
    @Expose
    private List<String> aspectsOfBackground = null;
    @SerializedName("anaphylaxis_risk_plan_completed_by_service_comments_from_hw")
    @Expose
    private List<Object> anaphylaxisRiskPlanCompletedByServiceCommentsFromHw = null;
    @SerializedName("toilet_training_comment_from_hw")
    @Expose
    private List<Object> toiletTrainingCommentFromHw = null;
    @SerializedName("other_children_comment_from_hw")
    @Expose
    private List<Object> otherChildrenCommentFromHw = null;
    @SerializedName("other_adults_comment_from_hw")
    @Expose
    private List<Object> otherAdultsCommentFromHw = null;
    @SerializedName("first_time_comment_from_hw")
    @Expose
    private List<Object> firstTimeCommentFromHw = null;
    @SerializedName("religious_activities_comment_from_hw")
    @Expose
    private List<Object> religiousActivitiesCommentFromHw = null;
    @SerializedName("aspects_of_background_comment_from_hw")
    @Expose
    private List<Object> aspectsOfBackgroundCommentFromHw = null;
    @SerializedName("contact_work_phones")
    @Expose
    private List<Object> contactWorkPhones = null;
    @SerializedName("has_formal_enrolment")
    @Expose
    private Boolean hasFormalEnrolment;
    @SerializedName("participants")
    @Expose
    private List<Participant> participants = null;
    @SerializedName("proof_of_identity_details")
    @Expose
    private List<ProofOfIdentityDetail> proofOfIdentityDetails = null;
    @SerializedName("required_fields")
    @Expose
    private List<String> requiredFields = null;
    @SerializedName("age")
    @Expose
    private Integer age;
    @SerializedName("hw_migration_completed")
    @Expose
    private Boolean hwMigrationCompleted;

    public String getPrivateHealthFund() {
        return privateHealthFund;
    }

    public void setPrivateHealthFund(String privateHealthFund) {
        this.privateHealthFund = privateHealthFund;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Object> getPriorNames() {
        return priorNames;
    }

    public void setPriorNames(List<Object> priorNames) {
        this.priorNames = priorNames;
    }

    public String getPriorNameExist() {
        return priorNameExist;
    }

    public void setPriorNameExist(String priorNameExist) {
        this.priorNameExist = priorNameExist;
    }

    public ContactAddress getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(ContactAddress contactAddress) {
        this.contactAddress = contactAddress;
    }

    public List<Object> getContactHomePhones() {
        return contactHomePhones;
    }

    public void setContactHomePhones(List<Object> contactHomePhones) {
        this.contactHomePhones = contactHomePhones;
    }

    public List<ContactMobilePhone> getContactMobilePhones() {
        return contactMobilePhones;
    }

    public void setContactMobilePhones(List<ContactMobilePhone> contactMobilePhones) {
        this.contactMobilePhones = contactMobilePhones;
    }

    public List<ContactEmail> getContactEmails() {
        return contactEmails;
    }

    public void setContactEmails(List<ContactEmail> contactEmails) {
        this.contactEmails = contactEmails;
    }

    public List<Object> getContactWebsites() {
        return contactWebsites;
    }

    public void setContactWebsites(List<Object> contactWebsites) {
        this.contactWebsites = contactWebsites;
    }

    public String getContactParentToChild() {
        return contactParentToChild;
    }

    public void setContactParentToChild(String contactParentToChild) {
        this.contactParentToChild = contactParentToChild;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public List<Education> getEducation() {
        return education;
    }

    public void setEducation(List<Education> education) {
        this.education = education;
    }

    public List<String> getGender() {
        return gender;
    }

    public void setGender(List<String> gender) {
        this.gender = gender;
    }

    public List<String> getBirthday() {
        return birthday;
    }

    public void setBirthday(List<String> birthday) {
        this.birthday = birthday;
    }

    public List<String> getLastName() {
        return lastName;
    }

    public void setLastName(List<String> lastName) {
        this.lastName = lastName;
    }

    public List<String> getFirstName() {
        return firstName;
    }

    public void setFirstName(List<String> firstName) {
        this.firstName = firstName;
    }

    public List<String> getMiddleNames() {
        return middleNames;
    }

    public void setMiddleNames(List<String> middleNames) {
        this.middleNames = middleNames;
    }

    public List<String> getCulture() {
        return culture;
    }

    public void setCulture(List<String> culture) {
        this.culture = culture;
    }

    public List<String> getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(List<String> placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public List<String> getReligiousActivities() {
        return religiousActivities;
    }

    public void setReligiousActivities(List<String> religiousActivities) {
        this.religiousActivities = religiousActivities;
    }

    public List<String> getAspectsOfBackground() {
        return aspectsOfBackground;
    }

    public void setAspectsOfBackground(List<String> aspectsOfBackground) {
        this.aspectsOfBackground = aspectsOfBackground;
    }

    public List<Object> getAnaphylaxisRiskPlanCompletedByServiceCommentsFromHw() {
        return anaphylaxisRiskPlanCompletedByServiceCommentsFromHw;
    }

    public void setAnaphylaxisRiskPlanCompletedByServiceCommentsFromHw(List<Object> anaphylaxisRiskPlanCompletedByServiceCommentsFromHw) {
        this.anaphylaxisRiskPlanCompletedByServiceCommentsFromHw = anaphylaxisRiskPlanCompletedByServiceCommentsFromHw;
    }

    public List<Object> getToiletTrainingCommentFromHw() {
        return toiletTrainingCommentFromHw;
    }

    public void setToiletTrainingCommentFromHw(List<Object> toiletTrainingCommentFromHw) {
        this.toiletTrainingCommentFromHw = toiletTrainingCommentFromHw;
    }

    public List<Object> getOtherChildrenCommentFromHw() {
        return otherChildrenCommentFromHw;
    }

    public void setOtherChildrenCommentFromHw(List<Object> otherChildrenCommentFromHw) {
        this.otherChildrenCommentFromHw = otherChildrenCommentFromHw;
    }

    public List<Object> getOtherAdultsCommentFromHw() {
        return otherAdultsCommentFromHw;
    }

    public void setOtherAdultsCommentFromHw(List<Object> otherAdultsCommentFromHw) {
        this.otherAdultsCommentFromHw = otherAdultsCommentFromHw;
    }

    public List<Object> getFirstTimeCommentFromHw() {
        return firstTimeCommentFromHw;
    }

    public void setFirstTimeCommentFromHw(List<Object> firstTimeCommentFromHw) {
        this.firstTimeCommentFromHw = firstTimeCommentFromHw;
    }

    public List<Object> getReligiousActivitiesCommentFromHw() {
        return religiousActivitiesCommentFromHw;
    }

    public void setReligiousActivitiesCommentFromHw(List<Object> religiousActivitiesCommentFromHw) {
        this.religiousActivitiesCommentFromHw = religiousActivitiesCommentFromHw;
    }

    public List<Object> getAspectsOfBackgroundCommentFromHw() {
        return aspectsOfBackgroundCommentFromHw;
    }

    public void setAspectsOfBackgroundCommentFromHw(List<Object> aspectsOfBackgroundCommentFromHw) {
        this.aspectsOfBackgroundCommentFromHw = aspectsOfBackgroundCommentFromHw;
    }

    public List<Object> getContactWorkPhones() {
        return contactWorkPhones;
    }

    public void setContactWorkPhones(List<Object> contactWorkPhones) {
        this.contactWorkPhones = contactWorkPhones;
    }

    public Boolean getHasFormalEnrolment() {
        return hasFormalEnrolment;
    }

    public void setHasFormalEnrolment(Boolean hasFormalEnrolment) {
        this.hasFormalEnrolment = hasFormalEnrolment;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    public List<ProofOfIdentityDetail> getProofOfIdentityDetails() {
        return proofOfIdentityDetails;
    }

    public void setProofOfIdentityDetails(List<ProofOfIdentityDetail> proofOfIdentityDetails) {
        this.proofOfIdentityDetails = proofOfIdentityDetails;
    }

    public List<String> getRequiredFields() {
        return requiredFields;
    }

    public void setRequiredFields(List<String> requiredFields) {
        this.requiredFields = requiredFields;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getHwMigrationCompleted() {
        return hwMigrationCompleted;
    }

    public void setHwMigrationCompleted(Boolean hwMigrationCompleted) {
        this.hwMigrationCompleted = hwMigrationCompleted;
    }

}
