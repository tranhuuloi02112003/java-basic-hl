import java.util.ArrayList;

public class LibraryManager {
    ArrayList<Book> bookList = new ArrayList<>();

    public boolean addBook(Book book) {
        if (isIsbnExists(book.getIsbn())) {
            System.out.println("ISBN already exists!!");
            return false;
        }
        bookList.add(book);
        return true;
    }

    public boolean removeBook(String isbn) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getIsbn().equals(isbn)) {
                bookList.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean updateBook(String isbn, Book book) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getIsbn().equals(isbn)) {
                bookList.set(i, book);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Book> findByAuthors(String author) {
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    public ArrayList<Book> sortBookByPublicationYear(ArrayList<Book> books) {
        ArrayList<Book> result = books;
        for (int i = 0; i < result.size(); i++) {
            for (int j = i + 1; j < result.size(); j++) {
                if (result.get(i).getPublicationYear() < result.get(j).getPublicationYear()) {
                    Book temp = result.get(i);
                    result.set(i, result.get(j));
                    result.set(j, temp);
                }
            }
        }
        return result;
    }

    public ArrayList<Book> findByAuthorsAndSortByPublicationYear(String author) {
        ArrayList<Book> result = findByAuthors(author);
        sortBookByPublicationYear(result);
        return result;
    }

    public void displayBooksBorrowed() {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).isStatus()) {
                bookList.get(i).displayInfo();
            }
        }
    }

    public void displayAllBooks() {
        for (Book book : bookList) {
            book.displayInfo();
        }
    }

    private boolean isIsbnExists(String isbn) {
        for (Book book : bookList) {
            if (book.getIsbn().equals(isbn)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LibraryManager library = new LibraryManager();
        library.addBook(new StoryBook("ISBN01", "Harry Potter", "J.K. Rowling", 1997, false, "Fantasy"));
        library.addBook(new PsychologyBook("ISBN02", "Thinking Fast and Slow", "Daniel Kahneman", 2011, true, "Cognitive Science"));
        library.addBook(new StoryBook("ISBN03", "Fantastic Beasts", "J.K. Rowling", 2001, true, "Adventure"));
        library.addBook(new PsychologyBook("ISBN04", "Emotional Intelligence", "Daniel Goleman", 1995, true, "Emotions"));

        System.out.println("Initial book list");
        library.displayAllBooks();
        System.out.println("\nUpdate book with isbn = ISBN01 ");
        library.updateBook("ISBN01", new StoryBook("ISBN01", "Harry Potter 2", "J.K. Rowling", 1992, true, "Fantasy"));
        System.out.println("Updated book list");
        library.displayAllBooks();

        String author = "J.K. Rowling";
        ArrayList<Book> found = library.findByAuthorsAndSortByPublicationYear(author);
        System.out.println("\nBooks by " + author + ":");
        for (Book b : found) {
            b.displayInfo();
        }

        System.out.println("\nRemoving book with ISBN02");
        boolean removed = library.removeBook("ISBN02");
        if (removed) {
            System.out.println("Removed successfully.");
        } else {
            System.out.println("Book not found.");
        }
        System.out.println("\nBook list after remove:");
        library.displayAllBooks();

        System.out.println("\nBooks borrowed");
        library.displayBooksBorrowed();

        System.out.println("\nSearch list by author name and sort by publication year:");
        for (Book book : library.findByAuthorsAndSortByPublicationYear("J.K. Rowling")) {
            book.displayInfo();
        }
    }
}
