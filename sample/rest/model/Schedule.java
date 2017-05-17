package com.cinecentre.cinecentrecinema.rest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by victg on 14.02.2017.
 */
public class Schedule implements Serializable {
    @SerializedName("ScheduleId")
    @Expose
    private int scheduleId;
    @SerializedName("Date")
    @Expose
    private long date;
    @SerializedName("ShowTimes")
    @Expose
    private long showTimes;
    @SerializedName("AvailableSeats")
    @Expose
    private long availableSeats;
    @SerializedName("TotalSeats")
    @Expose
    private long totalSeats;
    @SerializedName("ScheduleCloseTime")
    @Expose
    private long scheduleCloseTime;
    @SerializedName("LevelMessage")
    @Expose
    private String levelMessage;
    @SerializedName("ScreenId")
    @Expose
    private long screenId;
    @SerializedName("ScreenName")
    @Expose
    private String screenName;
    @SerializedName("Areas")
    @Expose
    private List<SeatingAreaInfo> areas = null;

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public long getShowTimes() {
        return showTimes;
    }

    public String getShowTimesString() {
        return new SimpleDateFormat("HH:mm").format(showTimes * 1000l).toString();
    }
    public String getWholeShowTimesString() {
        return new SimpleDateFormat("MMMM d, yyyy - HH:mm aaa").format(showTimes * 1000l).toString();
    }
    public void setShowTimes(long showTimes) {
        this.showTimes = showTimes;
    }

    public long getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(long availableSeats) {
        this.availableSeats = availableSeats;
    }

    public long getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(long totalSeats) {
        this.totalSeats = totalSeats;
    }

    public long getScheduleCloseTime() {
        return scheduleCloseTime;
    }

    public void setScheduleCloseTime(long scheduleCloseTime) {
        this.scheduleCloseTime = scheduleCloseTime;
    }

    public String getLevelMessage() {
        return levelMessage;
    }

    public void setLevelMessage(String levelMessage) {
        this.levelMessage = levelMessage;
    }

    public long getScreenId() {
        return screenId;
    }

    public void setScreenId(long screenId) {
        this.screenId = screenId;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public List<SeatingAreaInfo> getAreas() {
        return areas;
    }

    public void setAreas(List<SeatingAreaInfo> areas) {
        this.areas = areas;
    }
}
