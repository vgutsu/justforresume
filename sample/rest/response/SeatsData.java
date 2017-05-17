package com.cinecentre.cinecentrecinema.rest.response;

import com.cinecentre.cinecentrecinema.rest.model.Area;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by victg on 03.03.2017.
 */
public class SeatsData extends SeatingAreaData {

    @SerializedName("Areas")
    @Expose
    private List<Area> areas = null;

    public List<Area> getAreas() {
        return areas;
    }
}
