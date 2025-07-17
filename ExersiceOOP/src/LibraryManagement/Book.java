public abstract class Book {
    private String isbn;
    private String title;
    private String author;
    private int publicationYear;
    private boolean status;

    public Book(String isbn, String title, String author, int publicationYear, boolean status) {
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.status = status;
        this.title = title;
    }

    abstract void displayInfo();

    public String getIsbn() {
        return isbn;
    }

    public boolean isStatus() {
        return status;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getTitle() {
        return title;
    }
}
