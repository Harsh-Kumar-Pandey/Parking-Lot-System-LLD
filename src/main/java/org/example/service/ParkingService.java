package org.example.service;

import org.example.model.Level;
import org.example.model.ParkingSlot;
import org.example.model.ParkingTicket;
import org.example.model.Vehicle;
import org.example.strategy.parking.ParkingStrategy;

import java.util.List;

public class ParkingService {
    ParkingStrategy parkingStrategy;
    public List<Level> parkingLevels;
    TicketService ticketService;
    public ParkingService(ParkingStrategy parkingStrategy,TicketService ticketService){
        this.parkingStrategy=parkingStrategy;
        this.ticketService=ticketService;
    }
    public ParkingTicket parkVehicle(Vehicle v){
       ParkingSlot slot= parkingStrategy.getSlot(parkingLevels,v);
       slot.vehicle=v;
       return ticketService.createTicket(v,slot);
    }

    public double removeVehicle(ParkingTicket ticket){
        ticket.slot.removeVehicle();
        return ticketService.closeTicket(ticket);
    }
}
