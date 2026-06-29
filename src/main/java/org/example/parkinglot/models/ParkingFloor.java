package org.example.parkinglot.models;

import org.example.parkinglot.models.enums.ParkingFloorStatus;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
    private Long id;
    private int floorNumber; // 0 , 1, 2, 3
    private List<ParkingSpot> parkingSpots;
    private ParkingFloorStatus status;
    private int capacity;

    public ParkingFloor(Long id, int floorNumber, int capacity) {
        this.id = id;
        this.floorNumber = floorNumber;
        this.parkingSpots = new ArrayList<>();
        this.status = ParkingFloorStatus.OPERATIONAL;
        this.capacity = capacity;
    }

    // Getters
    public Long getId() { return id; }
    public int getFloorNumber() { return floorNumber; }
    public List<ParkingSpot> getParkingSpots() { return parkingSpots; }
    public ParkingFloorStatus getStatus() { return status; }

    // Setters
    public void setStatus(ParkingFloorStatus status) { this.status = status; }

    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public void addParkingSpot(ParkingSpot spot) {
        spot.setParkingFloor(this);
        parkingSpots.add(spot);
    }
}

// PF1
// PS99 {1, B22, null, PF1}
