package com.example.lowleveldesign.trafficsignalsystem.repository;

import com.example.lowleveldesign.trafficsignalsystem.domain.Direction;
import com.example.lowleveldesign.trafficsignalsystem.domain.VehicleCounter;
import java.util.EnumMap;
import java.util.Map;

public class TrafficRepository {
    private final Map<Direction, VehicleCounter> counters = new EnumMap<>(Direction.class);

    public TrafficRepository() {
        for (Direction direction : Direction.getAllDirections()) {
            counters.put(direction, new VehicleCounter(direction));
        }
    }

    public void save(VehicleCounter counter) {
        counters.put(counter.getDirection(), counter);
    }

    public VehicleCounter findByDirection(Direction direction) {
        return counters.get(direction);
    }
}
