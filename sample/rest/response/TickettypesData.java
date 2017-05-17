package com.cinecentre.cinecentrecinema.rest.response;

import com.cinecentre.cinecentrecinema.rest.model.MovieInfo;
import com.cinecentre.cinecentrecinema.rest.model.SeatingAreaInfo;
import com.cinecentre.cinecentrecinema.rest.model.TicketType;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by victg on 14.02.2017.
 */
public class TickettypesData implements Serializable {

    @SerializedName("MovieInfo")
    @Expose
    private MovieInfo movieInfo;
    @SerializedName("ScheduleId")
    @Expose
    private int scheduleId;
    @SerializedName("ScheduleDatetime")
    @Expose
    private long scheduleDatetime;
    @SerializedName("CinemaId")
    @Expose
    private int cinemaId;
    @SerializedName("CinemaName")
    @Expose
    private String cinemaName;
    @SerializedName("ScreenName")
    @Expose
    private String screenName;
    @SerializedName("SeatingAreaInfo")
    @Expose
    private SeatingAreaInfo seatingAreaInfo;
    @SerializedName("TicketTypes")
    @Expose
    private List<TicketType> ticketTypes = null;
    private TicketType currentTicketType;

    public MovieInfo getMovieInfo() {
        return movieInfo;
    }

    public void setMovieInfo(MovieInfo movieInfo) {
        this.movieInfo = movieInfo;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public long getScheduleDatetime() {
        return scheduleDatetime;
    }

    public void setScheduleDatetime(long scheduleDatetime) {
        this.scheduleDatetime = scheduleDatetime;
    }

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

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public SeatingAreaInfo getSeatingAreaInfo() {
        return seatingAreaInfo;
    }

    public void setSeatingAreaInfo(SeatingAreaInfo seatingAreaInfo) {
        this.seatingAreaInfo = seatingAreaInfo;
    }

    public List<TicketType> getTicketTypes() {
        return ticketTypes;
    }

    public void setTicketTypes(List<TicketType> ticketTypes) {
        this.ticketTypes = ticketTypes;
    }


    public String getShowTimesString() {
        return new SimpleDateFormat("HH:mm").format(scheduleDatetime * 1000l).toString();
    }

    public String getWholeShowTimesString() {
        return new SimpleDateFormat("MMMM d, yyyy - HH:mm aaa").format(scheduleDatetime * 1000l).toString();
    }

    public void setCurrentTicketType(TicketType currentTicketType) {
        this.currentTicketType = currentTicketType;
    }

    public TicketType getCurrentTicketType() {
        return currentTicketType;
    }
}
