package PlayerRankingSystem;

import java.util.ArrayList;
import java.util.List;

public class Management {
    private static List<Player> playerList = new ArrayList<>();

    public static void sortPlayersByRank() {
        for (int i = 0; i < playerList.size() - 1; i++) {
            for (int j = i + 1; j < playerList.size(); j++) {
                Player p1 = playerList.get(i);
                Player p2 = playerList.get(j);

                if ((p1.getHighScore() == p2.getHighScore() && p1.getPlayTime() > p2.getPlayTime())
                        || p1.getHighScore() < p2.getHighScore()) {
                    Player temp = playerList.get(i);
                    playerList.set(i, playerList.get(j));
                    playerList.set(j, temp);
                }
            }
        }
    }

    public static List<Player> getTop3ByPlayTime() {
        List<Player> top3 = new ArrayList<>();
        List<Player> copyList = new ArrayList<>(playerList);

        for (int i = 0; i < 3 && !copyList.isEmpty(); i++) {
            Player maxPlayer = copyList.get(0);
            for (int j = 1; j < copyList.size(); j++) {
                if (copyList.get(j).getPlayTime() > maxPlayer.getPlayTime()) {
                    maxPlayer = copyList.get(j);
                }
            }
            top3.add(maxPlayer);
            copyList.remove(maxPlayer);
        }
        return top3;
    }

    public static boolean addPlayer(Player player) {
        for (Player p : playerList) {
            if (p.getName().equalsIgnoreCase(player.getName())) {
                System.out.println("Duplicate name detected: " + player.getName());
                return false;
            }
        }
        playerList.add(player);
        return true;
    }

    public static void main(String[] args) {
        addPlayer(new RegularPlayer("R01", "Alice", 93, 9, 1));
        addPlayer(new RegularPlayer("R02", "Charlie", 80, 11, 2));
        addPlayer(new RegularPlayer("R03", "An", 83, 13, 3));
        addPlayer(new VipPlayer("V01", "Bob", 95, 11, 1000000));
        addPlayer(new VipPlayer("V02", "David", 80, 7, 1100000));

        System.out.println("Test add duplicate name:");
        boolean added = addPlayer(new RegularPlayer("P007", "Alice", 66, 100, 33));
        System.out.println(added ? "Added" : "Not added");

        System.out.println("\nAll Players sorted by score and playtime:");
        sortPlayersByRank();
        for (Player p : playerList) {
            p.displayInfo();
        }
        System.out.println("\nTop 3 players with the most playing time");
        List<Player> top3 = getTop3ByPlayTime();
        for (Player p : top3) {
            p.displayInfo();
        }
    }
}
