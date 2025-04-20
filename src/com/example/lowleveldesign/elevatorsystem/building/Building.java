package com.example.lowleveldesign.elevatorsystem.building;

import java.util.List;

public class Building {

    private List<Floor> floorList;

    public Building(List<Floor> floors) {
        this.floorList = floors;
    }

    public void addFloor(Floor floor) {
        floorList.add(floor);
    }

    public void removeFloor(Floor floor) {
        floorList.remove(floor);
    }

    public List<Floor> getAllFloorList() {
        return floorList;
    }
}
