package BankAccountManagement;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        PaymentAccount p = new PaymentAccount("026456","An",0,50000);
        SavingsAccount s= new SavingsAccount("036756","Binh",0,0.05);
        System.out.println( p.getAccountType());
        p.deposit(500000);
        p.withdraw(50000);
//        p.calculateFeeOrInterest();
//        p.displayInfo();

        System.out.println( s.getAccountType());
        s.deposit(500000);
        s.withdraw(50000);
//        s.calculateFeeOrInterest();
//        s.displayInfo();
        System.out.println("-----ArrayList-----");
        ArrayList<BankAccount> list = new ArrayList<>();
        list.add(p);
        list.add(s);
        for (BankAccount b:list) {
            b.calculateFeeOrInterest();
            b.displayInfo();
        }

    }
}
