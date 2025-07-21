public class StoryBook extends Book{
    private String genre;

    @Override
    public void displayInfo() {
        System.out.println("Story Book - ISBN: " + getIsbn()
                + ", Title: " + getTitle()
                + ", Author: " + getAuthor()
                + ", Year: " + getPublicationYear()
                + ", Genre: " + genre
                + ", Borrowed: " + (isStatus() ? "Yes" : "No"));
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
