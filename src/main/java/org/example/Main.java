package org.example;

import org.example.factory.ParkingStrategyFactory;
import org.example.factory.PriceStrategyFactory;
import org.example.manager.ParkingSystemManager;
import org.example.model.Level;
import org.example.model.ParkingSlot;
import org.example.model.ParkingTicket;
import org.example.model.Vehicle;
import org.example.model.enums.ParkingSlotSize;
import org.example.model.enums.VehicleSize;
import org.example.service.ParkingService;
import org.example.service.TicketService;
import org.example.strategy.parking.ParkingStrategy;
import org.example.strategy.pricing.PricingStrategy;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ParkingStrategyFactory parkingStrategyFactory=new ParkingStrategyFactory();
        PriceStrategyFactory priceStrategyFactory=new PriceStrategyFactory();
        ParkingStrategy parkingStrategy=parkingStrategyFactory.getStrategy("FirstFit");
        PricingStrategy pricingStrategy= priceStrategyFactory.getPriceStrategy("Hourly");
        TicketService ticketService=new TicketService(pricingStrategy);
        ParkingService parkingService=new ParkingService(parkingStrategy,ticketService);

        ParkingSlot slot1=new ParkingSlot();
        slot1.size= ParkingSlotSize.LARGE;
        slot1.id=1;

        ParkingSlot slot2=new ParkingSlot();
        slot2.size= ParkingSlotSize.MEDIUM;
        slot2.id=1;

        ParkingSlot slot3=new ParkingSlot();
        slot3.size= ParkingSlotSize.SMALL;
        slot3.id=1;

        Level level1=new Level();
        level1.id=1;

        level1.parkingSlots=new ArrayList<>();
        level1.parkingSlots.add(slot1);
        level1.parkingSlots.add(slot2);
        level1.parkingSlots.add(slot3);

        parkingService.parkingLevels=new ArrayList<>();
        parkingService.parkingLevels.add(level1);

        ParkingSystemManager parkingSystemManager=new ParkingSystemManager(parkingService);

        Vehicle v=new Vehicle();
        v.size= VehicleSize.LARGE;
        v.id=2;
        v.number="CG 04 ABCD";

        ParkingTicket ticket=parkingSystemManager.parkVehicle(v);

        System.out.println(ticket.vehicle.number);
        System.out.println(ticket.entryTime);
        System.out.println(ticket.slot.id);



    }
}