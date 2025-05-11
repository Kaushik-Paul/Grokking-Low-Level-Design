package com.example.lowleveldesign.bookmyshow.theatre;

import com.example.lowleveldesign.bookmyshow.movie.Movie;

import java.util.List;

public class Show {

    private int showId;
    private Movie movie;
    private Screen screen;
    private String showStartTime;
    private List<Integer> bookedSeatIds;

    public Show() {}

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public String getShowStartTime() {
        return showStartTime;
    }

    public void setShowStartTime(String showStartTime) {
        this.showStartTime = showStartTime;
    }

    public List<Integer> getBookedSeatIds() {
        return bookedSeatIds;
    }

    public void setBookedSeatIds(List<Integer> bookedSeatIds) {
        this.bookedSeatIds = bookedSeatIds;
    }
}
