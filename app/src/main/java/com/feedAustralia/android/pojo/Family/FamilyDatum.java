
package com.feedAustralia.android.pojo.Family;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FamilyDatum {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("compact_name")
    @Expose
    private String compactName;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("age")
    @Expose
    private Integer age;
    @SerializedName("avatar")
    @Expose
    private String avatar;
    @SerializedName("cover_picture_url")
    @Expose
    private Object coverPictureUrl;
    @SerializedName("services")
    @Expose
    private List<Service> services = null;
    @SerializedName("bookings")
    @Expose
    private Boolean bookings;
    @SerializedName("bookme")
    @Expose
    private Boolean bookme;
    @SerializedName("bookme_scheme_id")
    @Expose
    private Integer bookmeSchemeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompactName() {
        return compactName;
    }

    public void setCompactName(String compactName) {
        this.compactName = compactName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Object getCoverPictureUrl() {
        return coverPictureUrl;
    }

    public void setCoverPictureUrl(Object coverPictureUrl) {
        this.coverPictureUrl = coverPictureUrl;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public Boolean getBookings() {
        return bookings;
    }

    public void setBookings(Boolean bookings) {
        this.bookings = bookings;
    }

    public Boolean getBookme() {
        return bookme;
    }

    public void setBookme(Boolean bookme) {
        this.bookme = bookme;
    }

    public Integer getBookmeSchemeId() {
        return bookmeSchemeId;
    }

    public void setBookmeSchemeId(Integer bookmeSchemeId) {
        this.bookmeSchemeId = bookmeSchemeId;
    }

}
