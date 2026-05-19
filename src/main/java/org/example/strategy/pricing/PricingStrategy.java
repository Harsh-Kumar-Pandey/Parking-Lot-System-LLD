package org.example.strategy.pricing;

import org.example.model.ParkingTicket;

import java.time.Duration;

public interface PricingStrategy {

    double calculatePrice(ParkingTicket ticket);


}
