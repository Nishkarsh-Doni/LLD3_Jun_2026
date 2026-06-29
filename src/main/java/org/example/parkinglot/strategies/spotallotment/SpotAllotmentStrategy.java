package org.example.parkinglot.strategies.spotallotment;


import org.example.parkinglot.models.ParkingFloor;
import org.example.parkinglot.models.ParkingSpot;
import org.example.parkinglot.models.enums.VehicleType;

import java.util.List;

public interface SpotAllotmentStrategy {
    ParkingSpot findSpot(List<ParkingFloor> floors, VehicleType vehicleType);
}
