package org.example.parkinglot.models;

import org.example.parkinglot.models.enums.BillStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Bill {
    private Long id;
    private Ticket ticket;
    private Date exitTime;
    private Gate exitGate;
    private Operator operator;
    private Long amount;
    private BillStatus status;
    private List<Payment> payments;

    public Bill(Long id, Ticket ticket, Gate exitGate, Operator operator, Long amount) {
        this.id = id;
        this.ticket = ticket;
        this.exitTime = new Date();
        this.exitGate = exitGate;
        this.operator = operator;
        this.amount = amount;
        this.status = BillStatus.PENDING;
        this.payments = new ArrayList<>();
    }

    // Getters
    public Long getId() { return id; }
    public Ticket getTicket() { return ticket; }
    public Date getExitTime() { return exitTime; }
    public Gate getExitGate() { return exitGate; }
    public Operator getOperator() { return operator; }
    public Long getAmount() { return amount; }
    public BillStatus getStatus() { return status; }
    public List<Payment> getPayments() { return payments; }

    // Setters
    public void setStatus(BillStatus status) { this.status = status; }
}
