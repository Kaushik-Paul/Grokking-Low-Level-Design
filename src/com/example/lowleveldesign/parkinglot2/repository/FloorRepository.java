package com.example.lowleveldesign.parkinglot2.repository;

import com.example.lowleveldesign.parkinglot2.domain.Floor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class FloorRepository {
    private final List<Floor> floors = new ArrayList<>();

    public void save(Floor floor) {
        floors.add(floor);
    }

    public Optional<Floor> findById(UUID id) {
        return floors.stream().filter(floor -> floor.getId().equals(id)).findFirst();
    }

    public Optional<Floor> findByFloorNumber(int floorNumber) {
        return floors.stream().filter(floor -> floor.getFloorNumber() == floorNumber).findFirst();
    }

    public List<Floor> findAll() {
        return new ArrayList<>(floors);
    }

    public void delete(UUID id) {
        floors.removeIf(floor -> floor.getId().equals(id));
    }
}
