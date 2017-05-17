package com.cinecentre.cinecentrecinema.rest.model;

import java.io.Serializable;

/**
 * Created by victg on 28.03.2017.
 */
public class Order implements Serializable {
    private TicketType type;
    private MovieInfo movieInfo;

    private int scheduleId;
    private int cinemaId;
    private String wholeShowTimesString;
    private String cinemaName;

    public void setMovieInfo(MovieInfo movieInfo) {
        this.movieInfo = movieInfo;
    }


    public void setTicketType(TicketType type) {
        this.type = type;
    }

    public MovieInfo getMovieInfo() {
        return movieInfo;
    }

    public TicketType getTicketType() {
        return type;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public int getCinemaId() {
        return cinemaId;
    }

    public String getWholeShowTimesString() {
        return wholeShowTimesString;
    }

    public String getCinemaName() {
        return cinemaName;
    }
}
