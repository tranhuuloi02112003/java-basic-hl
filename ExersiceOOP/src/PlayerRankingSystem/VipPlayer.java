package PlayerRankingSystem;

public class VipPlayer extends Player {
    private double monthlyFee;

    @Override
    public void displayInfo() {
        System.out.println("VIP player - ID: " + getId() +
                ", Name: " + getName() +
                ", Score: " + getHighScore() +
                ", Play time: " + getPlayTime() + " min" +
                ", Monthly Fee: " + monthlyFee);
    }

    public void setMonthlyFee(double monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    public double getMonthlyFee() {
        return monthlyFee;
    }
}
