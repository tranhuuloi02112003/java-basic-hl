package BankAccountManagement;

public abstract class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount() {
    }

    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    void deposit(double amount){
        this.balance+=amount;
    }

    void withdraw(double amount){
        if (this.balance<amount){
            System.out.println("Insufficient balance for withdrawal");
        }else {
            this.balance-=amount;
        }
    }
    void displayInfo(){
        System.out.println("Account number:"+this.accountNumber);
        System.out.println("Account holder name:"+this.accountHolderName);
        System.out.println("Balance:"+this.balance);
    }

    abstract void calculateFeeOrInterest();

    abstract String getAccountType();

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
