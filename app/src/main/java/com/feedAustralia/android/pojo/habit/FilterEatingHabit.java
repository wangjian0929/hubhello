
package com.feedAustralia.android.pojo.habit;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FilterEatingHabit {

    @SerializedName("room_id")
    @Expose
    private Integer roomId;
    @SerializedName("eating_date")
    @Expose
    private String eatingDate;
    @SerializedName("eating_habits")
    @Expose
    private List<EatingHabit> eatingHabits = null;

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getEatingDate() {
        return eatingDate;
    }

    public void setEatingDate(String eatingDate) {
        this.eatingDate = eatingDate;
    }

    public List<EatingHabit> getEatingHabits() {
        return eatingHabits;
    }

    public void setEatingHabits(List<EatingHabit> eatingHabits) {
        this.eatingHabits = eatingHabits;
    }

}
