public class Laptop extends Product{
    private double screenSize;
    private String graphicsCard;

    public Laptop() {
    }

    public Laptop(String productId, String productName, double basePrice, double screenSize, String graphicsCard) {
        super(productId, productName, basePrice);
        this.screenSize = screenSize;
        this.graphicsCard = graphicsCard;
    }

    @Override
    double calculatePrice() {
        double extraFee = graphicsCard.equalsIgnoreCase("RTX 4060") ? 300000 : 150000;
        return getBasePrice() + extraFee;
    }

    @Override
    void displayInfo(){
        super.displayInfo();
        System.out.println("\tScreen size:"+screenSize+"\tGraphics card:"+graphicsCard+"\tPrice:"+calculatePrice());
    }
    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }
}
