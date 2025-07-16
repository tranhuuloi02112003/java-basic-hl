public class SavingsAccount extends BankAccount{
    private double annualInterestRate;

    public SavingsAccount( ) {
    }

    public SavingsAccount(String accountNumber, String accountHolderName, double balance, double annualInterestRate) {
        super(accountNumber, accountHolderName, balance);
        this.annualInterestRate = annualInterestRate;
    }

    @Override
    void calculateFeeOrInterest() {
        this.setBalance(this.getBalance()*this.annualInterestRate+ this.getBalance());
    }

    @Override
    String getAccountType() {
        return "Savings Account";
    }

}
