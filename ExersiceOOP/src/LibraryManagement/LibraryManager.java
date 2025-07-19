import java.util.ArrayList;
import java.util.List;

public class LibraryManager {

    public static boolean addBook(List<Book> bookList, Book book) {
        if (isIsbnExists(book.getIsbn())) {
            System.out.println("ISBN already exists!!");
            return false;
        }
        bookList.add(book);
        return true;
    }

    public static boolean removeBook(List<Book> bookList, String isbn) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getIsbn().equals(isbn)) {
                bookList.remove(i);
                return true;
            }
        }
        return false;
    }

    public static boolean updateBook(List<Book> bookList, String isbn, Book book) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getIsbn().equals(isbn)) {
                bookList.set(i, book);
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Book> findByAuthors(List<Book> bookList, String author) {
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    public static List<Book> sortBookByPublicationYear(List<Book> books) {
        List<Book> result = books;
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

    public static List<Book> findByAuthorsAndSortByPublicationYear(List<Book> bookList, String author) {
        List<Book> result = findByAuthors(bookList, author);
        sortBookByPublicationYear(result);
        return result;
    }

    public static void displayBooksBorrowed(List<Book> bookList) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).isStatus()) {
                bookList.get(i).displayInfo();
            }
        }
    }

    public static void displayAllBooks(List<Book> bookList) {
        for (Book book : bookList) {
            book.displayInfo();
        }
    }

    private static boolean isIsbnExists(List<Book> bookList, String isbn) {
        for (Book book : bookList) {
            if (book.getIsbn().equals(isbn)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<Book> bookList = new ArrayList<>();

        StoryBook storyBook1 = new StoryBook();
        storyBook1.setIsbn("ISBN01");
        storyBook1.setTitle("Harry Potter");
        storyBook1.setAuthor("J.K. Rowling");
        storyBook1.setPublicationYear(1997);
        storyBook1.setStatus(false);
        storyBook1.setGenre("Fantasy");
        addBook(bookList, storyBook1);

        StoryBook storyBook2 = new StoryBook();
        storyBook2.setIsbn("ISBN03");
        storyBook2.setTitle("Fantastic Beasts");
        storyBook2.setAuthor("J.K. Rowling");
        storyBook2.setPublicationYear(2001);
        storyBook2.setStatus(true);
        storyBook2.setGenre("Adventure");
        addBook(bookList, storyBook2);

        PsychologyBook psychologyBook1 = new PsychologyBook();
        psychologyBook1.setIsbn("ISBN02");
        psychologyBook1.setTitle("Thinking Fast and Slow");
        psychologyBook1.setAuthor("Daniel Kahneman");
        psychologyBook1.setPublicationYear(2011);
        psychologyBook1.setStatus(true);
        psychologyBook1.setTopic("Cognitive Science");
        addBook(bookList, psychologyBook1);

        PsychologyBook psychologyBook2 = new PsychologyBook();
        psychologyBook2.setIsbn("ISBN04");
        psychologyBook2.setTitle("Emotional Intelligence");
        psychologyBook2.setAuthor("Daniel Goleman");
        psychologyBook2.setPublicationYear(1995);
        psychologyBook2.setStatus(true);
        psychologyBook2.setTopic("Emotions");
        addBook(bookList, psychologyBook2);

        System.out.println("Initial book list");
        displayAllBooks(bookList);

        System.out.println("\nUpdate book with isbn = ISBN01 ");
        StoryBook updatedBook = new StoryBook();
        updatedBook.setIsbn("ISBN01");
        updatedBook.setTitle("Harry Potter 2");
        updatedBook.setAuthor("J.K. Rowling");
        updatedBook.setPublicationYear(1992);
        updatedBook.setStatus(true);
        updatedBook.setGenre("Fantasy");

        updateBook(bookList, "ISBN01", updatedBook);
        System.out.println("Updated book list");
        displayAllBooks(bookList);

        String author = "J.K. Rowling";
        List<Book> sortedBooksByAuthor = findByAuthorsAndSortByPublicationYear(bookList, author);
        System.out.println("\nBooks by " + author + " and sorted by publication year:");
        displayAllBooks(sortedBooksByAuthor);

        System.out.println("\nRemoving book with ISBN02");
        boolean removed = removeBook(bookList,"ISBN02");
        if (removed) {
            System.out.println("Removed successfully.");
        } else {
            System.out.println("Book not found.");
        }
        System.out.println("\nBook list after remove:");
        displayAllBooks(bookList);

        System.out.println("\nBooks borrowed");
        displayBooksBorrowed(bookList);
    }
}
