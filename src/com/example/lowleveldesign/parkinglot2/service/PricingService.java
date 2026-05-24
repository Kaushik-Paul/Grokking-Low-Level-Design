package com.example.lowleveldesign.parkinglot2.service;

import com.example.lowleveldesign.parkinglot2.domain.PricingRule;
import com.example.lowleveldesign.parkinglot2.domain.PricingRuleType;
import com.example.lowleveldesign.parkinglot2.domain.Ticket;
import com.example.lowleveldesign.parkinglot2.domain.VehicleType;
import com.example.lowleveldesign.parkinglot2.repository.PricingRuleRepository;

import java.time.Duration;

public class PricingService {
    private final PricingRuleRepository pricingRuleRepository;

    public PricingService(PricingRuleRepository pricingRuleRepository) {
        this.pricingRuleRepository = pricingRuleRepository;
    }

    public void addPricingRule(PricingRule pricingRule) {
        pricingRuleRepository.save(pricingRule);
    }

    public void updatePricingRule(VehicleType vehicleType, double ratePerHour, double flatRate, PricingRuleType ruleType) {
        pricingRuleRepository.save(new PricingRule(vehicleType, ratePerHour, flatRate, ruleType));
    }

    public double calculateFee(Ticket ticket, VehicleType vehicleType) {
        PricingRule rule = pricingRuleRepository.findByVehicleType(vehicleType)
                .orElse(new PricingRule(vehicleType, 20.0, 50.0, PricingRuleType.HOURLY));

        if (rule.getRuleType() == PricingRuleType.FLAT) {
            return rule.getFlatRate();
        }

        long minutes = Math.max(1, Duration.between(ticket.getEntryTime(), java.time.LocalDateTime.now()).toMinutes());
        long hours = (long) Math.ceil(minutes / 60.0);
        return Math.max(rule.getFlatRate(), hours * rule.getRatePerHour());
    }
}
