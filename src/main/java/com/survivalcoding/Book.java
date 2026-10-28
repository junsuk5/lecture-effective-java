package com.survivalcoding;

import java.util.Objects;

public class Book implements Comparable<Book> {
    private final String isbn;
    private final String title;

    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int compareTo(Book o) {
        return isbn.compareTo(o.getIsbn());
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Book book)) return false;

        return Objects.equals(isbn, book.isbn) && Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(isbn);
        result = 31 * result + Objects.hashCode(title);
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}