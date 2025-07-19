package StaffManagement;

public abstract class Staff {
    private String id;
    private String name;
    private double baseSalary;
    private double experienceCoefficient;

    public Staff(String id, String name, double baseSalary, double experienceCoefficient) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
        this.experienceCoefficient = experienceCoefficient;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public double getExperienceCoefficient() {
        return experienceCoefficient;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    abstract void displayInfo();
}
