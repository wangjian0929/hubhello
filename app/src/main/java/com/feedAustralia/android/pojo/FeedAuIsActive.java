
package com.feedAustralia.android.pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FeedAuIsActive {

    @SerializedName("hh_child")
    @Expose
    private HhChild hhChild;
    @SerializedName("services")
    @Expose
    private List<Service_> services = null;

    public HhChild getHhChild() {
        return hhChild;
    }

    public void setHhChild(HhChild hhChild) {
        this.hhChild = hhChild;
    }

    public List<Service_> getServices() {
        return services;
    }

    public void setServices(List<Service_> services) {
        this.services = services;
    }

}
