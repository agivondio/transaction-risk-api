# Transaction Risk API
A backend system for detecting potentially fraudulent transactions using rule-based scoring with explainable outputs. This API is designed as a foundational component for financial fraud detection systems.

## Features
- Fraud detection based on transaction patterns
- Risk scoring system (0.0 – 1.0)
- Explainable output (clear fraud reasoning)
- RESTful API built with Spring Boot
- In-memory database using H2
- Transaction logging for audit purposes
- Retrieve all and fraudulent transactions via API

## Tech Stack
- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database
- REST API

## API Endpoints

### Check Transaction
POST /api/check-transaction

Request:
{
  "amount": 7000,
  "frequency": 10
}

Response:
{
  "fraud": true,
  "riskScore": 0.9,
  "reason": "High transaction amount & unusual frequency"
}

### Get All Transactions
GET /api/transactions

### GET /api/transactions
GET /api/transactions/fraud

# How to Run
1. Clone the repository
2. Open in IntelliJ IDEA
3. Run TransactionRiskApiApplication
4. Access: http://localhost:8081/api

## H2 Database
Access:
http://localhost:8081/h2-console

Config:
JDBC URL: jdbc:h2:mem:testdb
User: sa
Password: (empty)

## Future Improvements
1. Integrate real machine learning model (Python)
2. Add authentication & authorization
3. Deploy to cloud (AWS / GCP)
4. Add monitoring dashboard
5. Improve scoring using historical data

## Author
Primusandy Subhan Agivondio
