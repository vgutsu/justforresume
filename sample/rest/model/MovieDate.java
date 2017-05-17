package com.cinecentre.cinecentrecinema.rest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class MovieDate implements Serializable {

    @SerializedName("TimeStamp")
    @Expose
    private long timeStamp;
    @SerializedName("DisplayDate")
    @Expose
    private String displayDate;

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getDisplayDate() {
        return displayDate;
    }

    public void setDisplayDate(String displayDate) {
        this.displayDate = displayDate;
    }

    public String getShowTimesString() {
        return new SimpleDateFormat("EEE\ndd", Locale.ENGLISH).format(timeStamp * 1000l).toString();
    }

    public String getDayOfWeek() {
        return new SimpleDateFormat("EEE", Locale.ENGLISH).format(timeStamp * 1000l).toString();
    }

    public String getDayOfMonth() {
        return new SimpleDateFormat("dd", Locale.ENGLISH).format(timeStamp * 1000l).toString();
    }
}