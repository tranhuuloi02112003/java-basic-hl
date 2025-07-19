package PlayerRankingSystem;

public class RegularPlayer extends Player {
    private int adsWatchedCount;

    public RegularPlayer(String id, String name, int highScore, int playTime, int adsWatchedCount) {
        super(id, name, highScore, playTime);
        this.adsWatchedCount = adsWatchedCount;
    }

    @Override
    public void displayInfo() {
        System.out.println("Regular Player - ID: " + getId() +
                ", Name: " + getName() +
                ", Score: " + getHighScore() +
                ", Play time: " + getPlayTime() + " min" +
                ", Ads watched: " + adsWatchedCount);
    }

    public int getAdsWatchedCount() {
        return adsWatchedCount;
    }
}
