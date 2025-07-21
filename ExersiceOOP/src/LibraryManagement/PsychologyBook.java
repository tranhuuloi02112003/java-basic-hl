public class PsychologyBook extends Book {
    private String topic;

    @Override
    public void displayInfo() {
        System.out.println("Psychology Book - ISBN: " + getIsbn()
                + ", Title: " + getTitle()
                + ", Author: " + getAuthor()
                + ", Year: " + getPublicationYear()
                + ", Topic: " + topic
                + ", Borrowed: " + (isStatus() ? "Yes" : "No"));
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
