package com.example.lowleveldesign.trafficsignalsystem.repository;

import com.example.lowleveldesign.trafficsignalsystem.domain.EmergencyRequest;
import java.util.HashMap;
import java.util.Map;

public class EmergencyRepository {
    private final Map<Integer, EmergencyRequest> activeRequestsByIntersectionId = new HashMap<>();
    private int nextId = 1;

    public int nextId() {
        return nextId++;
    }

    public void save(EmergencyRequest request) {
        activeRequestsByIntersectionId.put(request.getIntersectionId(), request);
    }

    public EmergencyRequest findActiveByIntersectionId(int intersectionId) {
        EmergencyRequest request = activeRequestsByIntersectionId.get(intersectionId);
        return request != null && request.isActive() ? request : null;
    }

    public void removeActiveByIntersectionId(int intersectionId) {
        activeRequestsByIntersectionId.remove(intersectionId);
    }
}
