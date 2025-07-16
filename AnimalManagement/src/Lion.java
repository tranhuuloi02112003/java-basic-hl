public class Lion extends Animal{
    public Lion() {
    }

    public Lion(String name, int age, String species) {
        super(name, age, species);
    }

    @Override
    void makeSound() {
        System.out.println("Roarrr");
    }
}
