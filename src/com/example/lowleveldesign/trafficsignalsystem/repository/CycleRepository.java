package com.example.lowleveldesign.trafficsignalsystem.repository;

import com.example.lowleveldesign.trafficsignalsystem.domain.IntersectionCycle;
import java.util.HashMap;
import java.util.Map;

public class CycleRepository {
    private final Map<Integer, IntersectionCycle> cyclesByIntersectionId = new HashMap<>();

    public void save(IntersectionCycle cycle) {
        cyclesByIntersectionId.put(cycle.getIntersectionId(), cycle);
    }

    public IntersectionCycle findByIntersectionId(int intersectionId) {
        return cyclesByIntersectionId.get(intersectionId);
    }
}
