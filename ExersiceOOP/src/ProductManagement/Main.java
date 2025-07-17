package ProductManagement;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Product> list= new ArrayList<>();
        Product p1 = new Phone("P01", "iPhone 14", 1000000, 4500, "iOS");
        Product p2 = new Laptop("L01", "Dell XPS 15", 2000000, 15.6, "RTX 4060");
        Product p3 = new Phone("P02", "Samsung Galaxy S23", 800000, 3900, "Android");

        list.add(p1);
        list.add(p2);
        list.add(p3);

        for (Product p:list
             ) {
            p.displayInfo();
        }
    }
}
