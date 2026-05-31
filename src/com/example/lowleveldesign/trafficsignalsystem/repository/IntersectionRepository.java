package com.example.lowleveldesign.trafficsignalsystem.repository;

import com.example.lowleveldesign.trafficsignalsystem.domain.Intersection;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class IntersectionRepository {
    private final Map<Integer, Intersection> intersections = new HashMap<>();

    public void save(Intersection intersection) {
        intersections.put(intersection.getId(), intersection);
    }

    public Intersection findById(int id) {
        return intersections.get(id);
    }

    public Collection<Intersection> findAll() {
        return intersections.values();
    }
}
