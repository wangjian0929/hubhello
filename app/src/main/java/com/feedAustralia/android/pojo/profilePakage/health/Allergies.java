
package com.feedAustralia.android.pojo.profilePakage.health;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Allergies {

    @SerializedName("food")
    @Expose
    private List<Food> food = null;
    @SerializedName("medication")
    @Expose
    private List<Medication> medication = null;
    @SerializedName("insect")
    @Expose
    private List<Insect> insect = null;
    @SerializedName("other")
    @Expose
    private List<Other> other = null;

    public List<Food> getFood() {
        return food;
    }

    public void setFood(List<Food> food) {
        this.food = food;
    }

    public List<Medication> getMedication() {
        return medication;
    }

    public void setMedication(List<Medication> medication) {
        this.medication = medication;
    }

    public List<Insect> getInsect() {
        return insect;
    }

    public void setInsect(List<Insect> insect) {
        this.insect = insect;
    }

    public List<Other> getOther() {
        return other;
    }

    public void setOther(List<Other> other) {
        this.other = other;
    }

}
