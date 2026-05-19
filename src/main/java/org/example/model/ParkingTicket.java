package org.example.model;

import org.example.model.enums.TicketStatus;

import java.time.LocalDate;

public class ParkingTicket {
    private int id;
    public Vehicle vehicle;
    public ParkingSlot slot;
    public LocalDate entryTime;
    public LocalDate exitTime;

    double amount;
    TicketStatus status;

}
