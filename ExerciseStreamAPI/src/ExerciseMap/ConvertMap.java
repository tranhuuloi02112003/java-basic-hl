package ExerciseMap;

import java.util.HashMap;
import java.util.Map;

public class ConvertMap {

    public static Map<String, Integer> createMapData() {
        return new HashMap<>(Map.of("Apple", 3,
                "Banana", 2,
                "Date", 4,
                "Elderberry", 3,
                "Cherry", 5));
    }

    public static Map<Integer, String> reverseMap(Map<String, Integer> originalMap) {
        Map<Integer, String> reversedMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : originalMap.entrySet()) {
            reversedMap.put(entry.getValue(), entry.getKey());
        }
        return reversedMap;
    }

    public static void main(String[] args) {
        Map<String, Integer> originalMap = createMapData();
        Map<Integer, String> reversedMap = reverseMap(originalMap);

        System.out.println("Original Map: ");
        originalMap.forEach((key, value) -> System.out.println("Key: " + key + " - Value: " + value));

        System.out.println("\nReversed Map: ");
        reversedMap.forEach((key, value) -> System.out.println("Key: " + key + " - Value: " + value));
    }
}
