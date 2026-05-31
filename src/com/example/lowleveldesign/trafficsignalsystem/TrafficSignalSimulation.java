package com.example.lowleveldesign.trafficsignalsystem;

import com.example.lowleveldesign.trafficsignalsystem.controller.EmergencyController;
import com.example.lowleveldesign.trafficsignalsystem.controller.IntersectionController;
import com.example.lowleveldesign.trafficsignalsystem.controller.TimingController;
import com.example.lowleveldesign.trafficsignalsystem.controller.TrafficController;
import com.example.lowleveldesign.trafficsignalsystem.domain.Direction;
import com.example.lowleveldesign.trafficsignalsystem.repository.CycleRepository;
import com.example.lowleveldesign.trafficsignalsystem.repository.EmergencyRepository;
import com.example.lowleveldesign.trafficsignalsystem.repository.IntersectionRepository;
import com.example.lowleveldesign.trafficsignalsystem.repository.TimingRepository;
import com.example.lowleveldesign.trafficsignalsystem.repository.TrafficRepository;
import com.example.lowleveldesign.trafficsignalsystem.service.EmergencyService;
import com.example.lowleveldesign.trafficsignalsystem.service.IntersectionService;
import com.example.lowleveldesign.trafficsignalsystem.service.TimingService;
import com.example.lowleveldesign.trafficsignalsystem.service.TrafficService;

public class TrafficSignalSimulation {
    public static void main(String[] args) {
        IntersectionRepository intersectionRepository = new IntersectionRepository();
        CycleRepository cycleRepository = new CycleRepository();
        TimingRepository timingRepository = new TimingRepository();
        TrafficRepository trafficRepository = new TrafficRepository();
        EmergencyRepository emergencyRepository = new EmergencyRepository();

        TrafficService trafficService = new TrafficService(trafficRepository);
        TimingService timingService = new TimingService(timingRepository, trafficService);
        IntersectionService intersectionService = new IntersectionService(
                intersectionRepository, cycleRepository, timingService);
        EmergencyService emergencyService = new EmergencyService(emergencyRepository, intersectionService);

        IntersectionController intersectionController = new IntersectionController(intersectionService);
        TrafficController trafficController = new TrafficController(trafficService);
        TimingController timingController = new TimingController(timingService);
        EmergencyController emergencyController = new EmergencyController(emergencyService);

        int intersectionId = 101;
        intersectionController.createIntersection(intersectionId, "MG Road Junction");
        intersectionController.startCycle(intersectionId);
        intersectionController.displayStatus(intersectionId);

        trafficController.updateVehicleCount(Direction.NORTH, 42);
        trafficController.updateVehicleCount(Direction.EAST, 10);
        trafficController.displayTrafficStatus();

        timingController.enableDynamicTiming(intersectionId, Direction.NORTH, true);
        timingController.adjustTimingBasedOnTraffic(intersectionId, Direction.NORTH);
        timingController.displayTimingStatus(intersectionId);

        intersectionController.advanceCycleOnce(intersectionId);
        intersectionController.displayStatus(intersectionId);

        emergencyController.requestEmergency(intersectionId, Direction.SOUTH, 20);
        emergencyController.getEmergencyStatus(intersectionId);
        intersectionController.displayStatus(intersectionId);

        emergencyController.endEmergency(intersectionId);
        intersectionController.displayStatus(intersectionId);
    }
}
