package com.cinecentre.cinecentrecinema.rest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by victg on 03.03.2017.
 */
public class Area {

    @SerializedName("AreaName")
    @Expose
    private String areaName;
    @SerializedName("AreaId")
    @Expose
    private long areaId;

    @SerializedName("Rows")
    @Expose
    private List<Row> rowList;

    public List<Row> getRowList() {
        return rowList;
    }

    public long getAreaId() {
        return areaId;
    }

    public String getAreaName() {
        return areaName;
    }

}
