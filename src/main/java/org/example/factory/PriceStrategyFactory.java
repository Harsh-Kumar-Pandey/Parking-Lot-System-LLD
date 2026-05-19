package org.example.factory;

import org.example.strategy.parking.ParkingStrategy;
import org.example.strategy.pricing.HourlyPricingStrategy;
import org.example.strategy.pricing.PricingStrategy;

public class PriceStrategyFactory {

    public PricingStrategy getPriceStrategy(String type){

        if(type.equals("Hourly")){
            return new HourlyPricingStrategy();
        }else{
            System.out.println("INVALID STRATEGY");
            return null;
        }

    }
}
