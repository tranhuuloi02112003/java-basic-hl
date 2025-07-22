package ExerciseStreamAPI.src.ProductManagement;

public class Laptop extends Product {
    private int ramGb;

    public int getRamGb() {
        return ramGb;
    }

    public void setRamGb(int ramGb) {
        this.ramGb = ramGb;
    }

    @Override
    public String toString() {
        return "Laptop - " + super.toString() + ", Ram gb =" + ramGb;
    }
}
