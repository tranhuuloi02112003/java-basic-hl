package StudentScoreSystem;

import java.util.ArrayList;

public abstract class Student {
    private String studentID;
    private String studentName;
    private ArrayList<Subject> subjects;

    public Student(String studentID, String studentName, ArrayList<Subject> subjects) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.subjects = subjects;
    }

    abstract void displayInfo();

    public String getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }
}
