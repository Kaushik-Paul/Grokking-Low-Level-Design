package com.example.lowleveldesign.trafficsignalsystem.service;

import com.example.lowleveldesign.trafficsignalsystem.domain.Direction;
import com.example.lowleveldesign.trafficsignalsystem.domain.VehicleCounter;
import com.example.lowleveldesign.trafficsignalsystem.repository.TrafficRepository;

public class TrafficService {
    private final TrafficRepository trafficRepository;

    public TrafficService(TrafficRepository trafficRepository) {
        this.trafficRepository = trafficRepository;
    }

    public void updateVehicleCount(Direction direction, int count) {
        VehicleCounter counter = trafficRepository.findByDirection(direction);
        counter.updateCount(count);
        trafficRepository.save(counter);
    }

    public int getVehicleCount(Direction direction) {
        return trafficRepository.findByDirection(direction).getCount();
    }
}
