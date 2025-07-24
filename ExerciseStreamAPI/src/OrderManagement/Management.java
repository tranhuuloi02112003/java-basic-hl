package OrderManagement;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Management {

    public static double calculateTotalRevenueOfOrders(List<Order> orders) {
        if (orders == null || orders.isEmpty()) {
            return 0;
        }
        return orders.stream().flatMap(order -> order.getOrderItems().stream())
                .mapToDouble(orderItem -> orderItem.getQuantity() * orderItem.getProduct().getPrice()).sum();
    }

    public static double getMaxTotalValueFromOrders(List<Order> orders) {
        if (orders == null || orders.isEmpty()) {
            return 0;
        }
        return orders.stream()
                .mapToDouble(order -> order.calculateTotalValueOfOrder())
                .max().getAsDouble();
    }

    public static List<Order> findOrdersWithMaxTotalValue(List<Order> orders) {
        if (orders == null || orders.isEmpty()) {
            return Collections.emptyList();
        }
        double maxTotalValue = getMaxTotalValueFromOrders(orders);

        return orders.stream().
                filter(order -> Double.compare(order.calculateTotalValueOfOrder(), maxTotalValue) == 0).toList();
    }

    public static Map<String, Long> countSoldQuantityByProductType(List<Order> orders) {
        return orders.stream()
                .flatMap(order -> order.getOrderItems().stream())
                .collect(Collectors.groupingBy(
                        orderItem -> orderItem.getProduct().getProductCategory(),
                        Collectors.summingLong(item -> item.getQuantity())
                ));
    }

    public static List<Order> getOrdersData() {
        ElectronicsProduct laptop = new ElectronicsProduct();
        laptop.setProductId("EP001");
        laptop.setProductName("Acer Aspire 7");
        laptop.setPrice(1500.0);
        laptop.setWarrantyMonths(24);

        FoodProduct bread = new FoodProduct();
        bread.setProductId("FP001");
        bread.setProductName("Bread");
        bread.setPrice(3.5);
        bread.setExpiryDate(LocalDate.of(2025, 12, 31));

        ElectronicsProduct monitor = new ElectronicsProduct();
        monitor.setProductId("EP002");
        monitor.setProductName("Dell UltraSharp");
        monitor.setPrice(350);
        monitor.setWarrantyMonths(36);

        OrderItem firstOrderItem = new OrderItem();
        firstOrderItem.setProduct(laptop);
        firstOrderItem.setQuantity(1);

        OrderItem secondOrderItem = new OrderItem();
        secondOrderItem.setProduct(bread);
        secondOrderItem.setQuantity(5);

        OrderItem thirdOrderItem = new OrderItem();
        thirdOrderItem.setProduct(monitor);
        thirdOrderItem.setQuantity(2);

        Order firstOrder = new Order();
        firstOrder.setId("ORD01");
        firstOrder.setCustomerName("Bob");
        firstOrder.setOrderItems(List.of(firstOrderItem, secondOrderItem));

        Order secondOrder = new Order();
        secondOrder.setId("ORD02");
        secondOrder.setCustomerName("Alice");
        secondOrder.setOrderItems(List.of(thirdOrderItem, secondOrderItem));
        return List.of(firstOrder, secondOrder);
    }

    public static void main(String[] args) {
        List<Order> orders = getOrdersData();

        System.out.println("All Orders:");
        orders.forEach(System.out::println);
        System.out.println("\nTotal revenue of all orders:" + calculateTotalRevenueOfOrders(orders));

        List<Order> maxOrders = findOrdersWithMaxTotalValue(orders);
        System.out.println("\nOrders with the maximum total value:");
        maxOrders.forEach(System.out::println);

        System.out.println("\nSold quantity of orders by Product category:");
        Map<String, Long> soldQuantityByProductType = countSoldQuantityByProductType(orders);
        soldQuantityByProductType.forEach((category, quantity) -> {
            System.out.println("Category: " + category + "\t Quantity: " + quantity);
        });
    }
}
