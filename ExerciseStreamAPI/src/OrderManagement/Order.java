package OrderManagement;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Order {
    private String id;
    private String customerName;
    private List<OrderItem> orderItems;

    public List<OrderItem> getOrderItems() {
        return Collections.unmodifiableList(orderItems);
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        String orderItemsStr = orderItems.stream()
                .map(item -> "- Product: " + item.getProduct().getProductName() + ", Quantity: " + item.getQuantity())
                .collect(Collectors.joining("\n  "));

        return "Order {" +
                "\n  ID: '" + id + '\'' +
                ",\n  Customer Name: '" + customerName + '\'' +
                ",\n  Order Items:\n  " + orderItemsStr +
                "\n}";
    }
     public double calculateTotalValueOfOrder(){
         if (orderItems.size()==0) return 0;
         return orderItems.stream()
                 .mapToDouble(orderItem -> orderItem.getQuantity() * orderItem.getProduct().getPrice()).sum();
     }
}
