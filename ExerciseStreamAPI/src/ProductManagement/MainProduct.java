package ProductManagement;


import java.util.ArrayList;
import java.util.List;

public class MainProduct {
    public static List<Product> getProductsGreaterThanMinPrice(List<Product> products, double minPrice) {
        return products.stream()
                .filter(product -> product.getPrice() > minPrice).toList();
    }

    public static double calculateTotalPrice(List<Product> products) {
        return products.stream().mapToDouble(product -> product.getPrice()).sum();
    }

    public static List<Product> getProductsByClassType(List<Product> products, Class<?> type) {
        return products.stream()
                .filter(product -> type.isInstance(product)).toList();
    }

    public static List<Product> getProductsData() {
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

        return products;
    }

    public static void main(String[] args) {
        List<Product> products = getProductsData();

        System.out.println("All products:");
        products.forEach(System.out::println);

        System.out.println("\nProducts with price > 1000:");
        List<Product> expensiveProducts = getProductsGreaterThanMinPrice(products, 1000);
        expensiveProducts.forEach(System.out::println);

        System.out.println("\nTotal price of all products:" + calculateTotalPrice(products));

        System.out.println("\nFiltered products by Phone");
        List<Product> phoneList = getProductsByClassType(products, Phone.class);
        phoneList.forEach(System.out::println);
    }
}
