package com.cinecentre.cinecentrecinema.rest.response;

import com.cinecentre.cinecentrecinema.rest.model.Film;
import com.cinecentre.cinecentrecinema.rest.model.FilmFliter;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by victg on 14.02.2017.
 */
public class MoviesData {

    @SerializedName("FilmFliter")
    @Expose
    private FilmFliter filmFliter;
    @SerializedName("Films")
    @Expose
    private List<Film> films = null;

    public FilmFliter getFilmFliter() {
        return filmFliter;
    }

    public void setFilmFliter(FilmFliter filmFliter) {
        this.filmFliter = filmFliter;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }
}
