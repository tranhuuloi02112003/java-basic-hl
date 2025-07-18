package BankTransactionManagement;

import java.time.LocalDate;
import java.util.ArrayList;

public class Management {
    static ArrayList<Transaction> transactions = new ArrayList<>();

    public static boolean removeTransaction(Transaction transaction) {
        if (transaction.getDate().equals(LocalDate.now())) {
            transactions.remove(transaction);
        }
        return false;
    }

    public static double calculateTotalByTypeAndDateRange(String type, LocalDate startDate, LocalDate endDate) {
        double total = 0;
        for (Transaction transaction : transactions) {
            boolean isInRange = !transaction.getDate().isBefore(startDate) && !transaction.getDate().isAfter(endDate);
            boolean typeTransaction = (type.equalsIgnoreCase("cash") && transaction instanceof CashTransaction)
                    || (type.equalsIgnoreCase("transfer") && transaction instanceof TransferTransaction);

            if (typeTransaction && isInRange) {
                total += transaction.getAmount();
            }
        }
        return total;
    }

    public static ArrayList<Transaction> sortTransactionByAmount() {
        ArrayList<Transaction> sortedTransactions = new ArrayList<>(transactions);
        for (int i = 0; i < sortedTransactions.size() - 1; i++) {
            for (int j = i + 1; j < sortedTransactions.size(); j++) {
                Transaction transaction1 = sortedTransactions.get(i);
                Transaction transaction2 = sortedTransactions.get(j);

                if (transaction1.getAmount() < transaction2.getAmount() ||
                        (transaction1.getAmount() == transaction2.getAmount() && transaction1.getDate().isBefore(transaction2.getDate()))) {
                    Transaction temp = sortedTransactions.get(i);
                    sortedTransactions.set(i, sortedTransactions.get(j));
                    sortedTransactions.set(j, temp);
                }
            }
        }

        return sortedTransactions;
    }

    public static void main(String[] args) {

        Transaction transaction1 = new CashTransaction("GD01", 1000, LocalDate.of(2025, 7, 18), "Hanoi branch");
        Transaction transaction2 = new CashTransaction("GD02", 2000, LocalDate.of(2025, 6, 11), "Saigon branch");
        Transaction transaction3 = new TransferTransaction("GD03", 2000, LocalDate.of(2025, 5, 12), "Vietcombank");
        Transaction transaction4 = new TransferTransaction("GD04", 2500, LocalDate.of(2025, 1, 13), "Techcombank");
        Transaction transaction5 = new TransferTransaction("GD05", 3000, LocalDate.of(2025, 7, 14), "ACB");

        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction3);
        transactions.add(transaction4);
        transactions.add(transaction5);

        System.out.println("Calculate Sum by Type and Date Range:"+calculateTotalByTypeAndDateRange("transfer",LocalDate.of(2025,01,01),LocalDate.of(2025,06,01)));

        System.out.println("\nSort transactions by amount:");
        for (Transaction transaction : sortTransactionByAmount()) {
            transaction.displayInfo();
        }

        System.out.println("\nRemoved transactions:");
        removeTransaction(transaction1);
        for (Transaction transaction : transactions) {
            transaction.displayInfo();
        }

    }
}
