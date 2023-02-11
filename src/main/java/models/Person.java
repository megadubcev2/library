package models;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private List<Book> books;

    Person() {
        books = new ArrayList<>();
    }

    public void put(Library library, Book book) {
        if (!books.contains(book)) {
            throw new NoSuchBookException();
        }
        books.remove(book);
        library.put(book);
    }

    public void get(Library library, Book book) {
        library.get(book);
        books.add(book);
    }
}
