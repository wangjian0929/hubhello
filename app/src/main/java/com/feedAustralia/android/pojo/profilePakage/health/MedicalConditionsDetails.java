
package com.feedAustralia.android.pojo.profilePakage.health;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MedicalConditionsDetails {

    @SerializedName("allergies")
    @Expose
    private Allergies allergies;
    @SerializedName("eyes")
    @Expose
    private List<Eye> eyes = null;
    @SerializedName("intolerances")
    @Expose
    private List<Intolerance> intolerances = null;
    @SerializedName("others")
    @Expose
    private List<Other_> others = null;

    public Allergies getAllergies() {
        return allergies;
    }

    public void setAllergies(Allergies allergies) {
        this.allergies = allergies;
    }

    public List<Eye> getEyes() {
        return eyes;
    }

    public void setEyes(List<Eye> eyes) {
        this.eyes = eyes;
    }

    public List<Intolerance> getIntolerances() {
        return intolerances;
    }

    public void setIntolerances(List<Intolerance> intolerances) {
        this.intolerances = intolerances;
    }

    public List<Other_> getOthers() {
        return others;
    }

    public void setOthers(List<Other_> others) {
        this.others = others;
    }

}
