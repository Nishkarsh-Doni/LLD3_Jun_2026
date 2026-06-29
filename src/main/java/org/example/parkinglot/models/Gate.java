package org.example.parkinglot.models;

import org.example.parkinglot.models.enums.GateStatus;
import org.example.parkinglot.models.enums.GateType;

public class Gate {
    private Long id;
    private int gateNumber;
    private GateType gateType;
    private Operator operator;
    private GateStatus status;

    public Gate(Long id, int gateNumber, GateType gateType, Operator operator) {
        this.id = id;
        this.gateNumber = gateNumber;
        this.gateType = gateType;
        this.operator = operator;
        this.status = GateStatus.OPERATIONAL;
    }

    // Getters
    public Long getId() { return id; }
    public int getGateNumber() { return gateNumber; }
    public GateType getGateType() { return gateType; }
    public Operator getOperator() { return operator; }
    public GateStatus getStatus() { return status; }

    // Setters
    public void setOperator(Operator operator) { this.operator = operator; }
    public void setStatus(GateStatus status) { this.status = status; }
}
