package com.cinecentre.cinecentrecinema.rest.response;

import com.cinecentre.cinecentrecinema.rest.model.Cinema;
import com.cinecentre.cinecentrecinema.rest.model.MovieInfo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by victg on 14.02.2017.
 */
public class MovieShowTimesData extends ShowTimesData {

    @SerializedName("MovieInfo")
    @Expose
    private MovieInfo movieInfo;

    @SerializedName("CinemaList")
    @Expose
    private List<Cinema> cinemaList = null;

    @Override
    public List<Cinema> getList() {
        return cinemaList;
    }

    public MovieInfo getMovieInfo() {
        return movieInfo;
    }
}

