package PlayerRankingSystem;

import java.util.ArrayList;
import java.util.List;

public class Management {

    public static void sortPlayersByHighScoreThenPlayTime(List<Player> players) {
        for (int i = 0; i < players.size() - 1; i++) {
            for (int j = i + 1; j < players.size(); j++) {
                Player current = players.get(i);
                Player next = players.get(j);

                if ((current.getHighScore() == next.getHighScore() && current.getPlayTime() > next.getPlayTime())
                        || current.getHighScore() < next.getHighScore()) {
                    players.set(i, next);
                    players.set(j, current);
                }
            }
        }
    }

    public static List<Player> getTop3PlayersByPlayTime(List<Player> players) {
        List<Player> top3Players = new ArrayList<>();
        List<Player> copyList = new ArrayList<>(players);

        for (int i = 0; i < 3 && !copyList.isEmpty(); i++) {
            Player maxPlayer = copyList.get(0);
            for (int j = 1; j < copyList.size(); j++) {
                if (copyList.get(j).getPlayTime() > maxPlayer.getPlayTime()) {
                    maxPlayer = copyList.get(j);
                }
            }
            top3Players.add(maxPlayer);
            copyList.remove(maxPlayer);
        }
        return top3Players;
    }

    public static boolean addPlayer(List<Player> players, Player player) {
        for (Player p : players) {
            if (p.getName().equalsIgnoreCase(player.getName())) {
                System.out.println("Duplicate name detected: " + player.getName());
                return false;
            }
        }
        players.add(player);
        return true;
    }

    public static void displayPlayers(List<Player> players) {
        for (Player player : players) {
            player.displayInfo();
        }
    }

    public static void main(String[] args) {
        List<Player> playerList = new ArrayList<>();

        RegularPlayer playerAlice = new RegularPlayer();
        playerAlice.setId("R01");
        playerAlice.setName("Alice");
        playerAlice.setHighScore(93);
        playerAlice.setPlayTime(9);
        playerAlice.setAdsWatchedCount(1);
        addPlayer(playerList, playerAlice);

        RegularPlayer playerCharlie = new RegularPlayer();
        playerCharlie.setId("R02");
        playerCharlie.setName("Charlie");
        playerCharlie.setHighScore(80);
        playerCharlie.setPlayTime(11);
        playerCharlie.setAdsWatchedCount(2);
        addPlayer(playerList, playerCharlie);

        RegularPlayer playerAn = new RegularPlayer();
        playerAn.setId("R03");
        playerAn.setName("An");
        playerAn.setHighScore(83);
        playerAn.setPlayTime(13);
        playerAn.setAdsWatchedCount(3);
        addPlayer(playerList, playerAn);

        VipPlayer playerBob = new VipPlayer();
        playerBob.setId("V01");
        playerBob.setName("Bob");
        playerBob.setHighScore(95);
        playerBob.setPlayTime(11);
        playerBob.setMonthlyFee(1_000_000);
        addPlayer(playerList, playerBob);

        VipPlayer playerDavid = new VipPlayer();
        playerDavid.setId("V02");
        playerDavid.setName("David");
        playerDavid.setHighScore(80);
        playerDavid.setPlayTime(7);
        playerDavid.setMonthlyFee(1_100_000);
        addPlayer(playerList, playerDavid);

        System.out.println("Test add duplicate name:");
        boolean added = addPlayer(playerList, playerBob);
        System.out.println(added ? "Added" : "Not added");

        System.out.println("\nAll Players sorted by score and playtime:");
        sortPlayersByHighScoreThenPlayTime(playerList);
        for (Player player : playerList) {
            player.displayInfo();
        }

        System.out.println("\nTop 3 players with the most playing time:");
        List<Player> top3Players = getTop3PlayersByPlayTime(playerList);
        displayPlayers(top3Players);
    }
}
