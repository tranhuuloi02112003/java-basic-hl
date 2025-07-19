package BankTransactionManagement;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Management {
    public static boolean removeTransaction(List<Transaction> transactions, Transaction transaction) {
        if (transaction.getDate().equals(LocalDate.now())) {
            transactions.remove(transaction);
        }
        return false;
    }

    public static double calculateTotalByTypeAndDateRange(List<Transaction> transactions, String type, LocalDate startDate, LocalDate endDate) {
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

    public static ArrayList<Transaction> sortTransactionByAmount(List<Transaction> transactions) {
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

    public static void displayTransactions(List<Transaction> transactions) {
        for (Transaction transaction : transactions) {
            transaction.displayInfo();
        }
    }

    public static void main(String[] args) {
        List<Transaction> transactions = new ArrayList<>();

        CashTransaction transaction1 = new CashTransaction();
        transaction1.setTransactionId("GD01");
        transaction1.setAmount(1000);
        transaction1.setDate(LocalDate.of(2025, 7, 19));
        transaction1.setBranchName("Hanoi branch");

        CashTransaction transaction2 = new CashTransaction();
        transaction2.setTransactionId("GD02");
        transaction2.setAmount(2000);
        transaction2.setDate(LocalDate.of(2025, 6, 11));
        transaction2.setBranchName("Saigon branch");

        TransferTransaction transaction3 = new TransferTransaction();
        transaction3.setTransactionId("GD03");
        transaction3.setAmount(2000);
        transaction3.setDate(LocalDate.of(2025, 5, 12));
        transaction3.setReceiverBank("Vietcombank");

        TransferTransaction transaction4 = new TransferTransaction();
        transaction4.setTransactionId("GD04");
        transaction4.setAmount(2500);
        transaction4.setDate(LocalDate.of(2025, 1, 13));
        transaction4.setReceiverBank("Techcombank");

        TransferTransaction transaction5 = new TransferTransaction();
        transaction5.setTransactionId("GD05");
        transaction5.setAmount(3000);
        transaction5.setDate(LocalDate.of(2025, 7, 14));
        transaction5.setReceiverBank("ACB");

        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction3);
        transactions.add(transaction4);
        transactions.add(transaction5);

        LocalDate startDate = LocalDate.of(2025, 1, 1);
        LocalDate endDate = LocalDate.of(2025, 6, 1);
        String type = "transfer";
        double totalAmount = calculateTotalByTypeAndDateRange(transactions, type, startDate, endDate);
        System.out.println("Calculate sum by type and date range: " + totalAmount);

        System.out.println("\nSort transactions by amount:");
        displayTransactions(sortTransactionByAmount(transactions));

        System.out.println("\nRemoved transactions:");
        removeTransaction(transactions, transaction1);
        displayTransactions(transactions);
    }
}
