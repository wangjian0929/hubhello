
package com.feedAustralia.android.pojo.habit;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MenuEatingHabit {

    @SerializedName("room_id")
    @Expose
    private Integer roomId;
    @SerializedName("room_name")
    @Expose
    private String roomName;
    @SerializedName("eating_habits")
    @Expose
    private List<EatingHabit> eatingHabits = null;

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public List<EatingHabit> getEatingHabits() {
        return eatingHabits;
    }

    public void setEatingHabits(List<EatingHabit> eatingHabits) {
        this.eatingHabits = eatingHabits;
    }

}
