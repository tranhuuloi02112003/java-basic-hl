package BankTransactionManagement;

import java.time.LocalDate;

public class TransferTransaction extends Transaction {
    private String receiverBank;

    public TransferTransaction(String transactionId, double amount, LocalDate date, String receiverBank) {
        super(transactionId, amount, date);
        this.receiverBank = receiverBank;
    }

    public String getReceiverBank() {
        return receiverBank;
    }

    @Override
    void displayInfo() {
        System.out.println("Cash Transaction - ID: " + getTransactionId()
                + ", Amount: " + getAmount()
                + ", Date: " + getDate()
                + ", Receiver bank: "+getReceiverBank());
    }
}
