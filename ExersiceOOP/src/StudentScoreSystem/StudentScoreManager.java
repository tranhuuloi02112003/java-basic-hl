package StudentScoreSystem;

import java.util.ArrayList;

public class StudentScoreManager {
    private ArrayList<Student> students = new ArrayList<>();

    public double calculateGPA(Student student) {
        double totalScore = 0;
        for (Subject subject : student.getSubjects()) {
            totalScore += subject.getScore();
        }
        if (student.getSubjects().size() == 0) return 0;
        return totalScore / students.size();
    }

    public Student findTopStudentInSubject(String subjectName) {
        Student topStudent = null;
        double highestScore = 0;
        for (Student student : students) {
            for (Subject subject : student.getSubjects()) {
                if (subject.getNameSubject().contains(subjectName)
                        && subject.getScore() > highestScore) {
                    topStudent = student;
                    highestScore = subject.getScore();
                }
            }
        }
        return topStudent;
    }

    public ArrayList<Student> sortStudentByGPA() {
        ArrayList<Student> sortedStudents = new ArrayList<>(students);
        for (int i = 0; i < students.size() - 1; i++) {
            for (int j = i + 1; j < students.size(); j++) {
                if (calculateGPA(students.get(i)) < calculateGPA(students.get(j))) {
                    Student temp = sortedStudents.get(i);
                    sortedStudents.set(i, sortedStudents.get(j));
                    sortedStudents.set(j, temp);
                }
            }
        }
        return sortedStudents;
    }

    public static void main(String[] args) {
        StudentScoreManager manager = new StudentScoreManager();

        ArrayList<Subject> subjectsAn = new ArrayList<>();
        subjectsAn.add(new Subject("Math", 9.0));
        subjectsAn.add(new Subject("Physics", 8.0));

        ArrayList<Subject> subjectsBob = new ArrayList<>();
        subjectsBob.add(new Subject("Math", 7.0));
        subjectsBob.add(new Subject("Physics", 6.5));
        subjectsBob.add(new Subject("Chemistry", 9.0));

        Student alice = new DomesticStudent("SV01", "An", subjectsAn, "Hanoi");
        Student bob = new InternationalStudent("SV02", "Bob", subjectsBob, "USA");

        manager.students.add(alice);
        manager.students.add(bob);

        System.out.println("Info student and GPT");
        for (Student student : manager.students) {
            student.displayInfo();
            System.out.println(", GPA: " + (double) manager.calculateGPA(student));
        }

        System.out.println("\nTop student in Math: ");
        if (manager.findTopStudentInSubject("Math") != null) {
            manager.findTopStudentInSubject("Math").displayInfo();
        } else {
            System.out.println("No students study math");
        }

        System.out.println("\n\nStudents sorted by GPA:");
        ArrayList<Student> sorted = manager.sortStudentByGPA();
        for (Student student : sorted) {
            student.displayInfo();
            System.out.print(", GPA: " + (double) manager.calculateGPA(student) + "\n");
        }
    }
}
