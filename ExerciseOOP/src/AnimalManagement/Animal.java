package AnimalManagement;

public abstract class Animal {
    private String name;
    private int age;
    private String species;

    public Animal(String name, int age, String species) {
        this.name = name;
        this.age = age;
        this.species = species;
    }

    abstract void makeSound();

    void displayInfo() {
        System.out.println("Name: " + name+"\tAge:" + age+"\tSpecies:"+species);
    }

    public String getName() {
        return name;
    }

}
