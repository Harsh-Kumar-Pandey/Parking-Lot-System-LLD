package org.example.strategy.parking;

import org.example.model.Level;
import org.example.model.ParkingSlot;
import org.example.model.Vehicle;

import java.util.List;

public class FirstFitStrategy implements ParkingStrategy{

    @Override
    public ParkingSlot getSlot(List<Level>parkingLevel, Vehicle vehicle){

        for(Level l:parkingLevel){

            for(ParkingSlot slot:l.parkingSlots){
                if(slot.isEmpty()&&slot.canFit(vehicle.size)){
                    return slot;
                }
            }
        }
        System.out.println("No available space");
        return null;
    }
}
