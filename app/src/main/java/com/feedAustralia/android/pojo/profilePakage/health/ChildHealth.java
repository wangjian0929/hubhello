
package com.feedAustralia.android.pojo.profilePakage.health;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChildHealth {

    @SerializedName("medical_conditions")
    @Expose
    private String medicalConditions;
    @SerializedName("allergies")
    @Expose
    private String allergies;
    @SerializedName("allergies_comments")
    @Expose
    private List<Object> allergiesComments = null;
    @SerializedName("food_allergies")
    @Expose
    private List<String> foodAllergies = null;
    @SerializedName("medical_conditions_details")
    @Expose
    private MedicalConditionsDetails medicalConditionsDetails;

    public String getMedicalConditions() {
        return medicalConditions;
    }

    public void setMedicalConditions(String medicalConditions) {
        this.medicalConditions = medicalConditions;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public List<Object> getAllergiesComments() {
        return allergiesComments;
    }

    public void setAllergiesComments(List<Object> allergiesComments) {
        this.allergiesComments = allergiesComments;
    }

    public List<String> getFoodAllergies() {
        return foodAllergies;
    }

    public void setFoodAllergies(List<String> foodAllergies) {
        this.foodAllergies = foodAllergies;
    }

    public MedicalConditionsDetails getMedicalConditionsDetails() {
        return medicalConditionsDetails;
    }

    public void setMedicalConditionsDetails(MedicalConditionsDetails medicalConditionsDetails) {
        this.medicalConditionsDetails = medicalConditionsDetails;
    }

}
