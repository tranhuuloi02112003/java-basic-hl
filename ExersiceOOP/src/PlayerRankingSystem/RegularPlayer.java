package PlayerRankingSystem;

public class RegularPlayer extends Player {
    private int adsWatchedCount;

    @Override
    public void displayInfo() {
        System.out.println("Regular Player - ID: " + getId() +
                ", Name: " + getName() +
                ", Score: " + getHighScore() +
                ", Play time: " + getPlayTime() + " min" +
                ", Ads watched: " + adsWatchedCount);
    }

    public void setAdsWatchedCount(int adsWatchedCount) {
        this.adsWatchedCount = adsWatchedCount;
    }

    public int getAdsWatchedCount() {
        return adsWatchedCount;
    }
}
