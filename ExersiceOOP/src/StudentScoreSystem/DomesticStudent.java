package StudentScoreSystem;

public class DomesticStudent extends Student {
    private String district;

    public void setDistrict(String district) {
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
