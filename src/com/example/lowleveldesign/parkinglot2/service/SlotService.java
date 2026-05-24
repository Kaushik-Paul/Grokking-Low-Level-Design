package com.example.lowleveldesign.parkinglot2.service;

import com.example.lowleveldesign.parkinglot2.domain.ParkingSlot;
import com.example.lowleveldesign.parkinglot2.domain.VehicleType;
import com.example.lowleveldesign.parkinglot2.repository.SlotRepository;

import java.util.Optional;
import java.util.UUID;

public class SlotService {
    private final SlotRepository slotRepository;

    public SlotService(SlotRepository slotRepository) {
        this.slotRepository = slotRepository;
    }

    public ParkingSlot createSlot(VehicleType slotType, int floorNumber) {
        ParkingSlot slot = new ParkingSlot(slotType, floorNumber);
        slotRepository.save(slot);
        return slot;
    }

    public Optional<ParkingSlot> allocateSlot(VehicleType vehicleType) {
        return slotRepository.findAvailableByType(vehicleType)
                .stream()
                .findFirst()
                .map(slot -> {
                    slot.occupy();
                    return slot;
                });
    }

    public boolean releaseSlot(UUID slotId) {
        Optional<ParkingSlot> slot = slotRepository.findById(slotId);
        slot.ifPresent(ParkingSlot::release);
        return slot.isPresent();
    }

    public int getAvailableSlotCount(VehicleType vehicleType) {
        return slotRepository.findAvailableByType(vehicleType).size();
    }
}
