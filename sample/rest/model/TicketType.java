package com.cinecentre.cinecentrecinema.rest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class TicketType implements Serializable {

    @SerializedName("SeatingAreaId")
    @Expose
    private long seatingAreaId;
    @SerializedName("TicketId")
    @Expose
    private long ticketId;
    @SerializedName("Desciption")
    @Expose
    private String desciption;
    @SerializedName("ShortDescription")
    @Expose
    private String shortDescription;
    @SerializedName("TCDescription")
    @Expose
    private String tCDescription;
    @SerializedName("TicketRate")
    @Expose
    private double ticketRate;
    @SerializedName("Quantity")
    @Expose
    private long quantity;
    @SerializedName("GroupId")
    @Expose
    private long groupId;
    @SerializedName("ComboItems")
    @Expose
    private List<Object> comboItems = null;

    public long getSeatingAreaId() {
        return seatingAreaId;
    }

    public void setSeatingAreaId(long seatingAreaId) {
        this.seatingAreaId = seatingAreaId;
    }

    public long getTicketId() {
        return ticketId;
    }

    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getTCDescription() {
        return tCDescription;
    }

    public void setTCDescription(String tCDescription) {
        this.tCDescription = tCDescription;
    }

    public double getTicketRate() {
        return ticketRate;
    }

    public void setTicketRate(double ticketRate) {
        this.ticketRate = ticketRate;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public List<Object> getComboItems() {
        return comboItems;
    }

    public void setComboItems(List<Object> comboItems) {
        this.comboItems = comboItems;
    }

    @Override
    public String toString() {
        return desciption;
    }
}
