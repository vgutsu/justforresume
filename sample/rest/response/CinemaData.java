package com.cinecentre.cinecentrecinema.rest.response;

import com.cinecentre.cinecentrecinema.rest.model.Cinema;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by victg on 27.01.2017.
 */

public class CinemaData {
    @SerializedName("Cinemas")
    @Expose
    private List<Cinema> cinemas = null;

    /**
     * No args constructor for use in serialization
     */
    public CinemaData() {
    }

    public List<Cinema> getCinemas() {
        return cinemas;
    }

    public void setCinemas(List<Cinema> cinemas) {
        this.cinemas = cinemas;

    }
}
