public abstract class Book {
    private String isbn;
    private String title;
    private String author;
    private int publicationYear;
    private boolean status;

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

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
