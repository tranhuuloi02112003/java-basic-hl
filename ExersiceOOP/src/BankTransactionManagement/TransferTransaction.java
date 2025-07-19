package BankTransactionManagement;

public class TransferTransaction extends Transaction {
    private String receiverBank;

    public String getReceiverBank() {
        return receiverBank;
    }

    public void setReceiverBank(String receiverBank) {
        this.receiverBank = receiverBank;
    }

    @Override
    void displayInfo() {
        System.out.println("Cash Transaction - ID: " + getTransactionId()
                + ", Amount: " + getAmount()
                + ", Date: " + getDate()
                + ", Receiver bank: "+getReceiverBank());
    }
}
