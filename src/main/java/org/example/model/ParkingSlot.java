package org.example.model;

import org.example.model.enums.ParkingSlotSize;
import org.example.model.enums.VehicleSize;

import static org.example.model.enums.ParkingSlotSize.*;
import static org.example.model.enums.ParkingSlotSize.LARGE;
import static org.example.model.enums.ParkingSlotSize.SMALL;
import static org.example.model.enums.VehicleSize.*;
public class ParkingSlot {
   public int id;
   public ParkingSlotSize size;
   public Vehicle vehicle;

    public boolean isEmpty(){
        return vehicle == null;

    }
    public void parkVehicle(Vehicle v){
        this.vehicle=v;
    }
    public void removeVehicle(){
        vehicle=null;
    }
    public boolean canFit(VehicleSize vehicleSize){
        if(size==LARGE&&vehicleSize==VehicleSize.LARGE){
            return true;
        } else if (size==SMALL&&vehicleSize==VehicleSize. SMALL) {
            return true;
        } else if (size==ParkingSlotSize.MEDIUM&&vehicleSize==VehicleSize.MEDIUM) {
            return true;
        }
        return false;
    }
}
