package BankTransactionManagement;

public class CashTransaction extends Transaction {
    private String branchName;

    public String getBranchName() {
        return branchName;
    }

    @Override
    void displayInfo() {
        System.out.println("Cash Transaction - ID: " + getTransactionId()
                + ", Amount: " + getAmount()
                + ", Date: " + getDate()
                + ", Branch name: " + getBranchName());
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
}
