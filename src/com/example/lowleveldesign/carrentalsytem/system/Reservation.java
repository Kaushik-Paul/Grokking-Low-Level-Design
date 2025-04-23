package com.example.lowleveldesign.carrentalsytem.system;

import com.example.lowleveldesign.carrentalsytem.product.Vehicle;
import com.example.lowleveldesign.carrentalsytem.user.User;

import java.util.Date;

public class Reservation {
    private int reservationId;
    private User user;
    private Vehicle vehicle;
    private Date bookingDate;
    private Date dateBookedFrom;
    private Date dateBookedTo;
    private Long fromTimeStamp;
    private Long toTimeStamp;
    private StoreLocation pickUpLocation;
    private StoreLocation dropLocation;
    private ReservationType reservationType;
    private ReservationStatus reservationStatus;
    private StoreLocation location;

    public int createReservation(User user, Vehicle vehicle) {
        this.reservationId = 12144;
        this.user = user;
        this.vehicle = vehicle;
        this.dateBookedFrom = new Date();
        this.dateBookedTo = new Date();
        this.fromTimeStamp = dateBookedFrom.getTime();
        this.toTimeStamp = dateBookedTo.getTime();
        this.reservationStatus = ReservationStatus.SCHEDULED;
        this.reservationType = ReservationType.DAILY;

        return this.reservationId;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public StoreLocation getPickUpLocation() {
        return pickUpLocation;
    }

    public StoreLocation getDropLocation() {
        return dropLocation;
    }

    public ReservationType getReservationType() {
        return reservationType;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public StoreLocation getLocation() {
        return location;
    }
}
