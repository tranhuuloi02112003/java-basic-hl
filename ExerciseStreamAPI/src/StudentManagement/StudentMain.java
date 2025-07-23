package StudentManagement;

import java.util.*;

public class StudentMain {

    public static List<Student> findStudentsScoreEqualsMaxScore(List<Student> students) {
        if (students == null || students.isEmpty()) {
            return Collections.EMPTY_LIST;
        }

        double maxScore = students.stream()
                .mapToDouble(Student::getScore)
                .max().getAsDouble();

        return students.stream()
                .filter(student -> student.getScore() == maxScore).toList();
    }

    public static double calculateAverageScoreOfStudents(List<Student> students) {
        return students.stream().mapToDouble(Student::getScore).average().orElse(0);
    }

    public static List<Student> sortStudentsByScoreOrderByDesc(List<Student> students) {
        return students.stream().sorted(Comparator.comparing(Student::getScore).reversed()).toList();
    }

    public static List<Student> getStudents() {
        List<Student> students = new ArrayList<>();

        Student alice = new Student();
        alice.setId("S01");
        alice.setName("Alice");
        alice.setAge(20);
        alice.setScore(8.5);

        Student bob = new Student();
        bob.setId("S02");
        bob.setName("Bob");
        bob.setAge(21);
        bob.setScore(9.2);

        Student charlie = new Student();
        charlie.setId("S03");
        charlie.setName("Charlie");
        charlie.setAge(19);
        charlie.setScore(9.2);

        students.add(alice);
        students.add(bob);
        students.add(charlie);
        return students;
    }

    public static void main(String[] args) {
        List<Student> students = getStudents();

        System.out.println("Top score students:");
        List<Student> topStudents = findStudentsScoreEqualsMaxScore(students);
        topStudents.forEach(System.out::println);

        double avgScore = calculateAverageScoreOfStudents(students);
        System.out.println("\nAverage score:" + avgScore);

        System.out.println("\nStudents sorted by score (desc):");
        List<Student> sortedList = sortStudentsByScoreOrderByDesc(students);
        sortedList.forEach(System.out::println);
    }
}
