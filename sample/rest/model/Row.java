package com.cinecentre.cinecentrecinema.rest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Row {
    @SerializedName("RowDescription")
    @Expose
    private String rowDescription;
    @SerializedName("RowId")
    @Expose
    private int rowId;

    @SerializedName("Seats")
    @Expose
    private List<SeatModel> seatList;

    public void setSeatList(List<SeatModel> seatList) {
        this.seatList = seatList;
    }

    public List<SeatModel> getSeatList() {
        return seatList;
    }

    public int getRowId() {
        return rowId;
    }

    public void setRowDescription(String rowDescription) {
        this.rowDescription = rowDescription;
    }

    public String getRowDescription() {
        return rowDescription;
    }
}