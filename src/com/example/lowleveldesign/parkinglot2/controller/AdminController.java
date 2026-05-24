package com.example.lowleveldesign.parkinglot2.controller;

import com.example.lowleveldesign.parkinglot2.domain.PricingRule;
import com.example.lowleveldesign.parkinglot2.domain.PricingRuleType;
import com.example.lowleveldesign.parkinglot2.domain.VehicleType;
import com.example.lowleveldesign.parkinglot2.service.AdminService;

import java.util.Map;

public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    public void initializeParkingLot() {
        adminService.initializeParkingLot();
    }

    public void addFloor(int floorNumber) {
        adminService.addFloor(floorNumber);
    }

    public void addSlot(int floorNumber, VehicleType slotType) {
        adminService.addSlot(floorNumber, slotType);
    }

    public void addSlotsToFloor(int floorNumber, VehicleType slotType, int count) {
        adminService.addSlots(floorNumber, slotType, count);
    }

    public void updatePricing(VehicleType vehicleType, double ratePerHour, double flatRate, PricingRuleType ruleType) {
        adminService.updatePricing(vehicleType, ratePerHour, flatRate, ruleType);
    }

    public void addPricingRule(PricingRule pricingRule) {
        adminService.addPricingRule(pricingRule);
    }

    public Map<String, String> getParkingStatus() {
        return adminService.getParkingStatus();
    }
}
