package com.example.lowleveldesign.parkinglot2.service;

import com.example.lowleveldesign.parkinglot2.domain.Floor;
import com.example.lowleveldesign.parkinglot2.domain.ParkingSlot;
import com.example.lowleveldesign.parkinglot2.domain.PricingRule;
import com.example.lowleveldesign.parkinglot2.domain.PricingRuleType;
import com.example.lowleveldesign.parkinglot2.domain.VehicleType;
import com.example.lowleveldesign.parkinglot2.repository.FloorRepository;
import com.example.lowleveldesign.parkinglot2.repository.PricingRuleRepository;
import com.example.lowleveldesign.parkinglot2.repository.SlotRepository;

import java.util.LinkedHashMap;
import java.util.Map;

public class AdminService {
    private final FloorRepository floorRepository;
    private final SlotRepository slotRepository;
    private final PricingRuleRepository pricingRuleRepository;

    public AdminService(FloorRepository floorRepository,
                        SlotRepository slotRepository,
                        PricingRuleRepository pricingRuleRepository) {
        this.floorRepository = floorRepository;
        this.slotRepository = slotRepository;
        this.pricingRuleRepository = pricingRuleRepository;
    }

    public Floor addFloor(int floorNumber) {
        Floor floor = new Floor(floorNumber);
        floorRepository.save(floor);
        return floor;
    }

    public ParkingSlot addSlot(int floorNumber, VehicleType slotType) {
        Floor floor = floorRepository.findByFloorNumber(floorNumber)
                .orElseGet(() -> addFloor(floorNumber));
        ParkingSlot slot = new ParkingSlot(slotType, floorNumber);
        floor.addSlot(slot);
        slotRepository.save(slot);
        return slot;
    }

    public void addSlots(int floorNumber, VehicleType slotType, int count) {
        for (int i = 0; i < count; i++) {
            addSlot(floorNumber, slotType);
        }
    }

    public void addPricingRule(PricingRule pricingRule) {
        pricingRuleRepository.save(pricingRule);
    }

    public void updatePricing(VehicleType vehicleType, double ratePerHour, double flatRate, PricingRuleType ruleType) {
        pricingRuleRepository.save(new PricingRule(vehicleType, ratePerHour, flatRate, ruleType));
    }

    public Map<String, String> getParkingStatus() {
        Map<String, String> status = new LinkedHashMap<>();
        for (VehicleType vehicleType : VehicleType.values()) {
            long total = slotRepository.findAll().stream()
                    .filter(slot -> slot.getSlotType() == vehicleType)
                    .count();
            long available = slotRepository.findAvailableByType(vehicleType).size();
            status.put(vehicleType.name(), available + " available / " + total + " total");
        }
        return status;
    }

    public void initializeParkingLot() {
        addFloor(1);
        addSlots(1, VehicleType.TWO_WHEELER, 5);
        addSlots(1, VehicleType.FOUR_WHEELER, 5);
        addSlots(1, VehicleType.HEAVY_VEHICLE, 2);

        updatePricing(VehicleType.TWO_WHEELER, 20.0, 30.0, PricingRuleType.HOURLY);
        updatePricing(VehicleType.FOUR_WHEELER, 50.0, 80.0, PricingRuleType.HOURLY);
        updatePricing(VehicleType.HEAVY_VEHICLE, 100.0, 150.0, PricingRuleType.HOURLY);
    }
}
