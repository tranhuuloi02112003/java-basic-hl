package OrderManagemant;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Management {
    private static List<Order> orders = new ArrayList<>();

    public static boolean addOrder(Order order) {
        for (Order tempOrder : orders) {
            if (tempOrder.getOrderId().equalsIgnoreCase(order.getOrderId())) {
                System.out.println("The order code already exists, please enter another order code!");
                return false;
            }
        }
        orders.add(order);
        System.out.println("Order has been added successfully!");
        return true;
    }

    public static double calculateTotalOrderAmount(Order order) {
        double total = 0;
        for (Product product : order.getProducts()) {
            total += product.getPrice() * product.getQuantity();
        }
        return total;
    }

    public static List<Order> findHighestValueOrderInMonth(ArrayList<Order> orders, int month) {
        List<Order> result = new ArrayList<>();
        double maxTotal = 0;
        for (Order tempOrder : orders) {
            if (tempOrder.getOrderDate().getMonthValue() == month) {
                double total = calculateTotalOrderAmount(tempOrder);
                if (maxTotal < total) {
                    maxTotal = total;
                    result.clear();
                    result.add(tempOrder);
                } else if (maxTotal == total) {
                    result.add(tempOrder);
                }
            }
        }
        return result;
    }

    public static List<Order> sortProductsInOrderByQuantity(ArrayList<Order> orders) {
        for (Order tempOrder : orders) {
            List<Product> products = tempOrder.getProducts();
            for (int i = 0; i < products.size() - 1; i++) {
                for (int j = i + 1; j < products.size(); j++) {
                    if (products.get(i).getQuantity() < products.get(j).getQuantity()) {
                        Product tempProduct = products.get(i);
                        products.set(i, products.get(j));
                        products.set(j, tempProduct);
                    }
                }
            }
        }
        return orders;
    }

    public static void main(String[] args) {
        List<Product> productList1 = new ArrayList<>();
        productList1.add(new Product(3, "P01", 100.0, "Laptop"));
        productList1.add(new Product(5, "P02", 50.0, "Mouse"));
        productList1.add(new Product(2, "P03", 200.0, "Monitor"));

        List<Product> productList2 = new ArrayList<>();
        productList2.add(new Product(1, "P01", 100.0, "Laptop"));
        productList2.add(new Product(4, "P05", 70.0, "Keyboard"));


        Order domesticOrder = new DomesticOrder(productList1, "D01", LocalDate.of(2025, 7, 17), "Hanoi");
        Order internationalOrder = new InternationalOrder(productList2, "I01", LocalDate.of(2025, 7, 01), "USA");

        addOrder(internationalOrder);
        addOrder(domesticOrder);
        System.out.println("Check duplicate order code");
        addOrder(internationalOrder);

        List<Order> highestOrders = findHighestValueOrderInMonth(new ArrayList<>(orders), 7);
        System.out.println("\nHighest value order in July:");
        for (Order order : highestOrders) {
            order.displayInfo();
        }

        System.out.println("\nOrders after sorting products by quantity descending:");
        List<Order> sortedOrders = sortProductsInOrderByQuantity(new ArrayList<>(orders));
        for (Order order : sortedOrders) {
            order.displayInfo();
        }
    }
}
