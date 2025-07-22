package StreamApiExercises.ProductManagement;

import java.util.ArrayList;
import java.util.List;

public class MainProduct {
    public static List<Product> filterByPrice(List<Product> products, double minPrice) {
        List<Product> filteredList = products.stream()
                .filter(product -> product.getPrice() > minPrice).toList();
        return filteredList;
    }

    public static double calculateTotalPrice(List<Product> products) {
        double totalPrice = 0;
        totalPrice = products.stream().mapToDouble(product -> product.getPrice()).sum();
        return totalPrice;
    }

    public static List<Product> filterByCategory(List<Product> products, Class<?> type) {
        List<Product> filteredList = products.stream()
                .filter(product -> type.isInstance(product)).toList();
        return filteredList;
    }

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        Phone iPhone15 = new Phone();
        iPhone15.setId("P01");
        iPhone15.setName("IPhone 15");
        iPhone15.setPrice(1200);
        iPhone15.setEsimSupport(true);

        Phone samsungGalaxyS24 = new Phone();
        samsungGalaxyS24.setId("P02");
        samsungGalaxyS24.setName("Samsung Galaxy S24");
        samsungGalaxyS24.setPrice(950);
        samsungGalaxyS24.setEsimSupport(false);

        Laptop macbookPro = new Laptop();
        macbookPro.setId("L01");
        macbookPro.setName("MacBook Pro");
        macbookPro.setPrice(2100);
        macbookPro.setRamGb(16);

        Laptop dellXps = new Laptop();
        dellXps.setId("L02");
        dellXps.setName("Dell XPS");
        dellXps.setPrice(1800);
        dellXps.setRamGb(32);

        products.add(iPhone15);
        products.add(samsungGalaxyS24);
        products.add(macbookPro);
        products.add(dellXps);

        System.out.println("All products:");
        products.forEach(System.out::println);

        System.out.println("\nProducts with price > 1000:");
        List<Product> expensiveProducts = filterByPrice(products, 1000);
        expensiveProducts.forEach(System.out::println);

        System.out.println("\nTotal price of all products:" + calculateTotalPrice(products));

        System.out.println("\nFiltered products by Phone");
        List<Product> phoneList = filterByCategory(products, Phone.class);
        phoneList.forEach(System.out::println);
    }
}
