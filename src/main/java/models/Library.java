package models;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Library {
    private Map<Book, Integer> books;
    private Map<String, Set<Book>> bookNames;

    public Library() {
        books = new HashMap<>();
        bookNames = new HashMap<>();
    }

    public Book get(Book book) {
        if (!books.containsKey(book)) {
            throw new NoSuchBookException();
        }
        books.put(book, books.get(book) - 1);
        if (books.get(book) == 0) {
            books.remove(book);
            Set<Book> booksWithOneName = bookNames.get(book.getName());
            booksWithOneName.remove(book);
            if (booksWithOneName.isEmpty()) {
                bookNames.remove(book.getName());
            }
        }
        return book;
    }

    public void put(Book book) {
        if (books.containsKey(book)) {
            books.put(book, books.get(book) + 1);
        } else {
            books.put(book, 1);
            if (bookNames.containsKey(book.getName())) {
                Set<Book> booksWithOneName = bookNames.get(book.getName());
                booksWithOneName.add(book);
            } else {
                Set<Book> booksWithOneName = new HashSet<>();
                booksWithOneName.add(book);
                bookNames.put(book.getName(), booksWithOneName);
            }
        }
    }
}
