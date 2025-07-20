package PlayerRankingSystem;

public abstract class Player {
    private String id;
    private String name;
    private int highScore;
    private int playTime;

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlayTime(int playTime) {
        this.playTime = playTime;
    }

    public int getHighScore() {
        return highScore;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPlayTime() {
        return playTime;
    }
    abstract void displayInfo();
}
