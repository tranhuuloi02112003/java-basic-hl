package PlayerRankingSystem;

public abstract class Player {
    private String id;
    private String name;
    private int highScore;
    private int playTime;

    public Player(String id, String name, int highScore, int playTime) {
        this.id = id;
        this.name = name;
        this.highScore = highScore;
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
