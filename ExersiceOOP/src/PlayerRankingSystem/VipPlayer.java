package PlayerRankingSystem;

public class VipPlayer extends Player {
    private double monthlyFee;

    public VipPlayer(String id, String name, int highScore, int playTime, double monthlyFee) {
        super(id, name, highScore, playTime);
        this.monthlyFee = monthlyFee;
    }

    @Override
    public void displayInfo() {
        System.out.println("VIP player - ID: " + getId() +
                ", Name: " + getName() +
                ", Score: " + getHighScore() +
                ", Play time: " + getPlayTime() + " min" +
                ", Monthly Fee: " + monthlyFee);
    }

    public double getMonthlyFee() {
        return monthlyFee;
    }
}
