package StreamApiExercises.ProductManagement;

public class Phone extends Product {
    private boolean isEsimSupport;

    public boolean isEsimSupport() {
        return isEsimSupport;
    }

    public void setEsimSupport(boolean esimSupport) {
        isEsimSupport = esimSupport;
    }

    @Override
    public String toString() {
        return "Phone - " + super.toString() + ", EsimSupport=" + (isEsimSupport ? "true" : "false");
    }
}
