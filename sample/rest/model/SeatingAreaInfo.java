package com.cinecentre.cinecentrecinema.rest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SeatingAreaInfo implements Serializable {

    @SerializedName("ScheduleId")
    @Expose
    private long scheduleId;
    @SerializedName("AreaId")
    @Expose
    private long areaId;
    @SerializedName("AreaDescription")
    @Expose
    private String areaDescription;
    @SerializedName("TotalTickets")
    @Expose
    private long totalTickets;
    @SerializedName("AvailableTickets")
    @Expose
    private long availableTickets;
    @SerializedName("IsTwinSeating")
    @Expose
    private boolean isTwinSeating;
    @SerializedName("SelectionMode")
    @Expose
    private long selectionMode;
    @SerializedName("MaxTicketsPerTrans")
    @Expose
    private int maxTicketsPerTrans;

    public long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public long getAreaId() {
        return areaId;
    }

    public void setAreaId(long areaId) {
        this.areaId = areaId;
    }

    public String getAreaDescription() {
        return areaDescription;
    }

    public void setAreaDescription(String areaDescription) {
        this.areaDescription = areaDescription;
    }

    public long getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(long totalTickets) {
        this.totalTickets = totalTickets;
    }

    public long getAvailableTickets() {
        return availableTickets;
    }

    public void setAvailableTickets(long availableTickets) {
        this.availableTickets = availableTickets;
    }

    public boolean isIsTwinSeating() {
        return isTwinSeating;
    }

    public void setIsTwinSeating(boolean isTwinSeating) {
        this.isTwinSeating = isTwinSeating;
    }

    public long getSelectionMode() {
        return selectionMode;
    }

    public void setSelectionMode(long selectionMode) {
        this.selectionMode = selectionMode;
    }

    public int getMaxTicketsPerTrans() {
        return maxTicketsPerTrans;
    }

    public void setMaxTicketsPerTrans(int maxTicketsPerTrans) {
        this.maxTicketsPerTrans = maxTicketsPerTrans;
    }

}
