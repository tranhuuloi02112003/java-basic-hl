package StudentScoreSystem;

import java.util.ArrayList;
import java.util.List;

public class StudentScoreManager {

    public double calculateGPA(Student student) {
        double totalScore = 0;
        for (Subject subject : student.getSubjects()) {
            totalScore += subject.getScore();
        }
        if (student.getSubjects().size() == 0) return 0;
        return totalScore / student.getSubjects().size();
    }

    public Student findTopStudentInSubject(String subjectName,List<Student> students) {
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

    public ArrayList<Student> sortStudentByGPA(List<Student> students) {
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

        List<Student> listStudent = new ArrayList<>();

        Subject mathOfAn= new Subject();
        Subject physicsOfAn= new Subject();

        mathOfAn.setScore(9);
        mathOfAn.setNameSubject("Math");
        physicsOfAn.setScore(8);
        physicsOfAn.setNameSubject("Physics");

        Subject mathOfBob= new Subject();
        Subject physicsOfBob= new Subject();

        mathOfBob.setScore(7);
        mathOfBob.setNameSubject("Math");
        physicsOfBob.setScore(6);
        physicsOfBob.setNameSubject("Physics");

        DomesticStudent an= new DomesticStudent();
        an.setStudentID("SV01");
        an.setStudentName("An");
        an.setSubjects(List.of(mathOfAn,physicsOfAn));
        an.setDistrict("Hanoi");

        InternationalStudent bob= new InternationalStudent();
        bob.setStudentID("SV02");
        bob.setStudentName("Bob");
        bob.setSubjects(List.of(mathOfBob,physicsOfBob));
        bob.setCountry("Canada");

        listStudent.add(an);
        listStudent.add(bob);

        System.out.println("Info student and GPT");
        for (Student student : listStudent) {
            student.displayInfo();
            System.out.println(", GPA: " + (double) manager.calculateGPA(student));
        }

        System.out.println("\nTop student in Math: ");
        if (manager.findTopStudentInSubject("Math",listStudent) != null) {
            manager.findTopStudentInSubject("Math",listStudent).displayInfo();
        } else {
            System.out.println("No students study mathOfAn");
        }

        System.out.println("\n\nStudents sorted by GPA:");
        ArrayList<Student> sorted = manager.sortStudentByGPA(listStudent);
        for (Student student : sorted) {
            student.displayInfo();
            System.out.print(", GPA: " + (double) manager.calculateGPA(student) + "\n");
        }
    }
}
