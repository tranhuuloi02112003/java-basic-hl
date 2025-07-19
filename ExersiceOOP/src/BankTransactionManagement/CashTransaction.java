package BankTransactionManagement;

import java.time.LocalDate;

public class CashTransaction extends Transaction {
    private String branchName;

    public CashTransaction(String transactionId, double amount, LocalDate date, String branchName) {
        super(transactionId, amount, date);
        this.branchName = branchName;
    }

    public String getBranchName() {
        return branchName;
    }

    @Override
    void displayInfo() {
        System.out.println("Cash Transaction - ID: " + getTransactionId()
        + ", Amount: " + getAmount()
        + ", Date: " + getDate()
        + ", Branch name: "+getBranchName());
    }
}
