package org.example.service;

import org.example.model.ParkingSlot;
import org.example.model.ParkingTicket;
import org.example.model.Vehicle;
import org.example.strategy.pricing.PricingStrategy;

import java.time.LocalDate;

public class TicketService {

    PricingStrategy pricingStrategy;

    public TicketService(PricingStrategy strategy){
        this.pricingStrategy=strategy;
    }
    public ParkingTicket createTicket(Vehicle v, ParkingSlot s){
        ParkingTicket ticket=new ParkingTicket();
        ticket.entryTime= LocalDate.now();
        ticket.vehicle=v;
        ticket.slot=s;
        return  ticket;
    }

    public double closeTicket(ParkingTicket ticket){
        ticket.exitTime=LocalDate.now();
        return pricingStrategy.calculatePrice(ticket);
    }
}
