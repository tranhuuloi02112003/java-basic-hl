package BankTransactionManagement;

import java.time.LocalDate;

public abstract class Transaction {
    private String transactionId;
    private double amount;
    private LocalDate date;

    public Transaction(String transactionId, double amount, LocalDate date) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.date = date;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Transaction other = (Transaction) obj;
        return this.transactionId.equals(other.transactionId);
    }
    abstract void displayInfo();

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getTransactionId() {
        return transactionId;
    }
}
