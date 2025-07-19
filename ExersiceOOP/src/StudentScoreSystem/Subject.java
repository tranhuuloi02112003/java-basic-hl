package StudentScoreSystem;

public class Subject {
    private String nameSubject;
    private double score;

    public Subject() {
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getNameSubject() {
        return nameSubject;
    }

    public double getScore() {
        return score;
    }
}
