package com.example.lowleveldesign.bookmyshow.payment;

import com.example.lowleveldesign.bookmyshow.theatre.Seat;
import com.example.lowleveldesign.bookmyshow.theatre.Show;

import java.util.ArrayList;
import java.util.List;

public class Booking {
    private int bookingId;
    private Show show;
    private Payment payment;
    private List<Seat> bookedSeats;

    public Booking() {
        this.bookingId = (int) (Math.random() * 100) + 1;
        this.show = new Show();
        this.payment = new Payment();
        this.bookedSeats = new ArrayList<>();
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public List<Seat> getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(List<Seat> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }
}
