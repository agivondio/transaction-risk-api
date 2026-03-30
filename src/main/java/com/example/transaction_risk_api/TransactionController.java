package com.example.transaction_risk_api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TransactionController {

    private final TransactionRepository repository;

    public TransactionController(TransactionRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/hello")
    public String hello() {
        return "API is working 🚀";
    }

    @GetMapping("/transactions")
    public java.util.List<Transaction> getAllTransactions() {
        return repository.findAll();
    }

    @GetMapping("/transactions/fraud")
    public java.util.List<Transaction> getFraudTransactions() {
        return repository.findByFraud(true);
    }

    @GetMapping("/transactions/high-risk")
    public java.util.List<Transaction> getHighRiskTransactions() {
        return repository.findAll()
                .stream()
                .filter(t -> t.getRiskScore() > 0.7)
                .toList();
    }

    @PostMapping("/check-transaction")
    public TransactionResponse checkTransaction(@RequestBody TransactionRequest request) {

        double riskScore = 0.0;
        String reason = "Normal transaction";

        if (request.getAmount() > 5000) {
            riskScore += 0.5;
            reason = "High transaction amount";
        }

        if (request.getFrequency() > 8) {
            riskScore += 0.4;
            reason += " & unusual frequency";
        }

        boolean isFraud = riskScore > 0.6;

        // ✅ SAVE TO DATABASE
        Transaction transaction = new Transaction(
                request.getAmount(),
                request.getFrequency(),
                riskScore,
                isFraud,
                reason
        );

        repository.save(transaction);

        return new TransactionResponse(isFraud, riskScore, reason);
    }
}