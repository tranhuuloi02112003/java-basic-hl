public class PsychologyBook extends Book {
    private String topic;

    public PsychologyBook(String isbn, String title, String author, int publicationYear, boolean status, String tocpic) {
        super(isbn, title, author, publicationYear, status);
        this.topic = tocpic;
    }

    @Override
    public void displayInfo() {
        System.out.println("Psychology Book - ISBN: " + getIsbn()
                + ", Title: " + getTitle()
                + ", Author: " + getAuthor()
                + ", Year: " + getPublicationYear()
                + ", Topic: " + topic
                + ", Borrowed: " + (isStatus() ? "Yes" : "No"));
    }
}
