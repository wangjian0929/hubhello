
package com.feedAustralia.android.pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class View {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("active_modules")
    @Expose
    private List<String> activeModules = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getActiveModules() {
        return activeModules;
    }

    public void setActiveModules(List<String> activeModules) {
        this.activeModules = activeModules;
    }

}
