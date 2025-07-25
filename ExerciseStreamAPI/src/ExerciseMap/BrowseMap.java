package ExerciseMap;

import java.util.Map;
import java.util.TreeMap;

public class BrowseMap {
    public static TreeMap<String, String> createMapData() {
        TreeMap<String, String> map = new TreeMap<>();
        map.put("Vietnam", "Hanoi");
        map.put("Japan", "Tokyo");
        map.put("France", "Paris");
        map.put("Thailand", "Bangkok");
        return map;
    }

    public static void displayUsingEntrySet(Map<String, String> map) {
        if (map != null || map.isEmpty()) {
            System.out.println("Map is empty");
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("Country: " + entry.getKey() + " - Capitol: " + entry.getValue());
        }
    }

    public static void displayUsingKeySet(Map<String, String> map) {
        if (map != null || map.isEmpty()) {
            System.out.println("Map is empty");
            return;
        }
        for (String key : map.keySet()) {
            System.out.println("Country: " + key + " - Capitol: " + map.get(key));
        }
    }

    public static void displayUsingLambda(Map<String, String> map) {
        if (map != null || map.isEmpty()) {
            System.out.println("Map is empty");
            return;
        }
        map.forEach((String key, String value) -> System.out.println("Country: " + key + " - Capitol: " + value));
    }

    public static void displayCapitals(Map<String, String> map) {
        if (map != null || map.isEmpty()) {
            System.out.println("Map is empty");
            return;
        }
        for (String capital : map.values()) {
            System.out.print("Capital: " + capital + "\t");
        }
    }

    public static void main(String[] args) {
        Map<String, String> map = createMapData();
        System.out.println("List Map using entrySet():");
        displayUsingEntrySet(map);

        System.out.println("\nList Map using keySet():");
        displayUsingKeySet(map);

        System.out.println("\nList Map using lambda:");
        displayUsingLambda(map);

        System.out.println("List capital:");
        displayCapitals(map);
    }
}
