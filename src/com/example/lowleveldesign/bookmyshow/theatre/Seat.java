package com.example.lowleveldesign.bookmyshow.theatre;

import com.example.lowleveldesign.bookmyshow.enums.SeatCategory;

public class Seat {
    private int seatId;
    private int row;
    private SeatCategory seatCategory;

    public Seat(int seatId, SeatCategory seatCategory, int row) {
        this.seatId = seatId;
        this.seatCategory = seatCategory;
        this.row = row;
    }

    public Seat() {}

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public SeatCategory getSeatCategory() {
        return seatCategory;
    }

    public void setSeatCategory(SeatCategory seatCategory) {
        this.seatCategory = seatCategory;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
