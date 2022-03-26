package com.fmi.service;

import com.fmi.model.Book;
import com.fmi.repository.CRUD;
import lombok.Setter;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Setter
public class BookStore implements Store {
    @Autowired
    private CRUD dbCrud;

    @SneakyThrows
    @Override
    public boolean add(Book o) {
        Book b = dbCrud.getByKey(o.getISBN());

        if (b == null) {
            dbCrud.add(o);
            return true;
        }

        dbCrud.add(b);
        return true;
    }

    @Override
    public void remove(Book o) {
        dbCrud.remove(o.getISBN());
    }

    @Override
    public List<Book> getAllBooksByAuthor(String author) {
        return dbCrud.getAll().stream()
                .filter(b -> b.getAuthor().equals(author))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getAllBooksPublishedAfter(LocalDate from) {
        return dbCrud.getAll().stream()
                .filter(b -> b.getPublishedYear().isAfter(from))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getAllBooksBetween(LocalDate from, LocalDate to) {
        // 3 < n < 7
        return dbCrud.getAll().stream()
                .filter(b -> b.getPublishedYear().isAfter(from))
                .filter(b -> b.getPublishedYear().isBefore(to))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, List<Book>> getAllBooksGroupByAuthor() {
        return dbCrud.getAll().stream().collect(Collectors.groupingBy(Book::getAuthor));
    }

    @Override
    public Map<String, List<Book>> getAllBooksGroupByPublisher() {
        return dbCrud.getAll().stream().collect(Collectors.groupingBy(Book::getPublisher));
    }

    @Override
    public List<Book> getAllBooksFilterBy(Predicate<Book> bookPredicate) {
        return dbCrud.getAll().stream().filter(bookPredicate).collect(Collectors.toList());
    }

    @Override
    public void clear() {
        dbCrud.clear();
    }
}
