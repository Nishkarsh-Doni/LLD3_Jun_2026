package org.example.parkinglot.strategies.feecalculation;

import org.example.parkinglot.models.Ticket;

public class HourlyFeeCalculationStrategy implements FeeCalculationStrategy {

    @Override
    public double calculateFee(Ticket ticket) {
        return 0;
    }
}
