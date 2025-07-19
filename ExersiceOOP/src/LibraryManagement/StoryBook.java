public class StoryBook extends Book{
    private String genre;

    public StoryBook(String isbn, String title, String author, int publicationYear, boolean status, String genre) {
        super(isbn, title, author, publicationYear, status);
        this.genre = genre;
    }

    @Override
    public void displayInfo() {
        System.out.println("Story Book - ISBN: " + getIsbn()
                + ", Title: " + getTitle()
                + ", Author: " + getAuthor()
                + ", Year: " + getPublicationYear()
                + ", Genre: " + genre
                + ", Borrowed: " + (isStatus() ? "Yes" : "No"));
    }

}
