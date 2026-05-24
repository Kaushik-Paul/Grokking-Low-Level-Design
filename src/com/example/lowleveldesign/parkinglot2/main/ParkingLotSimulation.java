package com.example.lowleveldesign.parkinglot2.main;

import com.example.lowleveldesign.parkinglot2.adapter.RazorpayAdapter;
import com.example.lowleveldesign.parkinglot2.adapter.StripeAdapter;
import com.example.lowleveldesign.parkinglot2.controller.AdminController;
import com.example.lowleveldesign.parkinglot2.controller.EntryController;
import com.example.lowleveldesign.parkinglot2.controller.ExitController;
import com.example.lowleveldesign.parkinglot2.domain.PaymentGateway;
import com.example.lowleveldesign.parkinglot2.domain.VehicleType;
import com.example.lowleveldesign.parkinglot2.repository.FloorRepository;
import com.example.lowleveldesign.parkinglot2.repository.PricingRuleRepository;
import com.example.lowleveldesign.parkinglot2.repository.SlotRepository;
import com.example.lowleveldesign.parkinglot2.repository.TicketRepository;
import com.example.lowleveldesign.parkinglot2.repository.PaymentRepository;
import com.example.lowleveldesign.parkinglot2.service.AdminService;
import com.example.lowleveldesign.parkinglot2.service.SlotService;
import com.example.lowleveldesign.parkinglot2.service.TicketService;
import com.example.lowleveldesign.parkinglot2.service.PricingService;
import com.example.lowleveldesign.parkinglot2.service.PaymentService;
import com.example.lowleveldesign.parkinglot2.service.ReceiptService;

public class ParkingLotSimulation {
    public static void main(String[] args) {
        FloorRepository floorRepository = new FloorRepository();
        SlotRepository slotRepository = new SlotRepository();
        TicketRepository ticketRepository = new TicketRepository();
        PricingRuleRepository pricingRuleRepository = new PricingRuleRepository();
        PaymentRepository paymentRepository = new PaymentRepository();

        AdminService adminService = new AdminService(floorRepository, slotRepository, pricingRuleRepository);
        SlotService slotService = new SlotService(slotRepository);
        TicketService ticketService = new TicketService(ticketRepository);
        PricingService pricingService = new PricingService(pricingRuleRepository);
        PaymentService paymentService = new PaymentService(paymentRepository);
        ReceiptService receiptService = new ReceiptService();

        paymentService.registerAdapter(PaymentGateway.RAZORPAY, new RazorpayAdapter());
        paymentService.registerAdapter(PaymentGateway.STRIPE, new StripeAdapter());

        AdminController adminController = new AdminController(adminService);
        EntryController entryController = new EntryController(ticketService, slotService);
        ExitController exitController = new ExitController(ticketService, pricingService, paymentService, receiptService, slotService);

        adminController.initializeParkingLot();
        System.out.println("Initial status: " + adminController.getParkingStatus());

        EntryController.EntryResult entryResult = entryController.enterVehicle("KA-01-HH-1234", VehicleType.FOUR_WHEELER);
        System.out.println(entryResult);
        System.out.println("After entry: " + adminController.getParkingStatus());

        if (entryResult.isSuccess()) {
            ExitController.ExitResult exitResult = exitController.exitVehicle(entryResult.getTicketId(), VehicleType.FOUR_WHEELER);
            System.out.println(exitResult);
        }

        System.out.println("After exit: " + adminController.getParkingStatus());
    }
}
