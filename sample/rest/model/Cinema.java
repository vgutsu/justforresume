
package com.cinecentre.cinecentrecinema.rest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Cinema implements Serializable {
    @SerializedName("CinemaId")
    @Expose
    private int cinemaId;
    @SerializedName("CinemaName")
    @Expose
    private String cinemaName;
    @SerializedName("Address")
    @Expose
    private String address;
    @SerializedName("City")
    @Expose
    private String city;
    @SerializedName("Pincode")
    @Expose
    private String pincode;
    @SerializedName("Phone1")
    @Expose
    private String phone1;
    @SerializedName("Phone2")
    @Expose
    private String phone2;

    @SerializedName("BookingDeadLine")
    @Expose
    private String bookingDeadLine;

    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    @Override
    public String toString() {
        return city;
    }

    public String getBookingDeadLine() {
        return bookingDeadLine;
    }

    public void setBookingDeadLine(String bookingDeadLine) {
        this.bookingDeadLine = bookingDeadLine;
    }

    public String getImage() {
        return "null";
    }
}
