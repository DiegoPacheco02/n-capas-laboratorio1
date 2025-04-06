package service;

import model.Book;

import java.util.*;

public class BookService {
    public List<Book> books = new ArrayList<>();

    public void saveBook(Book book) {
        books.add(book);
    }

    public Book getBookById(Long id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Book getBestSellingBook() {
        return books.stream()
                .max(Comparator.comparing(Book::getTotalQuantitySold))
                .orElse(null);
    }

    public List<Book> getBooksWithMoreThanXSales(int x) {
        return books.stream()
                .filter(book -> book.getTotalQuantitySold() > x)
                .toList();
    }
}