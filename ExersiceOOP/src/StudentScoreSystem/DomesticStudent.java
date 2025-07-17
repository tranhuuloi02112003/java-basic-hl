package StudentScoreSystem;

import java.util.ArrayList;

public class DomesticStudent extends Student {
    private String district;

    public DomesticStudent(String studentID, String studentName, ArrayList<Subject> subjects, String district) {
        super(studentID, studentName, subjects);
        this.district = district;
    }

    @Override
    void displayInfo() {
        System.out.print("Domestic student - Student ID: " + getStudentID()
                + ", Student Name: " + getStudentName()
                + ", Subjects: ");
        for (Subject subject : getSubjects()) {
            System.out.print(subject.getNameSubject() + " - "
                    + subject.getScore() + ", ");
        }
        System.out.print(", District: " + district);
    }

}
