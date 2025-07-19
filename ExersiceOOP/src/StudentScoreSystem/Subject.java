package StudentScoreSystem;

public class Subject {
    private String nameSubject;
    private double score;

    public Subject(String nameSubject, double score) {
        this.nameSubject = nameSubject;
        this.score = score;
    }

    public String getNameSubject() {
        return nameSubject;
    }

    public double getScore() {
        return score;
    }
}
