package com.example.transaction_risk_api;

public class TransactionResponse {

    private boolean fraud;
    private double riskScore;
    private String reason;

    public TransactionResponse(boolean fraud, double riskScore, String reason) {
        this.fraud = fraud;
        this.riskScore = riskScore;
        this.reason = reason;
    }

    public boolean isFraud() {
        return fraud;
    }

    public double getRiskScore() {
        return riskScore;
    }

    public String getReason() {
        return reason;
    }
}