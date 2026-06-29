package org.example.parkinglot.models;

import org.example.parkinglot.models.enums.PaymentMode;
import org.example.parkinglot.models.enums.PaymentStatus;

import java.util.Date;

public class Payment {
    private Long id;
    private Long amount; // 89.90 -> 8990 -> rupees.paise || Floating point precision
    private PaymentMode paymentMode;
    private PaymentStatus paymentStatus;
    private String referenceNumber;
    private Date time;

    public Payment(Long id, Long amount, PaymentMode paymentMode) {
        this.id = id;
        this.amount = amount;
        this.paymentMode = paymentMode;
        this.paymentStatus = PaymentStatus.PENDING;
        this.referenceNumber = null;
        this.time = new Date();
    }

    // Getters
    public Long getId() { return id; }
    public Long getAmount() { return amount; }
    public PaymentMode getPaymentMode() { return paymentMode; }
    public PaymentStatus getPaymentStatus() { return paymentStatus; }
    public String getReferenceNumber() { return referenceNumber; }
    public Date getTime() { return time; }

    // Setters
    public void setPaymentStatus(PaymentStatus paymentStatus) { this.paymentStatus = paymentStatus; }
    public void setReferenceNumber(String referenceNumber) { this.referenceNumber = referenceNumber; }
}
