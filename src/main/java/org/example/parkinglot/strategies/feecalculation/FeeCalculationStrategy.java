package org.example.parkinglot.strategies.feecalculation;

import org.example.parkinglot.models.Ticket;

public interface FeeCalculationStrategy {
    double calculateFee(Ticket ticket);
}
