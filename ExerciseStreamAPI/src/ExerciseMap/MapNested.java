package ExerciseMap;

import java.util.HashMap;
import java.util.Map;

public class MapNested {

    public static Map<String, Map<String, String>> createClassRoomData() {
        Map<String, Map<String, String>> classMap = new HashMap<>();

        classMap.put("12A1", Map.of(
                "SV01", "Alice",
                "SV02", "Bob",
                "SV03", "John",
                "SV04", "Robert"
        ));

        classMap.put("12A2", Map.of(
                "SV05", "James",
                "SV06", "Kevin",
                "SV07", "David"
        ));

        classMap.put("12A3", Map.of(
                "SV08", "Johnson",
                "SV09", "Linda",
                "SV10", "Maria"
        ));

        return classMap;
    }

    public static void printClassroomsInfo(Map<String, Map<String, String>> classMap) {
        for (Map.Entry<String, Map<String, String>> entry : classMap.entrySet()) {
            String className = entry.getKey();
            Map<String, String> students = entry.getValue();

            System.out.println("Class Name: " + className);
            for (Map.Entry<String, String> studentsEntry : students.entrySet()) {
                System.out.println("Student id: " + studentsEntry.getKey() + " - Student name:  " + studentsEntry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        Map<String, Map<String, String>> classroomData = createClassRoomData();
        printClassroomsInfo(classroomData);
    }
}
