package OrderManagemant;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Management {

    public static boolean addOrder(List<Order> orders, Order order) {
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

    public static List<Order> findHighestValueOrdersInMonth(List<Order> orders, int month) {
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

    public static void displayOrders(List<Order> orders) {
        for (Order tempOrder : orders) {
            tempOrder.displayInfo();
        }
    }

    public static void main(String[] args) {
        List<Order> orderList = new ArrayList<>();

        Product laptopProduct = new Product();
        laptopProduct.setProductId("P01");
        laptopProduct.setName("Laptop");
        laptopProduct.setPrice(100.0);
        laptopProduct.setQuantity(3);

        Product mouseProduct = new Product();
        mouseProduct.setProductId("P02");
        mouseProduct.setName("Mouse");
        mouseProduct.setPrice(50.0);
        mouseProduct.setQuantity(5);

        Product monitorProduct = new Product();
        monitorProduct.setProductId("P03");
        monitorProduct.setName("Monitor");
        monitorProduct.setPrice(200.0);
        monitorProduct.setQuantity(2);

        Product keyboardProduct = new Product();
        keyboardProduct.setProductId("P04");
        keyboardProduct.setName("Keyboard");
        keyboardProduct.setPrice(70.0);
        keyboardProduct.setQuantity(4);

        Product webcamProduct = new Product();
        webcamProduct.setProductId("P05");
        webcamProduct.setName("Webcam");
        webcamProduct.setPrice(90.0);
        webcamProduct.setQuantity(1);

        DomesticOrder domesticOrder = new DomesticOrder();
        domesticOrder.setOrderId("D01");
        domesticOrder.setOrderDate(LocalDate.of(2025, 7, 17));
        domesticOrder.setDistrict("Hanoi");
        try {
            domesticOrder.setProducts(new ArrayList<>(
                    List.of(laptopProduct, mouseProduct, monitorProduct)
            ));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        InternationalOrder internationalOrder = new InternationalOrder();
        internationalOrder.setOrderId("I01");
        internationalOrder.setOrderDate(LocalDate.of(2025, 7, 1));
        internationalOrder.setCountry("USA");
        try {
            internationalOrder.setProducts(new ArrayList<>(
                    List.of(laptopProduct, mouseProduct, monitorProduct)
            ));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        addOrder(orderList, domesticOrder);
        addOrder(orderList, internationalOrder);

        System.out.println("\nTest duplicate product ID:");
        Product duplicateProduct = new Product();
        duplicateProduct.setProductId("P01");
        duplicateProduct.setName("Laptop Pro");
        duplicateProduct.setPrice(150.0);
        duplicateProduct.setQuantity(1);
        try {
            domesticOrder.setProducts(new ArrayList<>(List.of(duplicateProduct)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        List<Order> highestValueOrders = findHighestValueOrdersInMonth(orderList, 7);
        System.out.println("\nHighest value order(s) in July:");
        for (Order order : highestValueOrders) {
            order.displayInfo();
        }

        System.out.println("\nOrders sorted products by quantity descending:");
        displayOrders(orderList);
    }
}
