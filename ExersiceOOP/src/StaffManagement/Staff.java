package StaffManagement;

public abstract class Staff {
    private String id;
    private String name;
    private double baseSalary;
    private double experienceCoefficient;

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

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public void setExperienceCoefficient(double experienceCoefficient) {
        this.experienceCoefficient = experienceCoefficient;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    abstract void displayInfo();
}
