package com.cinecentre.cinecentrecinema.rest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by victg on 13.02.2017.
 */
public class Region {

    @SerializedName("RegionId")
    @Expose
    private int regionId;
    @SerializedName("RegionName")
    @Expose
    private String regionName;
    private boolean isHighLight = false;

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @Override
    public String toString() {
        return regionName;
    }

    public boolean highLight(Object obj) {
        return isHighLight = equals(obj);
    }

    @Override
    public boolean equals(Object obj) {
        return this.regionId == ((Region) obj).regionId;
    }

    public boolean isHighLight() {
        return isHighLight;
    }
}
