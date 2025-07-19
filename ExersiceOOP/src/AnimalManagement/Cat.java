package AnimalManagement;

public class Cat extends Animal{

    public Cat() {
    }

    public Cat(String name, int age, String species) {
        super(name, age, species);
    }

    @Override
    void makeSound() {
        System.out.println("Meow meow");
    }
}
