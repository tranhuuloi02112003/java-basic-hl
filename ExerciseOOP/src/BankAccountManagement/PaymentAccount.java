package BankAccountManagement;

public class PaymentAccount extends BankAccount{
    private double annualServiceFee;

    public PaymentAccount(String accountNumber, String accountHolderName, double balance, double annualServiceFee) {
        super(accountNumber, accountHolderName, balance);
        this.annualServiceFee = annualServiceFee;
    }

    @Override
    void calculateFeeOrInterest() {
        this.setBalance(this.getBalance()-this.annualServiceFee);
    }

    @Override
    String getAccountType() {
        return "Payment account";
    }
}
