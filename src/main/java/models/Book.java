package models;

import java.util.Objects;

public class Book {
    private String name;
    private String authors;
    private String description;
    private int year;

    public Book(String name, String authors, String description, int year) {
        this.name = name;
        this.authors = authors;
        this.description = description;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getAuthors() {
        return authors;
    }

    public int getYear() {
        return year;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        Book other = (Book) obj;

        return Objects.equals(name, other.name) && Objects.equals(authors, other.authors) && Objects.equals(year, other.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, authors, year);
    }
}
