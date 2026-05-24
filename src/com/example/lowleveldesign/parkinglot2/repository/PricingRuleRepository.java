package com.example.lowleveldesign.parkinglot2.repository;

import com.example.lowleveldesign.parkinglot2.domain.PricingRule;
import com.example.lowleveldesign.parkinglot2.domain.VehicleType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PricingRuleRepository {
    private final List<PricingRule> pricingRules = new ArrayList<>();

    public void save(PricingRule pricingRule) {
        pricingRules.removeIf(rule -> rule.getVehicleType() == pricingRule.getVehicleType());
        pricingRules.add(pricingRule);
    }

    public Optional<PricingRule> findByVehicleType(VehicleType vehicleType) {
        return pricingRules.stream().filter(rule -> rule.getVehicleType() == vehicleType).findFirst();
    }

    public List<PricingRule> findAll() {
        return new ArrayList<>(pricingRules);
    }
}
