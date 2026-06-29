package org.example.parkinglot.models;

import org.example.parkinglot.models.enums.ParkingSpotStatus;
import org.example.parkinglot.models.enums.VehicleType;

public class ParkingSpot {
    private Long id;
    private int spotNumber;
    private VehicleType vehicleType;
    private ParkingSpotStatus status;
    private Vehicle vehicle; // no vehicle, then null
    private ParkingFloor parkingFloor;

    public ParkingSpot(Long id, int spotNumber, VehicleType vehicleType) {
        this.id = id;
        this.spotNumber = spotNumber;
        this.vehicleType = vehicleType;
        this.status = ParkingSpotStatus.AVAILABLE;
        this.vehicle = null;
        this.parkingFloor = null;
    }

    // Getters
    public Long getId() { return id; }
    public int getSpotNumber() { return spotNumber; }
    public VehicleType getVehicleType() { return vehicleType; }
    public ParkingSpotStatus getStatus() { return status; }
    public Vehicle getVehicle() { return vehicle; }
    public ParkingFloor getParkingFloor() { return parkingFloor; }

    // Setters
    public void setStatus(ParkingSpotStatus status) { this.status = status; }
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }
    public void setParkingFloor(ParkingFloor parkingFloor) { this.parkingFloor = parkingFloor; }

    public void assignVehicle(Vehicle vehicle) {
        setVehicle(vehicle);
        setStatus(ParkingSpotStatus.OCCUPIED);
    }

    public void freeSpot() {
        setVehicle(null);
        setStatus(ParkingSpotStatus.AVAILABLE);
    }
}
