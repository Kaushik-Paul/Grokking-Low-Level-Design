package com.example.lowleveldesign.parkinglot2.domain;

import java.util.UUID;

public class PricingRule {
    private UUID id;
    private VehicleType vehicleType;
    private double ratePerHour;
    private double flatRate;
    private PricingRuleType ruleType;

    public PricingRule(VehicleType vehicleType, double ratePerHour, double flatRate, PricingRuleType ruleType) {
        this.id = UUID.randomUUID();
        this.vehicleType = vehicleType;
        this.ratePerHour = ratePerHour;
        this.flatRate = flatRate;
        this.ruleType = ruleType;
    }

    public UUID getId() {
        return id;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public double getFlatRate() {
        return flatRate;
    }

    public PricingRuleType getRuleType() {
        return ruleType;
    }

    public void updateRates(double ratePerHour, double flatRate, PricingRuleType ruleType) {
        this.ratePerHour = ratePerHour;
        this.flatRate = flatRate;
        this.ruleType = ruleType;
    }

    @Override
    public String toString() {
        return "PricingRule{" +
                "id=" + id +
                ", vehicleType=" + vehicleType +
                ", ratePerHour=" + ratePerHour +
                ", flatRate=" + flatRate +
                ", ruleType=" + ruleType +
                '}';
    }
}
