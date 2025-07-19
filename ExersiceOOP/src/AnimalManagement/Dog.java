package AnimalManagement;

public class Dog extends Animal{
    public Dog() {
    }

    public Dog(String name, int age, String species) {
        super(name, age, species);
    }

    @Override
    void makeSound() {
        System.out.println("Woof woof");
    }
}
