package AnimalManagement;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Animal> list = new ArrayList<>();
        list.add(new Dog("Pi", 2, "Dog"));
        list.add(new Cat("Kitty", 3, "Cat"));
        list.add(new Lion("Simba", 5, "Lion"));

        for (Animal a : list) {
            a.makeSound();
            a.displayInfo();
        }
    }
}
