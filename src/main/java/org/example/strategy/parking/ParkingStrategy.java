package org.example.strategy.parking;

import org.example.model.Level;
import org.example.model.ParkingSlot;
import org.example.model.Vehicle;

import java.util.List;

public interface ParkingStrategy {

    ParkingSlot getSlot(List<Level>parkingLevels, Vehicle vehicle);


}
