package com.cinecentre.cinecentrecinema.rest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by victg on 13.02.2017.
 */
public class FilmFliter {

    @SerializedName("FirstFilter")
    @Expose
    private List<String> firstFilter = null;
    @SerializedName("SecondFilter")
    @Expose
    private List<String> secondFilter = null;

    public List<String> getFirstFilter() {
        return firstFilter;
    }

    public void setFirstFilter(List<String> firstFilter) {
        this.firstFilter = firstFilter;
    }

    public List<String> getSecondFilter() {
        return secondFilter;
    }

    public void setSecondFilter(List<String> secondFilter) {
        this.secondFilter = secondFilter;
    }

}
