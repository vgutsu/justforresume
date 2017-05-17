package com.cinecentre.cinecentrecinema.rest.model;

import com.cinecentre.cinecentrecinema.R;
import com.cinecentre.seats.hall.HallScheme;
import com.cinecentre.seats.hall.Seat;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SeatModel implements Seat {
    @SerializedName("SeatName")
    @Expose
    private String seatName;
    @SerializedName("SeatId")
    @Expose
    private int seatId;

    @SerializedName("SeatDescription")
    @Expose
    private String seatDescription;

    @SerializedName("TwinSeatId")
    @Expose
    private int twinSeatId;

    @SerializedName("IsPassage")
    @Expose
    private boolean isPassage;
    @SerializedName("IsSeatBroken")
    @Expose
    private boolean isSeatBroken;

    @SerializedName("IsWheelChair")
    @Expose
    private boolean isWheelChair;

    @SerializedName("IsBooked")
    @Expose
    private boolean isBooked;

    @SerializedName("IsAvailable")
    @Expose
    private boolean isAvailable;


    private String marker;
    private HallScheme.SeatStatus status = HallScheme.SeatStatus.FREE;


    public int getSeatId() {
        return seatId;
    }

    public int getTwinSeatId() {
        return twinSeatId;
    }

    public String getSeatDescription() {
        return seatDescription;
    }

    public String getSeatName() {
        return seatName;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public boolean isPassage() {
        return isPassage;
    }

    public boolean isSeatBroken() {
        return isSeatBroken;
    }

    public boolean isWheelChair() {
        return isWheelChair;
    }


    @Override
    public int id() {
        return getSeatId();
    }

    @Override
    public String marker() {
        return marker;
    }

    @Override
    public String selectedSeat() {
        return getSeatDescription();
    }


    @Override
    public HallScheme.SeatStatus getStatus() {
        if (status != HallScheme.SeatStatus.CHOSEN) {
            if (isAvailable) status = HallScheme.SeatStatus.FREE;
            if (isBooked) status = HallScheme.SeatStatus.BUSY;
        }
        return status;
    }

    @Override
    public int getFreeSeatColor() {
        int color = android.R.color.transparent;
        if (isWheelChair) color = R.color.color_wheel_seats;
        return color;
    }

    @Override
    public int getBusySeatColor() {
        return R.color.color_occupied_seats;
    }

    @Override
    public int getBorderColor() {
        return R.color.color_border_background_seats;
    }

    @Override
    public int getChosenColor() {
        return R.color.color_chosen_seats;
    }

    @Override
    public void setStatus(HallScheme.SeatStatus status) {
        this.status = status;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public void setBooked(boolean booked) {
        this.isBooked = booked;
    }

    @Override
    public String toString() {
        return selectedSeat();
    }
}