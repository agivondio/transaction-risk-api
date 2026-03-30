package com.example.transaction_risk_api;

public class TransactionRequest {

    private double amount;
    private int frequency;

    // Constructor kosong (WAJIB untuk JSON)
    public TransactionRequest() {}

    // Getter
    public double getAmount() {
        return amount;
    }

    public int getFrequency() {
        return frequency;
    }

    // Setter (opsional tapi disarankan)
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
}