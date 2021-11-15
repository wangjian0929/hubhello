
package com.feedAustralia.android.pojo.profilePakage.identity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfilePicture {

    @SerializedName("avatar")
    @Expose
    private String avatar;


    @SerializedName("picture_name")
    @Expose
    private String picture_name;


    @SerializedName("picture")
    @Expose
    private String picture;

    @SerializedName("scheme_id")
    @Expose
    private Integer schemeId;
    @SerializedName("service_id")
    @Expose
    private Integer serviceId;


    @SerializedName("hh_child_id")
    @Expose
    private Integer hhChildId;


    @SerializedName("auth_token")
    @Expose
    private String authToken;


    public String  getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }



    public Integer getHhChildId() {
        return hhChildId;
    }

    public void setHhChildId(Integer hhChildId) {
        this.hhChildId = hhChildId;
    }


    public Integer getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(Integer schemeId) {
        this.schemeId = schemeId;
    }


    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }


    public String getPicture_name(){return  picture_name;};

    public void  setPicture_name(String picture_name){this.picture_name = picture_name;}

    public String getPicture(){return  picture;};

    public void  setPicture(String picture){this.picture = picture;}


    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

}
