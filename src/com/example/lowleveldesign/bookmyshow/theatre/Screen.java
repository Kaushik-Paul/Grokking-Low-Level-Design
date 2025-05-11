package com.example.lowleveldesign.bookmyshow.theatre;

import java.util.ArrayList;
import java.util.List;

public class Screen {

    private int screenId;
    private List<Seat> seats;

    public Screen() {
        this.seats = new ArrayList<>();

        // Assign random screen id from 1 to 100
        this.screenId = (int) (Math.random() * 100) + 1;
    }

    public int getScreenId() {
        return screenId;
    }

    public void setScreenId(int screenId) {
        this.screenId = screenId;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
