package org.example.parkinglot.models;

import org.example.parkinglot.models.enums.VehicleType;

public class Vehicle {
    private Long id; // db pk
    private String licensePlate;
    private VehicleType vehicleType;
    private String ownerName;

    public Vehicle(Long id, String licensePlate, VehicleType vehicleType, String ownerName) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
        this.ownerName = ownerName;
    }

    public Long getId() { return id; }
    public String getLicensePlate() { return licensePlate; }
    public VehicleType getVehicleType() { return vehicleType; }
    public String getOwnerName() { return ownerName; }
}
