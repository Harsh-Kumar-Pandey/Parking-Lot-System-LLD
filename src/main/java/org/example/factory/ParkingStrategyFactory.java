package org.example.factory;

import org.example.strategy.parking.FirstFitStrategy;
import org.example.strategy.parking.ParkingStrategy;

public class ParkingStrategyFactory {

    public ParkingStrategy getStrategy(String type){

        if(type.equals("FirstFit")){
            return new FirstFitStrategy();
        } else  {
            System.out.println("INVALID TYPE");
            return null;
        }
    }
}
