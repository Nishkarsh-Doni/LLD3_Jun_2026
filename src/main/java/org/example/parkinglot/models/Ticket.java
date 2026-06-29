package org.example.parkinglot.models;

import java.util.Date;

// Ticket is generated when the vehicle arrives
// Vehicle enters the parking lot from the entry gate
public class Ticket {
    private Long id;
    private String ticketNumber;
    private Date entryTime;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private Gate entryGate;
    private Operator operator; // optional

    public Ticket(Long id, String ticketNumber, Vehicle vehicle,
                  ParkingSpot parkingSpot, Gate entryGate, Operator operator) {
        this.id = id;
        this.ticketNumber = ticketNumber;
        this.entryTime = new Date();
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.entryGate = entryGate;
        this.operator = operator;
    }

    // Getters
    public Long getId() { return id; }
    public String getTicketNumber() { return ticketNumber; }
    public Date getEntryTime() { return entryTime; }
    public Vehicle getVehicle() { return vehicle; }
    public ParkingSpot getParkingSpot() { return parkingSpot; }
    public Gate getEntryGate() { return entryGate; }
    public Operator getOperator() { return operator; }
}
