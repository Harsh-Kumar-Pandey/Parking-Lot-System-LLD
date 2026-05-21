package org.example.manager;

import org.example.model.Level;
import org.example.model.ParkingTicket;
import org.example.model.Vehicle;
import org.example.service.ParkingService;
import org.example.service.TicketService;
import org.example.strategy.parking.ParkingStrategy;
import org.example.strategy.pricing.PricingStrategy;

import java.util.List;
import java.util.Map;

public class ParkingSystemManager {

    private ParkingSystemManager instance;
    private ParkingSystemManager(){};
    public ParkingSystemManager getInstance(){
        if(instance==null){
            instance=new ParkingSystemManager();
            return instance;
        }
        return instance;
    }
    ParkingService parkingService;


    public ParkingSystemManager(ParkingService parkingService){
        this.parkingService=parkingService;
    }

    public ParkingTicket parkVehicle(Vehicle v){
       return parkingService.parkVehicle(v);
    }

    public double removeVehicle(ParkingTicket ticket){
       return parkingService.removeVehicle(ticket);
    }

}
