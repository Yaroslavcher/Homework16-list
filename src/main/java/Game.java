import java.util.HashMap;

public class Game {
    private HashMap<String, Integer> map = new HashMap<>();

    public void register(Player player) {
        map.put(player.getName(), player.getStrength());
    }

    public int round(String playerName1, String playerName2) {
        String p1 = null;
        String p2 = null;
        for (String key : map.keySet()) {
            if (key.equals(playerName1)) {
                p1 = key;
            }
            if (key.equals(playerName2)) {
                p2 = key;
            }
        }


        if (p1 == null) {
            throw new NotRegisteredException("Игрок " + playerName1 + " не зарегистрирован");
        }
        if (p2 == null) {
            throw new NotRegisteredException("Игрок " + playerName2 + " не зарегистрирован");
        }
        if (map.get(p1) == map.get(p2)) {
            return 0;
        }
        if (map.get(p1) < map.get(p2)) {
            return 2;
        } else {
            return 1;
        }
    }
}
