package com.cinecentre.cinecentrecinema.rest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class  MovieInfo implements Serializable {

    @SerializedName("MovieId")
    @Expose
    private int movieId;
    @SerializedName("MovieName")
    @Expose
    private String movieName;
    @SerializedName("Certificate")
    @Expose
    private String certificate;
    @SerializedName("MovieType")
    @Expose
    private String movieType;
    @SerializedName("MovieLanguage")
    @Expose
    private String movieLanguage;

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public String getMovieLanguage() {
        return movieLanguage;
    }

    public void setMovieLanguage(String movieLanguage) {
        this.movieLanguage = movieLanguage;
    }

}