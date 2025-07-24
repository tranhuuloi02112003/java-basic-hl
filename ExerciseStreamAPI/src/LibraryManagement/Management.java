package LibraryManagement;

import java.util.*;
import java.util.stream.Collectors;

public class Management {

    public static List<Book> findAvailableBooks(List<Book> books) {
        if (books == null || books.isEmpty()) {
            return Collections.emptyList();
        }
        return books.stream().filter(book -> !book.isBorrowed()).toList();
    }

    public static Map<String, Long> countBooksByAuthor(List<Book> books) {
        if (books == null || books.isEmpty()) {
            return Collections.emptyMap();
        }
        return books.stream().
                collect(Collectors.groupingBy(book -> book.getAuthor(), Collectors.counting()));
    }

    public static List<Book> findBooksPublishedAfterYearSortedByYear(List<Book> books, int minYear) {
        if (books == null || books.isEmpty()) {
            return Collections.emptyList();
        }
        return books.stream()
                .filter(book -> book.getPublicYear() > minYear)
                .sorted(Comparator.comparing(book -> book.getPublicYear())).toList();
    }

    public static void main(String[] args) {
        List<Book> books = getBooksData();

        System.out.println("List of available books:");
        findAvailableBooks(books).forEach(System.out::println);

        System.out.println("\nBook count by author:");
        countBooksByAuthor(books).forEach((author, count) ->
                System.out.println("Author: " + author + ": " + count + " book(s)"));

        System.out.println("\nBooks published after 2000 (sorted by year):");
        findBooksPublishedAfterYearSortedByYear(books, 2000).forEach(System.out::println);
    }

    public static List<Book> getBooksData() {
        Book algorithmsBook = new Book();
        algorithmsBook.setId("B01");
        algorithmsBook.setTitle("Introduction to Algorithms");
        algorithmsBook.setAuthor("Thomas H. Cormen");
        algorithmsBook.setPublicYear(2009);
        algorithmsBook.setBorrowed(false);

        Book javaBook = new Book();
        javaBook.setId("B02");
        javaBook.setTitle("Effective Java");
        javaBook.setAuthor("Joshua Bloch");
        javaBook.setPublicYear(2008);
        javaBook.setBorrowed(true);

        Book historyBook = new Book();
        historyBook.setId("B03");
        historyBook.setTitle("A History of the World");
        historyBook.setAuthor("Andrew Marr");
        historyBook.setPublicYear(2012);
        historyBook.setBorrowed(false);

        Book dataScienceBook = new Book();
        dataScienceBook.setId("B04");
        dataScienceBook.setTitle("Data Science from Scratch");
        dataScienceBook.setAuthor("Joel Grus");
        dataScienceBook.setPublicYear(2015);
        dataScienceBook.setBorrowed(true);

        Book oldBook = new Book();
        oldBook.setId("B05");
        oldBook.setTitle("Classic Physics");
        oldBook.setAuthor("Andrew Marr");
        oldBook.setPublicYear(1987);
        oldBook.setBorrowed(false);

        return new ArrayList<>(Arrays.asList(algorithmsBook, javaBook, historyBook, dataScienceBook, oldBook));
    }
}
