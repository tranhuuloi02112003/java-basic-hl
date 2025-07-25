package StudentScoreSystem;

public class InternationalStudent extends Student {
    private String country;

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    void displayInfo() {
        System.out.print("International student - Student ID: " + getStudentID()
                + ", Student Name: " + getStudentName()
                + ", Subjects: ");
        for (Subject subject : getSubjects()) {
            System.out.print(subject.getNameSubject() + ": " + subject.getScore() + " ");
        }
        System.out.print(", Country: " + country);
    }
}
