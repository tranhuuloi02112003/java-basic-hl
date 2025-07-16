public abstract class Animal {
    private String name;
    private int age;
    private String species;

    public Animal() {


    }

    public Animal(String name, int age, String species) {
        this.name = name;
        this.age = age;
        this.species = species;
        System.out.println("GIT");
    }
    abstract void makeSound();

    void displayInfo() {
        System.out.println("Name: " + name+"\tAge:" + age+"\tSpecies:"+species);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}
