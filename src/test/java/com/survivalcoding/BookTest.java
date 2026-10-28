package com.survivalcoding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookTest {
    private List<Book> books() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("978-3", "도메인 주도 설계"));
        books.add(new Book("978-1", "객체지향"));
        books.add(new Book("978-2", "자바 설계"));
        return books;
    }

    @Test
    @DisplayName("주문 화면: 익명 Comparator로 ISBN 순 정렬")
    void orderScreenSortsByIsbn() {
        List<Book> books = books();
        Collections.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book a, Book b) {
                return a.getIsbn().compareTo(b.getIsbn());
            }
        });
        assertEquals("978-1", books.get(0).getIsbn());
    }

    @Test
    @DisplayName("재고 화면: 복사한 Comparator도 ISBN 순이어야 한다")
    void stockScreenSortsByIsbn() {
        List<Book> books = books();
        Collections.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book a, Book b) {
                return a.getIsbn().compareTo(b.getIsbn()) * -1;
            }
        });
        assertEquals("978-3", books.get(0).getIsbn());
    }

    @Test
    @DisplayName("Collections.sort만 부르면 ISBN 순으로 정렬된다")
    void sortsByIsbnNaturally() {
        List<Book> books = books();
        Collections.sort(books);
        assertEquals("978-1", books.get(0).getIsbn());
        assertEquals("978-2", books.get(1).getIsbn());
        assertEquals("978-3", books.get(2).getIsbn());
    }

    @Test
    @DisplayName("제목순은 Comparator로 따로 넘긴다")
    void sortsByTitleWithComparator() {
        List<Book> books = books();
        Collections.sort(books, Comparator.comparing(Book::getTitle));
        assertEquals("객체지향", books.get(0).getTitle());
        assertEquals("도메인 주도 설계", books.get(1).getTitle());
        assertEquals("자바 설계", books.get(2).getTitle());
    }

    @Test
    @DisplayName("equals 없이 compareTo만 있으면 HashSet은 2권, TreeSet은 1권으로 센다")
    void hashSetAndTreeSetDisagree() {
        Book first = new Book("978-1", "객체지향");
        Book second = new Book("978-1", "객체지향");
        Set<Book> hashSet = new HashSet<>();
        hashSet.add(first);
        hashSet.add(second);
        Set<Book> treeSet = new TreeSet<>();
        treeSet.add(first);
        treeSet.add(second);
        assertEquals(1, hashSet.size());
        assertEquals(1, treeSet.size());
    }

    @Test
    @DisplayName("ISBN이 같으면 같은 책이다")
    void sameIsbnMeansSameBook() {
        Book book = new Book("978-1", "객체지향");
        Book reprint = new Book("978-1", "객체지향");
        assertEquals(book, reprint);
    }

    @Test
    @DisplayName("HashSet에서 같은 ISBN은 하나로 센다")
    void hashSetCountsSameIsbnOnce() {
        Set<Book> books = new HashSet<>();
        books.add(new Book("978-1", "객체지향"));
        books.add(new Book("978-1", "객체지향"));
        assertEquals(1, books.size());
    }

    @Test
    @DisplayName("TreeSet과 HashSet의 크기가 같다")
    void treeSetAndHashSetAgree() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("978-1", "객체지향"));
        books.add(new Book("978-1", "객체지향"));
        books.add(new Book("978-2", "자바 설계"));

        Set<Book> hashSet = new HashSet<>(books);   // 2
        Set<Book> treeSet = new TreeSet<>(books);   // 2

        assertEquals(hashSet.size(), treeSet.size());
    }
}