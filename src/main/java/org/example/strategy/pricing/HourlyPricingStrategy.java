package org.example.strategy.pricing;

import org.example.model.ParkingTicket;
import org.example.model.enums.VehicleSize;

import java.time.Duration;

import static org.example.model.enums.VehicleSize.*;

public class HourlyPricingStrategy implements PricingStrategy{

    @Override
    public double calculatePrice(ParkingTicket ticket){
        Duration duration=Duration.between(ticket.entryTime, ticket.exitTime);
        int hours=(int)duration.toHours();

        VehicleSize size=ticket.vehicle.size;

        if(size==LARGE){
            return hours*50;
        }else if(size==MEDIUM){
            return hours*20;
        } else if (size==SMALL) {
            return hours*10;
        }else{
            System.out.println("INVALID SIZE");
        }
        return 0;
    }
}
