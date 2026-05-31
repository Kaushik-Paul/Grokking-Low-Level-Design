package com.example.lowleveldesign.trafficsignalsystem.repository;

import com.example.lowleveldesign.trafficsignalsystem.domain.Direction;
import com.example.lowleveldesign.trafficsignalsystem.domain.SignalTiming;
import java.util.HashMap;
import java.util.Map;

public class TimingRepository {
    private final Map<String, SignalTiming> timings = new HashMap<>();

    public void save(SignalTiming timing) {
        timings.put(key(timing.getIntersectionId(), timing.getDirection()), timing);
    }

    public SignalTiming findByIntersectionAndDirection(int intersectionId, Direction direction) {
        return timings.get(key(intersectionId, direction));
    }

    private String key(int intersectionId, Direction direction) {
        return intersectionId + ":" + direction;
    }
}
