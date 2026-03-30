package com.example.transaction_risk_api;

import jakarta.persistence.*;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;
    private int frequency;
    private double riskScore;
    private boolean fraud;
    private String reason;

    public Transaction() {}

    public Transaction(double amount, int frequency, double riskScore, boolean fraud, String reason) {
        this.amount = amount;
        this.frequency = frequency;
        this.riskScore = riskScore;
        this.fraud = fraud;
        this.reason = reason;
    }

    // Getter
    public Long getId() { return id; }
    public double getAmount() { return amount; }
    public int getFrequency() { return frequency; }
    public double getRiskScore() { return riskScore; }
    public boolean isFraud() { return fraud; }
    public String getReason() { return reason; }
}