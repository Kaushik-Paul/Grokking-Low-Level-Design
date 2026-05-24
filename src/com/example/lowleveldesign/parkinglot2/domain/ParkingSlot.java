package com.example.lowleveldesign.parkinglot2.domain;

import java.util.UUID;

public class ParkingSlot {
    private UUID id;
    private VehicleType slotType;
    private boolean occupied;
    private int floorNumber;

    public ParkingSlot(VehicleType slotType, int floorNumber) {
        this.id = UUID.randomUUID();
        this.slotType = slotType;
        this.occupied = false;
        this.floorNumber = floorNumber;
    }

    public UUID getId() {
        return id;
    }

    public VehicleType getSlotType() {
        return slotType;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void occupy() {
        this.occupied = true;
    }

    public void release() {
        this.occupied = false;
    }

    public void setSlotType(VehicleType slotType) {
        this.slotType = slotType;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    @Override
    public String toString() {
        return "ParkingSlot{" +
                "id=" + id +
                ", slotType=" + slotType +
                ", occupied=" + occupied +
                ", floorNumber=" + floorNumber +
                '}';
    }
}
