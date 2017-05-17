package com.cinecentre.cinecentrecinema.rest.model;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.util.Map;

/**
 * Created by victg on 13.02.2017.
 */
public class Film extends MovieInfo {

    @SerializedName("BookingStatus")
    @Expose
    private Boolean bookingStatus;
    @SerializedName("CertificateMsg")
    @Expose
    private String certificateMsg;
    @SerializedName("Director")
    @Expose
    private String director;
    @SerializedName("Genres")
    @Expose
    private String genres;
    @SerializedName("Length")
    @Expose
    private int length;
    @SerializedName("MusicDirector")
    @Expose
    private String musicDirector;
    @SerializedName("Producer")
    @Expose
    private String producer;
    @SerializedName("ReleaseDate")
    @Expose
    private String releaseDate;
    @SerializedName("Starring")
    @Expose
    private String starring;
    @SerializedName("Synopsis")
    @Expose
    private String synopsis;
    @SerializedName("TrailerLink")
    @Expose
    private String trailerLink;

    public Boolean getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(Boolean bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public String getCertificateMsg() {
        return certificateMsg;
    }

    public void setCertificateMsg(String certificateMsg) {
        this.certificateMsg = certificateMsg;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public int getLength() {
        return length;
    }

    public String getLengthString() {
        int h = length / 60;
        int m = length % 60;
        return h + "h " + m + "m";
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getMusicDirector() {
        return musicDirector;
    }

    public void setMusicDirector(String musicDirector) {
        this.musicDirector = musicDirector;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getStarring() {
        return starring;
    }

    public void setStarring(String starring) {
        this.starring = starring;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getTrailerLink() {
        //TODO change with real link
        trailerLink = "https://www.youtube.com/embed/fIHH5-HVS9o";
        return trailerLink;
    }

    public void setTrailerLink(String trailerLink) {
        this.trailerLink = trailerLink;
    }

    public String getImage() {
        int cinemaID = 1045;
        return "http://www.cinecentre.co.za/admin/MovieImages/" + cinemaID + "/226_330/" + getMovieId() + ".jpg";
    }

    public Map returnFieldsAsMap() {
        Gson gson = new Gson();
        return gson.fromJson(gson.toJson(this, Film.class), new TypeToken<Map>() {
        }.getType());
    }
}
