
package com.feedAustralia.android.pojo.mealpkg;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MealGroup {

    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("colour")
    @Expose
    private String colour;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("recommendation_amount")
    @Expose
    private Double recommendationAmount;
    @SerializedName("recommendation_text")
    @Expose
    private String recommendationText;
    @SerializedName("tips")
    @Expose
    private String tips;
    @SerializedName("tips_html")
    @Expose
    private String tipsHtml;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRecommendationAmount() {
        return recommendationAmount;
    }

    public void setRecommendationAmount(Double recommendationAmount) {
        this.recommendationAmount = recommendationAmount;
    }

    public String getRecommendationText() {
        return recommendationText;
    }

    public void setRecommendationText(String recommendationText) {
        this.recommendationText = recommendationText;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public String getTipsHtml() {
        return tipsHtml;
    }

    public void setTipsHtml(String tipsHtml) {
        this.tipsHtml = tipsHtml;
    }

}
