package BankTransactionManagement;

import java.time.LocalDate;

public abstract class Transaction {
    private String transactionId;
    private double amount;
    private LocalDate date;

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

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
