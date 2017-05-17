package com.cinecentre.cinecentrecinema.rest.response;

import com.cinecentre.cinecentrecinema.rest.model.Region;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by victg on 13.02.2017.
 */
public class RegionData {
    @SerializedName("PopRegions")
    @Expose
    private List<Region> popRegions = null;
    @SerializedName("AllRegions")
    @Expose
    private List<Region> allRegions = null;

    public List<Region> getPopRegions() {
        return popRegions;
    }

    public void setPopRegions(List<Region> popRegions) {
        this.popRegions = popRegions;
    }

    public List<Region> getAllRegions() {
        return allRegions;
    }

    public void setAllRegions(List<Region> allRegions) {
        this.allRegions = allRegions;
    }


}
