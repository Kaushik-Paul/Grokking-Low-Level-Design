package com.example.lowleveldesign.bookmyshow.theatre;

import com.example.lowleveldesign.bookmyshow.enums.City;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
    private int theatreId;
    private String theatreAddress;
    private City city;
    private List<Screen> screens;
    private List<Show> shows;


    public Theatre() {
        this.theatreId = (int) (Math.random() * 100) + 1;
        this.theatreAddress = "";
        this.city = City.Kolkata;
        this.screens = new ArrayList<>();
        this.shows = new ArrayList<>();
    }

    public int getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(int theatreId) {
        this.theatreId = theatreId;
    }

    public String getTheatreAddress() {
        return theatreAddress;
    }

    public void setTheatreAddress(String theatreAddress) {
        this.theatreAddress = theatreAddress;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }
}
