
package com.feedAustralia.android.pojo.profilePakage.identity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContactAddress {

    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("floor")
    @Expose
    private String floor;
    @SerializedName("house_number")
    @Expose
    private String houseNumber;
    @SerializedName("level")
    @Expose
    private String level;
    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("postcode")
    @Expose
    private String postcode;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("street")
    @Expose
    private String street;
    @SerializedName("street_unit")
    @Expose
    private String streetUnit;
    @SerializedName("suburb")
    @Expose
    private String suburb;
    @SerializedName("unit")
    @Expose
    private String unit;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetUnit() {
        return streetUnit;
    }

    public void setStreetUnit(String streetUnit) {
        this.streetUnit = streetUnit;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

}
