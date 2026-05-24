package com.example.lowleveldesign.parkinglot2.repository;

import com.example.lowleveldesign.parkinglot2.domain.ParkingSlot;
import com.example.lowleveldesign.parkinglot2.domain.VehicleType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class SlotRepository {
    private final List<ParkingSlot> slots = new ArrayList<>();

    public void save(ParkingSlot slot) {
        slots.add(slot);
    }

    public Optional<ParkingSlot> findById(UUID id) {
        return slots.stream().filter(slot -> slot.getId().equals(id)).findFirst();
    }

    public List<ParkingSlot> findAvailableByType(VehicleType vehicleType) {
        List<ParkingSlot> availableSlots = new ArrayList<>();
        for (ParkingSlot slot : slots) {
            if (slot.getSlotType() == vehicleType && !slot.isOccupied()) {
                availableSlots.add(slot);
            }
        }
        return availableSlots;
    }

    public List<ParkingSlot> findAll() {
        return new ArrayList<>(slots);
    }

    public void delete(UUID id) {
        slots.removeIf(slot -> slot.getId().equals(id));
    }
}
